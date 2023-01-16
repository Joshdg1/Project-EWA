package com.flo4.server;

import com.flo4.server.Exceptions.NotFoundException;
import com.flo4.server.models.User;
import com.flo4.server.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.MethodNotAllowedException;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserTests {
    @Autowired
    private UserRepository entityManager;

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
}
