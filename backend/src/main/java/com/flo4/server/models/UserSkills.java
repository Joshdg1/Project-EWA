package com.flo4.server.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class UserSkills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    double level;

    @JsonIgnore
    @ManyToOne
    private User user;

    public UserSkills(){};

    public UserSkills(int id){this.id = id;}

    public UserSkills(int id, String name, double level, User user) {
        this(id);
        this.name = name;
        this.level = level;
        this.setUser(user);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
