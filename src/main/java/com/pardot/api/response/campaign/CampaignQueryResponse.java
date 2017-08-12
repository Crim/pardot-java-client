package com.pardot.api.response.campaign;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

/**
 * Represents the results of querying Campaigns in Pardot API.
 */
public class CampaignQueryResponse {
    private CampaignQueryResponse.Result result;

    public Result getResult() {
        return result;
    }

    /**
     * Represents the results of querying Campaigns in Pardot API.
     */
    public static class Result {
        private Integer totalResults = 0;

        @JacksonXmlProperty(localName = "campaign")
        private List<Campaign> campaigns;

        public Integer getTotalResults() {
            return totalResults;
        }

        public List<Campaign> getCampaigns() {
            return campaigns;
        }

        @Override
        public String toString() {
            return "Result{"
                + "totalResults=" + totalResults
                + ", campaigns=" + campaigns
                + '}';
        }
    }

    @Override
    public String toString() {
        return "CampaignQueryResponse{"
            + "result=" + result
            + '}';
    }
}
