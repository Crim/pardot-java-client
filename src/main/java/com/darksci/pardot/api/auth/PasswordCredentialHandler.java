package com.darksci.pardot.api.auth;

import com.darksci.pardot.api.InvalidRequestException;
import com.darksci.pardot.api.LoginFailedException;
import com.darksci.pardot.api.PardotClient;
import com.darksci.pardot.api.config.PasswordLoginCredentials;
import com.darksci.pardot.api.request.login.LoginRequest;
import com.darksci.pardot.api.response.login.LoginResponse;

import java.util.Objects;

/**
 *
 */
public class PasswordCredentialHandler implements CredentialHandler {
    private final PasswordLoginCredentials credentials;
    private final PardotClient client;

    public PasswordCredentialHandler(final PasswordLoginCredentials credentials, final PardotClient client) {
        this.credentials = Objects.requireNonNull(credentials);
        this.client = Objects.requireNonNull(client);
    }

    public boolean isValid() {
        return credentials.hasApiKey();
    }

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
