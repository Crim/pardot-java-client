package com.darksci.pardot.api.request.prospect;

import com.darksci.pardot.api.request.BaseRequest;

/**
 * Represents a request to perform an action against a specific prospect, either by
 * Id or Email address.
 */
abstract class ProspectActionRequest<T> extends BaseRequest<T> {

    /**
     * Define which prospect to perform action on by Id.
     * @param prospectId Id of prospect to delete.
     * @return RequestBuilder
     */
    public T withProspectId(final Long prospectId) {
        setParam("email", null);
        return setParam("id", prospectId);
    }

    /**
     * Define which prospect to perform action on by email.
     * @param email Email of prospect to delete.
     * @return RequestBuilder
     */
    public T withProspectEmail(final String email) {
        setParam("id", null);
        return setParam("email", email);
    }
}
