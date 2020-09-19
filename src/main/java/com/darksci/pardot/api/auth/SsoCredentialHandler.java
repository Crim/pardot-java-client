package com.darksci.pardot.api.auth;

import com.darksci.pardot.api.PardotClient;
import com.darksci.pardot.api.config.SsoLoginCredentials;
import com.darksci.pardot.api.request.login.SsoLoginRequest;
import com.darksci.pardot.api.response.login.SsoLoginResponse;
import com.darksci.pardot.api.rest.RestClient;
import com.darksci.pardot.api.rest.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * Handles refreshing credentials using SSO Login method.
 */
public class SsoCredentialHandler implements CredentialHandler {
    private final SsoLoginCredentials credentials;
    private final PardotClient client;

    public SsoCredentialHandler(final SsoLoginCredentials credentials, final PardotClient client) {
        this.credentials = Objects.requireNonNull(credentials);
        this.client = Objects.requireNonNull(client);
    }

    @Override
    public boolean isValid() {
        return credentials.hasAccessToken();
    }

    @Override
    public boolean refreshCredentials() {
        final SsoLoginResponse response = client.login(new SsoLoginRequest(credentials));

        // If we have an API key.
        if (response.getAccessToken() != null) {
            // Set it.
            credentials.setAccessToken(response.getAccessToken());
            return true;
        }

        return false;
    }
}
