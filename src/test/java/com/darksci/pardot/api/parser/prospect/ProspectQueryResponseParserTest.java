package com.darksci.pardot.api.parser.prospect;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.response.prospect.Prospect;
import com.darksci.pardot.api.response.prospect.ProspectQueryResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ProspectQueryResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(ProspectQueryResponseParserTest.class);

    /**
     * Validates we can parse a Prospect Query response.
     */
    @Test
    public void testQuery() throws IOException {
        final String input = readFile("prospectQuery.xml");
        final ProspectQueryResponse.Result response = new ProspectQueryResponseParser().parseResponse(input);
        logger.info("Result: {}", response);

        // High level validation
        assertEquals("Has expected value for total_results", 128, (int) response.getTotalResults());
        assertEquals("Has correct number of prospects in result", 2, response.getProspects().size());

        // Prospect validation
        validateProspect1(response.getProspects().get(0));
        validateProspect2(response.getProspects().get(1));
    }

    private void validateProspect1(final Prospect prospect) {
        assertEquals("has correct id", 331, (long) prospect.getId());
        assertEquals("has correct campaignId", 893, (long) prospect.getCampaignId());
        assertEquals("has correct first name", "Else", prospect.getFirstName());
        assertEquals("has correct last name", "Someone", prospect.getLastName());
        assertEquals("has correct email", "testuser+2@live.com", prospect.getEmail());
        assertEquals("has correct country", "USA", prospect.getCountry());
        assertEquals("has correct address one", "123 Burkhall St", prospect.getAddressOne());
        assertEquals("has correct address two ", "Unit 103", prospect.getAddressTwo());
        assertEquals("has correct city", "Weymouth", prospect.getCity());
        assertEquals("has correct state", "TX", prospect.getState());
        assertEquals("has correct zip", "02190 ", prospect.getZip());
        assertEquals("has correct phone", "(321) 456-0987", prospect.getPhone());
        assertEquals("has correct grade", "A+", prospect.getGrade());
        assertEquals("has correct score", 0, (int) prospect.getScore());
        assertEquals("has correct recent interaction", "Never active", prospect.getRecentInteraction());
        assertEquals("has correct created at", "2016-01-17T04:49:51.000", prospect.getCreatedAt().toString());
        assertEquals("has correct updated at", "2017-08-09T18:32:40.000", prospect.getUpdatedAt().toString());

        // Validate campaign
        assertNotNull("Should have non-null campaign", prospect.getCampaign());
        assertEquals("has correct campaign id", 893, (long) prospect.getCampaign().getId());
        assertEquals("has correct campaign name", "Database Mining", prospect.getCampaign().getName());
    }

    private void validateProspect2(final Prospect prospect) {
        assertEquals("has correct id", 332, (long) prospect.getId());
        assertEquals("has correct campaignId", 99, (long) prospect.getCampaignId());
        assertEquals("has correct first name", "Test", prospect.getFirstName());
        assertEquals("has correct last name", "User", prospect.getLastName());
        assertEquals("has correct email", "testUser@aol.com", prospect.getEmail());
        assertEquals("has correct country", "USA", prospect.getCountry());
        assertEquals("has correct address one", "89 Sunset Way", prospect.getAddressOne());
        assertNull("has null address two ", prospect.getAddressTwo());
        assertEquals("has correct city", "Atlanta", prospect.getCity());
        assertEquals("has correct state", "GA", prospect.getState());
        assertEquals("has correct zip", "012345", prospect.getZip());
        assertEquals("has correct phone", "(123) 456-7890", prospect.getPhone());
        assertEquals("has correct score", 123, (int) prospect.getScore());
        assertEquals("has correct grade", "C-", prospect.getGrade());
        assertEquals("has correct recent interaction", "Sent Fancy Email", prospect.getRecentInteraction());
        assertEquals("has correct created at", "2016-01-17T04:49:51.000", prospect.getCreatedAt().toString());
        assertEquals("has correct updated at", "2017-08-09T18:32:40.000", prospect.getUpdatedAt().toString());

        // Validate campaign
        assertNotNull("Should have non-null campaign", prospect.getCampaign());
        assertEquals("has correct campaign id", 99, (long) prospect.getCampaign().getId());
        assertEquals("has correct campaign name", "Website Tracking", prospect.getCampaign().getName());
    }

}