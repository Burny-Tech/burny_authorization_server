package tech.burny.security.conf.sms;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import tech.burny.common.constant.SecurityConstants;
import tech.burny.security.conf.captcha.CaptchaAuthenticationProvider;
import tech.burny.security.conf.redis.RedisOperator;
import tech.burny.security.exception.InvalidCaptchaException;


import static tech.burny.common.constant.RedisConstants.SMS_CAPTCHA_PREFIX_KEY;

//当前登录方式还是处于密码登录？
@Component
@Slf4j
//8 继承CaptchaAuthenticationProvider并重写additionalAuthenticationChecks方法
public class SmsCaptchaAuthenticationProvider extends CaptchaAuthenticationProvider {

    //    这里没有修改默认的key，如果想自定义key可以重写authenticate方法然后构建一个UsernamePasswordAuthencationToken再调用父类的authenticate方法就行，下方代码中有示例

    private final RedisOperator<String> redisOperator;

    /**
     * 利用构造方法在通过{@link Component}注解初始化时
     * 注入UserDetailsService和passwordEncoder，然后
     * 设置调用父类关于这两个属性的set方法设置进去
     *
     * @param userDetailsService 用户服务，给框架提供用户信息
     * @param passwordEncoder    密码解析器，用于加密和校验密码
     */
    public SmsCaptchaAuthenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder, RedisOperator redisOperator) {
        super(userDetailsService,passwordEncoder,redisOperator);
        this.redisOperator=redisOperator;
    }

      /*@Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取当前request
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            throw new InvalidCaptchaException("Failed to get the current request.");
        }
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

        // 获取手机号与验证码
        String phone = request.getParameter("phone");
        String smsCaptcha = request.getParameter("smsCaptcha");
        // 非空校验
        if (ObjectUtils.isEmpty(phone) || ObjectUtils.isEmpty(smsCaptcha)) {
            throw new BadCredentialsException("账号密码不能为空.");
        }

        // 构建UsernamePasswordAuthenticationToken
        UsernamePasswordAuthenticationToken unauthenticated = UsernamePasswordAuthenticationToken.unauthenticated(phone, smsCaptcha);
        unauthenticated.setDetails(new WebAuthenticationDetails(request));

        return super.authenticate(unauthenticated);
    }*/

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        log.info("Authenticate sms captcha...");

        if (authentication.getCredentials() == null) {
            this.logger.debug("Failed to authenticate since no credentials provided");
            throw new BadCredentialsException("The sms captcha cannot be empty.");
        }

        // 获取当前request
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            throw new InvalidCaptchaException("Failed to get the current request.");
        }
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

        // 获取当前登录方式
        String loginType = request.getParameter("loginType");
        String grantType = request.getParameter("grant_type");

        if (Objects.equals(loginType, SecurityConstants.SMS_LOGIN_TYPE)
                || Objects.equals(grantType, SecurityConstants.GRANT_TYPE_SMS_CODE)

        ) {
            // 获取存入session的验证码(UsernamePasswordAuthenticationToken的principal中现在存入的是手机号)
//            String smsCaptcha = (String) request.getSession(Boolean.FALSE).getAttribute((String) authentication.getPrincipal());
            String smsCaptcha = redisOperator.getAndDelete((SMS_CAPTCHA_PREFIX_KEY + authentication.getPrincipal()));

            // 校验输入的验证码是否正确(UsernamePasswordAuthenticationToken的credentials中现在存入的是输入的验证码)
            if (!Objects.equals(smsCaptcha, authentication.getCredentials())) {
                throw new BadCredentialsException("The sms captcha is incorrect.");
            }
            // 在这里也可以拓展其它登录方式，比如邮箱登录什么的
        } else {
            log.info("Not sms captcha loginType, exit.");
            // 其它调用父类默认实现的密码方式登录
            super.additionalAuthenticationChecks(userDetails, authentication);
        }

        log.info("Authenticated sms captcha.");
    }






}
