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
        assertEquals("Has correct address1", "123 Main Street", account.getAddress1());
        assertEquals("Has correct address2", "addr2", account.getAddress2());
        assertEquals("Has correct city", "Atlanta", account.getCity());
        assertEquals("Has correct state", "GA", account.getState());
        assertEquals("Has correct territory", "Test Territory", account.getTerritory());
        assertEquals("Has correct zipcode", 30064, (int) account.getZip());
        assertEquals("Has correct country", "United States", account.getCountry());
        assertEquals("Has correct phone", "123-456-4789", account.getPhone());
        assertEquals("Has correct createdAt", "2016-01-04T10:39:26.000Z", account.getCreatedAt().toString());
        assertEquals("Has correct updatedAt", "2017-08-10T05:32:19.000Z", account.getUpdatedAt().toString());
    }
}