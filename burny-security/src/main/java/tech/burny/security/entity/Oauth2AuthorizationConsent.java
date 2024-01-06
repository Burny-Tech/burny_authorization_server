package tech.burny.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;


/**
 * <p>
 *
 * </p>
 *
 * @author cyx
 * @since 2024-01-06
 */
@TableName("oauth2_authorization_consent")
@Schema(name = "Oauth2AuthorizationConsent对象", description = "")
public class Oauth2AuthorizationConsent implements Serializable {

    private static final long serialVersionUID = 1L;

    private String registeredClientId;

    private String principalName;

    private String authorities;

    public String getRegisteredClientId() {
        return registeredClientId;
    }

    public void setRegisteredClientId(String registeredClientId) {
        this.registeredClientId = registeredClientId;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "Oauth2AuthorizationConsent{" +
                "registeredClientId = " + registeredClientId +
                ", principalName = " + principalName +
                ", authorities = " + authorities +
                "}";
    }
}
