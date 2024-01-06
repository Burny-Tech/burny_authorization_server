package tech.burny.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * <p>
 * 三方登录账户信息表
 * </p>
 *
 * @author cyx
 * @since 2024-01-06
 */
@TableName("oauth2_third_account")
@Schema(name = "Oauth2ThirdAccount对象", description = "三方登录账户信息表")
public class Oauth2ThirdAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @SchemaProperty(name = "自增id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @SchemaProperty(name = "用户表主键")
    private Integer userId;

    @SchemaProperty(name = "三方登录唯一id")
    private String uniqueId;

    @SchemaProperty(name = "三方登录类型")
    private String type;

    @SchemaProperty(name = "博客地址")
    private String blog;

    @SchemaProperty(name = "地址")
    private String location;

    @SchemaProperty(name = "绑定时间")
    private LocalDateTime createTime;

    @SchemaProperty(name = "修改时间")
    private LocalDateTime updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
        return "Oauth2ThirdAccount{" +
                "id = " + id +
                ", userId = " + userId +
                ", uniqueId = " + uniqueId +
                ", type = " + type +
                ", blog = " + blog +
                ", location = " + location +
                ", createTime = " + createTime +
                ", updateTime = " + updateTime +
                "}";
    }
}
