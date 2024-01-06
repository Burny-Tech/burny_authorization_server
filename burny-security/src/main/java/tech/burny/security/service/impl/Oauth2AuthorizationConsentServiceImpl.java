package tech.burny.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tech.burny.security.entity.Oauth2AuthorizationConsent;
import tech.burny.security.mapper.Oauth2AuthorizationConsentMapper;
import tech.burny.security.service.IOauth2AuthorizationConsentService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cyx
 * @since 2024-01-06
 */
@Service
public class Oauth2AuthorizationConsentServiceImpl extends ServiceImpl<Oauth2AuthorizationConsentMapper, Oauth2AuthorizationConsent> implements IOauth2AuthorizationConsentService {

}
