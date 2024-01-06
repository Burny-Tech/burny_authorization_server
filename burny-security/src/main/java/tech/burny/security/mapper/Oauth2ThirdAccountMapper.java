package tech.burny.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import tech.burny.security.entity.Oauth2ThirdAccount;

/**
 * <p>
 * 三方登录账户信息表 Mapper 接口
 * </p>
 *
 * @author cyx
 * @since 2024-01-06
 */
@Mapper
public interface Oauth2ThirdAccountMapper extends BaseMapper<Oauth2ThirdAccount> {

}
