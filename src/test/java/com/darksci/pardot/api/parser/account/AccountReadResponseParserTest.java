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

package com.darksci.pardot.api.parser.account;

import com.darksci.pardot.api.parser.BaseResponseParserTest;
import com.darksci.pardot.api.response.account.Account;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AccountReadResponseParserTest extends BaseResponseParserTest {
    private static final Logger logger = LoggerFactory.getLogger(AccountReadResponseParserTest.class);

    /**
     * Validates we can parse an Account Read
     */
    @Test
    public void testRead() throws IOException {
        final String input = readFile("accountRead.xml");
        final Account account = new AccountReadResponseParser().parseResponse(input);
        logger.info("Result: {}", account);

        assertNotNull("Should not be null", account);
        assertEquals("Has correct id", 1L, (long) account.getId());
        assertEquals("Has correct company", "Test Account", account.getCompany());
        assertEquals("Has correct level", "SFDC Ultimate Edition", account.getLevel());
        assertEquals("Has correct website", "http://www.example.com", account.getWebsite());
        assertEquals("Has correct vanity domain", "http://go.example.com", account.getVanityDomain());
        assertEquals("Has correct plugin campaign id", 2, (long) account.getPluginCampaignId());
        assertNotNull("Has non-null tracking code template", account.getTrackingCodeTemplate());
        assertEquals("Has correct address1", "123 Main Street", account.getAddressOne());
        assertEquals("Has correct address2", "addr2", account.getAddressTwo());
        assertEquals("Has correct city", "Atlanta", account.getCity());
        assertEquals("Has correct state", "GA", account.getState());
        assertEquals("Has correct territory", "Test Territory", account.getTerritory());
        assertEquals("Has correct zipcode", "30064", account.getZip());
        assertEquals("Has correct country", "United States", account.getCountry());
        assertEquals("Has correct phone", "123-456-4789", account.getPhone());
        assertEquals("Has correct createdAt", "2016-01-04T10:39:26.000Z", account.getCreatedAt().toString());
        assertEquals("Has correct updatedAt", "2017-08-10T05:32:19.000Z", account.getUpdatedAt().toString());
    }
}