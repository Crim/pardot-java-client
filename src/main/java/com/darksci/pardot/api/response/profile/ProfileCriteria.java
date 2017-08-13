package com.darksci.pardot.api.response.profile;

/**
 * Represents a Pardot Profile Criteria.
 */
public class ProfileCriteria {
    private Long id;
    private String name;
    private String matches;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMatches() {
        return matches;
    }

    @Override
    public String toString() {
        return "ProfileCriteria{"
            + "id=" + id
            + ", name='" + name + '\''
            + ", matches='" + matches + '\''
            + '}';
    }
}
