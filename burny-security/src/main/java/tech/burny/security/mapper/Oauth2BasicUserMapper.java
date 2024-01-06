package tech.burny.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import tech.burny.security.entity.Oauth2BasicUser;

/**
 * <p>
 * 基础用户信息表 Mapper 接口
 * </p>
 *
 * @author cyx
 * @since 2024-01-06
 */
@Mapper
public interface Oauth2BasicUserMapper extends BaseMapper<Oauth2BasicUser> {

}
