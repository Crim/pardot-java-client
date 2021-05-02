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

package com.darksci.pardot.api.parser.visit;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.response.visit.Visit;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.*;

public class VisitReadResponseResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(VisitReadResponseResponseParserTest.class);

    /**
     * Validates we can parse a Visit Read
     */
    @Test
    public void testRead() throws IOException {
        final String input = readFile("visitRead.xml");
        final Visit visit = new VisitReadResponseParser().parseResponse(input);
        logger.info("Result: {}", visit);

        assertNotNull("Has non null response", visit);
        validateVisit1(visit);
    }

    private void validateVisit1(final Visit visit) {
        assertEquals("Has correct id", 37640L, (long) visit.getId());
        assertEquals("Has correct visitorId", 123L, (long) visit.getVisitorId());
        assertEquals("Has correct prospectId", 123L, (long) visit.getProspectId());
        assertEquals("Has correct visitorPageViewCount", 1024, (int) visit.getVisitorPageViewCount());
        assertEquals("Has correct firstVisitorPageViewAt", "2015-09-03T11:57:01.000", visit.getFirstVisitorPageViewAt().toString());
        assertEquals("Has correct lastVisitorPageViewAt", "2015-09-03T11:57:24.000", visit.getLastVisitorPageViewAt().toString());
        assertEquals("Has correct durationInSeconds", 1024, (int) visit.getDurationInSeconds());
        assertEquals("Has correct campaign parameter", "Campaign Parameter", visit.getCampaignParameter());
        assertEquals("Has correct medium parameter", "Medium Parameter", visit.getMediumParameter());
        assertEquals("Has correct Source parameter", "Source Parameter", visit.getSourceParameter());
        assertEquals("Has correct Content parameter", "Content Parameter", visit.getContentParameter());
        assertEquals("Has correct Term parameter", "Term Parameter", visit.getTermParameter());
        assertEquals("Has correct createdAt", "2015-09-03T11:57:01.000", visit.getCreatedAt().toString());
        assertEquals("Has correct updatedAt", "2015-09-03T11:57:24.000", visit.getUpdatedAt().toString());
        assertFalse("Should NOT have empty visitor page view list", visit.getVisitorPageViews().isEmpty());
        assertEquals("Should have 2 visitor page views", 2, visit.getVisitorPageViews().size());
    }
}