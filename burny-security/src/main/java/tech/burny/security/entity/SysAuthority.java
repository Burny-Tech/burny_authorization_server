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
 * 系统菜单表
 * </p>
 *
 * @author cyx
 * @since 2024-01-06
 */
@TableName("sys_authority")
@Schema(name = "SysAuthority对象", description = "系统菜单表")
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class SysAuthority implements Serializable {

    private static final long serialVersionUID = 1L;

    @SchemaProperty(name = "菜单自增ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @SchemaProperty(name = "菜单名称")
    private String name;

    @SchemaProperty(name = "父菜单ID")
    private Integer menuPid;

    @SchemaProperty(name = "跳转URL")
    private String url;

    @SchemaProperty(name = "所需权限")
    private String authority;

    @SchemaProperty(name = "排序")
    private Byte sort;

    @SchemaProperty(name = "0:菜单,1:接口")
    private Byte type;

    @SchemaProperty(name = "0:启用,1:删除")
    private Boolean deleted;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMenuPid() {
        return menuPid;
    }

    public void setMenuPid(Integer menuPid) {
        this.menuPid = menuPid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Byte getSort() {
        return sort;
    }

    public void setSort(Byte sort) {
        this.sort = sort;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
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
        return "SysAuthority{" +
                "id = " + id +
                ", name = " + name +
                ", menuPid = " + menuPid +
                ", url = " + url +
                ", authority = " + authority +
                ", sort = " + sort +
                ", type = " + type +
                ", deleted = " + deleted +
                ", createTime = " + createTime +
                ", createUserId = " + createUserId +
                "}";
    }
}
