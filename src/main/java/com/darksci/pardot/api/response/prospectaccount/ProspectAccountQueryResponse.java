package com.darksci.pardot.api.response.prospectaccount;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Collections;
import java.util.List;

public class ProspectAccountQueryResponse {
	 private ProspectAccountQueryResponse.Result result;

	    public Result getResult() {
	        return result;
	    }
	        
	        /**
	         * Represents the results of querying Campaigns in Pardot API.
	         */
	        public static class Result {
	            private Integer totalResults = 0;

	            @JacksonXmlProperty(localName = "prospectAccount")
	            private List<ProspectAccount> prospectAccounts = Collections.emptyList();

	            public Integer getTotalResults() {
	                return totalResults;
	            }

	            /**
	             * Prospects returned by the API.
	             *
	             * @return Immutable list of Prospects returned by the API.
	             */
	            public List<ProspectAccount> getProspectAccounts() {
	                if (prospectAccounts == null) {
	                    prospectAccounts = Collections.emptyList();
	                }
	                return Collections.unmodifiableList(prospectAccounts);
	            }
	            
	            @Override
	            public String toString() {
	                return "Result{"
	                    + "totalResults=" + totalResults
	                    + ", prospectAccounts=" + prospectAccounts
	                    + '}';
	            }
	        }
	       

	        @Override
	        public String toString() {
	            return "ProspectAccountQueryResponse{"
	                + "result=" + result
	                + '}';
	        }
}