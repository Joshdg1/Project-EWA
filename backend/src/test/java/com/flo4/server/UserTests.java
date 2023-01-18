package com.flo4.server;

import com.flo4.server.Exceptions.NotFoundException;
import com.flo4.server.models.User;
import com.flo4.server.repository.UserRepository;
import com.flo4.server.rest.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.MethodNotAllowedException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserTests {
    @Autowired
    private UserRepository entityManager;

    @Autowired
    private UserController userController;

    @Test
    void userTypeTest() throws Exception {
        for (User entity : entityManager.findAll()) {
            assertNotNull(entity.getUserType());
            String userType = entity.getUserType();
            switch (userType) {
                case "programmer" -> assertEquals("programmer", entity.getUserType());
                case "client" -> assertEquals("client", entity.getUserType());
                case "administrator" -> assertEquals("administrator", entity.getUserType());
                default -> throw new Exception("USERTYPE IS NOT ALLOWED");
            }
        }
    }
    @Test
    void getUserShouldReturnUsers() {
        for (User entity : userController.getAllUsers()) {
            assertInstanceOf(User.class ,entity);
        }
    }

    @Test
    void AbleToAddOneUser(){
        User user = new User(66,"valentijnnijhuis@gmail.com","Valentijn","Nijhuis","12312","piza&CO","client");
        entityManager.save(user);
    }
}
