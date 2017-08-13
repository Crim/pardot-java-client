package com.darksci.pardot.api.parser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import java.text.SimpleDateFormat;

/**
 * Creates properly configured Jackson XML Mapper instances.
 */
public class JacksonFactory {

    /**
     * Creates properly configured Jackson XML Mapper instances.
     * @return XmlMapper instance.
     */
    public static XmlMapper newInstance() {
        // Create new mapper
        final JacksonXmlModule module = new JacksonXmlModule();
        module.setDefaultUseWrapper(false);
        XmlMapper mapper = new XmlMapper(module);

        // Configure it
        mapper
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
            .registerModule(new JodaModule())
            .setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        return mapper;
    }
}
