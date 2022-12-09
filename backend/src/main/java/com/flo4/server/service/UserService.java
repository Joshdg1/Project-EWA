package com.flo4.server.service;


import com.flo4.server.models.User;
import com.flo4.server.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.NoResultException;
import java.util.Objects;

@Service
public class UserService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User registerUser(int id, String email, String firstName, String lastName, String password, String phoneNumber, String passwordConfirmation){
        if(!Objects.equals(password, passwordConfirmation))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wachtwoorden komen niet overeen");
        User emailValidation = userRepository.findByEmail(email);

        
        return userRepository.save(
                User.of(id, email, firstName, lastName, passwordEncoder.encode(password), phoneNumber)
        );
    }


    public Token login(String email, String password) {
        //Find user by email
        var user = userRepository.findByEmail(email);

        System.out.println(userRepository.findByEmail(email));
        //see if passwords match
        if (!passwordEncoder.matches(password, user.getPassword()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Verkeerde gegevens");


        return Token.of(user.getId(), 10L, "SecretKey for this user it's really secret");
    }


}
