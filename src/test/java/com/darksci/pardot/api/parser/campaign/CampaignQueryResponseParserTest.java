/**
 * Copyright 2017 Stephen Powis https://github.com/Crim/pardot-java-client
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

package com.darksci.pardot.api.parser.campaign;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.response.campaign.Campaign;
import com.darksci.pardot.api.response.campaign.CampaignQueryResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 */
public class CampaignQueryResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(CampaignQueryResponseParserTest.class);

    /**
     * Validates we can parse a Campaign query with multiple campaigns response A-OK.
     */
    @Test
    public void testMultipleCampaigns() throws IOException {
        final String input = readFile("campaignQuery.xml");
        final CampaignQueryResponse.Result response = new CampaignQueryResponseParser().parseResponse(input);
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
        final CampaignQueryResponse.Result response = new CampaignQueryResponseParser().parseResponse(input);
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