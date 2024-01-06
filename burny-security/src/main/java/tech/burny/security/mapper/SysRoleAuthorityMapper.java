package tech.burny.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import tech.burny.security.entity.SysRoleAuthority;

/**
 * <p>
 * 角色菜单多对多关联表 Mapper 接口
 * </p>
 *
 * @author cyx
 * @since 2024-01-06
 */
@Mapper
public interface SysRoleAuthorityMapper extends BaseMapper<SysRoleAuthority> {

}
