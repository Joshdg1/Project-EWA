package com.flo4.server.service;

import com.flo4.server.models.User;
import com.flo4.server.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
public class UserService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User registerUser(String email, String firstName, String lastName, String password, String phoneNumber, String passwordConfirmation){
        if(!Objects.equals(password, passwordConfirmation))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wachtwoorden komen niet overeen");

        return userRepository.save(
                User.of(email, firstName, lastName, passwordEncoder.encode(password), phoneNumber)
        );
    }
}
