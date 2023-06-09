package com.flo4.server.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flo4.server.Exceptions.NotFoundException;
import com.flo4.server.models.PasswordResetTokens;
import com.flo4.server.models.User;
import com.flo4.server.repository.PasswordResetRepository;
import com.flo4.server.repository.UserRepository;
import com.flo4.server.service.Login;
import com.flo4.server.service.PasswordReset;
import com.flo4.server.service.UserService;
import com.flo4.server.utils.PasswordResetUtil;
import com.mailgun.api.v3.MailgunMessagesApi;
import com.mailgun.client.MailgunClient;
import com.mailgun.model.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final PasswordResetRepository passwordResetRepository;

    /**
     * @return a list of all the users
     */
    @GetMapping(path = "", produces = "application/json")
    public List<User> getAllUsers() {

        return this.userRepository.findAll();
    }

    /**
     * @return a list of all the users with the usertype "programmer"
     */
    @GetMapping(path = "programmers", produces = "application/json")
    public List<User> getAllProgrammers() {

        return this.userRepository.findAllProgrammers();
    }

    /**
     * @return a list of all the users with the usertype "client"
     */
    @GetMapping(path = "clients", produces = "application/json")
    public List<User> getAllClients() {

        return this.userRepository.findAllClients();
    }

    /**
     * @param id
     * @return a user with a specific ID
     */
    @GetMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<User> getOneProject(@PathVariable() int id) {
        User user = this.userRepository.findById(id);

        if (user == null) {
            throw new NotFoundException(String.format("User with id %d was not found!", id));
        }

        return ResponseEntity.ok().body(user);
    }
//    @GetMapping(path = "companies", produces = "application/json")
//    public List<User> getAllCompanies() {
//        return this.userRepository.findAllCompanies();
//    }

//    @Transactional
//    @PostMapping(path = "add", produces = "application/json")
//    public ResponseEntity<User> addNewProject(@RequestBody User newUser) {
//
//        //Save the new project into the repository.
//        User savedUser = this.userRepository.save(newUser);
//
//        return ResponseEntity.ok().body(savedUser);
//    }

    /**
     * @param id
     * @delete a user with a specific ID
     */
    @DeleteMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<User> deleteUser(@PathVariable() int id) {
        User user = this.userRepository.findById(id);

        if (user == null) {
            throw new NotFoundException(String.format("User with id %d was not found!", id));
        }

        this.userRepository.deleteById(id);

        return ResponseEntity.ok().body(user);
    }

    /**
     * Updates a user
     * @param id
     * @param user
     * @return
     */
    @PutMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<User> updateProject(@PathVariable() int id, @RequestBody User user) {

        User updatedUser = this.userRepository.update(user, id);

        if (updatedUser == null) {
            throw new NotFoundException(String.format("User with id:%d was not found!", id));
        }

        return ResponseEntity.ok().body(updatedUser);

    }


    /**
     * Record for registering a user
     */
    record RegisterClientRequest(int id,
                                 String email,
                                 String firstName,
                                 String lastName,
                                 String password,
                                 String phoneNumber,

                                 String companyName,
                                 String userType
    ) {
    }

    record RegisterClientResponse(String email,
                                  @JsonProperty("first_name") String firstName,
                                  @JsonProperty("last_name") String lastName,
                                  @JsonProperty("phone_number") String phoneNumber) {
    }

    /**
     * Takes the user info, and registers a user, when that user is registered it sends an email out
     * to the user's email adress to reset their password
     * @param registerClientRequest
     * @return
     */
    @PostMapping("add")
    public RegisterClientResponse registerClient(@RequestBody RegisterClientRequest registerClientRequest) {
//        if (!Objects.equals(registerRequest.password(), registerRequest.passwordConfirmation()))
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wachtwoorden komen niet overeen");


        var user = userService.registerClient(
                registerClientRequest.id(),
                registerClientRequest.email(),
                registerClientRequest.firstName(),
                registerClientRequest.lastName(),
                registerClientRequest.password(),
                registerClientRequest.phoneNumber(),
                registerClientRequest.companyName(),
                registerClientRequest.userType()
        );

        if (registerClientRequest.password().equals("false")) {
            String tokenRegisterReset = new PasswordResetUtil().generateResetToken(String.valueOf(user.getId()));

            PasswordResetTokens passwordResetTokens = new PasswordResetTokens();
            passwordResetTokens.setToken(tokenRegisterReset);
            passwordResetTokens.setUser_id(user);

            String resetPasswordLink = "https://ewa-fe-app-production-55da.up.railway.app/#/users/resetPassword?token=" + tokenRegisterReset;

            passwordResetRepository.save(passwordResetTokens);

            MailgunMessagesApi mailgunMessagesApi = MailgunClient.config(env.getProperty("mailgun.api.key"))
                    .createApi(MailgunMessagesApi.class);

            Message message = Message.builder()
                    .from(env.getProperty("mailgun.email.from"))
                    .to(user.getEmail())
                    .subject("Verander de wachtwoord van uw Florijn account")
                    .text(String.format("Hi %s, om je wachtwoord te veranderen klik op deze link %s", user.getFirstName(), resetPasswordLink))
                    .build();

            mailgunMessagesApi.sendMessage(env.getProperty("mailgun.api.domain"), message);
        }
        return new RegisterClientResponse(user.getEmail(), user.getFirstName(), user.getLastName(), user.getPhoneNumber());
    }


    public UserController(UserService userService, UserRepository userRepository, PasswordResetRepository passwordResetRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.passwordResetRepository = passwordResetRepository;
    }

//    record RegisterRequest(int id,
//                           String email,
//                           @JsonProperty("first_name") String first_name,
//                           @JsonProperty("last_name") String last_name,
//                           String password,
//                           @JsonProperty("password_confirm") String passwordConfirmation,
//                           @JsonProperty("phone_number") String phoneNumber,
//
//                           @JsonProperty("user_type") String userType
//    ) {
//    }
//
//    record RegisterResponse(String email,
//                            @JsonProperty("first_name") String firstName,
//                            @JsonProperty("last_name") String lastName,
//                            @JsonProperty("phone_number") String phoneNumber) {
//    }

//    @PostMapping("register")
//    public RegisterResponse registerUser(@RequestBody RegisterRequest registerRequest) {
////        if (!Objects.equals(registerRequest.password(), registerRequest.passwordConfirmation()))
////            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wachtwoorden komen niet overeen");
//
//
//        User user = userService.registerUser(
//                registerRequest.id(),
//                registerRequest.email(),
//                registerRequest.first_name(),
//                registerRequest.last_name(),
//                registerRequest.password(),
//                registerRequest.phoneNumber(),
//                registerRequest.userType()
//        );
//
//
//        return new RegisterResponse(user.getEmail(), user.getFirstName(), user.getLastName(), user.getPhoneNumber());
//
//
//    }


    /**
     * records for loging in as a user
     */
    record LoginRequest(String email, String password) {
    }

    record LoginResponse(User user, String token) {
    }

    /**
     * takes the info and sends it to the service class where the logic is
     * Sets a refresh token as a cookie
     * @param loginRequest
     * @param response
     * @return the user and token as a response
     */
    @PostMapping(value = "login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        Login login = userService.login(loginRequest.email(), loginRequest.password());

        Cookie cookie = new Cookie("secretRefreshToken", login.getRefreshToken().getToken());
        cookie.setMaxAge(3600);
        cookie.setHttpOnly(true);
        cookie.setPath("/users");

        response.addCookie(cookie);
        return new LoginResponse(login.getUser(), login.getAccessToken().getToken());
    }

    record UserResponse(String email,
                        @JsonProperty("first_name") String firstName,
                        @JsonProperty("last_name") String lastName,
                        @JsonProperty("phone_number") String phoneNumber) {
    }

    @GetMapping(value = "token")
    public UserResponse user(HttpServletRequest request) {
        var user = (User) request.getAttribute("user");

        return new UserResponse(user.getEmail(), user.getFirstName(), user.getLastName(), user.getPhoneNumber());
    }

//    @GetMapping(path = "{id}", produces = "application/json")
//    public User getUserById(@PathVariable int id) {
//        User user = this.userRepository.findById(id);
//        if (user == null) {
//            throw new NotFoundException(String.format(String.valueOf(user), id));
//        }
//        return user;
//    }

    record RefreshResponse(String token) {
    }

    @PostMapping(value = "refresh")
    public RefreshResponse refresh(@CookieValue("secretRefreshToken") String refreshToken) {
        return new RefreshResponse(userService.refreshAccess(refreshToken).getAccessToken().getToken());
    }

//    @PutMapping(path = "{id}", produces = "application/json")
//    public ResponseEntity<User> updateUserById(@PathVariable int id, @RequestBody GetUser user) {
//
//        User user2 = this.userRepository.findById(id);
//
//        user2.setFirstName(user.getFirstName());
//        user2.setLastName(user.getLastName());
//        user2.setPhoneNumber(user.getPhoneNumber());
//        user2.setEmail(user.getEmail());
//
//        User user1 = this.userRepository.update(user2, id);
//
//        return ResponseEntity.ok().body(user1);
//    }

    record LogoutResponse(String msg) {
    }

    /**
     * sets the token to null when the user logs out
     * @param refreshToken
     * @param response
     * @return
     */
    @PostMapping(value = "logout")
    public LogoutResponse logout(@CookieValue("secretRefreshToken") String refreshToken, HttpServletResponse response) {
        Cookie cookie = new Cookie("secretRefreshToken", null);
        cookie.setMaxAge(0);
        cookie.setHttpOnly(true);

        response.addCookie(cookie);
        return new LogoutResponse("Logout successful");
    }


    @Autowired
    private Environment env;

    /**
     * finds the user by email and sets a reset token to the user, generates a link with the token and sends an email
     * to the user with a link to reset their password
     * @param passwordReset
     * @param request
     * @return
     */
    @PostMapping(path = "forgotPassword")
    public ResponseEntity<User> sendMail(@RequestBody PasswordReset passwordReset, HttpServletRequest request) {
        User user = this.userRepository.findByEmail(passwordReset.getEmail());


        String token = new PasswordResetUtil().generateResetToken(String.valueOf(user.getId()));


        PasswordResetTokens passwordResetTokens = new PasswordResetTokens();
        passwordResetTokens.setToken(token);
        passwordResetTokens.setUser_id(user);


        String resetPasswordLink = "https://ewa-fe-app-production-55da.up.railway.app/#/users/resetPassword?token=" + token;

        passwordResetRepository.save(passwordResetTokens);

//
//        if (user == null){
//            throw new NotFoundException("Unknown user");
//        }

        MailgunMessagesApi mailgunMessagesApi = MailgunClient.config(env.getProperty("mailgun.api.key"))
                .createApi(MailgunMessagesApi.class);

        Message message = Message.builder()
                .from(env.getProperty("mailgun.email.from"))
                .to(user.getEmail())
                .subject("Wachtwoord vergeten")
                .text(String.format("Hi %s, om je wachtwoord te veranderen klik op deze link %s", user.getFirstName(), resetPasswordLink))
                .build();

        mailgunMessagesApi.sendMessage(env.getProperty("mailgun.api.domain"), message);


        return ResponseEntity.ok().body(user);
    }


    record ResetRequest(String password, String token) {
    }

    record ResetResponse(int id, String email) {
    }

    //resetPassword?{token}
    //,@PathVariable(value = "token") String token

    /**
     * uses the userService class to update the password
     * @param resetRequest
     * @return
     */
    @PutMapping(path = "resetPassword")
    public ResetResponse resetPassword(@RequestBody ResetRequest resetRequest) {

        User userByToken = userRepository.findUserByToken(resetRequest.token);

        userService.updatePassword(userByToken, resetRequest.password);

        return new ResetResponse(userByToken.getId(), userByToken.getEmail());
    }


}
