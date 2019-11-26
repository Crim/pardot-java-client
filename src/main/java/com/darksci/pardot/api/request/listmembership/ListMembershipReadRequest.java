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

package com.darksci.pardot.api.request.listmembership;


import com.darksci.pardot.api.request.BaseRequest;

/**
 * Used to generate a List read request.
 */
public class ListMembershipReadRequest extends BaseRequest<ListMembershipReadRequest> {

    @Override
    public String getApiEndpoint() {
        return "listMembership/do/read";
    }

    /**
     * Retrieve membership by id.
     * @param id Id of the ListMembership.
     * @return The ListMembershipReadRequest
     */
    public ListMembershipReadRequest selectById(final long id) {
        setParam("list_id", null);
        setParam("prospect_id", null);
        return setParam("id", id);
    }

    /**
     * Retrieve membership by listId and prospectId.
     * @param listId Id of the List.
     * @param prospectId Id of the prospect.
     * @return The ListMembershipReadRequest
     */
    public ListMembershipReadRequest selectByListIdAndProspectId(final long listId, final long prospectId) {
        setParam("id", null);
        setParam("prospect_id", prospectId);
        return setParam("list_id", listId);
    }
}
