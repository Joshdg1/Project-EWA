package com.flo4.server.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@NamedQuery(
name = "Hours_find_by_Project",
        query = "select h from UserHours h WHERE project_id = ?1"
)
public class UserHours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    double hours;
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
