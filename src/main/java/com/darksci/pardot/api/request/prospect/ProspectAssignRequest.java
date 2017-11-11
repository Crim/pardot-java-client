/**
 * Copyright 2017 Stephen Powis
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

package com.darksci.pardot.api.request.prospect;

/**
 * Request for assigning a Prospect to a user.
 */
public class ProspectAssignRequest extends ProspectActionRequest<ProspectAssignRequest> {
    @Override
    public String getApiEndpoint() {
        return "prospect/do/assign";
    }

    /**
     * Assign prospect to the specified User's email address.
     * @param email Email address of user.
     * @return RequestBuilder
     */
    public ProspectAssignRequest withUserEmail(final String email) {
        setParam("user_id", null);
        setParam("group_id", null);
        return setParam("user_email", email);
    }

    /**
     * Assign prospect to the specified User by userId.
     * @param userId Id of user.
     * @return RequestBuilder
     */
    public ProspectAssignRequest withUserId(final Long userId) {
        setParam("user_id", userId);
        setParam("group_id", null);
        return setParam("user_email", null);
    }

    /**
     * Assign prospect to the specified Group by the group's Id.
     * @param groupId Id of the Group.
     * @return RequestBuilder
     */
    public ProspectAssignRequest withGroupId(final Long groupId) {
        setParam("user_id", null);
        setParam("group_id", groupId);
        return setParam("user_email", null);
    }
}
