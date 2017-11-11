/**
 * Copyright 2017 Stephen Powis
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

package com.darksci.pardot.api.parser.user;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.response.user.UserAbilitiesResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class UserAbilitiesParserTestResponse extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(UserAbilitiesParserTestResponse.class);

    @Test
    public void test() throws IOException {
        final String input = readFile("userAbilities.xml");
        final UserAbilitiesResponse.Result result = new UserAbilitiesParser().parseResponse(input);
        logger.info("result: {}", result);

        assertEquals("Should have 189 results", 189, (int) result.getTotalResults());
        assertEquals("Check first entry", "marketing:emails:emails:transactionalsend", result.getCredentials().get(0));
        assertEquals("Check last entry", "marketing:engagementstudio:engagementprogram:delete", result.getCredentials().get(188));


    }
}