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

package com.darksci.pardot.api.parser.visitor;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.parser.user.UserQueryResponseParser;
import com.darksci.pardot.api.response.user.User;
import com.darksci.pardot.api.response.user.UserQueryResponse;
import com.darksci.pardot.api.response.visitor.Visitor;
import com.darksci.pardot.api.response.visitor.VisitorQueryResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 *
 */
public class VisitorQueryResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(VisitorQueryResponseParserTest.class);

    /**
     * Validates we can parse a Visitor query with multiple visitors response A-OK.
     */
    @Test
    public void testMultpleUsers() throws IOException {
        final String input = readFile("visitorQuery.xml");
        final VisitorQueryResponse.Result response = new VisitorQueryResponseParser().parseResponse(input);
        logger.info("Result: {}", response);

        assertNotNull("Should not be null", response);
        assertEquals("Should have 2 results", 2, (int) response.getTotalResults());
        assertEquals("Should have 2 results", 2, response.getVisitors().size());
        validateVisitor1(response.getVisitors().get(0));
        validateVisitor2(response.getVisitors().get(1));
    }

    private void validateVisitor1(final Visitor visitor) {
        assertEquals("Has correct id", 37640L, (long) visitor.getId());
        assertEquals("Has correct prospectId", 123L, (long) visitor.getProspectId());
        assertEquals("Has correct pageViewCount", 1024, (int) visitor.getPageViewCount());
        assertEquals("Has correct IP", "111.222.333.444", visitor.getIpAddress());
        assertEquals("Has correct Hostname", "some.host.com", visitor.getHostname());
        assertEquals("Has correct campaign parameter", "Campaign Parameter", visitor.getCampaignParameter());
        assertEquals("Has correct medium parameter", "Medium Parameter", visitor.getMediumParameter());
        assertEquals("Has correct Source parameter", "Source Parameter", visitor.getSourceParameter());
        assertEquals("Has correct Content parameter", "Content Parameter", visitor.getContentParameter());
        assertEquals("Has correct Term parameter", "Term Parameter", visitor.getTermParameter());
        assertTrue("Should have empty activities list", visitor.getVisitorActivities().isEmpty());
    }

    private void validateVisitor2(final Visitor visitor) {
        assertEquals("Has correct id", 12313L, (long) visitor.getId());
        assertEquals("Has correct prospectId", null, visitor.getProspectId());
        assertEquals("Has correct pageViewCount", 0, (int) visitor.getPageViewCount());
        assertEquals("Has correct IP", "1.2.3.4", visitor.getIpAddress());
        assertNull("Field is null", visitor.getHostname());
        assertNull("Field is null", visitor.getCampaignParameter());
        assertNull("Field is null", visitor.getMediumParameter());
        assertNull("Field is null", visitor.getSourceParameter());
        assertNull("Field is null", visitor.getContentParameter());
        assertNull("Field is null", visitor.getTermParameter());
        assertTrue("Should have empty activities list", visitor.getVisitorActivities().isEmpty());
    }
}