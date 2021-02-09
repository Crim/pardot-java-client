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

package com.darksci.pardot.api.config;

/**
 * Defines credentials for authenticating to Pardot API using Pardot username and password.
 * @deprecated This method of authentication to be removed by Pardot.  To be replaced with
 *             Salesforce SSO authentication {@link SsoLoginCredentials}.
 */
public class PasswordLoginCredentials {
    // Immutable Fields.
    private final String username;
    private final String password;
    private final String userKey;

    /**
     * Constructor.
     * @param username Pardot username or email address.
     * @param password Pardot user's password.
     * @param userKey Pardot user's user_key.
     */
    public PasswordLoginCredentials(final String username, final String password, final String userKey) {
        this.username = username;
        this.password = password;
        this.userKey = userKey;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUserKey() {
        return userKey;
    }

    @Override
    public String toString() {
        return "PasswordLoginCredentials{"
            + "username='" + username + '\''
            + ", password='XXXXXXXXX'"
            + ", userKey='XXXXXXXXX'"
            + '}';
    }
}
