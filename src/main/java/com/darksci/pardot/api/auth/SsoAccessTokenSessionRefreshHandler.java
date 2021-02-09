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

import com.darksci.pardot.api.PardotClient;
import com.darksci.pardot.api.config.SsoAccessTokenCredentials;

import java.util.Objects;

/**
 * Handles authenticating credentials using SSO with a previously acquired access_token.
 *
 * NOTE: This implementation does NOT support renewing sessions when they expire.
 *       see {@link SsoRefreshTokenSessionRefreshHandler} for an implementation that can renew the session
 *       automatically using a refresh_token.
 */
public class SsoAccessTokenSessionRefreshHandler implements SessionRefreshHandler {
    private final SsoAccessTokenCredentials credentials;

    /**
     * Constructor.
     * @param credentials Credentials required for authenticating.
     */
    public SsoAccessTokenSessionRefreshHandler(final SsoAccessTokenCredentials credentials) {
        this.credentials = Objects.requireNonNull(credentials);
    }

    @Override
    public boolean isValid() {
        return credentials.getAccessToken() != null;
    }

    @Override
    public void clearToken() {
        // No-op, unable to clear.
    }

    @Override
    public boolean refreshCredentials(final PardotClient client) {
        /*
         * This authentication method does not support refreshing the access_token.
         *
         * see {@link SsoRefreshTokenSessionRefreshHandler} for an implementation that can renew the session
         * automatically using a refresh_token.
         */
        return false;
    }

    @Override
    public AuthParameter[] getAuthorizationHeaders() {
        if (!isValid()) {
            return AuthParameter.EMPTY;
        }

        final String value = "Bearer " + credentials.getAccessToken();
        return new AuthParameter[] {
            new AuthParameter("Authorization", value),
            new AuthParameter("Pardot-Business-Unit-Id", credentials.getBusinessUnitId())
        };
    }

    @Override
    public AuthParameter[] getAuthorizationRequestParameters() {
        return AuthParameter.EMPTY;
    }
}
