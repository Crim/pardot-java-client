package com.darksci.pardot.api.response.prospect;

/**
 * Represents the response from a Prospect Read API request.
 */
public class ProspectReadResponse {
    private Prospect prospect;

    public Prospect getProspect() {
        return prospect;
    }

    @Override
    public String toString() {
        return "ProspectReadResponse{"
            + "prospect=" + prospect
            + '}';
    }
}
