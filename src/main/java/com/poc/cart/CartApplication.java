package com.poc.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class CartApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CartApplication.class, args);
    }

}