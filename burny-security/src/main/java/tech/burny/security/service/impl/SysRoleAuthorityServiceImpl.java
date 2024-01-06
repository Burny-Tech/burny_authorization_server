package tech.burny.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tech.burny.security.entity.SysRoleAuthority;
import tech.burny.security.mapper.SysRoleAuthorityMapper;
import tech.burny.security.service.ISysRoleAuthorityService;

/**
 * <p>
 * 角色菜单多对多关联表 服务实现类
 * </p>
 *
 * @author cyx
 * @since 2024-01-06
 */
@Service
public class SysRoleAuthorityServiceImpl extends ServiceImpl<SysRoleAuthorityMapper, SysRoleAuthority> implements ISysRoleAuthorityService {

}
