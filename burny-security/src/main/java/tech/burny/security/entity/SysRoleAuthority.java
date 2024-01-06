package tech.burny.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import java.io.Serializable;


/**
 * <p>
 * 角色菜单多对多关联表
 * </p>
 *
 * @author cyx
 * @since 2024-01-06
 */
@TableName("sys_role_authority")
@Schema(name = "SysRoleAuthority对象", description = "角色菜单多对多关联表")
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class SysRoleAuthority implements Serializable {

    private static final long serialVersionUID = 1L;

    @SchemaProperty(name = "角色菜单关联表自增ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @SchemaProperty(name = "角色ID")
    private Integer roleId;

    @SchemaProperty(name = "权限菜单ID")
    private Integer authorityId;

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

    public Integer getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    @Override
    public String toString() {
        return "SysRoleAuthority{" +
                "id = " + id +
                ", roleId = " + roleId +
                ", authorityId = " + authorityId +
                "}";
    }
}
