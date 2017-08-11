package com.pardot.api.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base Request Properties.
 */
abstract class BaseRequest {
    private static final Logger logger = LoggerFactory.getLogger(BaseRequest.class);

    private Integer limit = 200;
    private Integer offset = null;
    private String sortBy = "id";
    private String sortOrder = "ascending";

    public Integer getLimit() {
        return limit;
    }

    public void withLimit(final Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void withOffset(final Integer offset) {
        this.offset = offset;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void withSortBy(final String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void withSortOrder(final String sortOrder) {
        this.sortOrder = sortOrder;
    }
}
