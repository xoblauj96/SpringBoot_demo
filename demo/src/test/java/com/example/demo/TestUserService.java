package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.exception.UserException;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class TestUserService {
    @Autowired
    private UserService userService;

    @Order(1)
    @Test
    void TestCreate() throws UserException {
        User user = userService.create(TestData.email, TestData.password, TestData.name);

        //check not null
        Assertions.assertNotNull(user);
        Assertions.assertNotNull(user.getId());

        //check equal
        Assertions.assertEquals(TestData.name, user.getName());
        Assertions.assertEquals(TestData.email, user.getEmail());
        boolean isMatched = userService.matchPassword(TestData.password, user.getPassword());
        Assertions.assertTrue(isMatched);

    }

    @Order(2)
    @Test
    void TestUpdate() {
    }

    @Order(3)
    @Test
    void TestDelete() {
    }

    interface TestData {
        String email = "sorlor2@gmail.com";
        String password = "1234";
        String name = "sorlor";
    }

}
