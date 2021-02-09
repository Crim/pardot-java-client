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

import java.util.Objects;

/**
 * Defines credentials for authenticating to Pardot API using Salesforce SSO using a previously
 * acquired refresh_token.
 */
public class SsoAccessTokenCredentials {
    // Immutable values.
    private final String accessToken;
    private final String clientId;
    private final String clientSecret;
    private final String businessUnitId;

    /**
     * Constructor.
     * @param accessToken Previously acquired access_token from the access_key OAuth2 authentication flow.
     * @param clientId Connected App client or consumer Id.
     * @param clientSecret Connected App client or consumer secret.
     * @param businessUnitId Pardot Business Unit Id to connect to.
     */
    public SsoAccessTokenCredentials(
        final String accessToken,
        final String clientId,
        final String clientSecret,
        final String businessUnitId
    ) {

        this.accessToken = Objects.requireNonNull(accessToken);
        this.clientId = Objects.requireNonNull(clientId);
        this.clientSecret = Objects.requireNonNull(clientSecret);
        this.businessUnitId = Objects.requireNonNull(businessUnitId);
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getBusinessUnitId() {
        return businessUnitId;
    }

    @Override
    public String toString() {
        return "SsoRefreshTokenCredentials{"
            + "accessToken='XXXXXXXXXX'"
            + ", clientId='" + clientId + '\''
            + ", clientSecret='XXXXXXXXXX'"
            + ", businessUnitId='" + businessUnitId + '\''
            + '}';
    }
}
