package com.darksci.pardot.api.parser.opportunity;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.response.opportunity.Opportunity;
import com.darksci.pardot.api.response.prospect.Prospect;
import com.darksci.pardot.api.response.visitoractivity.VisitorActivity;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Validates we can parse opportunity read response.
 */
public class OpportunityReadResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(OpportunityReadResponseParserTest.class);

    /**
     * Validates we can parse a custom field read
     */
    @Test
    public void testRead() throws IOException {
        final String input = readFile("opportunityRead.xml");
        final Opportunity opportunity = new OpportunityReadResponseParser().parseResponse(input);
        logger.info("Result: {}", opportunity);

        assertNotNull("Should not be null", opportunity);
        validateOpportunity(opportunity);
    }

    private void validateOpportunity(final Opportunity opportunity) {
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
        final Prospect prospect = opportunity.getProspects().get(0);
        assertEquals("Has correct prospect id", 11, (long) prospect.getId());
        assertEquals("Has correct prospect email", "angela.lansbury@cbs.com", prospect.getEmail());

        // Has activities in this response
        final List<VisitorActivity> activityList = opportunity.getOpportunityActivities();
        assertEquals("Should have activities", 1, activityList.size());
        assertEquals("Has correct id", 100, (long) activityList.get(0).getId());
        assertEquals("Has correct prospect id", 11, (long) activityList.get(0).getProspectId());
    }
}