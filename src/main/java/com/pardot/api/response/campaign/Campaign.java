package com.pardot.api.response.campaign;

/**
 * Represents a Pardot Campaign.
 */
public class Campaign {
    private Long id;
    private String name;
    private Integer cost;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Campaign{"
            + "id=" + id
            + ", name='" + name + '\''
            + ", cost=" + cost
            + '}';
    }
}
