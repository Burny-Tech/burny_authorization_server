package tech.burny.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tech.burny.security.entity.SysRole;
import tech.burny.security.mapper.SysRoleMapper;
import tech.burny.security.service.ISysRoleService;

/**
 * <p>
 * 系统角色表 服务实现类
 * </p>
 *
 * @author cyx
 * @since 2024-01-06
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

}
