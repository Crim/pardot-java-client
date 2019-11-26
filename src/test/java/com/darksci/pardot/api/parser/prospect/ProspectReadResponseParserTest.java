/**
 * Copyright 2017, 2018, 2019 Stephen Powis https://github.com/Crim/pardot-java-client
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

package com.darksci.pardot.api.parser.prospect;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.response.list.List;
import com.darksci.pardot.api.response.list.ListSubscription;
import com.darksci.pardot.api.response.prospect.Prospect;
import com.darksci.pardot.api.response.visitoractivity.VisitorActivity;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProspectReadResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(ProspectReadResponseParserTest.class);

    /**
     * Validates we can parse an Account Read
     */
    @Test
    public void testRead() throws IOException {
        final String input = readFile("prospectRead.xml");
        final Prospect response = new ProspectReadResponseParser().parseResponse(input);
        logger.info("Result: {}", response);

        // Do validation
        validateProspect1(response);
    }

    private void validateProspect1(final Prospect prospect) {
        // Validate identifiers
        assertEquals("has correct id", 1233, (long) prospect.getId());
        assertEquals("has correct email", "random.user@example.com", prospect.getEmail());

        // Validate default fields
        assertEquals("has correct campaignId", 423, (long) prospect.getCampaignId());
        assertEquals("has correct first name", "Random", prospect.getFirstName());
        assertEquals("has correct last name", "user", prospect.getLastName());
        assertEquals("has correct country", "Canada", prospect.getCountry());
        assertEquals("has correct address one", "123 Main St", prospect.getAddressOne());
        assertEquals("has correct address two ", "Unit 44", prospect.getAddressTwo());
        assertEquals("has correct city", "Manassas", prospect.getCity());
        assertEquals("has correct state", "VA", prospect.getState());
        assertEquals("has correct zip", "32327", prospect.getZip());
        assertEquals("has correct phone", "(321) 456-0987", prospect.getPhone());
        assertEquals("has correct grade", "B", prospect.getGrade());
        assertEquals("has correct score", 3232, (int) prospect.getScore());
        assertEquals("has correct recent interaction", "Played Video Games", prospect.getRecentInteraction());
        assertEquals("has correct created at", "2017-08-11T21:40:25.000", prospect.getCreatedAt().toString());
        assertEquals("has correct updated at", "2017-08-11T21:40:25.000", prospect.getUpdatedAt().toString());
        assertEquals("has correct is_reviewed", true, prospect.getIsReviewed());
        assertEquals("has correct is_starred", false, prospect.getIsStarred());
        assertEquals("has correct is do not call", false, prospect.getIsDoNotCall());

        // Validate custom fields
        assertNotNull("Should have non-null custom fields", prospect.getCustomFields());
        assertEquals("Should have 2 custom fields", 2, prospect.getCustomFields().size());
        assertEquals("Should have first custom field value", "my custom field value", prospect.getCustomField("MyCustom_Field"));
        assertEquals("Should have second custom field value", "my other custom field value", prospect.getCustomField("MyOtherCustom_Field"));

        // Validate assigned To user
        assertNotNull("Assigned To is not null", prospect.getAssignedTo());
        assertEquals("has correct id", 2332L, (long) prospect.getAssignedUser().getId());
        assertEquals("has correct account id", 1L, (long) prospect.getAssignedUser().getAccount());
        assertEquals("Has correct email", "sales.user@example.com", prospect.getAssignedUser().getEmail());
        assertEquals("Has correct first_name", "Sales", prospect.getAssignedUser().getFirstName());
        assertEquals("Has correct last_name", "User", prospect.getAssignedUser().getLastName());
        assertEquals("Has correct role", "Administrator", prospect.getAssignedUser().getRole());
        assertEquals("has correct created at", "2016-01-04T10:39:29.000", prospect.getAssignedUser().getCreatedAt().toString());
        assertEquals("has correct updated at", "2017-08-09T18:28:24.000", prospect.getAssignedUser().getUpdatedAt().toString());

        // Validate campaign
        assertNotNull("Should have non-null campaign", prospect.getCampaign());
        assertEquals("has correct campaign id", 423, (long) prospect.getCampaign().getId());
        assertEquals("has correct campaign name", "Website Tracking", prospect.getCampaign().getName());

        // Validate profile
        assertNotNull("has non null profile", prospect.getProfile());
        assertEquals("Has correct profile id", 209, (long) prospect.getProfile().getId());
        assertEquals("Has correct profile name", "Default", prospect.getProfile().getName());

        // Spot check one profile criteria
        assertNotNull("Has profile criteria", prospect.getProfile().getProfileCriteria());
        assertEquals("Has profile criteria count", 5, prospect.getProfile().getProfileCriteria().size());
        assertEquals("Has correct profile criteria id", 1041, (long) prospect.getProfile().getProfileCriteria().get(0).getId());
        assertEquals("Has correct profile criteria name", "Company Size", prospect.getProfile().getProfileCriteria().get(0).getName());
        assertEquals("Has correct profile criteria matches", "Unknown", prospect.getProfile().getProfileCriteria().get(0).getMatches());

        // Spot check one VisitorActivity
        assertNotNull("Has non null visitor activities", prospect.getVisitorActivities());
        assertEquals("Has expected number of visitor activities", 19, prospect.getVisitorActivities().size());
        final VisitorActivity visitorActivity = prospect.getVisitorActivities().get(0);
        assertEquals("Has correct id", 710207401, (long) visitorActivity.getId());
        assertEquals("Has correct type", 6, (int) visitorActivity.getType());
        assertEquals("Has correct type name", "Email", visitorActivity.getTypeName());
        assertEquals("Has correct details", "This is the Subject", visitorActivity.getDetails());
        assertEquals("Has correct email id", 167044349, (long) visitorActivity.getEmailId());
        assertNotNull("Has non null campaign", visitorActivity.getCampaign());
        assertEquals("Has correct campaign id", 423, (long) visitorActivity.getCampaign().getId());
        assertEquals("Has correct campaign name", "Website Tracking", visitorActivity.getCampaign().getName());
        assertEquals("has correct created at", "2017-08-11T21:41:08.000", visitorActivity.getCreatedAt().toString());

        // Spot check one list
        assertNotNull("Has non null list subscriptions", prospect.getListSubscriptions());
        assertEquals("Has expected number of list subscriptions", 1, prospect.getListSubscriptions().size());
        final ListSubscription listSubscription = prospect.getListSubscriptions().get(0);
        assertEquals("Has correct id", 158902003, (long) listSubscription.getId());
        assertEquals("has correct did opt in", false, listSubscription.getDidOptIn());
        assertEquals("has correct did opt out", false, listSubscription.getDidOptOut());
        assertEquals("has correct created at", "2017-08-11T22:03:37.000", listSubscription.getCreatedAt().toString());
        assertEquals("has correct updated at", "2017-08-11T22:03:37.000", listSubscription.getUpdatedAt().toString());

        // Validate list
        assertNotNull("list is not null", listSubscription.getList());
        final List list = listSubscription.getList();
        assertEquals("Has correct id", 33173, (long) list.getId());
        assertEquals("Has correct name", "Stevie Only List", list.getName());
        assertEquals("has correct is public", false, list.getIsPublic());
        assertEquals("has correct is dynamic", false, list.getIsDynamic());
        assertEquals("has correct is crm visible", false, list.getIsCrmVisible());
        assertEquals("has correct created at", "2017-08-11T22:03:22.000", list.getCreatedAt().toString());
        assertEquals("has correct updated at", "2017-08-11T22:03:22.000", list.getUpdatedAt().toString());
    }

    /**
     * Validates a prospect read with last_activity entry.
     */
    @Test
    public void testRead_prospectWithLastActivity() throws IOException {
        final String input = readFile("prospectRead2.xml");
        final Prospect response = new ProspectReadResponseParser().parseResponse(input);
        logger.info("Result: {}", response);

        assertNotNull("Is not null", response);
        assertNotNull("Has non-null lastActivity", response.getLastActivity());
    }
}