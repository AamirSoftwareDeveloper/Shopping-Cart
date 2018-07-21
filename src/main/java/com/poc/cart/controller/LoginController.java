package com.poc.cart.controller;

import com.poc.cart.services.AuthenticationService;
import com.poc.cart.filter.SessionUtils;
import com.poc.cart.model.AuthData;
import com.poc.cart.model.UserAccount;
import com.poc.cart.model.UserData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/public")
public class LoginController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private AuthenticationService authenticationService;

    @Autowired
    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/authenticate")
    public @Valid
    @ResponseBody
    ResponseEntity<?> customerSubmit(HttpServletRequest request,
                                     @RequestBody AuthData authData) {

        Optional<UserAccount> loggedInUserAdAccount = authenticationService.authenticate(authData.userName,
                authData.password);

        return loggedInUserAdAccount.map(userAccount -> {
            String userFullName = userAccount.userName;
            String adUserName = userAccount.userEmail;
            UserData userData = new UserData(adUserName, userFullName, true);
            SessionUtils.saveUserToSession(request, userData);
            return ResponseEntity.ok(userData);
        }).orElseGet(() -> {
            log.warn("Login failed for user {}", authData.userName);
            return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).build();
        });
    }
}
