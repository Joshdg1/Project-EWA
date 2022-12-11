package com.flo4.server.service;

import com.flo4.server.models.User;
import com.flo4.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.Objects;

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

    public User registerUser(int id, String email, String firstName, String lastName, String password, String phoneNumber, String passwordConfirmation){
        if(!Objects.equals(password, passwordConfirmation))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wachtwoorden komen niet overeen");
        
        return userRepository.save(
                User.of(id, email, firstName, lastName, passwordEncoder.encode(password), phoneNumber)
        );
    }


    public Login login(String email, String password) {
        //Find user by email
        var user = userRepository.findByEmail(email);

        System.out.println(userRepository.findByEmail(email));
        //see if passwords match
        if (!passwordEncoder.matches(password, user.getPassword()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Verkeerde gegevens");


        return Login.of(user.getId(), secretAccessToken,
                secretRefreshToken);
    }


    public User getUserFromToken(String token) {
        return userRepository.findById(Token.from(token, secretAccessToken));
    }
}
