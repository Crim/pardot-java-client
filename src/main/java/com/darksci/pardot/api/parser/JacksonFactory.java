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

package com.darksci.pardot.api.parser;

import com.darksci.pardot.api.parser.prospect.ProspectCustomFieldDeserializer;
import com.darksci.pardot.api.response.customfield.ProspectCustomFieldValue;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import java.text.SimpleDateFormat;

/**
 * Creates properly configured Jackson XML Mapper instances.
 */
public class JacksonFactory {

    /**
     * Cache mapper instance.
     */
    private static final XmlMapper xmlInstance = newInstance();
    private static final JsonMapper jsonInstance = newJsonInstance();

    /**
     * Creates properly configured Jackson JSON Mapper instances.
     * @return JsonMapper instance.
     */
    public static JsonMapper newJsonInstance() {
        if (jsonInstance != null) {
            return jsonInstance;
        }

        return new JsonMapper();
    }

    /**
     * Creates properly configured Jackson XML Mapper instances.
     * @return XmlMapper instance.
     */
    public static XmlMapper newInstance() {
        if (xmlInstance != null) {
            return xmlInstance;
        }

        // Create new mapper
        final JacksonXmlModule module = new JacksonXmlModule();
        module.setDefaultUseWrapper(false);
        module.addDeserializer(ProspectCustomFieldValue.class, new ProspectCustomFieldDeserializer());

        final XmlMapper mapper = new XmlMapper(module);
        // Coerce fields marked as <fieldName/> into NULL to maintain backwards compatibility.
        mapper.enable(FromXmlParser.Feature.EMPTY_ELEMENT_AS_NULL);

        // Configure it
        mapper
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
            .registerModule(new JodaModule())
            .setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        return mapper;
    }
}
