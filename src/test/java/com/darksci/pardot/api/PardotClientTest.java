package com.darksci.pardot.api;

import categories.IntegrationTest;
import com.darksci.pardot.api.request.account.AccountReadRequest;
import com.darksci.pardot.api.request.campaign.CampaignCreateRequest;
import com.darksci.pardot.api.request.campaign.CampaignQueryRequest;
import com.darksci.pardot.api.request.campaign.CampaignReadRequest;
import com.darksci.pardot.api.request.campaign.CampaignUpdateRequest;
import com.darksci.pardot.api.request.email.EmailReadRequest;
import com.darksci.pardot.api.request.email.EmailSendListRequest;
import com.darksci.pardot.api.request.email.EmailSendOneToOneRequest;
import com.darksci.pardot.api.request.email.EmailStatsRequest;
import com.darksci.pardot.api.request.list.ListCreateRequest;
import com.darksci.pardot.api.request.list.ListQueryRequest;
import com.darksci.pardot.api.request.list.ListReadRequest;
import com.darksci.pardot.api.request.list.ListUpdateRequest;
import com.darksci.pardot.api.request.listmembership.ListMembershipCreateRequest;
import com.darksci.pardot.api.request.listmembership.ListMembershipQueryRequest;
import com.darksci.pardot.api.request.listmembership.ListMembershipReadRequest;
import com.darksci.pardot.api.request.listmembership.ListMembershipUpdateRequest;
import com.darksci.pardot.api.request.login.LoginRequest;
import com.darksci.pardot.api.request.prospect.ProspectAssignRequest;
import com.darksci.pardot.api.request.prospect.ProspectCreateRequest;
import com.darksci.pardot.api.request.prospect.ProspectDeleteRequest;
import com.darksci.pardot.api.request.prospect.ProspectQueryRequest;
import com.darksci.pardot.api.request.prospect.ProspectReadRequest;
import com.darksci.pardot.api.request.prospect.ProspectUnassignRequest;
import com.darksci.pardot.api.request.prospect.ProspectUpdateRequest;
import com.darksci.pardot.api.request.prospect.ProspectUpsertRequest;
import com.darksci.pardot.api.request.user.UserAbilitiesRequest;
import com.darksci.pardot.api.request.user.UserQueryRequest;
import com.darksci.pardot.api.request.user.UserReadRequest;
import com.darksci.pardot.api.response.account.Account;
import com.darksci.pardot.api.response.campaign.Campaign;
import com.darksci.pardot.api.response.campaign.CampaignQueryResponse;
import com.darksci.pardot.api.response.email.Email;
import com.darksci.pardot.api.response.email.EmailStatsResponse;
import com.darksci.pardot.api.response.list.List;
import com.darksci.pardot.api.response.list.ListMembership;
import com.darksci.pardot.api.response.list.ListQueryResponse;
import com.darksci.pardot.api.response.listmembership.ListMembershipQueryResponse;
import com.darksci.pardot.api.response.login.LoginResponse;
import com.darksci.pardot.api.response.prospect.Prospect;
import com.darksci.pardot.api.response.prospect.ProspectQueryResponse;
import com.darksci.pardot.api.response.user.User;
import com.darksci.pardot.api.response.user.UserAbilitiesResponse;
import com.darksci.pardot.api.response.user.UserQueryResponse;
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
 *
 * You can run these tests by creating a file under test/resources/test_credentials.properties with 3 values:
 * username=your_pardot_username
 * password=your_pardot_password
 * user_key=your_pardot_userkey
 */
@Category(IntegrationTest.class)
public class PardotClientTest {
    private static final Logger logger = LoggerFactory.getLogger(PardotClientTest.class);

    private Configuration testConfig;
    private PardotClient client;

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

        // Create client
        client = new PardotClient(testConfig);
    }

    @After
    public void tearDown() {
        testConfig = null;
    }

    /**
     * Attempt to login.
     */
    @Test
    public void loginTest() throws IOException {
        final LoginResponse response = client.login(new LoginRequest()
            .withEmail(testConfig.getEmail())
            .withPassword(testConfig.getPassword())
        );

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

        final Account response = client.accountRead(readRequest);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Attempt to retrieve users.
     */
    @Test
    public void userQueryTest() throws IOException {
        UserQueryRequest userQueryRequest = new UserQueryRequest()
            .withIdGreaterThan(10L)
            .withLimit(1)
            .withArchivedUsersOnly(true)
            .withSortByCreatedAt()
            .withSortOrderAscending();

        final UserQueryResponse.Result response = client.userQuery(userQueryRequest);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Attempt to retrieve current user's abilities.
     */
    @Test
    public void userAbilitiesTest() throws IOException {
        UserAbilitiesRequest userAbilitiesRequest = new UserAbilitiesRequest();

        final UserAbilitiesResponse.Result response = client.userAbilities(userAbilitiesRequest);
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

        final User response = client.userRead(readRequest);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Attempt to query campaigns.
     */
    @Test
    public void campaignQueryTest() throws IOException {
        CampaignQueryRequest request = new CampaignQueryRequest();

        final CampaignQueryResponse.Result response = client.campaignQuery(request);
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

        final Campaign response = client.campaignRead(request);
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
        final Campaign response = client.campaignCreate(request);
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
        final Campaign response = client.campaignUpdate(request);
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

        final Email response = client.emailRead(request);
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

        final EmailStatsResponse.Stats response = client.emailStats(request);
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

        final EmailSendOneToOneRequest request = new EmailSendOneToOneRequest()
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

        final Email response = client.emailSendOneToOne(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test querying lists.
     */
    @Test
    public void listQueryTest() {
        final ListQueryRequest request = new ListQueryRequest();

        final ListQueryResponse.Result response = client.listQuery(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test reading a specific list.
     */
    @Test
    public void listReadTest() {
        final ListReadRequest request = new ListReadRequest()
            .selectById(33173L);

        final List response = client.listRead(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test creating a list.
     */
    @Test
    public void listCreateTest() {
        // Create list
        final List list = new List();
        list.setName("My new test list");
        list.setTitle("Title of my list");
        list.setDescription("My new list description");
        list.setCrmVisible(true);
        list.setPublic(false);

        final ListCreateRequest request = new ListCreateRequest()
            .withList(list)
            .withFolderId(18449L);

        final List response = client.listCreate(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test update a list.
     */
    @Test
    public void listUpdateTest() {
        // Create list
        final List list = new List();
        list.setId(37275L);
        list.setName("UpdatedList");
        list.setTitle("Updated Title of my list");
        list.setDescription("My Updated list description");
        list.setCrmVisible(true);
        list.setPublic(false);

        final ListUpdateRequest request = new ListUpdateRequest()
            .withList(list)
            .withFolderId(18449L);

        final List response = client.listUpdate(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test querying listMemberships.
     */
    @Test
    public void listMembershipQueryTest() {
        final ListMembershipQueryRequest request = new ListMembershipQueryRequest()
            .withListId(33173L);

        final ListMembershipQueryResponse.Result response = client.listMembershipQuery(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test reading a specific listMembership by ListId and ProspectId.
     */
    @Test
    public void listMembershipByListIdAndProspectIdReadTest() {
        final ListMembershipReadRequest request = new ListMembershipReadRequest()
            .selectByListIdAndProspectId(33173L, 59156811L);

        final ListMembership response = client.listMembershipRead(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test reading a specific listMembership by Id.
     */
    @Test
    public void listMembershipByIdReadTest() {
        final ListMembershipReadRequest request = new ListMembershipReadRequest()
            .selectById(170293539L);

        final ListMembership response = client.listMembershipRead(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test creating a list membership.
     */
    @Test
    public void listMembershipCreateTest() {
        // Create list
        final ListMembership listMembership = new ListMembership();
        listMembership.setListId(33173L);
        listMembership.setProspectId(59156811L);

        final ListMembershipCreateRequest request = new ListMembershipCreateRequest()
            .withListMembership(listMembership);

        final ListMembership response = client.listMembershipCreate(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test updating a list membership.
     */
    @Test
    public void listMembershipUpdateTest() {
        // Create list
        final ListMembership listMembership = new ListMembership();
        listMembership.setListId(33173L);
        listMembership.setProspectId(59156811L);

        final ListMembershipUpdateRequest request = new ListMembershipUpdateRequest()
            .withListMembership(listMembership);

        final ListMembership response = client.listMembershipUpdate(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test sending a 1-to-1 email to a specific prospect.
     */
    @Test
    public void emailSendListTest() {
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

        final Email response = client.emailSendList(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test reading prospect by id.
     */
    @Test
    public void prospectReadTest() {
        final long prospectId = 59135263;

        final Prospect response = client.prospectRead(new ProspectReadRequest()
            .selectById(prospectId)
        );
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test creating prospect.
     */
    @Test
    public void prospectCreateTest() {
        final Prospect prospect = new Prospect();
        prospect.setEmail("random-email" + System.currentTimeMillis() + "@example.com");
        prospect.setFirstName("Test");
        prospect.setLastName("User");
        prospect.setCity("Some City");

        final ProspectCreateRequest request = new ProspectCreateRequest()
            .withProspect(prospect);

        // Issue request
        final Prospect response = client.prospectCreate(request);

        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test creating prospect.
     */
    @Test
    public void prospectUpsertTest() {
        final Prospect prospect = new Prospect();
        prospect.setEmail("random-email" + System.currentTimeMillis() + "@example.com");
        prospect.setFirstName("Test");
        prospect.setLastName("User");
        prospect.setCity("Some City");

        final ProspectUpsertRequest request = new ProspectUpsertRequest()
            .withProspect(prospect);

        // Issue request
        final Prospect response = client.prospectUpsert(request);

        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test creating prospect.
     */
    @Test
    public void prospectUpdateTest() {
        final long prospectId = 59138429L;

        final Prospect prospect = new Prospect();
        prospect.setId(prospectId);
        prospect.setFirstName("Test");
        prospect.setLastName("User");
        prospect.setCity("Some City");
        prospect.setCompany("New Company");

        final ProspectUpdateRequest request = new ProspectUpdateRequest()
            .withProspect(prospect);

        // Issue request
        final Prospect response = client.prospectUpdate(request);

        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test creating prospect.
     */
    @Test
    public void prospectDeleteTest() {
        final long prospectId = 59138429L;

        final ProspectDeleteRequest request = new ProspectDeleteRequest()
            .withProspectId(prospectId);

        // Issue request
        final boolean response = client.prospectDelete(request);

        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test assigning prospect.
     */
    @Test
    public void prospectAssignTest() {
        final long prospectId = 59138429L;
        final long userId = 3793281;

        final ProspectAssignRequest request = new ProspectAssignRequest()
            .withProspectId(prospectId)
            .withUserId(userId);

        // Issue request
        final Prospect response = client.prospectAssign(request);

        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test unassigning prospect.
     */
    @Test
    public void prospectUnassignTest() {
        final long prospectId = 59138429L;

        final ProspectUnassignRequest request = new ProspectUnassignRequest()
            .withProspectId(prospectId);

        // Issue request
        final Prospect response = client.prospectUnassign(request);

        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test reading prospect by id.
     */
    @Test
    public void prospectQueryTest() {
        final ProspectQueryRequest request = new ProspectQueryRequest()
            .withArchivedOnly();

        final ProspectQueryResponse.Result response = client.prospectQuery(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }
}