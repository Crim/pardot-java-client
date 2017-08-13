package com.darksci.pardot.api.rest;

import categories.IntegrationTest;
import com.darksci.pardot.api.request.account.AccountReadRequest;
import com.darksci.pardot.api.request.email.EmailSendListRequest;
import com.darksci.pardot.api.response.account.Account;
import com.darksci.pardot.api.response.email.Email;
import com.darksci.pardot.api.response.user.UserQueryResponse;
import com.darksci.pardot.api.Configuration;
import com.darksci.pardot.api.request.campaign.CampaignCreateRequest;
import com.darksci.pardot.api.request.campaign.CampaignQueryRequest;
import com.darksci.pardot.api.request.campaign.CampaignReadRequest;
import com.darksci.pardot.api.request.campaign.CampaignUpdateRequest;
import com.darksci.pardot.api.request.email.EmailReadRequest;
import com.darksci.pardot.api.request.email.EmailSendOneToOneRequest;
import com.darksci.pardot.api.request.email.EmailStatsRequest;
import com.darksci.pardot.api.request.user.UserAbilitiesRequest;
import com.darksci.pardot.api.request.user.UserQueryRequest;
import com.darksci.pardot.api.request.user.UserReadRequest;
import com.darksci.pardot.api.response.LoginResponse;
import com.darksci.pardot.api.response.campaign.Campaign;
import com.darksci.pardot.api.response.campaign.CampaignQueryResponse;
import com.darksci.pardot.api.response.email.EmailStatsResponse;
import com.darksci.pardot.api.response.user.User;
import com.darksci.pardot.api.response.user.UserAbilitiesResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Integration/End-to-End test over HttpClientRestClient.
 */
@Category(IntegrationTest.class)
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
     * Attempt to retrieve account.
     */
    @Test
    public void accountReadTest() throws IOException {
        AccountReadRequest readRequest = new AccountReadRequest();

        final Account response = restClient.accountRead(readRequest);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
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
        CampaignQueryRequest request = new CampaignQueryRequest()
            .withSortBy("poop");

        final CampaignQueryResponse.Result response = restClient.campaignQuery(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Attempt to read campaign.
     */
    @Test
    public void campaignReadTest() throws IOException {
        CampaignReadRequest request = new CampaignReadRequest()
            .selectById(14885L);

        final Campaign response = restClient.campaignRead(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Attempt to create a campaign.
     */
    @Test
    public void campaignCreateTest() throws IOException {
        // Define campaign
        final Campaign campaign = new Campaign();
        campaign.setName("API Test Campaign " + System.currentTimeMillis());
        campaign.setCost(31337);

        // Create request
        CampaignCreateRequest request = new CampaignCreateRequest()
            .withCampaign(campaign);

        // Send Request
        final Campaign response = restClient.campaignCreate(request);
        assertNotNull("Should not be null", response);
        assertNotNull("Has an Id", response.getId());
        assertEquals("Has correct name", campaign.getName(), response.getName());
        assertEquals("Has correct cost", campaign.getCost(), response.getCost());
        logger.info("Response: {}", response);
    }

    /**
     * Attempt to create a campaign.
     */
    @Test
    public void campaignUpdateTest() throws IOException {
        final long campaignId = 14887L;

        // Define campaign
        final Campaign campaign = new Campaign();
        campaign.setId(campaignId);
        campaign.setName("Updated API Test Campaign " + System.currentTimeMillis());
        campaign.setCost(20);

        // Create request
        CampaignUpdateRequest request = new CampaignUpdateRequest()
            .withCampaign(campaign);

        // Send Request
        final Campaign response = restClient.campaignUpdate(request);
        assertNotNull("Should not be null", response);
        assertEquals("Has correct Id", campaignId, (long) response.getId());
        assertEquals("Has correct name", campaign.getName(), response.getName());
        assertEquals("Has correct cost", campaign.getCost(), response.getCost());
        logger.info("Response: {}", response);
    }

    /**
     * Test reading a specific email over the api.
     */
    @Test
    public void emailReadTest() throws IOException {
        final long emailId = 167044349L;

        EmailReadRequest request = new EmailReadRequest()
            .selectById(emailId);

        final Email response = restClient.emailRead(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test reading a specific email over the api.
     */
    @Test
    public void emailStatsTest() throws IOException {
        final long listEmailId = 167044401;

        EmailStatsRequest request = new EmailStatsRequest()
            .selectByListEmailId(listEmailId);

        final EmailStatsResponse.Stats response = restClient.emailStats(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test sending a 1-to-1 email to a specific prospect.
     */
    @Test
    public void emailSendOneToOneTest() throws IOException {
        final long campaignId = 14885;
        final long prospectId = 59135263;

        EmailSendOneToOneRequest request = new EmailSendOneToOneRequest()
            .withProspectId(prospectId)
            .withCampaignId(campaignId)
            .withFromNameAndEmail("Test User", "no-reply@example.com")
            .withReplyToEmail("no-reply@example.com")
            .withName("Test Email Send " + System.currentTimeMillis())
            .withOperationalEmail(true)
            .withSubject("Test Email From Api")
            .withTag("Tag 1")
            .withTag("Tag 2")
            .withTextContent("Hello %%first_name%%!")
            .withHtmlContent("<html><body><h1>Hello %%first_name%%!</h1></body></html>");

        final Email response = restClient.emailSendOneToOne(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test sending a 1-to-1 email to a specific prospect.
     */
    @Test
    public void emailSendListTest() throws IOException {
        final long campaignId = 14885;
        final long listId = 33173;

        EmailSendListRequest request = new EmailSendListRequest()
            .withListId(listId)
            .withCampaignId(campaignId)
            .withFromNameAndEmail("Test User", "no-reply@example.com")
            .withReplyToEmail("no-reply@example.com")
            .withName("Test List Email Send " + System.currentTimeMillis())
            .withOperationalEmail(true)
            .withSubject("Test Email From Api")
            .withTag("Tag 1")
            .withTag("Tag 2")
            .withTextContent("Hello %%first_name%%!")
            .withHtmlContent("<html><body><h1>Hello %%first_name%%!</h1></body></html>");

        final Email response = restClient.emailSendList(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }
}