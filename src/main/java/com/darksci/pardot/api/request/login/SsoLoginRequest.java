package com.darksci.pardot.api.request.login;

import com.darksci.pardot.api.config.SsoLoginCredentials;
import com.darksci.pardot.api.request.BaseRequest;
import com.darksci.pardot.api.request.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 */
public class SsoLoginRequest extends BaseRequest<SsoLoginRequest> implements LoginRequestMarker {
    public SsoLoginRequest() {
        withGrantType("password");
    }

    public SsoLoginRequest(final SsoLoginCredentials credentials) {
        this();
        Objects.requireNonNull(credentials);
        withClientId(credentials.getClientId());
        withClientSecret(credentials.getClientSecret());
        withUsername(credentials.getUsername());
        withPassword(credentials.getPassword());
    }

    public SsoLoginRequest withClientId(final String clientId) {
        return setParam("client_id", clientId);
    }

    public SsoLoginRequest withClientSecret(final String clientSecret) {
        return setParam("client_secret", clientSecret);
    }

    public SsoLoginRequest withUsername(final String username) {
        return setParam("username", username);
    }

    public SsoLoginRequest withPassword(final String password) {
        return setParam("password", password);
    }

    public SsoLoginRequest withGrantType(final String grantType) {
        return setParam("grant_type", grantType);
    }

    @Override
    public String getApiEndpoint() {
        return "/services/oauth2/token";
    }

    public String getApiHostname() {
        return "https://login.salesforce.com";
    }
}
