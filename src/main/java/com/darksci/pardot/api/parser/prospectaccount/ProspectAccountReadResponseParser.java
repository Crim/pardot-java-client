package com.darksci.pardot.api.parser.prospectaccount;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.darksci.pardot.api.parser.JacksonFactory;
import com.darksci.pardot.api.parser.ResponseParser;
import com.darksci.pardot.api.parser.prospectaccount.ProspectAccountReadResponseParser;
import com.darksci.pardot.api.response.prospectaccount.ProspectAccount;
import com.darksci.pardot.api.response.prospectaccount.ProspectAccountReadResponse;


/**
 * Parses Prospect Read API response.
 */
public class ProspectAccountReadResponseParser implements ResponseParser<ProspectAccount> {
    private static final Logger logger = LoggerFactory.getLogger(ProspectAccountReadResponseParser.class);

    @Override
    public ProspectAccount parseResponse(final String responseStr) throws IOException {
        logger.info("{}", responseStr);
        return JacksonFactory
            .newInstance()
            .readValue(responseStr, ProspectAccountReadResponse.class).getProspectAccount();
    }
}
