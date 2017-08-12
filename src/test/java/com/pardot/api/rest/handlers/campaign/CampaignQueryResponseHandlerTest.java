package com.pardot.api.rest.handlers.campaign;

import com.pardot.api.response.campaign.Campaign;
import com.pardot.api.response.campaign.CampaignQueryResponse;
import com.pardot.api.rest.handlers.BaseResponseHandlerTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 */
public class CampaignQueryResponseHandlerTest extends BaseResponseHandlerTest {
    private static final Logger logger = LoggerFactory.getLogger(CampaignQueryResponseHandlerTest.class);

    /**
     * Validates we can parse a Campaign query with multiple campaigns response A-OK.
     */
    @Test
    public void testMultipleCampaigns() throws IOException {
        final String input = readFile("campaignQuery.xml");
        final CampaignQueryResponse.Result response = new CampaignQueryResponseHandler().parseResponse(input);
        logger.info("Result: {}", response);

        assertNotNull("Should not be null", response);
        assertEquals("Should have 2 results", 2, (int) response.getTotalResults());
        assertEquals("Should have 2 results", 2, response.getCampaigns().size());
        validateCampaign1(response.getCampaigns().get(0));
        validateCampaign2(response.getCampaigns().get(1));
    }

    /**
     * Validates we can parse a Campaign query with a single campaign response A-OK.
     */
    @Test
    public void testSingleCampaign() throws IOException {
        final String input = readFile("campaignQuery2.xml");
        final CampaignQueryResponse.Result response = new CampaignQueryResponseHandler().parseResponse(input);
        logger.info("Result: {}", response);

        assertNotNull("Should not be null", response);
        assertEquals("Should have 1 results", 1, (int) response.getTotalResults());
        assertEquals("Should have 1 results", 1, response.getCampaigns().size());
        validateCampaign1(response.getCampaigns().get(0));
    }

    private void validateCampaign1(final Campaign campaign) {
        assertEquals("Has correct id", 123L, (long) campaign.getId());
        assertEquals("Has correct last name", "Website Tracking", campaign.getName());
        assertEquals("Has correct cost", null, campaign.getCost());
    }

    private void validateCampaign2(final Campaign campaign) {
        assertEquals("Has correct id", 456L, (long) campaign.getId());
        assertEquals("Has correct last name", "Test Campaign", campaign.getName());
        assertEquals("Has correct cost", 100, (int) campaign.getCost());
    }

}