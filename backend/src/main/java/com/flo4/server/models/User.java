package com.flo4.server.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class User {
    /**
     * Entity class for user
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private String companyName;
    private String userType;

    @ManyToMany
    @JoinTable(
            name = "user_project",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id")
    )
    @JsonIgnore()
    private List<Project> projects;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserSkills> skills;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PasswordResetTokens> resetTokens;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public static User of(int id, String email, String firstName, String lastName, String phoneNumber, String companyName, String userType) {
        return new User(id, email, firstName, lastName, phoneNumber, companyName, userType);
    }

    public static User of(int id, String email, String firstName, String lastName, String password, String phoneNumber, String companyName, String userType) {
        return new User(id, email, firstName, lastName, password, phoneNumber, companyName, userType);
    }

    public User(int id, String email, String firstName, String lastName, String password, String phoneNumber, String companyName, String userType) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.companyName = companyName;
        this.userType = userType;
    }

    public User(int id, String email, String firstName, String lastName, String phoneNumber, String companyName, String userType) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.companyName = companyName;
        this.userType = userType;
    }
}
