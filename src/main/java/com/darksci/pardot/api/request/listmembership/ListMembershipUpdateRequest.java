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

package com.darksci.pardot.api.request.listmembership;

import com.darksci.pardot.api.request.BaseRequest;
import com.darksci.pardot.api.response.list.ListMembership;

/**
 * For Updating existing ListMemberships using Pardot's API.
 */
public class ListMembershipUpdateRequest extends BaseRequest<ListMembershipUpdateRequest> {
    @Override
    public String getApiEndpoint() {
        return "listMembership/do/update";
    }

    /**
     * Define the listMembership you want to update in pardot.
     * @param listMembership The listMembership you want to update in pardot.
     * @return ListUpdateRequest builder.
     */
    public ListMembershipUpdateRequest withListMembership(final ListMembership listMembership) {
        setParam("id", listMembership.getId());
        setParam("list_id", listMembership.getListId());
        setParam("prospect_id", listMembership.getProspectId());
        setBooleanParam("opted_out", listMembership.getOptedOut());
        return this;
    }
}
