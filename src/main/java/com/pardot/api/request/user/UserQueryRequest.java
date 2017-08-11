package com.pardot.api.request.user;

import com.pardot.api.request.DateParameter;
import com.pardot.api.request.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Used to generate a User request.
 */
public class UserQueryRequest implements Request {
    private static final Logger logger = LoggerFactory.getLogger(UserQueryRequest.class);

    // User specific
    private DateParameter createdAfter = null;
    private DateParameter createdBefore = null;
    private Integer idGreaterThan = null;
    private Integer idLessThan = null;

    private Map<String, Object> params = new HashMap<>();

    public UserQueryRequest() {
    }

    public DateParameter getCreatedAfter() {
        return (DateParameter) params.getOrDefault("created_after", null);
    }

    public UserQueryRequest withCreatedAfter(DateParameter dateParameter) {
        createdAfter = dateParameter;
        params.put("created_after", dateParameter);
        return this;
    }

    public DateParameter getCreatedBefore() {
        return (DateParameter) params.getOrDefault("created_before", null);
    }

    public UserQueryRequest withCreatedBefore(final DateParameter createdBefore) {
        this.createdBefore = createdBefore;
        params.put("created_before", createdBefore);
        return this;
    }

    public Integer getIdGreaterThan() {
        return idGreaterThan;
    }

    public UserQueryRequest withIdGreaterThan(final Integer idGreaterThan) {
        this.idGreaterThan = idGreaterThan;
        params.put("id_greater_than", idGreaterThan);
        return this;
    }

    public Integer getIdLessThan() {
        return (Integer) params.getOrDefault("id_less_than", null);
    }

    public UserQueryRequest withIdLessThan(final Integer idLessThan) {
        this.idLessThan = idLessThan;
        params.put("id_less_than", idLessThan);
        return this;
    }

    @Override
    public String getApiEndpoint() {
        return "user/do/query";
    }


    @Override
    public Map<String, Object> getRequestParameters() {
        return params;
    }
}
