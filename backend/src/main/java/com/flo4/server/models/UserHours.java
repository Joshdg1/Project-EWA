package com.flo4.server.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

    private String isApproved;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = true)
    private User user;

    @ManyToOne
    @JoinColumn(name = "projectId", nullable = true)
    private Project project;

    public User getApproverdBy() {
        return approverdBy;
    }

    public UserHours() {}

    public UserHours(int id) {
        this.id = id;
    }

    public UserHours(int id, Project project, User user) {
        this(id);
        this.user = user;
        this.project = project;
    }

    public int getId() {
        return id;
    }



    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public void setApproverdBy(User approverdBy) {
        this.approverdBy = approverdBy;
    }

    public String getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(String isApproved) {
        this.isApproved = isApproved;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
