package tech.burny.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import java.io.Serializable;


/**
 * <p>
 *
 * </p>
 *
 * @author cyx
 * @since 2024-01-06
 */
@TableName("sys_user_role")
@Schema(name = "SysUserRole对象", description = "")
public class SysUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @SchemaProperty(name = "角色ID")
    private Integer roleId;

    @SchemaProperty(name = "用户ID")
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "SysUserRole{" +
                "id = " + id +
                ", roleId = " + roleId +
                ", userId = " + userId +
                "}";
    }
}
