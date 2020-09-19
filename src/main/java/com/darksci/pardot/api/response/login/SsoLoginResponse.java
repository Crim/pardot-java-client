package com.darksci.pardot.api.response.login;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
public class SsoLoginResponse {
    private final String accessToken;
    private final String instanceUrl;
    private final String id;
    private final String tokenType;
    private final String issuedAt;
    private final String signature;

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
