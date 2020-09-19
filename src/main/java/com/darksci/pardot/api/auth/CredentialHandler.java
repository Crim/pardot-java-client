package com.darksci.pardot.api.auth;

public interface CredentialHandler {

    boolean isValid();
    boolean refreshCredentials();
}
