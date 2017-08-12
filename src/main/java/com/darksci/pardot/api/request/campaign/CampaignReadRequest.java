package com.darksci.pardot.api.request.campaign;


import com.darksci.pardot.api.request.BaseRequest;

/**
 * Used to generate a Campaign read request.
 */
public class CampaignReadRequest extends BaseRequest<CampaignReadRequest> {

    @Override
    public String getApiEndpoint() {
        return "campaign/do/read";
    }

    public CampaignReadRequest selectById(final Long id) {
        return setParam("id", id);
    }
}
