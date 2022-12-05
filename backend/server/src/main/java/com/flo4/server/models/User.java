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
    private String firstname;
    private String lastname;
    private String password;
    private String userType;

    public User(){}

    public User(int id) {
        this.id = id;
    }

    public User(int id, String email, String firstname, String lastname, String password, String userType) {
        this.id = id;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.userType = userType;
    }
}
