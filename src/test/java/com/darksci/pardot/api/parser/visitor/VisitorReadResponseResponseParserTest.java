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
import com.darksci.pardot.api.parser.user.UserReadResponseParser;
import com.darksci.pardot.api.response.user.User;
import com.darksci.pardot.api.response.visitor.Visitor;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class VisitorReadResponseResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(VisitorReadResponseResponseParserTest.class);

    /**
     * Validates we can parse a Visitor Read
     */
    @Test
    public void testRead() throws IOException {
        final String input = readFile("visitorRead.xml");
        final Visitor visitor = new VisitorReadResponseParser().parseResponse(input);
        logger.info("Result: {}", visitor);

        assertNotNull("Has non null response", visitor);
        validateVisitor1(visitor);
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
        assertFalse("Should NOT have empty activities list", visitor.getVisitorActivities().isEmpty());
        assertEquals("Should have 2 activities", 2, visitor.getVisitorActivities().size());
    }
}