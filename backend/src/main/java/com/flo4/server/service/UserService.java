package com.flo4.server.service;

import com.flo4.server.models.PasswordResetTokens;
import com.flo4.server.models.User;
import com.flo4.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final String secretAccessToken;
    private final String secretRefreshToken;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                       @Value("${application.security.secret-access-token}") String secretAccessToken,
                       @Value("${application.security.secret-refresh-token}")String secretRefreshToken) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.secretAccessToken = secretAccessToken;
        this.secretRefreshToken = secretRefreshToken;
    }

    public User registerUser(int id, String email, String first_name, String last_name, String password, String phoneNumber, String companyName, String userType){
//        if(!Objects.equals(password, passwordConfirmation))
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wachtwoorden komen niet overeen");
        
        return userRepository.save(
                User.of(id, email, first_name, last_name, passwordEncoder.encode(password), phoneNumber, companyName, userType)
        );
    }

    public User registerClient(int id, String email, String firstName, String lastName, String password, String phoneNumber, String companyName, String userType){
//        if(!Objects.equals(password, passwordConfirmation))
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wachtwoorden komen niet overeen");

        if (password.equals("false")){
            return userRepository.save(
                    User.of(id, email, firstName, lastName, phoneNumber, companyName, userType)
            );
        } else {
            return userRepository.save(
                    User.of(id, email, firstName, lastName, passwordEncoder.encode(password), phoneNumber, companyName, userType)
            );
        }
    }


    /**
     * Login logic takes a user's email and password, finds the email, then checks if the password matches with
     * the encoded password
     * @param email
     * @param password
     * @return
     */
    public Login login(String email, String password) {
        //Find user by email
        User user = userRepository.findByEmail(email);

        System.out.println(userRepository.findByEmail(email));
        //see if passwords match
        if (!passwordEncoder.matches(password, user.getPassword()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Verkeerde gegevens");

//        var login = Login.of(user.getId(), secretAccessToken,
//                secretRefreshToken);
//        var refreshJwt = login.getRefreshToken();
//        user.addToken()

        return Login.of(user.getId(), secretAccessToken,
                secretRefreshToken, user);
    }


    /**
     * Gets the user from a token
     * @param token
     * @return
     */
    public User getUserFromToken(String token) {
        return userRepository.findById(Token.from(token, secretAccessToken));
    }

    public Login refreshAccess(String refreshToken) {
        int id = Token.from(refreshToken, secretRefreshToken);

        return Login.of(id, secretAccessToken, Token.of(refreshToken), getUserFromToken(secretAccessToken));
    }

//    public PasswordResetTokens getByToken(String token){
//        return  userRepository.findToken(token);
//    }

    /**
     * Updates the user with a new password
     * @param user
     * @param newPassword
     * @return
     */
    public User updatePassword(User user, String newPassword){
        user.setPassword(passwordEncoder.encode(newPassword));
         return userRepository.save(user);
    }

//    public PasswordResetTokens deleteToken(String token){
//
//       return userRepository.deleteByToken(token);
//    }
}
