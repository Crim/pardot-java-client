package com.darksci.pardot.api.response.prospect;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

/**
 * Represents the response from a Prospect Query API call.
 */
public class ProspectQueryResponse {

    private ProspectQueryResponse.Result result;

    public ProspectQueryResponse.Result getResult() {
        return result;
    }

    /**
     * Represents the results of querying Campaigns in Pardot API.
     */
    public static class Result {
        private Integer totalResults = 0;

        @JacksonXmlProperty(localName = "prospect")
        private List<Prospect> prospects;

        public Integer getTotalResults() {
            return totalResults;
        }

        public List<Prospect> getProspects() {
            return prospects;
        }

        @Override
        public String toString() {
            return "Result{"
                + "totalResults=" + totalResults
                + ", prospects=" + prospects
                + '}';
        }
    }

    @Override
    public String toString() {
        return "ProspectQueryResponse{"
            + "result=" + result
            + '}';
    }
}
