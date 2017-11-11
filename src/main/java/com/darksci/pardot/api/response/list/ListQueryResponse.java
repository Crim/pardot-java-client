package com.darksci.pardot.api.response.list;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

/**
 * Represents the results of querying Lists in Pardot API.
 */
public class ListQueryResponse {
    private ListQueryResponse.Result result;

    public Result getResult() {
        return result;
    }

    /**
     * Represents the results of querying Lists in Pardot API.
     */
    public static class Result {
        private Integer totalResults = 0;

        @JacksonXmlProperty(localName = "list")
        private List<com.darksci.pardot.api.response.list.List> lists;

        public Integer getTotalResults() {
            return totalResults;
        }

        public List<com.darksci.pardot.api.response.list.List> getLists() {
            return lists;
        }

        @Override
        public String toString() {
            return "Result{"
                + "totalResults=" + totalResults
                + ", lists=" + lists
                + '}';
        }
    }

    @Override
    public String toString() {
        return "ListQueryResponse{"
            + "result=" + result
            + '}';
    }
}
