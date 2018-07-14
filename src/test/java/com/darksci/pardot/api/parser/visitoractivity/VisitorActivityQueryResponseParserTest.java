/**
 * Copyright 2017, 2018 Stephen Powis https://github.com/Crim/pardot-java-client
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
package com.darksci.pardot.api.parser.visitoractivity;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.response.visitoractivity.VisitorActivity;
import com.darksci.pardot.api.response.visitoractivity.VisitorActivityQueryResponse;
import com.darksci.pardot.api.response.visitoractivity.VisitorActivityType;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class VisitorActivityQueryResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(VisitorActivityQueryResponseParserTest.class);

    /**
     * Validates we can parse a Visitor Activity query with multiple visitor activities response A-OK.
     */
    @Test
    public void testMultipleActivities() throws IOException {
        final String input = readFile("visitorActivityQuery.xml");
        final VisitorActivityQueryResponse.Result response = new VisitorActivityQueryResponseParser().parseResponse(input);
        logger.info("Result: {}", response);

        assertNotNull("Should not be null", response);
        assertEquals("Should have 200 total results", 200, (int) response.getTotalResults());
        assertEquals("Should have 3 results", 3, response.getVisitorActivities().size());
        validateVisitorActivity1(response.getVisitorActivities().get(0));
        validateVisitorActivity2(response.getVisitorActivities().get(1));
        validateVisitorActivity3(response.getVisitorActivities().get(2));
    }

    private void validateVisitorActivity1(final VisitorActivity visitorActivity) {
        assertEquals("Has correct id", 123L, (long) visitorActivity.getId());
        assertEquals("Has correct visitorId", 321L, (long) visitorActivity.getVisitorId());
        assertEquals("Has correct prospectId", null, visitorActivity.getProspectId());
        assertEquals("Has correct type", 2, (int) visitorActivity.getType());
        assertEquals("Has correct type name", "File", visitorActivity.getTypeName());
        assertEquals("Has correct type enum", VisitorActivityType.VIEW, visitorActivity.getActivityType());
        assertEquals("Has correct details", "My Rad File", visitorActivity.getDetails());
        assertEquals("Has correct fileId", 100L, (long) visitorActivity.getFileId());
        assertNull("Has null landingPageId", visitorActivity.getLandingPageId());

        // Has null campaign
        assertNull("Has null campaign", visitorActivity.getCampaign());
    }

    private void validateVisitorActivity2(final VisitorActivity visitorActivity) {
        assertEquals("Has correct id",456L , (long) visitorActivity.getId());
        assertEquals("Has correct visitorId", 654L, (long) visitorActivity.getVisitorId());
        assertEquals("Has correct prospectId", 100L, (long) visitorActivity.getProspectId());
        assertEquals("Has correct type", 2, (int) visitorActivity.getType());
        assertEquals("Has correct type name", "Landing Page", visitorActivity.getTypeName());
        assertEquals("Has correct type enum", VisitorActivityType.VIEW, visitorActivity.getActivityType());
        assertEquals("Has correct details", "Landing Page 1", visitorActivity.getDetails());
        assertEquals("Has correct landingPageId", 12L, (long) visitorActivity.getLandingPageId());
        assertNull("Has null fileId", visitorActivity.getFileId());

        // Has campaign
        assertNotNull("Has non-null campaign", visitorActivity.getCampaign());
        assertEquals("Has correct campaignId", 1111L, (long) visitorActivity.getCampaign().getId());
        assertEquals("Has correct campaignName", "Website Tracking", visitorActivity.getCampaign().getName());
    }

    private void validateVisitorActivity3(final VisitorActivity visitorActivity) {
        assertEquals("Has correct id", 789L, (long) visitorActivity.getId());
        assertEquals("Has correct visitorId", 987L, (long) visitorActivity.getVisitorId());
        assertEquals("Has correct prospectId", 200L, (long) visitorActivity.getProspectId());
        assertEquals("Has correct type", 1, (int) visitorActivity.getType());
        assertEquals("Has correct type name", "Landing Page Tracker", visitorActivity.getTypeName());
        assertEquals("Has correct type enum", VisitorActivityType.CLICK, visitorActivity.getActivityType());
        assertEquals("Has correct details", "http://go.pardot.com/l/ABC/XYZ", visitorActivity.getDetails());
        assertEquals("Has correct landingPageId", 12L, (long) visitorActivity.getLandingPageId());
        assertNull("Has null fileId", visitorActivity.getFileId());

        // Has campaign
        assertNotNull("Has non-null campaign", visitorActivity.getCampaign());
        assertEquals("Has correct campaignId", 1111L, (long) visitorActivity.getCampaign().getId());
        assertEquals("Has correct campaignName", "Website Tracking", visitorActivity.getCampaign().getName());
    }
}