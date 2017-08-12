package com.darksci.pardot.api.rest.handlers.email;

import com.darksci.pardot.api.response.email.EmailStatsResponse;
import com.darksci.pardot.api.rest.handlers.BaseResponseHandlerTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EmailStatsResponseHandlerTest extends BaseResponseHandlerTest {
    private static final Logger logger = LoggerFactory.getLogger(EmailStatsResponseHandlerTest.class);

    /**
     * Validates we can parse a User Read
     */
    @Test
    public void testStats() throws IOException {
        final String input = readFile("emailStats.xml");
        final EmailStatsResponse.Stats stats = new EmailStatsResponseHandler().parseResponse(input);
        logger.info("Result: {}", stats);

        assertNotNull("Should not be null", stats);
        assertEquals("Has correct sent", 1024, (int) stats.getSent());
        assertEquals("Has correct sent", 1020, (int) stats.getDelivered());
        assertEquals("Has correct sent", 512, (int) stats.getTotalClicks());
        assertEquals("Has correct sent", 256, (int) stats.getUniqueClicks());
        assertEquals("Has correct sent", 10, (int) stats.getSoftBounced());
        assertEquals("Has correct sent", 12, (int) stats.getHardBounced());
        assertEquals("Has correct sent", 14, (int) stats.getOptOuts());
        assertEquals("Has correct sent", 2, (int) stats.getSpamComplaints());
        assertEquals("Has correct sent", 964, (int) stats.getOpens());
        assertEquals("Has correct sent", 459, (int) stats.getUniqueOpens());
        assertEquals("Has correct sent", "98.42%", stats.getDeliveryRate());
        assertEquals("Has correct sent", "42.00%", stats.getOpensRate());
        assertEquals("Has correct sent", "23.00%", stats.getClickThroughRate());
        assertEquals("Has correct sent", "53.00%", stats.getUniqueClickThroughRate());
        assertEquals("Has correct sent", "75.05%", stats.getClickOpenRatio());
        assertEquals("Has correct sent", "4.00%", stats.getOptOutRate());
        assertEquals("Has correct sent", "2.20%", stats.getSpamComplaintRate());
    }
}