package com.darksci.pardot.api.request.prospect;

import com.darksci.pardot.api.request.BaseRequest;

/**
 * Defines a Prospect Read Request.
 */
public class ProspectReadRequest extends BaseRequest<ProspectReadRequest> {
    public ProspectReadRequest() {
        super();

        // Default to full output
        setParam("output", "full");
    }

    @Override
    public String getApiEndpoint() {
        return "prospect/do/read";
    }

    /**
     * Returns data for the prospect specified by id.
     * @param id Prospect Id to read.
     * @return RequestBuilder
     */
    public ProspectReadRequest selectById(final Long id) {
        setParam("email", null);
        return setParam("id", id);
    }

    /**
     * Returns data for the prospect specified by email.
     * @param email Prospect Email to read.
     * @return RequestBuilder
     */
    public ProspectReadRequest selectByEmail(final String email) {
        setParam("id", null);
        return setParam("email", email);
    }

    /**
     * Get Response in 'Full' format.
     * @return RequestBuilder
     */
    public ProspectReadRequest withFullOutputFormat() {
        return setParam("output", "full");
    }

    /**
     * Get Response in 'Simple' format.
     * @return RequestBuilder
     */
    public ProspectReadRequest withSimpleOutputFormat() {
        return setParam("output", "simple");
    }
}
