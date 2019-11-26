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

import com.darksci.pardot.api.response.customfield.CustomField;

/**
 * For Updating existing Custom Fields using Pardot's API.
 */
public class CustomFieldUpdateRequest extends CustomFieldCreateRequest {
    @Override
    public String getApiEndpoint() {
        return "customField/do/update";
    }

    /**
     * Define the campaign you want to update in pardot.
     * @param customField The customField you want to update in pardot.
     * @return CustomFieldUpdateRequest builder.
     */
    public CustomFieldUpdateRequest withCustomField(final CustomField customField) {
        setParam("id", customField.getId());
        super.withCustomField(customField);
        return this;
    }

    /**
     * This field is not accessible via READ or QUERY, but is allowed to be set
     * over the UPDATE api end point.  Optional to set.
     * @param isRequired should the field be required.
     * @return CustomFieldUpdateRequest builder.
     */
    public CustomFieldUpdateRequest withFieldIsRequired(final boolean isRequired) {
        super.withFieldIsRequired(isRequired);
        return this;
    }

    /**
     * This field is not accessible via READ or QUERY, but is allowed to be set
     * over the UPDATE api end point.  Optional to set.
     * @return CustomFieldUpdateRequest builder.
     */
    public CustomFieldUpdateRequest withFieldIsRequired() {
        super.withFieldIsRequired(true);
        return this;
    }

    /**
     * This field is not accessible via READ or QUERY, but is allowed to be set
     * over the UPDATE api end point.  Optional to set.
     * @return CustomFieldUpdateRequest builder.
     */
    public CustomFieldUpdateRequest withFieldIsNotRequired() {
        super.withFieldIsRequired(false);
        return this;
    }
}
