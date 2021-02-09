/**
 * Copyright 2017, 2018, 2019, 2020 Stephen Powis https://github.com/Crim/pardot-java-client
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.darksci.pardot.api.request.login;

import com.darksci.pardot.api.auth.AuthorizationServer;
import com.darksci.pardot.api.request.BaseRequest;

import java.util.Objects;

/**
 * Defines a request to Salesforce's SSO Authentication end points.
 */
public class SsoLoginRequest extends BaseRequest<SsoLoginRequest> implements LoginRequestMarker {
    /**
     * Defines the Hostname and URI that we attempt to authenticate the OAuth2 request against.
     */
    private AuthorizationServer authorizationServer;

    /**
     * Constructor.
     * This uses the Default Salesforce SSO Authorization server.
     */
    public SsoLoginRequest() {
        this(AuthorizationServer.DEFAULT_SALESFORCE);
    }

    /**
     * Constructor.
     * @param authorizationServer Allows for overriding the default Authorization server.
     */
    public SsoLoginRequest(final AuthorizationServer authorizationServer) {
        this.authorizationServer = Objects.requireNonNull(authorizationServer);
        withGrantType("password");
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

    public SsoLoginRequest withAuthorizationServer(final AuthorizationServer authorizationServer) {
        this.authorizationServer = Objects.requireNonNull(authorizationServer);
        return this;
    }

    @Override
    public String getApiEndpoint() {
        return authorizationServer.getAuthUri();
    }

    public String getApiHostname() {
        return authorizationServer.getAuthServer();
    }
}
