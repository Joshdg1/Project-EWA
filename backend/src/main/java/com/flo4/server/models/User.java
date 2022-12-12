package com.flo4.server.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private String userType;

    public User(){}

    public User(int id) {
        this.id = id;
    }

    public static User of(int id, String email, String firstName, String lastName, String password, String phoneNumber) {
        return new User(id, email,firstName, lastName, password, phoneNumber, null);
    }

    public User(int id, String email, String firstName, String lastName, String password, String phoneNumber, String userType) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
    }
}
