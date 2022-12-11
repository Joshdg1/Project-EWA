package com.flo4.server.rest;

import com.fasterxml.jackson.annotation.JsonProperty;


import com.flo4.server.models.User;
import com.flo4.server.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
@RequestMapping(value = "/api")
public class UserController {
    private final UserService userService;




    public UserController(UserService userService) {
        this.userService = userService;
    }

    record RegisterRequest(int id,
                            String email,
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
              registerRequest.id(),
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
    record LoginResponse(String token){}

  @PostMapping(value = "login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest, HttpServletResponse response){
        var login = userService.login(loginRequest.email(), loginRequest.password());

      Cookie cookie = new Cookie("secretRefreshToken", login.getRefreshToken().getToken());
      cookie.setMaxAge(3600);
      cookie.setHttpOnly(true);
      cookie.setPath("/api");

      response.addCookie(cookie);
        return new LoginResponse(login.getAccessToken().getToken());
  }

    record UserResponse(String email,
                            @JsonProperty("first_name") String firstName,
                            @JsonProperty("last_name")String lastName,
                            @JsonProperty("phone_number") String phoneNumber){}

    @GetMapping(value = "user")
    public UserResponse user(HttpServletRequest request){
        var user = (User) request.getAttribute("user");

        return new UserResponse(user.getEmail(), user.getFirstName(), user.getLastName(), user.getPhoneNumber());
    }

    record RefreshResponse(String token){}

    @PostMapping(value = "refresh")
    public RefreshResponse refresh(@CookieValue("secretRefreshToken") String refreshToken){
        return new RefreshResponse(userService.refreshAccess(refreshToken).getAccessToken().getToken());
    }
}
