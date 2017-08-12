package com.pardot.api.request.email;

import com.pardot.api.request.BaseRequest;

/**
 * Used to generate a User read request.
 */
public class EmailReadRequest extends BaseRequest<EmailReadRequest> {

    @Override
    public String getApiEndpoint() {
        return "email/do/read";
    }


    public EmailReadRequest selectById(final Long id) {
        return setParam("id", id);
    }

    /**
     * When set to false, the email will not include the html nor text body message.
     * Defaults to true.
     * @param includeMessage Should the response include the html and text bodies.
     */
    public EmailReadRequest withIncludeMessageInResponse(boolean includeMessage) {
        String value = "true";
        if (!includeMessage) {
            value = "false";
        }
        return setParam("include_message", value);
    }
}
