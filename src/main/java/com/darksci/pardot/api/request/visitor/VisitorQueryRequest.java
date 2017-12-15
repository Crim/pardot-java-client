/**
 * Copyright 2017 Stephen Powis https://github.com/Crim/pardot-java-client
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

package com.darksci.pardot.api.request.visitor;

import com.darksci.pardot.api.request.BaseQueryRequest;
import com.darksci.pardot.api.request.DateParameter;

import java.util.Collection;

/**
 * Defines a Visitor Query Request.
 */
public class VisitorQueryRequest extends BaseQueryRequest<VisitorQueryRequest> {

    @Override
    public String getApiEndpoint() {
        return "visitor/do/query";
    }

    @Override
    public VisitorQueryRequest withUpdatedAfter(final DateParameter updatedAfter) {
        return super.withUpdatedAfter(updatedAfter);
    }

    @Override
    public VisitorQueryRequest withUpdatedBefore(final DateParameter updatedBefore) {
        return super.withUpdatedBefore(updatedBefore);
    }

    /**
     * Only select identified visitors.
     * @return RequestBuilder
     */
    public VisitorQueryRequest withIdentifiedOnly() {
        return setBooleanParam("only_identified", true);
    }

    // Relationship filters

    /**
     * Only select visitors who are associated with the specified prospect id.
     * @param prospectId The prospectId to filter by.
     * @return RequestBuilder
     */
    public VisitorQueryRequest withProspectId(final Long prospectId) {
        return withCollectionParam("prospect_ids", prospectId);
    }

    /**
     * Only select visitors who are associated with the specified prospect ids.
     * @param prospectIds The prospect ids to filter by.
     * @return RequestBuilder
     */
    public VisitorQueryRequest withProspectIds(final Collection<Long> prospectIds) {
        return withCollectionParam("prospect_ids", prospectIds);
    }

    // Sort options

    /**
     * Sort by CreatedAt.
     * @return BaseQueryRequest
     */
    public VisitorQueryRequest withSortByCreatedAt() {
        return super.withSortByCreatedAt();
    }

    /**
     * Sort results by UpdatedAt.
     * @return BaseQueryRequest
     */
    public VisitorQueryRequest withSortByUpdatedAt() {
        return super.withSortByUpdatedAt();
    }

    /**
     * Sort results by Id.
     * @return BaseQueryRequest
     */
    public VisitorQueryRequest withSortById() {
        return super.withSortById();
    }
}
