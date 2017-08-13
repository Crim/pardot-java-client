package com.darksci.pardot.api.response.visitor;

/**
 * Represents a Pardot visitor.
 */
public class Visitor {
    private Long id;

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Visitor{"
            + "id=" + id
            + '}';
    }
}
