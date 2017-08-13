package com.darksci.pardot.api.parser.campaign;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.response.campaign.Campaign;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CampaignReadResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(CampaignReadResponseParserTest.class);

    /**
     * Validates we can parse a User Read
     */
    @Test
    public void testRead() throws IOException {
        final String input = readFile("campaignRead.xml");
        final Campaign campaign = new CampaignReadResponseParser().parseResponse(input);
        logger.info("Result: {}", campaign);

        assertNotNull("Should not be null", campaign);
        assertEquals("Has correct id", 456L, (long) campaign.getId());
        assertEquals("Has correct last name", "Test Campaign", campaign.getName());
        assertEquals("Has correct cost", 100, (int) campaign.getCost());
    }
}