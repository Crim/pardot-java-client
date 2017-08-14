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
