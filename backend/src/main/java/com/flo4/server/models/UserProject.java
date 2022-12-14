//package com.flo4.server.models;
//
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//
//import javax.persistence.*;
//
//@Entity
//public class UserProject {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    int id;
//
//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JsonBackReference(value = "user")
//    private User user;
//
//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JsonBackReference(value = "project")
//    private Project project;
//
//    public UserProject() {
//
//    }
//
//    public UserProject(int id) {
//        this.id = id;
//    }
//
//    public UserProject(int id, Project project, User user) {
//        this(id);
//        this.user = user;
//        this.project = project;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Project getProject() {
//        return project;
//    }
//
//    public void setProject(Project project) {
//        this.project = project;
//    }
//}
