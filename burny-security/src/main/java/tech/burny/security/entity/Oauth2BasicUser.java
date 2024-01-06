package tech.burny.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


/**
 * <p>
 * 基础用户信息表
 * </p>
 *
 * @author cyx
 * @since 2024-01-06
 */
@TableName("oauth2_basic_user")
@Data
@Schema(name = "Oauth2BasicUser对象", description = "基础用户信息表")
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class Oauth2BasicUser implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    @SchemaProperty(name = "自增id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @SchemaProperty(name = "用户名、昵称")
    private String name;

    @SchemaProperty(name = "账号")
    private String account;

    @SchemaProperty(name = "密码")
    private String password;

    @SchemaProperty(name = "手机号")
    private String mobile;

    @SchemaProperty(name = "邮箱")
    private String email;

    @SchemaProperty(name = "头像地址")
    private String avatarUrl;

    @SchemaProperty(name = "是否已删除")
    private Boolean deleted;

    @SchemaProperty(name = "用户来源")
    private String sourceFrom;

    @SchemaProperty(name = "创建时间")
    private LocalDateTime createTime;

    @SchemaProperty(name = "修改时间")
    private LocalDateTime updateTime;

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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }


    @TableField(exist = false)
   private Collection<? extends GrantedAuthority> authorities;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return account;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getSourceFrom() {
        return sourceFrom;
    }

    public void setSourceFrom(String sourceFrom) {
        this.sourceFrom = sourceFrom;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Oauth2BasicUser{" +
                "id = " + id +
                ", name = " + name +
                ", account = " + account +
                ", password = " + password +
                ", mobile = " + mobile +
                ", email = " + email +
                ", avatarUrl = " + avatarUrl +
                ", deleted = " + deleted +
                ", sourceFrom = " + sourceFrom +
                ", createTime = " + createTime +
                ", updateTime = " + updateTime +
                "}";
    }
}
