package tech.burny.security.conf.sms;

import java.security.Principal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClaimAccessor;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken.TokenType;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2RefreshToken;
import org.springframework.security.oauth2.core.OAuth2Token;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.authorization.OAuth2Authorization;
import org.springframework.security.oauth2.server.authorization.OAuth2Authorization.Token;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.OAuth2TokenType;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2AccessTokenAuthenticationToken;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2ClientAuthenticationToken;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2RefreshTokenAuthenticationToken;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.context.AuthorizationServerContextHolder;
import org.springframework.security.oauth2.server.authorization.token.DefaultOAuth2TokenContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenGenerator;

public class CustomOAuth2RefreshTokenAuthenticationProvider implements AuthenticationProvider {
    private static final String ERROR_URI = "https://datatracker.ietf.org/doc/html/rfc6749#section-5.2";
    private static final OAuth2TokenType ID_TOKEN_TOKEN_TYPE = new OAuth2TokenType("id_token");
    private final Log logger = LogFactory.getLog(this.getClass());
    private OAuth2AuthorizationService authorizationService;
    private OAuth2TokenGenerator<? extends OAuth2Token> tokenGenerator;

//    public CustomOAuth2RefreshTokenAuthenticationProvider(OAuth2AuthorizationService authorizationService, OAuth2TokenGenerator<? extends OAuth2Token> tokenGenerator) {
//        Assert.notNull(authorizationService, "authorizationService cannot be null");
//        Assert.notNull(tokenGenerator, "tokenGenerator cannot be null");
//        this.authorizationService = authorizationService;
//        this.tokenGenerator = tokenGenerator;
//    }

    public static OAuth2ClientAuthenticationToken getAuthenticatedClientElseThrowInvalidClient(Authentication authentication) {
        OAuth2ClientAuthenticationToken clientPrincipal = null;
        if (OAuth2ClientAuthenticationToken.class.isAssignableFrom(authentication.getPrincipal().getClass())) {
            clientPrincipal = (OAuth2ClientAuthenticationToken) authentication.getPrincipal();
        }

        if (clientPrincipal != null && clientPrincipal.isAuthenticated()) {
            return clientPrincipal;
        } else {
            throw new OAuth2AuthenticationException("invalid_client");
        }
    }

    public void setAuthorizationService(OAuth2AuthorizationService oAuth2AuthorizationService) {
        this.authorizationService = oAuth2AuthorizationService;
    }

    public void setTokenGenerator(OAuth2TokenGenerator tokenGenerator) {
        this.tokenGenerator = tokenGenerator;
    }

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Instant expireAt2 = LocalDateTime.now().plusYears(2).toInstant(ZoneOffset.UTC);

        OAuth2RefreshTokenAuthenticationToken refreshTokenAuthentication = (OAuth2RefreshTokenAuthenticationToken) authentication;
        OAuth2ClientAuthenticationToken clientPrincipal = getAuthenticatedClientElseThrowInvalidClient(refreshTokenAuthentication);
        RegisteredClient registeredClient = clientPrincipal.getRegisteredClient();
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Retrieved registered client");
        }

        OAuth2Authorization authorization = this.authorizationService.findByToken(refreshTokenAuthentication.getRefreshToken(), OAuth2TokenType.REFRESH_TOKEN);
        if (authorization == null) {
            throw new OAuth2AuthenticationException("invalid_grant");
        } else {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Retrieved authorization with refresh token");
            }

            if (!registeredClient.getId().equals(authorization.getRegisteredClientId())) {
                throw new OAuth2AuthenticationException("invalid_grant");
            } else if (!registeredClient.getAuthorizationGrantTypes().contains(AuthorizationGrantType.REFRESH_TOKEN)) {
                throw new OAuth2AuthenticationException("unauthorized_client");
            } else {
                OAuth2Authorization.Token<OAuth2RefreshToken> refreshToken = authorization.getRefreshToken();
                if (!refreshToken.isActive()) {
                    throw new OAuth2AuthenticationException("invalid_grant");
                } else {
                    Set<String> scopes = refreshTokenAuthentication.getScopes();
                    Set<String> authorizedScopes = authorization.getAuthorizedScopes();
                    if (!authorizedScopes.containsAll(scopes)) {
                        throw new OAuth2AuthenticationException("invalid_scope");
                    } else {
                        if (this.logger.isTraceEnabled()) {
                            this.logger.trace("Validated token request parameters");
                        }

                        if (scopes.isEmpty()) {
                            scopes = authorizedScopes;
                        }

                        DefaultOAuth2TokenContext.Builder tokenContextBuilder = (DefaultOAuth2TokenContext.Builder) ((DefaultOAuth2TokenContext.Builder) ((DefaultOAuth2TokenContext.Builder) ((DefaultOAuth2TokenContext.Builder) ((DefaultOAuth2TokenContext.Builder) ((DefaultOAuth2TokenContext.Builder) ((DefaultOAuth2TokenContext.Builder) DefaultOAuth2TokenContext.builder().registeredClient(registeredClient)).principal((Authentication) authorization.getAttribute(Principal.class.getName()))).authorizationServerContext(AuthorizationServerContextHolder.getContext())).authorization(authorization)).authorizedScopes(scopes)).authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)).authorizationGrant(refreshTokenAuthentication);
                        OAuth2Authorization.Builder authorizationBuilder = OAuth2Authorization.from(authorization);
                        OAuth2TokenContext tokenContext = ((DefaultOAuth2TokenContext.Builder) tokenContextBuilder.tokenType(OAuth2TokenType.ACCESS_TOKEN)).build();
                        OAuth2Token generatedAccessToken = this.tokenGenerator.generate(tokenContext);
                        if (generatedAccessToken == null) {
                            OAuth2Error error = new OAuth2Error("server_error", "The token generator failed to generate the access token.", "https://datatracker.ietf.org/doc/html/rfc6749#section-5.2");
                            throw new OAuth2AuthenticationException(error);
                        } else {
                            if (this.logger.isTraceEnabled()) {
                                this.logger.trace("Generated access token");
                            }

                            OAuth2AccessToken accessToken = new OAuth2AccessToken(TokenType.BEARER, generatedAccessToken.getTokenValue(), generatedAccessToken.getIssuedAt(), expireAt2, tokenContext.getAuthorizedScopes());
                            if (generatedAccessToken instanceof ClaimAccessor) {
                                authorizationBuilder.token(accessToken, (metadata) -> {
                                    metadata.put(Token.CLAIMS_METADATA_NAME, ((ClaimAccessor) generatedAccessToken).getClaims());
                                    metadata.put(Token.INVALIDATED_METADATA_NAME, false);
                                });
                            } else {
                                authorizationBuilder.accessToken(accessToken);
                            }

                            OAuth2RefreshToken currentRefreshToken = (OAuth2RefreshToken) refreshToken.getToken();
                            if (!registeredClient.getTokenSettings().isReuseRefreshTokens()) {
                                tokenContext = ((DefaultOAuth2TokenContext.Builder) tokenContextBuilder.tokenType(OAuth2TokenType.REFRESH_TOKEN)).build();
                                OAuth2Token generatedRefreshToken = this.tokenGenerator.generate(tokenContext);
                                if (!(generatedRefreshToken instanceof OAuth2RefreshToken)) {
                                    OAuth2Error error = new OAuth2Error("server_error", "The token generator failed to generate the refresh token.", "https://datatracker.ietf.org/doc/html/rfc6749#section-5.2");
                                    throw new OAuth2AuthenticationException(error);
                                }

                                if (this.logger.isTraceEnabled()) {
                                    this.logger.trace("Generated refresh token");
                                }

//                                currentRefreshToken = (OAuth2RefreshToken)generatedRefreshToken;
                                currentRefreshToken = new OAuth2RefreshToken(generatedRefreshToken.getTokenValue(), generatedRefreshToken.getIssuedAt(), expireAt2);
                                authorizationBuilder.refreshToken(currentRefreshToken);
                            }

                            OidcIdToken idToken;
                            if (authorizedScopes.contains("openid")) {
                                tokenContext = ((DefaultOAuth2TokenContext.Builder) ((DefaultOAuth2TokenContext.Builder) tokenContextBuilder.tokenType(ID_TOKEN_TOKEN_TYPE)).authorization(authorizationBuilder.build())).build();
                                OAuth2Token generatedIdToken = this.tokenGenerator.generate(tokenContext);
                                if (!(generatedIdToken instanceof Jwt)) {
                                    OAuth2Error error = new OAuth2Error("server_error", "The token generator failed to generate the ID token.", "https://datatracker.ietf.org/doc/html/rfc6749#section-5.2");
                                    throw new OAuth2AuthenticationException(error);
                                }

                                if (this.logger.isTraceEnabled()) {
                                    this.logger.trace("Generated id token");
                                }

                                idToken = new OidcIdToken(generatedIdToken.getTokenValue(), generatedIdToken.getIssuedAt(), expireAt2, ((Jwt) generatedIdToken).getClaims());
                                authorizationBuilder.token(idToken, (metadata) -> {
                                    metadata.put(Token.CLAIMS_METADATA_NAME, idToken.getClaims());
                                });
                            } else {
                                idToken = null;
                            }

                            authorization = authorizationBuilder.build();
                            this.authorizationService.save(authorization);
                            if (this.logger.isTraceEnabled()) {
                                this.logger.trace("Saved authorization");
                            }

                            Map<String, Object> additionalParameters = Collections.emptyMap();
                            if (idToken != null) {
                                additionalParameters = new HashMap();
                                ((Map) additionalParameters).put("id_token", idToken.getTokenValue());
                            }

                            if (this.logger.isTraceEnabled()) {
                                this.logger.trace("Authenticated token request");
                            }

                            return new OAuth2AccessTokenAuthenticationToken(registeredClient, clientPrincipal, accessToken, currentRefreshToken, (Map) additionalParameters);
                        }
                    }
                }
            }
        }
    }

    public boolean supports(Class<?> authentication) {
        return OAuth2RefreshTokenAuthenticationToken.class.isAssignableFrom(authentication);
    }
}

