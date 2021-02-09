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

import com.darksci.pardot.api.InvalidRequestException;
import com.darksci.pardot.api.LoginFailedException;
import com.darksci.pardot.api.PardotClient;
import com.darksci.pardot.api.config.PasswordLoginCredentials;
import com.darksci.pardot.api.request.login.LoginRequest;
import com.darksci.pardot.api.response.login.LoginResponse;

import java.util.Objects;

/**
 * Handles refreshing/renewing sessions using Pardot's Username and Password authentication scheme.
 * @deprecated This method of authentication to be removed by Pardot.  To be replaced with
 *             Salesforce SSO authentication {@link SsoSessionRefreshHandler}.
 */
public class PasswordSessionRefreshHandler implements SessionRefreshHandler {
    private final PasswordLoginCredentials credentials;
    private String apiToken = null;

    /**
     * Constructor.
     * @param credentials Configured credentials to use for renewing a session.
     */
    public PasswordSessionRefreshHandler(final PasswordLoginCredentials credentials) {
        this.credentials = Objects.requireNonNull(credentials);
    }

    /**
     * Does a valid session exist.
     * @return True if yes, false if not.
     */
    @Override
    public boolean isValid() {
        return apiToken != null;
    }

    /**
     * Clear saved Session token.
     */
    @Override
    public void clearToken() {
        apiToken = null;
    }

    /**
     * Refresh session token.
     * @return true on success, false on error.
     */
    @Override
    public boolean refreshCredentials(final PardotClient client) {
        // Otherwise attempt to authenticate.
        try {
            final LoginResponse response = client.login(new LoginRequest()
                .withEmail(credentials.getUsername())
                .withPassword(credentials.getPassword())
            );

            // If we have an API key.
            if (response.getApiKey() != null) {
                // Set it.
                setApiToken(response.getApiKey());
                return true;
            }
        } catch (final InvalidRequestException exception) {
            // If we get an InvalidRequest Exception
            throw new LoginFailedException(exception.getMessage(), exception.getErrorCode(), exception);
        }
        return false;
    }

    @Override
    public AuthParameter[] getAuthorizationHeaders() {
        if (!isValid()) {
            return AuthParameter.EMPTY;
        }

        final String value = "Pardot user_key=" + credentials.getUserKey() + ", api_key=" + apiToken;
        return new AuthParameter[] {
            new AuthParameter("Authorization", value)
        };
    }

    @Override
    public AuthParameter[] getAuthorizationRequestParameters() {
        return new AuthParameter[] {
            new AuthParameter("user_key", credentials.getUserKey())
        };
    }

    /**
     * Used to set ApiToken value.
     * @param apiToken value to set.
     */
    public void setApiToken(final String apiToken) {
        this.apiToken = apiToken;
    }
}
