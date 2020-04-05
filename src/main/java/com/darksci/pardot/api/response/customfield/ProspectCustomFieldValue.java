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

package com.darksci.pardot.api.response.customfield;

import com.darksci.pardot.api.parser.prospect.ProspectCustomFieldDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Represents a Prospect CustomField value.
 * Since custom fields can be stored as a single value, or as a list of values (for record multiple fields),
 * this attempts to normalize the way these two types are accessed.
 */
@JsonDeserialize(using = ProspectCustomFieldDeserializer.class)
public class ProspectCustomFieldValue {
    private final String fieldName;
    private final List<String> values = new ArrayList<>();

    /**
     * Constructor for custom field which only has a single value.
     * @param fieldName name of the field.
     * @param value value of the field.
     */
    public ProspectCustomFieldValue(final String fieldName, final String value) {
        this.fieldName = fieldName;
        if (value != null) {
            this.values.add(value);
        }
    }

    /**
     * Constructor for custom field which has multiple values.
     * @param fieldName name of the field.
     * @param values values for the field.
     */
    public ProspectCustomFieldValue(final String fieldName, final Collection<String> values) {
        this.fieldName = fieldName;
        if (values != null) {
            this.values.addAll(values);
        }
    }

    public String getFieldName() {
        return fieldName;
    }

    /**
     * The value of the custom field.
     * @return value of the custom field.
     *         *NOTE* If this is a record multiple field with multiple values, this will return the first value only.
     */
    public String getValue() {
        if (values.isEmpty()) {
            return null;
        }
        return values.get(0);
    }

    public List<String> getValues() {
        return values;
    }

    public boolean hasMultipleValues() {
        return getValues().size() > 1;
    }

    public void addValue(final String value) {
        values.add(value);
    }

    public void addValues(final Collection<String> values) {
        values.addAll(values);
    }

    public void setValue(final String value) {
        values.clear();
        addValue(value);
    }

    public void setValues(final Collection<String> values) {
        values.clear();
        addValues(values);
    }

    @Override
    public String toString() {
        return "ProspectCustomFieldValue{"
            + "fieldName='" + fieldName + '\''
            + ", values=" + values
            + '}';
    }
}
