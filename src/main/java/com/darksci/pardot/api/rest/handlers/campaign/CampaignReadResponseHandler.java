package com.darksci.pardot.api.rest.handlers.campaign;

import com.darksci.pardot.api.response.campaign.Campaign;
import com.darksci.pardot.api.response.campaign.CampaignReadResponse;
import com.darksci.pardot.api.rest.handlers.BaseResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Handles parsing CampaignRead API responses into POJOs.
 */
public class CampaignReadResponseHandler extends BaseResponseHandler<Campaign> {

    @Override
    public Campaign parseResponse(final String responseStr) throws IOException {
        return getMapper().readValue(responseStr, CampaignReadResponse.class).getCampaign();
    }
}
