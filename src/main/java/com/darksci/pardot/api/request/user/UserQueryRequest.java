package com.darksci.pardot.api.request.user;

import com.darksci.pardot.api.request.BaseQueryRequest;

/**
 * Used to query Users over the Pardot API.
 */
public class UserQueryRequest extends BaseQueryRequest<UserQueryRequest> {
    @Override
    public String getApiEndpoint() {
        return "user/do/query";
    }

    public UserQueryRequest withArchivedUsersOnly(final boolean archivedUsersOnly) {
        return super.withArchivedOnly(archivedUsersOnly);
    }

    public UserQueryRequest withSortByCreatedAt() {
        return super.withSortByCreatedAt();
    }

    public UserQueryRequest withSortById() {
        return super.withSortById();
    }

}
