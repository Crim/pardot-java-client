package com.darksci.pardot.api.parser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Handles a HTTP response and returns the value as a string.
 *
 * @param <T> The type of object your response handler returns.
 */
public abstract class ResponseHandler<T> {
    private static final Logger logger = LoggerFactory.getLogger(ResponseHandler.class);

    /**
     * Jackson Mapper instance.
     */
    private final ObjectMapper mapper;

    /**
     * Default constructor.
     */
    public ResponseHandler() {
        // Create new mapper
        final JacksonXmlModule module = new JacksonXmlModule();
        module.setDefaultUseWrapper(false);
        mapper = new XmlMapper(module);

        // Configure it
        mapper
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
            .registerModule(new JodaModule())
            .setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * Abstract parseResponse method.  We give you the String representation of the response, your job is
     * to parse into something more useful and return it!
     * @param responseStr The response string from the request.
     * @return Parsed response.
     * @throws IOException on parse errors.
     */
    public abstract T parseResponse(final String responseStr) throws IOException;

    /**
     * @return Jackson Mapper instance.
     */
    protected ObjectMapper getMapper() {
        return mapper;
    }

    /**
     * Utility/debug method for logging a response.
     * @param response the response string to log.
     */
    protected void logResponse(final String response) {
        logger.info("Response: {}", response);
    }
}
