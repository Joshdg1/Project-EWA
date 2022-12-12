package com.flo4.server.models;


import javax.persistence.*;

@Entity
public class UserProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Project project;

    public UserProject() {

    }

    public UserProject(int id) {
        this.id = id;
    }

    public UserProject(int id, Project project, User user) {
        this(id);
        this.user = user;
        this.project = project;
    }
}
