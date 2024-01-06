package tech.burny.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tech.burny.security.entity.SysAuthority;
import tech.burny.security.mapper.SysAuthorityMapper;
import tech.burny.security.service.ISysAuthorityService;

/**
 * <p>
 * 系统菜单表 服务实现类
 * </p>
 *
 * @author cyx
 * @since 2024-01-06
 */
@Service
public class SysAuthorityServiceImpl extends ServiceImpl<SysAuthorityMapper, SysAuthority> implements ISysAuthorityService {

}
