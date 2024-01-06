package tech.burny.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tech.burny.security.entity.Oauth2Authorization;
import tech.burny.security.mapper.Oauth2AuthorizationMapper;
import tech.burny.security.service.IOauth2AuthorizationService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cyx
 * @since 2024-01-06
 */
@Service
public class Oauth2AuthorizationServiceImpl extends ServiceImpl<Oauth2AuthorizationMapper, Oauth2Authorization> implements IOauth2AuthorizationService {

}
