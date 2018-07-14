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

package com.darksci.pardot.api.request.visitor;


import com.darksci.pardot.api.request.BaseQueryRequest;

/**
 * Request for assigning a visitor to a prospect.
 */
public class VisitorAssignRequest extends BaseQueryRequest<VisitorAssignRequest> {
    @Override
    public String getApiEndpoint() {
        return "visitor/do/assign";
    }

    /**
     * Assign visitor to the specified Prospect's email address.
     * @param email Email address of prospect.
     * @return RequestBuilder
     */
    public VisitorAssignRequest withProspectEmail(final String email) {
        setParam("prospect_id", null);
        return setParam("prospect_email", email);
    }

    /**
     * Assign visitor to the specified prospect by prospectId.
     * @param prospectId Id of prospect.
     * @return RequestBuilder
     */
    public VisitorAssignRequest withProspectId(final Long prospectId) {
        setParam("prospect_email", null);
        return setParam("prospect_id", prospectId);
    }

    /**
     * Select which visitor to assign.
     * @param visitorId The id of the visitor to assign.
     * @return RequestBuilder
     */
    public VisitorAssignRequest withVisitorId(final Long visitorId) {
        return setParam("id", visitorId);
    }
}
