package com.darksci.pardot.api.parser.prospect;

import com.darksci.pardot.api.parser.JacksonFactory;
import com.darksci.pardot.api.parser.ResponseParser;
import com.darksci.pardot.api.response.prospect.Prospect;
import com.darksci.pardot.api.response.prospect.ProspectReadResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Parses Prospect Read API response.
 */
public class ProspectReadResponseParser implements ResponseParser<Prospect> {
    private static final Logger logger = LoggerFactory.getLogger(ProspectReadResponseParser.class);

    @Override
    public Prospect parseResponse(final String responseStr) throws IOException {
        logger.info("{}", responseStr);
        return JacksonFactory
            .newInstance()
            .readValue(responseStr, ProspectReadResponse.class).getProspect();
    }
}
