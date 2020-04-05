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

package com.darksci.pardot.api;

import categories.IntegrationTest;
import com.darksci.pardot.api.request.account.AccountReadRequest;
import com.darksci.pardot.api.request.campaign.CampaignCreateRequest;
import com.darksci.pardot.api.request.campaign.CampaignQueryRequest;
import com.darksci.pardot.api.request.campaign.CampaignReadRequest;
import com.darksci.pardot.api.request.campaign.CampaignUpdateRequest;
import com.darksci.pardot.api.request.customfield.CustomFieldCreateRequest;
import com.darksci.pardot.api.request.customfield.CustomFieldDeleteRequest;
import com.darksci.pardot.api.request.customfield.CustomFieldQueryRequest;
import com.darksci.pardot.api.request.customfield.CustomFieldReadRequest;
import com.darksci.pardot.api.request.customfield.CustomFieldUpdateRequest;
import com.darksci.pardot.api.request.customredirect.CustomRedirectQueryRequest;
import com.darksci.pardot.api.request.customredirect.CustomRedirectReadRequest;
import com.darksci.pardot.api.request.email.EmailReadRequest;
import com.darksci.pardot.api.request.email.EmailSendListRequest;
import com.darksci.pardot.api.request.email.EmailSendOneToOneRequest;
import com.darksci.pardot.api.request.email.EmailStatsRequest;
import com.darksci.pardot.api.request.emailclick.EmailClickQueryRequest;
import com.darksci.pardot.api.request.emailtemplate.EmailTemplateReadRequest;
import com.darksci.pardot.api.request.form.FormCreateRequest;
import com.darksci.pardot.api.request.form.FormDeleteRequest;
import com.darksci.pardot.api.request.form.FormQueryRequest;
import com.darksci.pardot.api.request.form.FormReadRequest;
import com.darksci.pardot.api.request.form.FormUpdateRequest;
import com.darksci.pardot.api.request.list.ListCreateRequest;
import com.darksci.pardot.api.request.list.ListQueryRequest;
import com.darksci.pardot.api.request.list.ListReadRequest;
import com.darksci.pardot.api.request.list.ListUpdateRequest;
import com.darksci.pardot.api.request.listmembership.ListMembershipCreateRequest;
import com.darksci.pardot.api.request.listmembership.ListMembershipQueryRequest;
import com.darksci.pardot.api.request.listmembership.ListMembershipReadRequest;
import com.darksci.pardot.api.request.listmembership.ListMembershipUpdateRequest;
import com.darksci.pardot.api.request.login.LoginRequest;
import com.darksci.pardot.api.request.opportunity.OpportunityCreateRequest;
import com.darksci.pardot.api.request.opportunity.OpportunityDeleteRequest;
import com.darksci.pardot.api.request.opportunity.OpportunityQueryRequest;
import com.darksci.pardot.api.request.opportunity.OpportunityReadRequest;
import com.darksci.pardot.api.request.opportunity.OpportunityUndeleteRequest;
import com.darksci.pardot.api.request.opportunity.OpportunityUpdateRequest;
import com.darksci.pardot.api.request.prospect.ProspectAssignRequest;
import com.darksci.pardot.api.request.prospect.ProspectCreateRequest;
import com.darksci.pardot.api.request.prospect.ProspectDeleteRequest;
import com.darksci.pardot.api.request.prospect.ProspectQueryRequest;
import com.darksci.pardot.api.request.prospect.ProspectReadRequest;
import com.darksci.pardot.api.request.prospect.ProspectUnassignRequest;
import com.darksci.pardot.api.request.prospect.ProspectUpdateRequest;
import com.darksci.pardot.api.request.prospect.ProspectUpsertRequest;
import com.darksci.pardot.api.request.tag.TagQueryRequest;
import com.darksci.pardot.api.request.tag.TagReadRequest;
import com.darksci.pardot.api.request.tagobject.TagObjectQueryRequest;
import com.darksci.pardot.api.request.tagobject.TagObjectReadRequest;
import com.darksci.pardot.api.request.tagobject.TagObjectType;
import com.darksci.pardot.api.request.user.UserAbilitiesRequest;
import com.darksci.pardot.api.request.user.UserCookieRequest;
import com.darksci.pardot.api.request.user.UserCreateRequest;
import com.darksci.pardot.api.request.user.UserDeleteRequest;
import com.darksci.pardot.api.request.user.UserQueryRequest;
import com.darksci.pardot.api.request.user.UserReadRequest;
import com.darksci.pardot.api.request.user.UserUpdateRoleRequest;
import com.darksci.pardot.api.request.visitor.VisitorAssignRequest;
import com.darksci.pardot.api.request.visitor.VisitorQueryRequest;
import com.darksci.pardot.api.request.visitor.VisitorReadRequest;
import com.darksci.pardot.api.request.visitoractivity.VisitorActivityQueryRequest;
import com.darksci.pardot.api.request.visitoractivity.VisitorActivityReadRequest;
import com.darksci.pardot.api.response.account.Account;
import com.darksci.pardot.api.response.campaign.Campaign;
import com.darksci.pardot.api.response.campaign.CampaignQueryResponse;
import com.darksci.pardot.api.response.customfield.CustomField;
import com.darksci.pardot.api.response.customfield.CustomFieldQueryResponse;
import com.darksci.pardot.api.response.customfield.CustomFieldType;
import com.darksci.pardot.api.response.customredirect.CustomRedirect;
import com.darksci.pardot.api.response.customredirect.CustomRedirectQueryResponse;
import com.darksci.pardot.api.response.email.Email;
import com.darksci.pardot.api.response.email.EmailStatsResponse;
import com.darksci.pardot.api.response.emailclick.EmailClickQueryResponse;
import com.darksci.pardot.api.response.emailtemplate.EmailTemplate;
import com.darksci.pardot.api.response.emailtemplate.EmailTemplateListOneToOneResponse;
import com.darksci.pardot.api.response.form.Form;
import com.darksci.pardot.api.response.form.FormQueryResponse;
import com.darksci.pardot.api.response.list.List;
import com.darksci.pardot.api.response.list.ListMembership;
import com.darksci.pardot.api.response.list.ListQueryResponse;
import com.darksci.pardot.api.response.listmembership.ListMembershipQueryResponse;
import com.darksci.pardot.api.response.login.LoginResponse;
import com.darksci.pardot.api.response.opportunity.Opportunity;
import com.darksci.pardot.api.response.opportunity.OpportunityQueryResponse;
import com.darksci.pardot.api.response.prospect.Prospect;
import com.darksci.pardot.api.response.prospect.ProspectQueryResponse;
import com.darksci.pardot.api.response.tag.Tag;
import com.darksci.pardot.api.response.tag.TagQueryResponse;
import com.darksci.pardot.api.response.tagobject.TagObject;
import com.darksci.pardot.api.response.tagobject.TagObjectQueryResponse;
import com.darksci.pardot.api.response.user.Cookie;
import com.darksci.pardot.api.response.user.User;
import com.darksci.pardot.api.response.user.UserAbilitiesResponse;
import com.darksci.pardot.api.response.user.UserQueryResponse;
import com.darksci.pardot.api.response.visitor.Visitor;
import com.darksci.pardot.api.response.visitor.VisitorQueryResponse;
import com.darksci.pardot.api.response.visitoractivity.VisitorActivity;
import com.darksci.pardot.api.response.visitoractivity.VisitorActivityQueryResponse;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Integration/End-to-End test over HttpClientRestClient.
 *
 * You can run these tests by creating a file under test/resources/test_credentials.properties with 3 values:
 * username=your_pardot_username
 * password=your_pardot_password
 * user_key=your_pardot_userkey
 */
@Category(IntegrationTest.class)
public class PardotClientIntegrationTest {
    private static final Logger logger = LoggerFactory.getLogger(PardotClientIntegrationTest.class);

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
        if (properties.getProperty("api_host") != null) {
            testConfig
                .setPardotApiHost(properties.getProperty("api_host"))
                .useInsecureSslCertificates();

        }

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
    public void loginTest() {
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
    public void accountReadTest() {
        AccountReadRequest readRequest = new AccountReadRequest();

        final Account response = client.accountRead(readRequest);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Attempt to retrieve users.
     */
    @Test
    public void userQueryTest() {
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
    public void userAbilitiesTest() {
        UserAbilitiesRequest userAbilitiesRequest = new UserAbilitiesRequest();

        final UserAbilitiesResponse.Result response = client.userAbilities(userAbilitiesRequest);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Attempt to retrieve current user's cookie.
     */
    @Test
    public void userCookieTest() {
        final Cookie response = client.userCookie(new UserCookieRequest());
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Attempt to retrieve a user.
     */
    @Test
    public void userReadTest() {
        UserReadRequest readRequest = new UserReadRequest()
            .selectById(1L);

        final User response = client.userRead(readRequest);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Attempt to create a new user.
     */
    @Test
    public void userCreateTest() {
        final UserCreateRequest createRequest = new UserCreateRequest()
            .withEmail("test" + System.currentTimeMillis() + "@salesforce.com")
            .withFirstName("First")
            .withLastName("Last")
            .withJobTitle("Job Title")
            .withPhone("123-123-1234")
            .withUrl("http:/www.example.com")
            .withPasswordExpireable(false)
            .withRole(4L)
            .withTimezone(DateTimeZone.UTC);

        final User response = client.userCreate(createRequest);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Attempt to delete an existing user.
     */
    @Test
    public void userDeleteByEmailTest() {
        final String email = "test" + System.currentTimeMillis() + "@salesforce.com";

        final UserCreateRequest createRequest = new UserCreateRequest()
            .withEmail(email)
            .withFirstName("First")
            .withLastName("Last")
            .withJobTitle("Job Title")
            .withPhone("123-123-1234")
            .withUrl("http:/www.example.com")
            .withPasswordExpireable(false)
            .withRole(4L)
            .withTimezone(DateTimeZone.UTC);

        final User response = client.userCreate(createRequest);
        assertNotNull("Should not be null", response);

        // Now attempt to delete it
        final UserDeleteRequest deleteRequest = new UserDeleteRequest()
            .deleteByEmail(email);

        final boolean result = client.userDelete(deleteRequest);
        assertTrue("Response should be true", result);
    }

    /**
     * Attempt to delete an existing user.
     */
    @Test
    public void userDeleteByIdTest() {
        final UserCreateRequest createRequest = new UserCreateRequest()
            .withEmail("test" + System.currentTimeMillis() + "@salesforce.com")
            .withFirstName("First")
            .withLastName("Last")
            .withJobTitle("Job Title")
            .withPhone("123-123-1234")
            .withUrl("http:/www.example.com")
            .withPasswordExpireable(false)
            .withRole(4L)
            .withTimezone(DateTimeZone.UTC);

        final User response = client.userCreate(createRequest);
        assertNotNull("Should not be null", response);

        // Now attempt to delete it
        final UserDeleteRequest deleteRequest = new UserDeleteRequest()
            .deleteById(response.getId());

        final boolean result = client.userDelete(deleteRequest);
        assertTrue("Response should be true", result);
    }

    /**
     * Attempt to delete an existing user.
     */
    @Test
    public void userUpdateRoleByIdTest() {
        final long originalRoleId = 4L;
        final String originalRoleName = "Sales";

        final long updatedRoleId = 5L;
        final String updatedRoleName = "Sales Manager";

        final UserCreateRequest createRequest = new UserCreateRequest()
            .withEmail("test" + System.currentTimeMillis() + "@salesforce.com")
            .withFirstName("First")
            .withLastName("Last")
            .withJobTitle("Job Title")
            .withPhone("123-123-1234")
            .withUrl("http:/www.example.com")
            .withPasswordExpireable(false)
            .withRole(originalRoleId)
            .withTimezone(DateTimeZone.UTC);

        final User response = client.userCreate(createRequest);
        assertNotNull("Should not be null", response);

        // Validate assumption of role
        assertEquals(originalRoleName, response.getRole());

        // Now attempt to updated
        final UserUpdateRoleRequest updateRoleRequest = new UserUpdateRoleRequest()
            .withUserId(response.getId())
            .withRoleId(updatedRoleId);

        final User updatedUser = client.userUpdateRole(updateRoleRequest);

        // Validate role was updated
        assertEquals(updatedRoleName, updatedUser.getRole());
    }

    /**
     * Attempt to query campaigns.
     */
    @Test
    public void campaignQueryTest() {
        CampaignQueryRequest request = new CampaignQueryRequest();

        final CampaignQueryResponse.Result response = client.campaignQuery(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Attempt to read campaign.
     */
    @Test
    public void campaignReadTest() {
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
    public void campaignCreateTest() {
        // Define campaign
        final Campaign campaign = new Campaign();
        campaign.setName("API 新　Test Campaign " + System.currentTimeMillis());
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
    public void campaignUpdateTest() {
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
     * Attempt to query custom fields.
     */
    @Test
    public void customFieldQueryTest() {
        CustomFieldQueryRequest request = new CustomFieldQueryRequest();

        final CustomFieldQueryResponse.Result response = client.customFieldQuery(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Attempt to read custom field.
     */
    @Test
    public void customFieldReadTest() {
        final long customFieldId = 5636;
        CustomFieldReadRequest request = new CustomFieldReadRequest()
            .selectById(customFieldId);

        final CustomField response = client.customFieldRead(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Attempt to create a custom field.
     */
    @Test
    public void customFieldCreateTest() {
        // Define custom field
        final CustomField customField = new CustomField();
        customField.setName("API Test Campaign " + System.currentTimeMillis());
        customField.setFieldType(CustomFieldType.TEXT);
        customField.setFieldId("Api_Test_Field_" + System.currentTimeMillis());
        customField.setRecordMultipleResponses(true);
        customField.setUseValues(true);

        // Create request
        CustomFieldCreateRequest request = new CustomFieldCreateRequest()
            .withCustomField(customField)
            .withFieldIsNotRequired();

        // Send Request
        final CustomField response = client.customFieldCreate(request);
        assertNotNull("Should not be null", response);
        assertNotNull("Has an Id", response.getId());
        assertEquals("Has correct name", customField.getName(), response.getName());
        logger.info("Response: {}", response);
    }

    /**
     * Attempt to update a custom field.
     */
    @Test
    public void customFieldUpdateTest() {
        final long customFieldId = 5634;

        // Define campaign
        final CustomField customField = new CustomField();
        customField.setId(customFieldId);
        customField.setName("Updated API Test CustomField " + System.currentTimeMillis());

        // Create request
        CustomFieldUpdateRequest request = new CustomFieldUpdateRequest()
            .withCustomField(customField);

        // Send Request
        final CustomField response = client.customFieldUpdate(request);
        assertNotNull("Should not be null", response);
        assertNotNull("Has an Id", response.getId());
        assertEquals("Has correct name", customField.getName(), response.getName());
        logger.info("Response: {}", response);
    }

    /**
     * Attempt to delete a custom field.
     */
    @Test
    public void customFieldDeleteTest() {
        final long customFieldId = 5636;

        // Create request
        CustomFieldDeleteRequest request = new CustomFieldDeleteRequest()
            .withCustomFieldId(customFieldId);

        // Send Request
        final Boolean response = client.customFieldDelete(request);
        assertNotNull("Should not be null", response);
        assertTrue("Is true", response);
        logger.info("Response: {}", response);
    }

    /**
     * Attempt to query custom redirects.
     */
    @Test
    public void customRedirectQueryTest() {
        CustomRedirectQueryRequest request = new CustomRedirectQueryRequest();

        final CustomRedirectQueryResponse.Result response = client.customRedirectQuery(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Attempt to read custom field.
     */
    @Test
    public void customRedirectReadTest() {
        final long customRedirectId = 1147;
        CustomRedirectReadRequest request = new CustomRedirectReadRequest()
            .selectById(customRedirectId);

        final CustomRedirect response = client.customRedirectRead(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test reading a specific email over the api.
     */
    @Test
    public void emailReadTest() {
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
    public void emailStatsTest() {
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
    public void emailSendOneToOneTest() {
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
     * Test sending a 1-to-1 email to a specific prospect.
     */
    @Test
    public void emailSendListTest() {
        final long campaignId = 1;
        final long listId = 5;
        final DateTime scheduledTime = DateTime.now().plusDays(2);

        EmailSendListRequest request = new EmailSendListRequest()
            .withListId(listId)
            .withCampaignId(campaignId)
            .withFromNameAndEmail("Test User", "no-reply@example.com")
            .withReplyToEmail("no-reply@example.com")
            .withName("Test List Email Send " + System.currentTimeMillis())
            .withSubject("Test Email From Api")
            .withTag("Tag 1")
            .withTag("Tag 2")
            .withTextContent("Hello %%first_name%%! %%unsubscribe%%")
            .withHtmlContent("<html><body><h1>Hello %%first_name%%! %%unsubscribe%% </h1></body></html>")
            .withScheduledTime(scheduledTime);

        final Email response = client.emailSendList(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test querying email clicks.
     */
    @Test
    public void emailClickQueryTest() {
        final EmailClickQueryRequest request = new EmailClickQueryRequest();

        final EmailClickQueryResponse.Result response = client.emailClickQuery(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test reading a specific email template over the api.
     */
    @Test
    public void emailTemplateReadTest() {
        final long emailTemplateId = 11L;

        final EmailTemplateReadRequest request = new EmailTemplateReadRequest()
            .selectById(emailTemplateId);

        final EmailTemplate response = client.emailTemplateRead(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test listing all one to one email templates.
     */
    @Test
    public void emailTemplateListOneToOneTest() {
        final EmailTemplateListOneToOneResponse.Result response = client.emailTemplateListOneToOne();
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Attempt to create a form.
     */
    @Test
    public void formCreateTest() {
        final String name = "My new Form Name" + System.currentTimeMillis();
        final Long campaignId = 1L;
        final Long layoutTemplateId = 1L;
        final Long folderId = 1L;

        final FormCreateRequest request = new FormCreateRequest()
            .withName(name)
            .withCampaignId(campaignId)
            .withLayoutTemplateId(layoutTemplateId)
            .withFolderId(folderId);

        final Form response = client.formCreate(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);

        assertNotNull("Has an Id", response.getId());
        assertEquals("Has correct name", name, response.getName());
        assertNotNull("Has a campaign", response.getCampaign());
        assertEquals("Has correct campaign id", campaignId, response.getCampaign().getId());
        assertNotNull("Has an embedcode", response.getEmbedCode());
    }

    /**
     * Attempt to create a form.
     */
    @Test
    public void formDeleteTest() {
        final Long formId = 8L;

        final FormDeleteRequest request = new FormDeleteRequest()
            .withFormId(formId);

        final boolean response = client.formDelete(request);
        assertTrue("Should be true", response);
    }

    /**
     * Attempt to query forms.
     */
    @Test
    public void formQueryTest() {
        final FormQueryRequest request = new FormQueryRequest();

        final FormQueryResponse.Result response = client.formQuery(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Attempt to read campaign.
     */
    @Test
    public void formReadTest() {
        final FormReadRequest request = new FormReadRequest()
            .selectById(1L);

        final Form response = client.formRead(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Attempt to update an existing form.
     */
    @Test
    public void formUpdateTest() {
        final String name = "My new Form Name" + System.currentTimeMillis();
        final Long campaignId = 1L;
        final Long layoutTemplateId = 1L;
        final Long folderId = 1L;
        final Long formId = 1L;

        final FormUpdateRequest request = new FormUpdateRequest()
            .withFormId(formId)
            .withName(name)
            .withCampaignId(campaignId)
            .withLayoutTemplateId(layoutTemplateId)
            .withFolderId(folderId);

        final Form response = client.formUpdate(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);

        assertNotNull("Has an Id", response.getId());
        assertEquals("Has correct name", name, response.getName());
        assertNotNull("Has a campaign", response.getCampaign());
        assertEquals("Has correct campaign id", campaignId, response.getCampaign().getId());
        assertNotNull("Has an embedcode", response.getEmbedCode());
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
     * Test querying opportunities.
     */
    @Test
    public void opportunityQueryTest() {
        final OpportunityQueryRequest request = new OpportunityQueryRequest();
        final OpportunityQueryResponse.Result response = client.opportunityQuery(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test reading opportunity by id.
     */
    @Test
    public void opportunityReadTest() {
        final long opportunityId = 1;

        final Opportunity response = client.opportunityRead(new OpportunityReadRequest()
            .selectById(opportunityId)
        );
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test creating an opportunity.
     */
    @Test
    public void opportunityCreateTest() {
        final OpportunityCreateRequest request = new OpportunityCreateRequest()
            .withCampaignId(1L)
            .withClosedAt(System.currentTimeMillis() / 1000)
            .withProspectId(1L)
            .withName("My test opp " + System.currentTimeMillis())
            .withProbability(50)
            .withValue(10000)
            .withStage("My Stage")
            .withStatusWon()
            .withType("My Type");

        final Opportunity response = client.opportunityCreate(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test updating an opportunity.
     */
    @Test
    public void opportunityUpdateTest() {
        final OpportunityUpdateRequest request = new OpportunityUpdateRequest()
            .withId(194L)
            .withCampaignId(1L)
            .withClosedAt(System.currentTimeMillis() / 1000)
            .withProspectId(1L)
            .withName("My Updated test opp " + System.currentTimeMillis())
            .withProbability(50)
            .withValue(10000)
            .withStage("My Stage")
            .withStatusWon()
            .withType("My Type");

        final Opportunity response = client.opportunityUpdate(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test deleting an opportunity.
     */
    @Test
    public void opportunityDeleteTest() {
        final OpportunityDeleteRequest request = new OpportunityDeleteRequest()
            .withOpportunityId(194L);

        client.opportunityDelete(request);
    }

    /**
     * Test undeleting an opportunity.
     */
    @Test
    public void opportunityUndeleteTest() {
        final OpportunityUndeleteRequest request = new OpportunityUndeleteRequest()
            .withOpportunityId(194L);

        client.opportunityUndelete(request);
    }

    /**
     * Test reading prospect by id.
     */
    @Test
    public void prospectReadTest() {
        final long prospectId = 59164595L;

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
    public void prospectCreateTest_withMultiSelect_setSingleValue() {
        final String multiSelectCustomFieldName = "CustomMultiSelectFIeld";

        final Prospect prospect = new Prospect();
        prospect.setEmail("random-email" + System.currentTimeMillis() + "@example.com");
        prospect.setFirstName("Test");
        prospect.setLastName("User");
        prospect.setCity("Some City");

        prospect.setCustomField(multiSelectCustomFieldName + "_0", "MultiValue0");
        prospect.setCustomField(multiSelectCustomFieldName + "_1", "MultiValue1");
        prospect.setCustomField(multiSelectCustomFieldName + "_2", "MultiValue2");

        final ProspectCreateRequest request = new ProspectCreateRequest()
            .withProspect(prospect);

        // Issue request
        final Prospect response = client.prospectCreate(request);

        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
        try {
            assertEquals("First value returned", "MultiValue0", response.getCustomField(multiSelectCustomFieldName));
            assertEquals("Should have 3 values", 3, response.getCustomFieldValues(multiSelectCustomFieldName).size());
            assertEquals("Should have value1", "MultiValue0", response.getCustomFieldValues(multiSelectCustomFieldName).get(0));
            assertEquals("Should have value2", "MultiValue1", response.getCustomFieldValues(multiSelectCustomFieldName).get(1));
            assertEquals("Should have value3", "MultiValue2", response.getCustomFieldValues(multiSelectCustomFieldName).get(2));
        } finally {
            // Cleanup / Delete test prospect.
            client.prospectDelete(new ProspectDeleteRequest().withProspectId(response.getId()));
        }
    }

    /**
     * Test creating prospect.
     */
    @Test
    public void prospectUpsertTest() {
        final String multiSelectCustomFieldName = "CustomMultiSelectFIeld";
        final String customFieldName = "MyCustom_Field";

        final Prospect prospect = new Prospect();
        prospect.setEmail("random-email" + System.currentTimeMillis() + "@example.com");
        prospect.setFirstName("Test");
        prospect.setLastName("User");
        prospect.setCity("Some City");

        // Multi select field
        java.util.List<String> values = new ArrayList<>();
        values.add("val1");
        values.add("val2");
        prospect.setCustomField(multiSelectCustomFieldName, values);
        prospect.appendCustomFieldValue(multiSelectCustomFieldName, "val3");

        // Custom field
        prospect.setCustomField(customFieldName, "custom field value here");

        final ProspectUpsertRequest request = new ProspectUpsertRequest()
            .withProspect(prospect);

        // Issue request
        final Prospect response = client.prospectUpsert(request);
        logger.info("Response: {}", response);
        try {
            assertNotNull("Should not be null", response);

            assertNotNull(response.getId());

            // Check multi value
            assertEquals("First value returned", "val1", response.getCustomField(multiSelectCustomFieldName));
            assertEquals("Should have 2 values", 3, response.getCustomFieldValues(multiSelectCustomFieldName).size());
            assertEquals("Should have value1", "val1", response.getCustomFieldValues(multiSelectCustomFieldName).get(0));
            assertEquals("Should have value2", "val2", response.getCustomFieldValues(multiSelectCustomFieldName).get(1));
            assertEquals("Should have value3", "val3", response.getCustomFieldValues(multiSelectCustomFieldName).get(2));

            // Check custom field
            assertEquals("CustomField set", "custom field value here", response.getCustomField(customFieldName));
        } finally {
            // Cleanup / Delete test prospect.
            client.prospectDelete(new ProspectDeleteRequest().withProspectId(response.getId()));
        }
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
     * Test querying prospects.
     */
    @Test
    public void prospectQueryTest() {
        final ProspectQueryRequest request = new ProspectQueryRequest()
            .withArchivedOnly();

        final ProspectQueryResponse.Result response = client.prospectQuery(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test querying tags.
     */
    @Test
    public void tagQueryTest() {
        final TagQueryRequest request = new TagQueryRequest();

        final TagQueryResponse.Result response = client.tagQuery(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test querying tags.
     */
    @Test
    public void tagQueryIdGreaterThanTest() {
        final TagQueryRequest request = new TagQueryRequest()
            .withIdGreaterThan(1L);

        final TagQueryResponse.Result response = client.tagQuery(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test Reading a tag.
     */
    @Test
    public void tagReadTest() {
        final long tagId = 711621L;

        final TagReadRequest request = new TagReadRequest()
            .selectById(tagId);

        final Tag response = client.tagRead(request);
        logger.info("Response: {}", response);

        assertNotNull("Should not be null", response);
        assertNotNull("Should have a name", response.getName());
        assertNotNull("Should have an id", response.getId());
        assertNotNull("Should have a create at", response.getCreatedAt());
        assertNotNull("Should have an updated at", response.getUpdatedAt());
    }

    /**
     * Test querying tag objects.
     */
    @Test
    public void tagObjectQuery() {
        final TagObjectQueryRequest request = new TagObjectQueryRequest();

        final TagObjectQueryResponse.Result response = client.tagObjectQuery(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test querying tag objects.
     */
    @Test
    public void tagObjectQueryWithEnum() {
        final TagObjectQueryRequest request = new TagObjectQueryRequest()
            .withType(TagObjectType.EMAIL);

        final TagObjectQueryResponse.Result response = client.tagObjectQuery(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test reading tag object.
     */
    @Test
    public void tagObjectReadQuery() {
        final long tagObjectId = 17736959L;

        final TagObjectReadRequest request = new TagObjectReadRequest()
            .selectById(tagObjectId);

        final TagObject response = client.tagObjectRead(request);
        assertNotNull("Should not be null", response);
        assertNotNull(response.getType());
        assertNotNull(response.getTypeName());
        logger.info("Response: {}", response);
    }

    /**
     * Test Querying visitors.
     */
    @Test
    public void visitorQueryTest() {
        final VisitorQueryRequest request = new VisitorQueryRequest()
            .withNonIdentifiedVisitors();

        final VisitorQueryResponse.Result response = client.visitorQuery(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test Reading a visitor.
     */
    @Test
    public void visitorReadTest() {
        final long visitorId = 37640L;
        final VisitorReadRequest request = new VisitorReadRequest()
            .selectById(visitorId);

        final Visitor response = client.visitorRead(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test assigning a visitor.
     */
    @Test
    public void visitorAssignTest() {
        final long visitorId = 1610949348L;
        final long prospectId = 41323302L;

        final VisitorAssignRequest request = new VisitorAssignRequest()
            .withVisitorId(visitorId)
            .withProspectId(prospectId);

        final Visitor response = client.visitorAssign(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test Querying visitor activities.
     */
    @Test
    public void visitorActivityQueryTest() {
        final VisitorActivityQueryRequest request = new VisitorActivityQueryRequest();

        final VisitorActivityQueryResponse.Result response = client.visitorActivityQuery(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }

    /**
     * Test Reading a visitor activity.
     */
    @Test
    public void visitorActivityReadTest() {
        final long visitorActivityId = 320419032L;
        final VisitorActivityReadRequest request = new VisitorActivityReadRequest()
            .selectById(visitorActivityId);

        final VisitorActivity response = client.visitorActivityRead(request);
        assertNotNull("Should not be null", response);
        logger.info("Response: {}", response);
    }
}