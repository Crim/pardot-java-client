package com.darksci.pardot.api.response.listmembership;

import com.darksci.pardot.api.response.list.ListMembership;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

/**
 * Represents the results of querying ListMembership in Pardot API.
 */
public class ListMembershipQueryResponse {
    private ListMembershipQueryResponse.Result result;

    public Result getResult() {
        return result;
    }

    /**
     * Represents the results of querying ListMembership in Pardot API.
     */
    public static class Result {
        private Integer totalResults = 0;

        @JacksonXmlProperty(localName = "list_membership")
        private List<ListMembership> listMemberships;

        public Integer getTotalResults() {
            return totalResults;
        }

        public List<ListMembership> getListMemberships() {
            return listMemberships;
        }

        @Override
        public String toString() {
            return "Result{"
                + "totalResults=" + totalResults
                + ", listMemberships=" + listMemberships
                + '}';
        }
    }

    @Override
    public String toString() {
        return "ListMembershipQueryResponse{"
            + "result=" + result
            + '}';
    }
}
