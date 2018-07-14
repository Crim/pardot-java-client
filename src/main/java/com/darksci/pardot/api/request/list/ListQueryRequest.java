/**
 * Copyright 2017, 2018 Stephen Powis https://github.com/Crim/pardot-java-client
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

package com.darksci.pardot.api.request.list;

import com.darksci.pardot.api.request.BaseQueryRequest;
import com.darksci.pardot.api.request.DateParameter;

/**
 * Used to query Lists over the Pardot API.
 */
public class ListQueryRequest extends BaseQueryRequest<ListQueryRequest> {
    @Override
    public String getApiEndpoint() {
        return "list/do/query";
    }

    // Query criteria

    @Override
    public ListQueryRequest withUpdatedAfter(final DateParameter createdAfter) {
        return super.withUpdatedAfter(createdAfter);
    }

    @Override
    public ListQueryRequest withUpdatedBefore(final DateParameter createdAfter) {
        return super.withUpdatedBefore(createdAfter);
    }

    /**
     * Filter by list name
     * @param name Name to search for.
     * @return ListQueryRequest instance.
     */
    public ListQueryRequest withName(final String name) {
        return setParam("name", name);
    }

    // Sort options.

    @Override
    public ListQueryRequest withSortByCreatedAt() {
        return super.withSortByCreatedAt();
    }

    @Override
    public ListQueryRequest withSortByUpdatedAt() {
        return super.withSortByUpdatedAt();
    }

    @Override
    public ListQueryRequest withSortById() {
        return super.withSortById();
    }

    @Override
    public ListQueryRequest withSortByName() {
        return super.withSortByName();
    }
}
