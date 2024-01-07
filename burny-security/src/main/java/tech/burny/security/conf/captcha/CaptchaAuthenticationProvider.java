package tech.burny.security.conf.captcha;


import jakarta.servlet.http.HttpServletRequest;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import tech.burny.common.constant.SecurityConstants;
import tech.burny.security.conf.redis.RedisOperator;
import tech.burny.security.exception.InvalidCaptchaException;


import static tech.burny.common.constant.RedisConstants.IMAGE_CAPTCHA_PREFIX_KEY;

/**
 * 验证码校验
 * 注入ioc中替换原先的DaoAuthenticationProvider
 * 在authenticate方法中添加校验验证码的逻辑
 * 最后调用父类的authenticate方法并返回
 *
 * @author vains
 */
@Slf4j
@Component
public class CaptchaAuthenticationProvider extends DaoAuthenticationProvider {


    private final RedisOperator<String> redisOperator;

    /**
     * 利用构造方法在通过{@link Component}注解初始化时
     * 注入UserDetailsService和passwordEncoder，然后
     * 设置调用父类关于这两个属性的set方法设置进去
     *
     * @param userDetailsService 用户服务，给框架提供用户信息
     * @param passwordEncoder    密码解析器，用于加密和校验密码
     */
    public CaptchaAuthenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder ,RedisOperator redisOperator) {
        super.setPasswordEncoder(passwordEncoder);
        super.setUserDetailsService(userDetailsService);
        this.redisOperator = redisOperator;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.info("Authenticate captcha...");

        // 获取当前request
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            InvalidCaptchaException invalidCaptchaException = new InvalidCaptchaException("Failed to get the current request.");
            invalidCaptchaException.printStackTrace();
            throw invalidCaptchaException;
        }
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();


        // 8 !! 重点。如果用自定义grant_type 的方式，smprovider 会比这个先执行，后执行到这里的时候
        // 因为有super.authenticate  所以跳过了验证码模式。
        // 获取当前登录方式
        String loginType = request.getParameter("loginType");
        if (Objects.equals(loginType, SecurityConstants.SMS_LOGIN_TYPE)) {
            log.info("It isn't necessary captcha authenticate.");
            return super.authenticate(authentication);
        }


        // 获取参数中的验证码
        String code = request.getParameter("code");
        if (ObjectUtils.isEmpty(code)) {
            InvalidCaptchaException invalidCaptchaException = new InvalidCaptchaException("The captcha cannot be empty.");
            invalidCaptchaException.printStackTrace();
            throw invalidCaptchaException;
        }

        String captchaId = request.getParameter(SecurityConstants.CAPTCHA_ID_NAME);
        // 获取缓存中存储的验证码
        String captchaCode = redisOperator.getAndDelete((IMAGE_CAPTCHA_PREFIX_KEY + captchaId));
        if (!ObjectUtils.isEmpty(captchaCode)) {
            if (!captchaCode.equalsIgnoreCase(code)) {
                throw new InvalidCaptchaException("The captcha is incorrect.");
            }
        } else {
            throw new InvalidCaptchaException("The captcha is abnormal. Obtain it again.");
        }

        log.info("Captcha authenticated.");
        return super.authenticate(authentication);
    }
}


