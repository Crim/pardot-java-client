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

package com.darksci.pardot.api.parser.opportunity;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.response.opportunity.Opportunity;
import com.darksci.pardot.api.response.opportunity.OpportunityQueryResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Validates the ability to parse Opportunity query responses.
 */
public class OpportunityQueryResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(OpportunityQueryResponseParserTest.class);

    /**
     * Validates we can parse a Opportunity query with multiple responses A-OK.
     */
    @Test
    public void testMultipleOpportunities() throws IOException {
        final String input = readFile("opportunityQuery.xml");
        final OpportunityQueryResponse.Result response = new OpportunityQueryResponseParser().parseResponse(input);
        logger.info("Result: {}", response);

        assertNotNull("Should not be null", response);
        assertEquals("Should have 193 results", 193, (int) response.getTotalResults());
        assertEquals("Should have 2 results", 2, response.getOpportunities().size());
        validateOpportunity1(response.getOpportunities().get(0));
        validateOpportunity2(response.getOpportunities().get(1));
    }

    private void validateOpportunity1(final Opportunity opportunity) {
        assertEquals("Has correct id", 1, (long) opportunity.getId());
        assertEquals("Has correct name", "Opportunity1", opportunity.getName());
        assertEquals("Has correct value", 5, (int) opportunity.getValue());
        assertEquals("Has correct probability", 50, (int) opportunity.getProbability());
        assertEquals("Has correct type", "ReallyGood", opportunity.getType());
        assertEquals("Has correct Stage", "Alpha", opportunity.getStage());
        assertEquals("Has correct status", "Open", opportunity.getStatus());

        assertNotNull("Has non-null campaign", opportunity.getCampaign());
        assertEquals("has correct campaignId", 3, (long) opportunity.getCampaign().getId());
        assertEquals("has correct campaign name", "Google Buyer's Guide Campaign", opportunity.getCampaign().getName());

        assertNotNull("Has non-null prospects", opportunity.getProspects());
        assertEquals("has 1 prospect", 1, opportunity.getProspects().size());
        assertEquals("Has correct prospect id", 11, (long) opportunity.getProspects().get(0).getId());
        assertEquals("Has correct prospect email", "angela.lansbury@cbs.com", opportunity.getProspects().get(0).getEmail());

        // Has no activities in this response
        assertEquals("Should have no activities", 0, opportunity.getOpportunityActivities().size());
    }

    private void validateOpportunity2(final Opportunity opportunity) {
        assertEquals("Has correct id", 2, (long) opportunity.getId());
        assertEquals("Has correct name", "Opportunity2", opportunity.getName());
        assertEquals("Has correct value", 200, (int) opportunity.getValue());
        assertEquals("Has correct probability", 2, (int) opportunity.getProbability());
        assertEquals("Has correct type", "Horrible", opportunity.getType());
        assertEquals("Has correct Stage", "Beta", opportunity.getStage());
        assertEquals("Has correct status", "Open", opportunity.getStatus());

        assertNotNull("Has non-null campaign", opportunity.getCampaign());
        assertEquals("has correct campaignId", 3, (long) opportunity.getCampaign().getId());
        assertEquals("has correct campaign name", "Google Buyer's Guide Campaign", opportunity.getCampaign().getName());

        assertNotNull("Has non-null prospects", opportunity.getProspects());
        assertEquals("has 0 prospects", 0, opportunity.getProspects().size());

        // Has no activities in this response
        assertEquals("Should have no activities", 0, opportunity.getOpportunityActivities().size());
    }
}