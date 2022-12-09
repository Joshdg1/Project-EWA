package com.flo4.server.models;


import javax.persistence.*;

@Entity
public class UserFiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String fileName;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = true)
    private User user;

    public UserFiles() {

    }

    public UserFiles(int id) {
        this.id = id;
    }

    public UserFiles(int id, User user) {
        this(id);
        this.user = user;
    }
}
