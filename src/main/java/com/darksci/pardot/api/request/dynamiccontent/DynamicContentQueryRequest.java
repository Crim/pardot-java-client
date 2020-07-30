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

package com.darksci.pardot.api.request.dynamiccontent;

import com.darksci.pardot.api.request.BaseQueryRequest;
import com.darksci.pardot.api.request.DateParameter;

/**
 * Used to query DynamicContent over the Pardot API.
 */
public class DynamicContentQueryRequest extends BaseQueryRequest<DynamicContentQueryRequest> {
    @Override
    public String getApiEndpoint() {
        return "dynamicContent/do/query";
    }

    // Filter Options
    public DynamicContentQueryRequest withUpdatedAfter(final DateParameter dateParameter) {
        return super.withUpdatedAfter(dateParameter);
    }

    public DynamicContentQueryRequest withUpdatedBefore(final DateParameter dateParameter) {
        return super.withUpdatedBefore(dateParameter);
    }

    // Sorting Options
    public DynamicContentQueryRequest withSortById() {
        return super.withSortById();
    }

    public DynamicContentQueryRequest withSortByCreatedAt() {
        return super.withSortByCreatedAt();
    }

    public DynamicContentQueryRequest withSortByUpdatedAt() {
        return super.withSortByUpdatedAt();
    }
}
