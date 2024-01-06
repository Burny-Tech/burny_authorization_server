package tech.burny.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * <p>
 *
 * </p>
 *
 * @author cyx
 * @since 2024-01-06
 */
@TableName("oauth2_authorization")
@Schema(name = "Oauth2Authorization对象", description = "")

public class Oauth2Authorization implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String registeredClientId;

    private String principalName;

    private String authorizationGrantType;

    private String authorizedScopes;

    private byte[] attributes;

    private String state;

    private byte[] authorizationCodeValue;

    private LocalDateTime authorizationCodeIssuedAt;

    private LocalDateTime authorizationCodeExpiresAt;

    private byte[] authorizationCodeMetadata;

    private byte[] accessTokenValue;

    private LocalDateTime accessTokenIssuedAt;

    private LocalDateTime accessTokenExpiresAt;

    private byte[] accessTokenMetadata;

    private String accessTokenType;

    private String accessTokenScopes;

    private byte[] oidcIdTokenValue;

    private LocalDateTime oidcIdTokenIssuedAt;

    private LocalDateTime oidcIdTokenExpiresAt;

    private byte[] oidcIdTokenMetadata;

    private byte[] refreshTokenValue;

    private LocalDateTime refreshTokenIssuedAt;

    private LocalDateTime refreshTokenExpiresAt;

    private byte[] refreshTokenMetadata;

    private byte[] userCodeValue;

    private LocalDateTime userCodeIssuedAt;

    private LocalDateTime userCodeExpiresAt;

    private byte[] userCodeMetadata;

    private byte[] deviceCodeValue;

    private LocalDateTime deviceCodeIssuedAt;

    private LocalDateTime deviceCodeExpiresAt;

    private byte[] deviceCodeMetadata;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getAuthorizationGrantType() {
        return authorizationGrantType;
    }

    public void setAuthorizationGrantType(String authorizationGrantType) {
        this.authorizationGrantType = authorizationGrantType;
    }

    public String getAuthorizedScopes() {
        return authorizedScopes;
    }

    public void setAuthorizedScopes(String authorizedScopes) {
        this.authorizedScopes = authorizedScopes;
    }

    public byte[] getAttributes() {
        return attributes;
    }

    public void setAttributes(byte[] attributes) {
        this.attributes = attributes;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public byte[] getAuthorizationCodeValue() {
        return authorizationCodeValue;
    }

    public void setAuthorizationCodeValue(byte[] authorizationCodeValue) {
        this.authorizationCodeValue = authorizationCodeValue;
    }

    public LocalDateTime getAuthorizationCodeIssuedAt() {
        return authorizationCodeIssuedAt;
    }

    public void setAuthorizationCodeIssuedAt(LocalDateTime authorizationCodeIssuedAt) {
        this.authorizationCodeIssuedAt = authorizationCodeIssuedAt;
    }

    public LocalDateTime getAuthorizationCodeExpiresAt() {
        return authorizationCodeExpiresAt;
    }

    public void setAuthorizationCodeExpiresAt(LocalDateTime authorizationCodeExpiresAt) {
        this.authorizationCodeExpiresAt = authorizationCodeExpiresAt;
    }

    public byte[] getAuthorizationCodeMetadata() {
        return authorizationCodeMetadata;
    }

    public void setAuthorizationCodeMetadata(byte[] authorizationCodeMetadata) {
        this.authorizationCodeMetadata = authorizationCodeMetadata;
    }

    public byte[] getAccessTokenValue() {
        return accessTokenValue;
    }

    public void setAccessTokenValue(byte[] accessTokenValue) {
        this.accessTokenValue = accessTokenValue;
    }

    public LocalDateTime getAccessTokenIssuedAt() {
        return accessTokenIssuedAt;
    }

    public void setAccessTokenIssuedAt(LocalDateTime accessTokenIssuedAt) {
        this.accessTokenIssuedAt = accessTokenIssuedAt;
    }

    public LocalDateTime getAccessTokenExpiresAt() {
        return accessTokenExpiresAt;
    }

    public void setAccessTokenExpiresAt(LocalDateTime accessTokenExpiresAt) {
        this.accessTokenExpiresAt = accessTokenExpiresAt;
    }

    public byte[] getAccessTokenMetadata() {
        return accessTokenMetadata;
    }

    public void setAccessTokenMetadata(byte[] accessTokenMetadata) {
        this.accessTokenMetadata = accessTokenMetadata;
    }

    public String getAccessTokenType() {
        return accessTokenType;
    }

    public void setAccessTokenType(String accessTokenType) {
        this.accessTokenType = accessTokenType;
    }

    public String getAccessTokenScopes() {
        return accessTokenScopes;
    }

    public void setAccessTokenScopes(String accessTokenScopes) {
        this.accessTokenScopes = accessTokenScopes;
    }

    public byte[] getOidcIdTokenValue() {
        return oidcIdTokenValue;
    }

    public void setOidcIdTokenValue(byte[] oidcIdTokenValue) {
        this.oidcIdTokenValue = oidcIdTokenValue;
    }

    public LocalDateTime getOidcIdTokenIssuedAt() {
        return oidcIdTokenIssuedAt;
    }

    public void setOidcIdTokenIssuedAt(LocalDateTime oidcIdTokenIssuedAt) {
        this.oidcIdTokenIssuedAt = oidcIdTokenIssuedAt;
    }

    public LocalDateTime getOidcIdTokenExpiresAt() {
        return oidcIdTokenExpiresAt;
    }

    public void setOidcIdTokenExpiresAt(LocalDateTime oidcIdTokenExpiresAt) {
        this.oidcIdTokenExpiresAt = oidcIdTokenExpiresAt;
    }

    public byte[] getOidcIdTokenMetadata() {
        return oidcIdTokenMetadata;
    }

    public void setOidcIdTokenMetadata(byte[] oidcIdTokenMetadata) {
        this.oidcIdTokenMetadata = oidcIdTokenMetadata;
    }

    public byte[] getRefreshTokenValue() {
        return refreshTokenValue;
    }

    public void setRefreshTokenValue(byte[] refreshTokenValue) {
        this.refreshTokenValue = refreshTokenValue;
    }

    public LocalDateTime getRefreshTokenIssuedAt() {
        return refreshTokenIssuedAt;
    }

    public void setRefreshTokenIssuedAt(LocalDateTime refreshTokenIssuedAt) {
        this.refreshTokenIssuedAt = refreshTokenIssuedAt;
    }

    public LocalDateTime getRefreshTokenExpiresAt() {
        return refreshTokenExpiresAt;
    }

    public void setRefreshTokenExpiresAt(LocalDateTime refreshTokenExpiresAt) {
        this.refreshTokenExpiresAt = refreshTokenExpiresAt;
    }

    public byte[] getRefreshTokenMetadata() {
        return refreshTokenMetadata;
    }

    public void setRefreshTokenMetadata(byte[] refreshTokenMetadata) {
        this.refreshTokenMetadata = refreshTokenMetadata;
    }

    public byte[] getUserCodeValue() {
        return userCodeValue;
    }

    public void setUserCodeValue(byte[] userCodeValue) {
        this.userCodeValue = userCodeValue;
    }

    public LocalDateTime getUserCodeIssuedAt() {
        return userCodeIssuedAt;
    }

    public void setUserCodeIssuedAt(LocalDateTime userCodeIssuedAt) {
        this.userCodeIssuedAt = userCodeIssuedAt;
    }

    public LocalDateTime getUserCodeExpiresAt() {
        return userCodeExpiresAt;
    }

    public void setUserCodeExpiresAt(LocalDateTime userCodeExpiresAt) {
        this.userCodeExpiresAt = userCodeExpiresAt;
    }

    public byte[] getUserCodeMetadata() {
        return userCodeMetadata;
    }

    public void setUserCodeMetadata(byte[] userCodeMetadata) {
        this.userCodeMetadata = userCodeMetadata;
    }

    public byte[] getDeviceCodeValue() {
        return deviceCodeValue;
    }

    public void setDeviceCodeValue(byte[] deviceCodeValue) {
        this.deviceCodeValue = deviceCodeValue;
    }

    public LocalDateTime getDeviceCodeIssuedAt() {
        return deviceCodeIssuedAt;
    }

    public void setDeviceCodeIssuedAt(LocalDateTime deviceCodeIssuedAt) {
        this.deviceCodeIssuedAt = deviceCodeIssuedAt;
    }

    public LocalDateTime getDeviceCodeExpiresAt() {
        return deviceCodeExpiresAt;
    }

    public void setDeviceCodeExpiresAt(LocalDateTime deviceCodeExpiresAt) {
        this.deviceCodeExpiresAt = deviceCodeExpiresAt;
    }

    public byte[] getDeviceCodeMetadata() {
        return deviceCodeMetadata;
    }

    public void setDeviceCodeMetadata(byte[] deviceCodeMetadata) {
        this.deviceCodeMetadata = deviceCodeMetadata;
    }

    @Override
    public String toString() {
        return "Oauth2Authorization{" +
                "id = " + id +
                ", registeredClientId = " + registeredClientId +
                ", principalName = " + principalName +
                ", authorizationGrantType = " + authorizationGrantType +
                ", authorizedScopes = " + authorizedScopes +
                ", attributes = " + attributes +
                ", state = " + state +
                ", authorizationCodeValue = " + authorizationCodeValue +
                ", authorizationCodeIssuedAt = " + authorizationCodeIssuedAt +
                ", authorizationCodeExpiresAt = " + authorizationCodeExpiresAt +
                ", authorizationCodeMetadata = " + authorizationCodeMetadata +
                ", accessTokenValue = " + accessTokenValue +
                ", accessTokenIssuedAt = " + accessTokenIssuedAt +
                ", accessTokenExpiresAt = " + accessTokenExpiresAt +
                ", accessTokenMetadata = " + accessTokenMetadata +
                ", accessTokenType = " + accessTokenType +
                ", accessTokenScopes = " + accessTokenScopes +
                ", oidcIdTokenValue = " + oidcIdTokenValue +
                ", oidcIdTokenIssuedAt = " + oidcIdTokenIssuedAt +
                ", oidcIdTokenExpiresAt = " + oidcIdTokenExpiresAt +
                ", oidcIdTokenMetadata = " + oidcIdTokenMetadata +
                ", refreshTokenValue = " + refreshTokenValue +
                ", refreshTokenIssuedAt = " + refreshTokenIssuedAt +
                ", refreshTokenExpiresAt = " + refreshTokenExpiresAt +
                ", refreshTokenMetadata = " + refreshTokenMetadata +
                ", userCodeValue = " + userCodeValue +
                ", userCodeIssuedAt = " + userCodeIssuedAt +
                ", userCodeExpiresAt = " + userCodeExpiresAt +
                ", userCodeMetadata = " + userCodeMetadata +
                ", deviceCodeValue = " + deviceCodeValue +
                ", deviceCodeIssuedAt = " + deviceCodeIssuedAt +
                ", deviceCodeExpiresAt = " + deviceCodeExpiresAt +
                ", deviceCodeMetadata = " + deviceCodeMetadata +
                "}";
    }
}
