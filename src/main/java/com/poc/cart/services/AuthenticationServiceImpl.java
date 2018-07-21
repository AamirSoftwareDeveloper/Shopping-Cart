package com.poc.cart.services;

import com.poc.cart.model.UserAccount;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Component
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public Optional<UserAccount> authenticate(String userName, String password) {
        if(userName.equals("cart.user@email.com") && password.equals("password")) {
            UserAccount account = new UserAccount();
            return Optional.of(account);
        }
        return Optional.empty();
    }

}
