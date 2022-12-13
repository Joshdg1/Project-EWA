package com.flo4.server.rest;

import com.fasterxml.jackson.annotation.JsonProperty;


import com.flo4.server.Exceptions.NotFoundException;
import com.flo4.server.models.GetUser;
import com.flo4.server.models.User;
import com.flo4.server.repository.EntityRepository;
import com.flo4.server.service.UserService;

import org.springframework.web.bind.annotation.*;



import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping(value = "/users")
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {
    private final UserService userService;




    public UserController(UserService userService) {
        this.userService = userService;
    }

    record RegisterRequest(int id,
                            String email,
                           @JsonProperty("first_name") String first_name,
                           @JsonProperty("last_name")String last_name,
                           String password,
                           @JsonProperty("password_confirm") String passwordConfirmation,
                           @JsonProperty("phone_number") String phoneNumber
    ) {
    }

    record RegisterResponse(String email,
                            @JsonProperty("first_name") String firstName,
                            @JsonProperty("last_name") String lastName,
                            @JsonProperty("phone_number") String phoneNumber) {
    }

    @PostMapping("register")
    public RegisterResponse registerUser(@RequestBody RegisterRequest registerRequest){
//        if (!Objects.equals(registerRequest.password(), registerRequest.passwordConfirmation()))
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wachtwoorden komen niet overeen");


      var user =  userService.registerUser(
              registerRequest.id(),
              registerRequest.email(),
              registerRequest.first_name(),
              registerRequest.last_name(),
              registerRequest.password(),
              registerRequest.phoneNumber(),
              registerRequest.passwordConfirmation()
      );
      return new RegisterResponse(user.getEmail(), user.getFirstName(), user.getLastName(), user.getPhoneNumber());
  }

    record LoginRequest(String email, String password) {
    }

    record LoginResponse(String token) {
    }

  @PostMapping(value = "login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest, HttpServletResponse response){
        var login = userService.login(loginRequest.email(), loginRequest.password());

      Cookie cookie = new Cookie("secretRefreshToken", login.getRefreshToken().getToken());
      cookie.setMaxAge(3600);
      cookie.setHttpOnly(true);
      cookie.setPath("/users");

      response.addCookie(cookie);
        return new LoginResponse(login.getAccessToken().getToken());
  }

    record UserResponse(String email,
                            @JsonProperty("first_name") String firstName,
                            @JsonProperty("last_name")String lastName,
                            @JsonProperty("phone_number") String phoneNumber){}

    @GetMapping(value = "token")
    public UserResponse user(HttpServletRequest request){
        var user = (User) request.getAttribute("user");

        return new UserResponse(user.getEmail(), user.getFirstName(), user.getLastName(), user.getPhoneNumber());
    }

    @GetMapping(path = "{id}", produces = "application/json")
    public User getUserById(@PathVariable int id) {
        User user = this.userRepository.findById(id);
        if (user == null) {
            throw new NotFoundException(String.format(String.valueOf(user), id));
        }

    record RefreshResponse(String token){}

    @PostMapping(value = "refresh")
    public RefreshResponse refresh(@CookieValue("secretRefreshToken") String refreshToken){
        return new RefreshResponse(userService.refreshAccess(refreshToken).getAccessToken().getToken());
    }

    @PutMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<User> updateUserById(@PathVariable int id, @RequestBody GetUser user) {

        User user2 = this.userRepository.findById(id);

        user2.setFirstName(user.getFirstName());
        user2.setLastName(user.getLastName());
        user2.setPhoneNumber(user.getPhoneNumber());
        user2.setEmail(user.getEmail());

        User user1 = this.userRepository.update(user2, id);

        return ResponseEntity.ok().body(user1);
    }

    record LogoutResponse(String msg){}
    @PostMapping(value = "logout")
    public LogoutResponse logout(@CookieValue("secretRefreshToken") String refreshToken, HttpServletResponse response){
        Cookie cookie = new Cookie("secretRefreshToken" ,null);
        cookie.setMaxAge(0);
        cookie.setHttpOnly(true);

        response.addCookie(cookie);
        return new LogoutResponse("Logout successful");
    }
}
