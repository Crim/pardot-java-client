/**
 * Copyright 2017, 2018, 2019 Stephen Powis https://github.com/Crim/pardot-java-client
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

package com.darksci.pardot.api.request.customfield;

import com.darksci.pardot.api.request.BaseRequest;
import com.darksci.pardot.api.response.customfield.CustomField;

/**
 * For creating new Custom Fields using Pardot's API.
 */
public class CustomFieldCreateRequest extends BaseRequest<CustomFieldCreateRequest> {
    @Override
    public String getApiEndpoint() {
        return "customField/do/create";
    }

    /**
     * Define the campaign you want to create in pardot.
     * @param customField The customField you want to create in pardot.
     * @return CustomFieldCreateRequest builder.
     */
    public CustomFieldCreateRequest withCustomField(final CustomField customField) {
        setParam("name", customField.getName());
        // Api is inconsistent here, type in READ/QUERY is returned as a String,
        // During CREATE it wants the constant integer value.
        setParam("type", customField.getTypeId());
        setParam("field_id", customField.getFieldId());
        setParam("crm_id", customField.getCrmId());
        setBooleanParam("is_record_multiple_responses", customField.isRecordMultipleResponses());
        setBooleanParam("is_use_values", customField.isUseValues());
        return this;
    }

    /**
     * This field is not accessible via READ or QUERY, but is allowed to be set
     * over the CREATE api end point.  Optional to set.
     * @param isRequired should the field be required.
     * @return CustomFieldCreateRequest builder.
     */
    public CustomFieldCreateRequest withFieldIsRequired(final boolean isRequired) {
        return setBooleanParam("is_required", true);
    }

    /**
     * This field is not accessible via READ or QUERY, but is allowed to be set
     * over the CREATE api end point.  Optional to set.
     * @return CustomFieldCreateRequest builder.
     */
    public CustomFieldCreateRequest withFieldIsRequired() {
        return withFieldIsRequired(true);
    }

    /**
     * This field is not accessible via READ or QUERY, but is allowed to be set
     * over the CREATE api end point.  Optional to set.
     * @return CustomFieldCreateRequest builder.
     */
    public CustomFieldCreateRequest withFieldIsNotRequired() {
        return withFieldIsRequired(false);
    }
}
