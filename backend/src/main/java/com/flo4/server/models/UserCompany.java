package com.flo4.server.models;


import javax.persistence.*;

@Entity
public class UserCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String companyName;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = true)
    private User user;

    public UserCompany(int id) {
        this.id = id;
    }

    public UserCompany(int id, String companyName, User user) {
        this(id);
        this.companyName = companyName;
        this.setUser(user);
    }

    public UserCompany() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
