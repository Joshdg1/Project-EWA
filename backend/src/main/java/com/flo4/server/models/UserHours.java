package com.flo4.server.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
public class UserHours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String start;
    String end;

    @ManyToOne
    @JoinColumn(name = "approvedById")
    private User approverdBy;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = true)
    private User user;

    @ManyToOne
    @JoinColumn(name = "projectId", nullable = true)
    private Project project;

    public User getApproverdBy() {
        return approverdBy;
    }

    public UserHours() {

    }

    public UserHours(int id) {
        this.id = id;
    }

    public UserHours(int id, Project project, User user) {
        this(id);
        this.user = user;
        this.project = project;
    }
}
