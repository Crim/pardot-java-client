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

public class ProxyConfiguration {
    // Optional Proxy Configuration
    private final String host;
    private final int port;
    private final String scheme;

    // Optional Proxy Authentication.
    private final String username;
    private final String password;

    /**
     * Not configured constructor.
     */
    public ProxyConfiguration() {
        this(null, 0, null, null, null);
    }

    /**
     * Constructor.
     * @param host
     * @param port
     * @param scheme
     * @param username
     * @param password
     */
    public ProxyConfiguration(final String host, final int port, final String scheme, final String username, final String password) {
        this.host = host;
        this.port = port;
        this.scheme = scheme;
        this.username = username;
        this.password = password;
    }

    public boolean isConfigured() {
        return getHost() != null;
    }

    public boolean isAuthenticationRequired() {
        return getUsername() != null;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getScheme() {
        return scheme;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        String authDisplay = "";
        if (isAuthenticationRequired()) {
            authDisplay =
                ", username='" + username + '\''
                + ", password='XXXXXXXXXX'";
        }

        return "ProxyConfiguration{"
            + "host='" + host + '\''
            + ", port=" + port
            + ", scheme='" + scheme + '\''
            + authDisplay
            + '}';
    }
}
