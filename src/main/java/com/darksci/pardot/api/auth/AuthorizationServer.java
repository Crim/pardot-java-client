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

package com.darksci.pardot.api.auth;

import java.util.Objects;

/**
 * Used for defining an alternative Authorization Server hostname or end point for SSO OAuth2 authentication.
 */
public class AuthorizationServer {
    /**
     * The default Authorization Server for production salesforce.
     */
    public static final AuthorizationServer DEFAULT_SALESFORCE = new AuthorizationServer(
        "https://login.salesforce.com",
        "/services/oauth2/token"
    );

    /**
     * The default Authorization Server for test/sandbox instances.
     */
    public static final AuthorizationServer SANDBOX_SALESFORCE = new AuthorizationServer(
        "https://test.salesforce.com",
        "/services/oauth2/token"
    );

    /**
     * Hostname, including protocol, with no trailing /
     * Example: "https://login.salesforce.com"
     */
    private final String authServer;

    /**
     * URI.
     * Example: "/services/oauth2/token"
     */
    private final String authUri;

    /**
     * Constructor.
     * @param authServer Hostname, including protocol, with no trailing /, Example: "https://login.salesforce.com".
     * @param authUri Example: "/services/oauth2/token".
     */
    public AuthorizationServer(final String authServer, final String authUri) {
        this.authServer = Objects.requireNonNull(authServer);
        this.authUri = Objects.requireNonNull(authUri);
    }

    public String getAuthServer() {
        return authServer;
    }

    public String getAuthUri() {
        return authUri;
    }

    @Override
    public String toString() {
        return "AuthorizationServer{"
            + "authServer='" + authServer + '\''
            + ", authUri='" + authUri + '\''
            + '}';
    }
}
