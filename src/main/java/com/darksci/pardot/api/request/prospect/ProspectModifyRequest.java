package com.darksci.pardot.api.request.prospect;

import com.darksci.pardot.api.request.BaseRequest;
import com.darksci.pardot.api.response.prospect.Prospect;

import java.util.Map;

/**
 * Abstract shared code between Create, Update, and Upsert Prospect operations.
 */
abstract class ProspectModifyRequest<T> extends BaseRequest<T> {

    /**
     * Define the campaign you want to create in pardot.
     * @param prospect The prospect you want to create in pardot.
     * @return CampaignCreateRequest builder.
     */
    public T withProspect(final Prospect prospect) {
        // Identifying fields
        setParam("id", prospect.getId());
        setParam("email", prospect.getEmail());

        // Default fields
        setParam("first_name", prospect.getFirstName());
        setParam("last_name", prospect.getLastName());
        setParam("campaign_id", prospect.getCampaignId());
        setParam("salutation", prospect.getSalutation());
        setParam("company", prospect.getCompany());
        setParam("prospect_account_d", prospect.getProspectAccountId());
        setParam("website", prospect.getWebsite());
        setParam("job_title", prospect.getJobTitle());
        setParam("department", prospect.getDepartment());
        setParam("country", prospect.getCountry());
        setParam("address_one", prospect.getAddressOne());
        setParam("address_two", prospect.getAddressTwo());
        setParam("city", prospect.getCity());
        setParam("state", prospect.getState());
        setParam("territory", prospect.getTerritory());
        setParam("zip", prospect.getZip());
        setParam("phone", prospect.getPhone());
        setParam("fax", prospect.getFax());
        setParam("source", prospect.getSource());
        setParam("annual_revenue", prospect.getAnnualRevenue());
        setParam("employees", prospect.getEmployees());
        setParam("industry", prospect.getIndustry());
        setParam("years_in_business", prospect.getYearsInBusiness());

        // Loop through and set custom fields
        if (prospect.getCustomFields() != null) {
            for (Map.Entry<String, String> entry: prospect.getCustomFields().entrySet()) {
                setParam(entry.getKey(), entry.getValue());
            }
        }

        // TODO add other fields?  How to handle custom fields?

        return (T) this;
    }

    /**
     * Explicitly clear the value of a field.
     *
     * You can get the same behavior by setting the field on a Prospect to empty string ""
     * or by calling setFieldValue(fieldName, "")
     *
     * @param fieldName The field to clear.
     * @return RequestBuilder
     */
    public T withFieldValueCleared(final String fieldName) {
        return setParam(fieldName, "");
    }

    /**
     * Explicity set the value of a field.
     * @param fieldName The field to set
     * @param value The value to set.
     * @return RequestBuilder
     */
    public T withFieldValue(final String fieldName, final Object value) {
        return setParam(fieldName, value);
    }

    /**
     * Subscribe prospect to specified list.
     * @param listId List to subscribe prospect to.
     * @return RequestBuilder
     */
    public T withSubscribeToList(final Long listId) {
        return setParam("list_" + String.valueOf(listId), "1");
    }

    /**
     * Subscribe prospect to specified list.
     * @param listId List to subscribe prospect to.
     * @return RequestBuilder
     */
    public T withUnsubscribeFromList(final Long listId) {
        return setParam("list_" + String.valueOf(listId), "0");
    }

    /**
     * Set a prospect's profile criteria as matching.
     * @param profileCriteriaId Id of the profile criteria to mark as matching.
     * @return RequestBuilder
     */
    public T withProfileCriteriaMatching(final Long profileCriteriaId) {
        return setParam("profile_criteria_" + String.valueOf(profileCriteriaId), "match");
    }

    /**
     * Set a prospect's profile criteria as not matching.
     * @param profileCriteriaId Id of the profile criteria to mark as not matching.
     * @return RequestBuilder
     */
    public T withProfileCriteriaNotMatching(final Long profileCriteriaId) {
        return setParam("profile_criteria_" + String.valueOf(profileCriteriaId), "nomatch");
    }

    /**
     * Set a prospect's profile criteria as unknown.
     * @param profileCriteriaId Id of the profile criteria to mark as unknown.
     * @return RequestBuilder
     */
    public T withProfileCriteriaUnknown(final Long profileCriteriaId) {
        return setParam("profile_criteria_" + String.valueOf(profileCriteriaId), "unknown");
    }
}
