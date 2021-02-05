package com.darksci.pardot.api.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 *
 */
public class AuthParameter {
    private final String name;
    private final String value;

    public AuthParameter(final String name, final String value) {
        this.name = Objects.requireNonNull(name);
        this.value = Objects.requireNonNull(value);
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "AuthHeader{"
            + "name='" + name + '\''
            + ", value='XXXXXXX'"
            + '}';
    }
}
