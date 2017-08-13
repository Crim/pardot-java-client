package com.darksci.pardot.api.response.profile;

import java.util.List;

/**
 * Represents a Pardot profile.
 */
public class Profile {
    private Long id;
    private String name;
    private List<ProfileCriteria> profileCriteria;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<ProfileCriteria> getProfileCriteria() {
        return profileCriteria;
    }

    @Override
    public String toString() {
        return "Profile{"
            + "id=" + id
            + ", name='" + name + '\''
            + ", profileCriteria=" + profileCriteria
            + '}';
    }
}
