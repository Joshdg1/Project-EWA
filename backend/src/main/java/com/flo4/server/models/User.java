package com.flo4.server.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    @ManyToMany
    @JoinTable(
            name = "user_project",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id")
    )
    @JsonIgnore()
    private List<Project> projects;

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
