package com.darksci.pardot.api.request.prospectaccount;


import com.darksci.pardot.api.request.BaseQueryRequest;
import com.darksci.pardot.api.request.DateParameter;
import com.darksci.pardot.api.request.prospect.ProspectQueryRequest;

import java.util.Collection;
import java.util.stream.Collectors;



public class ProspectAccountQueryRequest extends BaseQueryRequest<ProspectAccountQueryRequest>
{

	 @Override
	    public String getApiEndpoint() {
	        return "prospectAccount/do/query";
	    }
	
	
	  /**
	     * Specifies the fields to be returned. Note: If this parameter isn't present, all default fields and custom fields
	     * for which the prospect has a value will be returned;
	     * id field will always be returned.
	     *
	     * Each call will append the field argument to the list of previously passed fields.
	     *
	     * @param fields Collection of fields to be selected by the request.
	     * @return RequestBuilder
	     */
	    public ProspectAccountQueryRequest withFields(final Collection<String> fields) {
	        final String fieldsStr = fields.stream().collect(Collectors.joining( "," ));
	        final String currentValue = getParam("fields");
	        if (currentValue == null) {
	            // set
	            return setParam("fields", fieldsStr);
	        } else {
	            // Append
	            return setParam("fields", currentValue + "," + fieldsStr);
	        }
	    }

	    /**
	     * Specifies the fields to be returned. Note: If this parameter isn't present, all default fields and custom fields
	     * for which the prospect has a value will be returned;
	     * id field will always be returned.
	     *
	     * Each call will append the field argument to the list of previously passed fields.
	     *
	     * @param field Field to be selected by request.
	     * @return RequestBuilder
	     */
	    public ProspectAccountQueryRequest withField(final String field) {
	        final String currentValue = getParam("fields");
	        if (currentValue == null) {
	            // set
	            return setParam("fields", field);
	        } else {
	            // Append
	            return setParam("fields", currentValue + "," + field);
	        }
	    }

	
	 public ProspectAccountQueryRequest withUpdatedAfter(final DateParameter dateParameter) {
	        return super.withUpdatedAfter(dateParameter);
	    }
	
	  public ProspectAccountQueryRequest withUpdatedBefore(final DateParameter dateParameter) {
	        return super.withUpdatedBefore(dateParameter);
	    }

	  public ProspectAccountQueryRequest withCreatedBefore(final DateParameter dateParameter) {
	        return super.withCreatedBefore(dateParameter);
	  }
	   public ProspectAccountQueryRequest withCreatedAfter(final DateParameter dateParameter) {
		        return super.withCreatedAfter(dateParameter);
	    }
	  // Filter Options
	    public ProspectAccountQueryRequest withName(final String name) {
	        return setParam("name", name);
	    }
	    /**
	     * Sort by CreatedAt.
	     * @return BaseQueryRequest
	     */
	    public ProspectAccountQueryRequest withSortByCreatedAt() {
	        return super.withSortByCreatedAt();
	    }
	    
	    /**
	     * Sort results by Id.
	     * @return BaseQueryRequest
	     */
	    public ProspectAccountQueryRequest withSortById() {
	        return super.withSortById();
	    }
	    @Override
	    public ProspectAccountQueryRequest withSortByName() {
	        return super.withSortByName();
	    }
	    
	    public ProspectAccountQueryRequest withSortByUpdatedAt() {
	        return super.withSortByUpdatedAt();
	    }
	    
	    
}
