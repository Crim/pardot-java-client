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
import com.darksci.pardot.api.config.Configuration;
import com.darksci.pardot.api.request.login.SsoLoginRequest;
import com.darksci.pardot.api.request.tag.TagQueryRequest;
import com.darksci.pardot.api.response.login.SsoLoginResponse;
import com.darksci.pardot.api.response.tag.TagQueryResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

/**
 * Test cases using SSO Login method.
 */
@Category(IntegrationTest.class)
public class PardotClientSsoIntegrationTest extends AbstractPardotClientIntegrationTest {
    private static final Logger logger = LoggerFactory.getLogger(PardotClientSsoIntegrationTest.class);

    @Override
    public ConfigurationBuilder createConfiguration() throws IOException {
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

        if (properties.getProperty("api_host") != null) {
            configBuilder
                .withPardotApiHost(properties.getProperty("api_host"))
                .withIgnoreInvalidSslCertificates(true);
        }

        // Create client
        return configBuilder;
    }

    /**
     * Attempt to login.
     */
    @Test
    public void loginTest() {
        final SsoLoginResponse response = client.login(new SsoLoginRequest()
            .withUsername(testConfig.getSsoLoginCredentials().getUsername())
            .withPassword(testConfig.getSsoLoginCredentials().getPassword())
            .withClientId(testConfig.getSsoLoginCredentials().getClientId())
            .withClientSecret(testConfig.getSsoLoginCredentials().getClientSecret())
        );

        logger.info("Response: {}", response);
        assertNotNull("Should not be null", response);
        assertNotNull("Should have non-null property", response.getAccessToken());
    }

    /**
     * Attempt to login with bad credentials.
     */
    @Test
    public void loginErrorTest() {
        final SsoLoginRequest request = new SsoLoginRequest()
            .withUsername(testConfig.getSsoLoginCredentials().getUsername())
            .withPassword(testConfig.getSsoLoginCredentials().getPassword())
            .withClientId("bad-id")
            .withClientSecret("bad-secret");

        assertThrows(LoginFailedException.class, () -> client.login(request));
    }

    /**
     * Inject a bad access_token, forcing the library to renew the session.
     */
    @Test
    public void sessionRenewTest_injectBadAccessTokenToForceSessionRenew() {
        // Inject a bad access token
        testConfig.getSsoLoginCredentials().setAccessToken("BAD-VALUE");

        // Execute query, this should force a bad auth response from pardot,
        // which then triggers renewing the SSO token, and then re-playing the tag query request.
        final TagQueryRequest request = new TagQueryRequest();
        final TagQueryResponse.Result result = client.tagQuery(request);
        logger.info("Result: {}", result);
    }

    @Test
    @Override
    public void accountReadTest() {
        super.accountReadTest();
    }

    @Test
    @Override
    public void userQueryTest() {
        super.userQueryTest();
    }

    @Test
    @Override
    public void userAbilitiesTest() {
        super.userAbilitiesTest();
    }

    @Test
    @Override
    public void userCookieTest() {
        super.userCookieTest();
    }

    @Test
    @Override
    public void userReadTest() {
        super.userReadTest();
    }

    @Test
    @Override
    public void userCreateTest() {
        super.userCreateTest();
    }

    @Test
    @Override
    public void userDeleteByEmailTest() {
        super.userDeleteByEmailTest();
    }

    @Test
    @Override
    public void userDeleteByIdTest() {
        super.userDeleteByIdTest();
    }

    @Test
    @Override
    public void userUpdateRoleByIdTest() {
        super.userUpdateRoleByIdTest();
    }

    @Test
    @Override
    public void campaignQueryTest() {
        super.campaignQueryTest();
    }

    @Test
    @Override
    public void campaignReadTest() {
        super.campaignReadTest();
    }

    @Test
    @Override
    public void campaignCreateTest() {
        super.campaignCreateTest();
    }

    @Test
    @Override
    public void campaignUpdateTest() {
        super.campaignUpdateTest();
    }

    @Test
    @Override
    public void customFieldQueryTest() {
        super.customFieldQueryTest();
    }

    @Test
    @Override
    public void customFieldReadTest() {
        super.customFieldReadTest();
    }

    @Test
    @Override
    public void customFieldCreateTest() {
        super.customFieldCreateTest();
    }

    @Test
    @Override
    public void customFieldUpdateTest() {
        super.customFieldUpdateTest();
    }

    @Test
    @Override
    public void customFieldDeleteTest() {
        super.customFieldDeleteTest();
    }

    @Test
    @Override
    public void customRedirectQueryTest() {
        super.customRedirectQueryTest();
    }

    @Test
    @Override
    public void customRedirectReadTest() {
        super.customRedirectReadTest();
    }

    @Test
    @Override
    public void dynamicContentQueryTest() {
        super.dynamicContentQueryTest();
    }

    @Test
    @Override
    public void dynamicContentReadTest() {
        super.dynamicContentReadTest();
    }

    @Test
    @Override
    public void emailReadTest() {
        super.emailReadTest();
    }

    @Test
    @Override
    public void emailStatsTest() {
        super.emailStatsTest();
    }

    @Test
    @Override
    public void emailSendOneToOneTest() {
        super.emailSendOneToOneTest();
    }

    @Test
    @Override
    public void emailSendListTest() {
        super.emailSendListTest();
    }

    @Test
    @Override
    public void emailClickQueryTest() {
        super.emailClickQueryTest();
    }

    @Test
    @Override
    public void emailTemplateReadTest() {
        super.emailTemplateReadTest();
    }

    @Test
    @Override
    public void emailTemplateListOneToOneTest() {
        super.emailTemplateListOneToOneTest();
    }

    @Test
    @Override
    public void formCreateTest() {
        super.formCreateTest();
    }

    @Test
    @Override
    public void formDeleteTest() {
        super.formDeleteTest();
    }

    @Test
    @Override
    public void formQueryTest() {
        super.formQueryTest();
    }

    @Test
    @Override
    public void formReadTest() {
        super.formReadTest();
    }

    @Test
    @Override
    public void formUpdateTest() {
        super.formUpdateTest();
    }

    @Test
    @Override
    public void listQueryTest() {
        super.listQueryTest();
    }

    @Test
    @Override
    public void listReadTest() {
        super.listReadTest();
    }

    @Test
    @Override
    public void listCreateTest() {
        super.listCreateTest();
    }

    @Test
    @Override
    public void listUpdateTest() {
        super.listUpdateTest();
    }

    @Test
    @Override
    public void listMembershipQueryTest() {
        super.listMembershipQueryTest();
    }

    @Test
    @Override
    public void listMembershipByListIdAndProspectIdReadTest() {
        super.listMembershipByListIdAndProspectIdReadTest();
    }

    @Test
    @Override
    public void listMembershipByIdReadTest() {
        super.listMembershipByIdReadTest();
    }

    @Test
    @Override
    public void listMembershipCreateTest() {
        super.listMembershipCreateTest();
    }

    @Test
    @Override
    public void listMembershipUpdateTest() {
        super.listMembershipUpdateTest();
    }

    @Test
    @Override
    public void opportunityQueryTest() {
        super.opportunityQueryTest();
    }

    @Test
    @Override
    public void opportunityReadTest() {
        super.opportunityReadTest();
    }

    @Test
    @Override
    public void opportunityCreateTest() {
        super.opportunityCreateTest();
    }

    @Test
    @Override
    public void opportunityUpdateTest() {
        super.opportunityUpdateTest();
    }

    @Test
    @Override
    public void opportunityDeleteTest() {
        super.opportunityDeleteTest();
    }

    @Test
    @Override
    public void opportunityUndeleteTest() {
        super.opportunityUndeleteTest();
    }

    @Test
    @Override
    public void prospectAccountQueryTest() {
        super.prospectAccountQueryTest();
    }

    @Test
    @Override
    public void prospectReadTest() {
        super.prospectReadTest();
    }

    @Test
    @Override
    public void prospectCreateTest() {
        super.prospectCreateTest();
    }

    @Test
    @Override
    public void prospectCreateTest_withMultiSelect_setSingleValue() {
        super.prospectCreateTest_withMultiSelect_setSingleValue();
    }

    @Test
    @Override
    public void prospectUpsertTest() {
        super.prospectUpsertTest();
    }

    @Test
    @Override
    public void prospectUpdateTest() {
        super.prospectUpdateTest();
    }

    @Test
    @Override
    public void prospectDeleteTest() {
        super.prospectDeleteTest();
    }

    @Test
    @Override
    public void prospectCreateAndDeleteTest() {
        super.prospectCreateAndDeleteTest();
    }

    @Test
    @Override
    public void prospectAssignTest() {
        super.prospectAssignTest();
    }

    @Test
    @Override
    public void prospectUnassignTest() {
        super.prospectUnassignTest();
    }

    @Test
    @Override
    public void prospectQueryTest() {
        super.prospectQueryTest();
    }

    @Test
    @Override
    public void tagQueryTest() {
        super.tagQueryTest();
    }

    @Test
    @Override
    public void tagQueryIdGreaterThanTest() {
        super.tagQueryIdGreaterThanTest();
    }

    @Test
    @Override
    public void tagReadTest() {
        super.tagReadTest();
    }

    @Test
    @Override
    public void tagObjectQuery() {
        super.tagObjectQuery();
    }

    @Test
    @Override
    public void tagObjectQueryWithEnum() {
        super.tagObjectQueryWithEnum();
    }

    @Test
    @Override
    public void tagObjectReadQuery() {
        super.tagObjectReadQuery();
    }

    @Test
    @Override
    public void visitorQueryTest() {
        super.visitorQueryTest();
    }

    @Test
    @Override
    public void visitorReadTest() {
        super.visitorReadTest();
    }

    @Test
    @Override
    public void visitorAssignTest() {
        super.visitorAssignTest();
    }

    @Test
    @Override
    public void visitorActivityQueryTest() {
        super.visitorActivityQueryTest();
    }

    @Test
    @Override
    public void visitorActivityReadTest() {
        super.visitorActivityReadTest();
    }
}
