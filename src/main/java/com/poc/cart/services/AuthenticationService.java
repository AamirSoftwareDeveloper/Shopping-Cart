package com.poc.cart.services;

import com.poc.cart.model.UserAccount;

import java.util.Optional;

public interface AuthenticationService {
    Optional<UserAccount> authenticate(String userName, String password);
}
