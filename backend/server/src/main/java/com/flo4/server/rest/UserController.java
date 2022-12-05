package com.flo4.server.rest;

import com.flo4.server.models.User;

import com.flo4.server.repository.EntityRepository;
import com.flo4.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping(value = "user")
public class UserController {


    @Autowired
    UserService userService;

  @PostMapping("add")
    public User addUser(@RequestBody User user){
      return this.userService.save(user);
  }
}
