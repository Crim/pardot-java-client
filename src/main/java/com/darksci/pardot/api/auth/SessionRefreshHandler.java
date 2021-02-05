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

import com.darksci.pardot.api.LoginFailedException;
import com.darksci.pardot.api.PardotClient;

/**
 * Interface for handling renewing session authentication tokens and defining how authentication tokens
 * are passed to requests against the Pardot API.
 */
public interface SessionRefreshHandler {
    /**
     * Is the current token valid.
     * @return True if set, false if not set.
     */
    boolean isValid();

    /**
     * Resets token.
     */
    void clearToken();

    /**
     * Refresh/Renew authentication token.
     *
     * @param client Reference to the PardotClient instance if you want to use it to make requests.
     * @return True on success, false on failure to renew.  Although, it is preferred to throw a LoginFailedException if the
     *         implementation fails to refresh the token, including relevant details about the error.
     * @throws LoginFailedException if a specific and actionable error occurs while refreshing the token.
     */
    boolean refreshCredentials(final PardotClient client);

    /**
     * Define zero or more headers that will be passed along to authenticate API requests.
     * @return Array of zero or more headers.
     */
    AuthParameter[] getAuthorizationHeaders();

    /**
     * Define zero or more request parameters that will be passed along to authenticate API requests.
     * @return Array of zero or more request parameters.
     */
    AuthParameter[] getAuthorizationRequestParameters();
}
