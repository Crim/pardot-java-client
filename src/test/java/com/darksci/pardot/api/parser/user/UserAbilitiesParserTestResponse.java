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