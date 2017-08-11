package com.pardot.api.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public abstract class BaseQueryRequest<T> extends BaseRequest<T> {
    public Integer getLimit() {
        return getParam("limit");
    }

    public T withLimit(final Integer limit) {
        return setParam("limit", limit);
    }

    public Integer getOffset() {
        return getParam("offset");
    }

    public T withOffset(final Integer offset) {
        return setParam("offset", offset);
    }

    public String getSortBy() {
        return getParam("sort_by");
    }

    public T withSortBy(final String sortBy) {
        return setParam("sort_by", sortBy);
    }

    public String getSortOrder() {
        return getParam("sort_order");
    }

    public T withSortOrder(final String sortOrder) {
        return setParam("sort_order", sortOrder);
    }

    public T withSortOrderDescending() {
        return withSortOrder("descending");
    }

    public T withSortOrderAscending() {
        return withSortOrder("ascending");
    }

    /**
     * Marked as protected because I'm not sure if all objects support this or not.
     */
    protected T withArchivedOnly(boolean archivedOnly) {
        String value = "false";
        if (archivedOnly) {
            value = "true";
        }
        return setParam("deleted", archivedOnly);
    }
}
