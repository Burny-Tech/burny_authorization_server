package tech.burny.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tech.burny.security.entity.Oauth2RegisteredClient;
import tech.burny.security.mapper.Oauth2RegisteredClientMapper;
import tech.burny.security.service.IOauth2RegisteredClientService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cyx
 * @since 2024-01-06
 */
@Service
public class Oauth2RegisteredClientServiceImpl extends ServiceImpl<Oauth2RegisteredClientMapper, Oauth2RegisteredClient> implements IOauth2RegisteredClientService {

}
