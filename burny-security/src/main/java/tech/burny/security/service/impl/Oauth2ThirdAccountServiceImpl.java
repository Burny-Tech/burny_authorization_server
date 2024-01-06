package tech.burny.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tech.burny.security.entity.Oauth2ThirdAccount;
import tech.burny.security.mapper.Oauth2ThirdAccountMapper;
import tech.burny.security.service.IOauth2ThirdAccountService;

/**
 * <p>
 * 三方登录账户信息表 服务实现类
 * </p>
 *
 * @author cyx
 * @since 2024-01-06
 */
@Service
public class Oauth2ThirdAccountServiceImpl extends ServiceImpl<Oauth2ThirdAccountMapper, Oauth2ThirdAccount> implements IOauth2ThirdAccountService {

}
