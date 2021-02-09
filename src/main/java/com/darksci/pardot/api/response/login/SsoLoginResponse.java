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

package com.darksci.pardot.api.response.login;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a success response from Authenticating via Salesforce SSO.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SsoLoginResponse {
    private final String accessToken;
    private final String instanceUrl;
    private final String id;
    private final String tokenType;
    private final String issuedAt;
    private final String signature;

    /**
     * Constructor.
     * @param accessToken user's access token.
     * @param instanceUrl Instance the user belongs to.
     * @param id Reference to user's record/
     * @param tokenType Type of token.
     * @param issuedAt When the token was issued.
     * @param signature Signature of the response.
     */
    @JsonCreator
    public SsoLoginResponse(
        @JsonProperty("access_token") final String accessToken,
        @JsonProperty("instance_url") final String instanceUrl,
        @JsonProperty("id") final String id,
        @JsonProperty("token_type") final String tokenType,
        @JsonProperty("issued_at") final String issuedAt,
        @JsonProperty("signature") final String signature) {
        this.accessToken = accessToken;
        this.instanceUrl = instanceUrl;
        this.id = id;
        this.tokenType = tokenType;
        this.issuedAt = issuedAt;
        this.signature = signature;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getInstanceUrl() {
        return instanceUrl;
    }

    public String getId() {
        return id;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getIssuedAt() {
        return issuedAt;
    }

    public String getSignature() {
        return signature;
    }

    @Override
    public String toString() {
        return "SsoLoginResponse{"
            + "accessToken='XXXXXXXXXXXXX'"
            + ", instanceUrl='" + instanceUrl + '\''
            + ", id='" + id + '\''
            + ", tokenType='" + tokenType + '\''
            + ", issuedAt='" + issuedAt + '\''
            + ", signature='" + signature + '\''
            + '}';
    }
}
