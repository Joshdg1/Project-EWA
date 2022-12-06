package com.flo4.server.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flo4.server.models.User;

import com.flo4.server.repository.UserRepository;
import com.flo4.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.Objects;

@RestController
@RequestMapping(value = "user")
public class UserController {
    private final UserService userService;




    public UserController(UserService userService) {
        this.userService = userService;
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

      var user =  userService.registerUser(
              registerRequest.email(),
              registerRequest.firstName(),
              registerRequest.lastName(),
              registerRequest.password(),
              registerRequest.phoneNumber(),
              registerRequest.passwordConfirmation()
      );
      return new RegisterResponse(user.getEmail(), user.getFirstName(), user.getLastName(), user.getPhoneNumber());
  }

  record LoginRequest(String email, String password){}
    record LoginResponse(String email,
                         @JsonProperty("first_name") String firstName,
                         @JsonProperty("last_name")String lastName,
                         @JsonProperty("phone_number") String phoneNumber){}

  @PostMapping(value = "login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        var user = userService.login(loginRequest.email(), loginRequest.password());

        return new LoginResponse(user.getEmail(), user.getFirstName(), user.getLastName(), user.getPhoneNumber());
  }
}
