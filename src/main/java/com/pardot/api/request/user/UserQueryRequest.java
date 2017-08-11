package com.pardot.api.request.user;

import com.pardot.api.request.DateParameter;
import com.pardot.api.request.BaseRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Used to generate a User Query request.
 */
public class UserQueryRequest extends BaseRequest<UserQueryRequest> {
    private static final Logger logger = LoggerFactory.getLogger(UserQueryRequest.class);

    public DateParameter getCreatedAfter() {
        return getParam("created_after");
    }

    public UserQueryRequest withCreatedAfter(DateParameter dateParameter) {
        return setParam("created_after", dateParameter);
    }

    public DateParameter getCreatedBefore() {
        return getParam("created_before");
    }

    public UserQueryRequest withCreatedBefore(final DateParameter createdBefore) {
        return setParam("created_before", createdBefore);
    }

    public Integer getIdGreaterThan() {
        return getParam("id_greater_than");
    }

    public UserQueryRequest withIdGreaterThan(final Integer idGreaterThan) {
        return setParam("id_greater_than", idGreaterThan);
    }

    public Integer getIdLessThan() {
        return getParam("id_less_than");
    }

    public UserQueryRequest withIdLessThan(final Integer idLessThan) {
        return setParam("id_less_than", idLessThan);
    }

    public UserQueryRequest withSortByCreatedAt() {
        return withSortBy("created_at");
    }

    public UserQueryRequest withSortById() {
        return withSortBy("id");
    }

    public UserQueryRequest withArchivedUsersOnly(final boolean archivedUsersOnly) {
        return super.withArchivedOnly(archivedUsersOnly);
    }

    @Override
    public String getApiEndpoint() {
        return "user/do/query";
    }
}
