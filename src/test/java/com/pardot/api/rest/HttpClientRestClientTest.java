package com.pardot.api.rest;

import com.pardot.api.Configuration;
import com.pardot.api.request.user.UserQueryRequest;
import com.pardot.api.rest.responses.LoginResponse;
import com.pardot.api.rest.responses.UserQueryResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Integration test over HttpClientRestClient.
 */
public class HttpClientRestClientTest {
    private static final Logger logger = LoggerFactory.getLogger(HttpClientRestClientTest.class);

    private Configuration testConfig;
    private HttpClientRestClient restClient;

    @Before
    public void setup() throws IOException {
        final InputStream inputStream = getClass().getClassLoader().getResourceAsStream("test_credentials.properties");

        // Load properties
        Properties properties = new Properties();
        properties.load(inputStream);
        inputStream.close();

        // Load in config
        testConfig = new Configuration(
            properties.getProperty("username"),
            properties.getProperty("password"),
            properties.getProperty("user_key")
        );

        logger.info("Config: {}", testConfig);

        // Create and init rest client
        restClient = new HttpClientRestClient();
        restClient.init(testConfig);
    }

    @After
    public void tearDown() {
        testConfig = null;
    }

    @Test
    public void smokeTest() throws IOException {
        // Define configuration
        Configuration configuration = new Configuration("test@example.com", "password", "userkey");
        HttpClientRestClient restClient = new HttpClientRestClient();
        restClient.init(configuration);
        restClient.get("https://www.pardot.com/");
    }

    /**
     * Attempt to login.
     */
    @Test
    public void loginTest() throws IOException {
        final LoginResponse response = restClient.authenticate();

        logger.info("Response: {}", response);
        assertNotNull("Should not be null", response);
        assertNotNull("Should have non-null property", response.getApiKey());
    }

    /**
     * Attempt to retrieve users.
     */
    @Test
    public void usersTest() throws IOException {
        UserQueryRequest userQueryRequest = new UserQueryRequest()
            .withIdGreaterThan(10);

        final UserQueryResponse.Result response = restClient.userQuery(userQueryRequest);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }
}