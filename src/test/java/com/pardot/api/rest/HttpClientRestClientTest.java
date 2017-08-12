package com.pardot.api.rest;

import com.pardot.api.Configuration;
import com.pardot.api.request.campaign.CampaignQueryRequest;
import com.pardot.api.request.user.UserAbilitiesRequest;
import com.pardot.api.request.user.UserQueryRequest;
import com.pardot.api.request.user.UserReadRequest;
import com.pardot.api.rest.responses.LoginResponse;
import com.pardot.api.rest.responses.campaign.CampaignQueryResponse;
import com.pardot.api.rest.responses.user.User;
import com.pardot.api.rest.responses.user.UserAbilitiesResponse;
import com.pardot.api.rest.responses.user.UserQueryResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.assertNotNull;

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
    public void userQueryTest() throws IOException {
        UserQueryRequest userQueryRequest = new UserQueryRequest()
            .withIdGreaterThan(10)
            .withLimit(1)
            .withArchivedUsersOnly(true)
            .withSortByCreatedAt()
            .withSortOrderAscending();

        final UserQueryResponse.Result response = restClient.userQuery(userQueryRequest);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Attempt to retrieve current user's abilities.
     */
    @Test
    public void userAbilitiesTest() throws IOException {
        UserAbilitiesRequest userAbilitiesRequest = new UserAbilitiesRequest();

        final UserAbilitiesResponse.Result response = restClient.userAbilities(userAbilitiesRequest);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Attempt to retrieve a user.
     */
    @Test
    public void userReadTest() throws IOException {
        UserReadRequest readRequest = new UserReadRequest()
            .selectById(3793281L);

        final User response = restClient.userRead(readRequest);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Attempt to query campaigns.
     */
    @Test
    public void campaignQueryTest() throws IOException {
        CampaignQueryRequest request = new CampaignQueryRequest();

        final CampaignQueryResponse.Result response = restClient.campaignQuery(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }
}