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

package com.darksci.pardot.api.parser.prospect;

import com.darksci.pardot.api.response.customfield.ProspectCustomFieldValue;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Custom deserializer to be able to support Record Multiple custom fields.
 */
public class ProspectCustomFieldDeserializer extends StdDeserializer<ProspectCustomFieldValue> {

    /**
     * Constructor.
     */
    public ProspectCustomFieldDeserializer() {
        this(null);
    }

    /**
     * Constructor.
     * @param vc the type of the class this handles.
     */
    public ProspectCustomFieldDeserializer(final Class<?> vc) {
        super(vc);
    }

    @Override
    public ProspectCustomFieldValue deserialize(final JsonParser parser, final DeserializationContext context) throws IOException {
        // Get the current custom field name.
        final String fieldName = parser.getCurrentName();

        // Keep track of all the values associated with the field.
        final List<String> fieldValues = new ArrayList<>();

        // If we have multiple values
        if (parser.getCurrentToken() == JsonToken.START_OBJECT) {
            // Loop until we hit end object
            while (parser.nextToken() != JsonToken.END_OBJECT) {
                // Pull out each value
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    fieldValues.add(parser.getValueAsString());
                }
            }
        } else if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
            // If we have a single value, we just record the value as is.
            fieldValues.add(parser.getValueAsString());
        }

        // Return our deserialized instance.
        return new ProspectCustomFieldValue(fieldName, fieldValues);
    }
}
