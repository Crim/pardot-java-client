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

package com.darksci.pardot.api.parser.email;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.response.email.EmailStatsResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EmailStatsResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(EmailStatsResponseParserTest.class);

    /**
     * Validates we can parse a User Read
     */
    @Test
    public void testStats() throws IOException {
        final String input = readFile("emailStats.xml");
        final EmailStatsResponse.Stats stats = new EmailStatsResponseParser().parseResponse(input);
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