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

package com.darksci.pardot.api.request.visit;

import com.darksci.pardot.api.request.BaseQueryRequest;

import java.util.Collection;

/**
 * Defines a Visit Query Request.
 */
public class VisitQueryRequest extends BaseQueryRequest<VisitQueryRequest> {

    @Override
    public String getApiEndpoint() {
        return "visit/do/query";
    }

    // Filter Options

    /**
     * Only select visits who are associated with the specified visit id.
     * @param id The visit id to filter by.
     * @return RequestBuilder
     */
    public VisitQueryRequest withId(final Long id) {
        return withCollectionParam("ids", id);
    }

    /**
     * Only select visits who are associated with the specified visit ids.
     * @param ids The visit ids to filter by.
     * @return RequestBuilder
     */
    public VisitQueryRequest withIds(final Collection<Long> ids) {
        return withCollectionParams("ids", ids);
    }

    /**
     * Only select visits who are associated with the specified visitor id.
     * @param visitorId The visitor id to filter by.
     * @return RequestBuilder
     */
    public VisitQueryRequest withVisitorId(final Long visitorId) {
        return withCollectionParam("visitor_ids", visitorId);
    }

    /**
     * Only select visits who are associated with the specified visitor ids.
     * @param visitorIds The visitor ids to filter by.
     * @return RequestBuilder
     */
    public VisitQueryRequest withVisitorIds(final Collection<Long> visitorIds) {
        return withCollectionParams("visitor_ids", visitorIds);
    }

    /**
     * Only select visits who are associated with the specified prospect id.
     * @param prospectId The prospect id to filter by.
     * @return RequestBuilder
     */
    public VisitQueryRequest withProspectId(final Long prospectId) {
        return withCollectionParam("prospect_ids", prospectId);
    }

    /**
     * Only select visits who are associated with the specified prospect ids.
     * @param prospectIds The prospect ids to filter by.
     * @return RequestBuilder
     */
    public VisitQueryRequest withProspectIds(final Collection<Long> prospectIds) {
        return withCollectionParams("prospect_ids", prospectIds);
    }


}
