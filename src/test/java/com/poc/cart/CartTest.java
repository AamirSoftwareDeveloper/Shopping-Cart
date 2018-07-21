package com.poc.cart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CartTest.class)
@ContextConfiguration
public class CartTest {

    @Test
    public void contextLoads() {
    }

}
