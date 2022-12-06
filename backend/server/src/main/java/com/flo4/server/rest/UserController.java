package com.flo4.server.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flo4.server.models.User;

import com.flo4.server.repository.EntityRepository;
import com.flo4.server.repository.UserRepository;
import com.flo4.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Objects;

@RestController
@RequestMapping(value = "user")
public class UserController {
    private final UserRepository userRepository;



    @Autowired
    UserService userService;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    record RegisterRequest(String email,
                           @JsonProperty("first_name") String firstName,
                           @JsonProperty("last_name")String lastName,
                           String password,
                           @JsonProperty("password_confirm") String passwordConfirmation,
                           @JsonProperty("phone_number") String phoneNumber
                           ){}

    record RegisterResponse(String email,
                            @JsonProperty("first_name") String firstName,
                            @JsonProperty("last_name")String lastName,
                            @JsonProperty("phone_number") String phoneNumber){}

    @PostMapping("add")
    public RegisterResponse registerUser(@RequestBody RegisterRequest registerRequest){
        if (!Objects.equals(registerRequest.password(), registerRequest.passwordConfirmation()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wachtwoorden komen niet overeen");


      var user =  userRepository.save(
             User.of(
                     registerRequest.email(),
                     registerRequest.firstName(),
                     registerRequest.lastName(),
                     registerRequest.password(),
                     registerRequest.phoneNumber()

             )
      );
      return new RegisterResponse(user.getEmail(), user.getFirstName(), user.getLastName(), user.getPhoneNumber());
  }
}
