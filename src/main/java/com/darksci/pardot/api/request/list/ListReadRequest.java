package com.darksci.pardot.api.request.list;


import com.darksci.pardot.api.request.BaseRequest;

/**
 * Used to generate a List read request.
 */
public class ListReadRequest extends BaseRequest<ListReadRequest> {

    @Override
    public String getApiEndpoint() {
        return "list/do/read";
    }

    public ListReadRequest selectById(final Long id) {
        return setParam("id", id);
    }
}
