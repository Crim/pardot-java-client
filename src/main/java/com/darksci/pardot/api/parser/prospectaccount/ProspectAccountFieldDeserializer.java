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

package com.darksci.pardot.api.parser.prospectaccount;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

/**
 * Custom deserializer to support deserializing fields on ProspectAccount which have the format of
 * <fieldName>
 *     <value>Actual Value We Want Here</value>
 * </fieldName>
 */
public class ProspectAccountFieldDeserializer extends StdDeserializer<String> {

    /**
     * Constructor.
     */
    public ProspectAccountFieldDeserializer() {
        this(null);
    }

    /**
     * Constructor.
     * @param vc the type of the class this handles.
     */
    public ProspectAccountFieldDeserializer(final Class<?> vc) {
        super(vc);
    }

    @Override
    public String deserialize(final JsonParser parser, final DeserializationContext context) throws IOException {
        boolean inValueTag = false;
        String value = null;

        // If we have multiple values
        if (parser.getCurrentToken() == JsonToken.START_OBJECT) {
            // Get the next token
            parser.nextToken();

            if (parser.getCurrentToken() == JsonToken.END_OBJECT) {
                // Empty value....
                return null;
            }
            if (parser.getCurrentToken() != JsonToken.FIELD_NAME || !"value".equalsIgnoreCase(parser.getCurrentName())) {
                // Empty value...
                return null;
            }
            parser.nextToken();

            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                value = parser.getValueAsString();
            }
            parser.nextToken();

            // Loop until we hit end object
            while (parser.nextToken() != JsonToken.END_OBJECT) {
                // Ignore everything else.
            }
            return value;
        } else if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
            // If we have a single value, we just record the value as is.
            return parser.getValueAsString();
        }

        return value;
    }
}
