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
 * Defines properties for connecting to Pardot API via a Proxy.
 */
public class ProxyConfiguration {
    // Optional Proxy Configuration
    private final String host;
    private final int port;
    private final String scheme;

    // Optional Proxy Authentication.
    private final String username;
    private final String password;

    /**
     * Empty constructor.
     * Calling this will populate an un-configured instance, meaning no proxy will be used
     * to make connections to the Pardot API.
     */
    public ProxyConfiguration() {
        this(null, 0, null, null, null);
    }

    /**
     * Constructor.
     * @param host Hostname of the proxy to connect to.
     * @param port Port of the proxy to connect to.
     * @param scheme Scheme of the proxy, supported values are 'HTTP' or 'HTTPS'
     * @param username Username for a proxy which requires authentication. Pass NULL if no authentication required.
     * @param password Password for a proxy which requires authentication. Pass NULL if no authentication required.
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
