package com.darksci.pardot.api.response.campaign;

/**
 * Represents a Pardot Campaign.
 */
public class Campaign {
    private Long id;
    private String name;
    private Integer cost;
    private Long folderId;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCost() {
        return cost;
    }

    public Long getFolderId() {
        return folderId;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setCost(final Integer cost) {
        this.cost = cost;
    }

    public void setFolderId(final Long folderId) {
        this.folderId = folderId;
    }

    @Override
    public String toString() {
        return "Campaign{"
            + "id=" + id
            + ", name='" + name + '\''
            + ", cost=" + cost
            + ", folderId=" + folderId
            + '}';
    }
}
