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
 */
public class PasswordSessionRefreshHandler implements SessionRefreshHandler {
    private final PasswordLoginCredentials credentials;
    private final PardotClient client;

    /**
     * Constructor.
     * @param credentials Configured credentials to use for renewing a session.
     * @param client Underlying PardotClient to make requests using.
     */
    public PasswordSessionRefreshHandler(final PasswordLoginCredentials credentials, final PardotClient client) {
        this.credentials = Objects.requireNonNull(credentials);
        this.client = Objects.requireNonNull(client);
    }

    /**
     * Does a valid session exist.
     * @return True if yes, false if not.
     */
    @Override
    public boolean isValid() {
        return credentials.hasApiKey();
    }

    /**
     * Clear saved Session token.
     */
    @Override
    public void clearToken() {
        credentials.clearApiKey();
    }

    /**
     * Refresh session token.
     * @return true on success, false on error.
     */
    @Override
    public boolean refreshCredentials() {
        // Otherwise attempt to authenticate.
        try {
            final LoginResponse response = client.login(new LoginRequest()
                .withEmail(credentials.getUsername())
                .withPassword(credentials.getPassword())
            );

            // If we have an API key.
            if (response.getApiKey() != null) {
                // Set it.
                credentials.setApiKey(response.getApiKey());
                return true;
            }
        } catch (final InvalidRequestException exception) {
            // If we get an InvalidRequest Exception
            throw new LoginFailedException(exception.getMessage(), exception.getErrorCode(), exception);
        }
        return false;
    }
}
