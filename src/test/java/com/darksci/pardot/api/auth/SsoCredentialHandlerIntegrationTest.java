package com.darksci.pardot.api.auth;

import categories.IntegrationTest;
import com.darksci.pardot.api.Configuration;
import com.darksci.pardot.api.ConfigurationBuilder;
import com.darksci.pardot.api.LoginFailedException;
import com.darksci.pardot.api.PardotClient;
import com.darksci.pardot.api.rest.HttpClientRestClient;
import com.darksci.pardot.api.rest.RestClient;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

@Category(IntegrationTest.class)
public class SsoCredentialHandlerIntegrationTest {

    private Configuration testConfig;
    private PardotClient pardotClient;

    /**
     * Validates what happens when we successfully refresh credentials.
     */
    @Test
    public void doSuccessfulAuthTest() throws IOException {
        // Load valid credentials
        loadValidCredentials();

        final RestClient restClient = new HttpClientRestClient();
        restClient.init(testConfig);

        final SsoCredentialHandler handler = new SsoCredentialHandler(
            testConfig.getSsoLoginCredentials(),
            pardotClient
        );

        // Sanity check
        assertFalse(testConfig.getSsoLoginCredentials().hasAccessToken());

        // Validate not yet valid
        assertFalse("should not yet be valid", handler.isValid());

        // Call method with valid credentials and this should return true.
        assertTrue(handler.refreshCredentials());

        // Sanity check
        assertTrue(testConfig.getSsoLoginCredentials().hasAccessToken());
    }

    /**
     * Validates what happens when we fail refresh credentials.
     */
    @Test
    public void doFailedAuthTest() {
        loadInvalidCredentials();

        final RestClient restClient = new HttpClientRestClient();
        restClient.init(testConfig);

        final SsoCredentialHandler handler = new SsoCredentialHandler(
            testConfig.getSsoLoginCredentials(),
            pardotClient
        );

        // Sanity check
        assertFalse(testConfig.getSsoLoginCredentials().hasAccessToken());

        // Validate not yet valid
        assertFalse("should not yet be valid", handler.isValid());

        // Call method with valid credentials and this should throw LoginFailedException.
        assertThrows(LoginFailedException.class, handler::refreshCredentials);

        // Sanity check
        assertFalse(testConfig.getSsoLoginCredentials().hasAccessToken());
    }

    private void loadInvalidCredentials() {
        // Build new configuration
        final ConfigurationBuilder configBuilder = Configuration.newBuilder()
            .withSsoLogin(
                "user",
                "notapassword",
                "notaclientid",
                "notaclientsecret",
                "some-biz-unit-id"
            );

        // Create config
        testConfig = configBuilder.build();
        pardotClient = new PardotClient(testConfig);
    }

    private void loadValidCredentials() throws IOException {
        final InputStream inputStream = getClass().getClassLoader().getResourceAsStream("test_sso_credentials.properties");

        // Load properties
        Properties properties = new Properties();
        properties.load(inputStream);
        inputStream.close();

        // Build new configuration
        final ConfigurationBuilder configBuilder = Configuration.newBuilder()
            .withSsoLogin(
                properties.getProperty("username"),
                properties.getProperty("password"),
                properties.getProperty("client_id"),
                properties.getProperty("client_secret"),
                properties.getProperty("business_unit_id")
            );

        // Create config
        testConfig = configBuilder.build();
        pardotClient = new PardotClient(testConfig);
    }
}