package tech.burny.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * <p>
 * 系统角色表
 * </p>
 *
 * @author cyx
 * @since 2024-01-06
 */
@TableName("sys_role")
@Schema(name = "SysRole对象", description = "系统角色表")
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @SchemaProperty(name = "角色自增ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @SchemaProperty(name = "角色名")
    private String roleName;

    @SchemaProperty(name = "0:启用,1:删除")
    private Boolean deleted;

    @SchemaProperty(name = "排序")
    private Integer sort;

    @SchemaProperty(name = "创建时间")
    private LocalDateTime createTime;

    @SchemaProperty(name = "创建人")
    private Integer createUserId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id = " + id +
                ", roleName = " + roleName +
                ", deleted = " + deleted +
                ", sort = " + sort +
                ", createTime = " + createTime +
                ", createUserId = " + createUserId +
                "}";
    }
}
