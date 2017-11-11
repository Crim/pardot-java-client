package com.darksci.pardot.api.response.list;

/**
 * Represents API response for a List read request.
 */
public class ListReadResponse {
    private List list;

    public List getList() {
        return list;
    }

    @Override
    public String toString() {
        return "ListReadResponse{"
            + "list=" + list
            + '}';
    }
}
