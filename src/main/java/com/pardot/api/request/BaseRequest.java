package com.pardot.api.request;

import com.pardot.api.request.user.UserQueryRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Base Request Properties.
 */
public abstract class BaseRequest<T> implements Request {
    // Param holder
    private Map<String, Object> params = new HashMap<>();

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

    protected <T> T getParam(final String name) {
        return (T) params.getOrDefault(name, null);
    }

    protected <T> T setParam(final String name, Object value) {
        if (value == null) {
            params.remove(name);
        } else {
            params.put(name, value);
        }
        return (T) this;
    }

    @Override
    public Map<String, String> getRequestParameters() {
        // Clone the params and cast to string
        Map<String, String> requestParams = new HashMap<>();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            requestParams.put(entry.getKey(), entry.getValue().toString());
        }
        return requestParams;
    }
}
