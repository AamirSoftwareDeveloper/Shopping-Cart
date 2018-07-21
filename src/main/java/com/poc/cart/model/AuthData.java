package com.poc.cart.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthData {

    public final String userName;
    public final String password;

    @JsonCreator
    public AuthData(@JsonProperty("userName") String userName,
                    @JsonProperty("password") String password) {
        this.userName = userName;
        this.password = password;
    }
}
