package com.flo4.server.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import old.Client;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String company;
    private String description;
    private String title;

    @ManyToMany
    @JoinTable(
            name = "user_project",
            joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
    )
    private List<User> users = new ArrayList<>();

    private Date startDate;
    private Date endDate;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
//        this.users = users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public Project() {

    }

    public Project(int id) {
        this.id = id;
    }

    public Project(int id, String title, String description, String company, int hoursWorked, Client client) {
        this(id);
        this.setTitle(title);
        this.setDescription(description);
    }

    public Project(String title, String description, Date startDate, Date endDate) {
        this.setTitle(title);
        this.setDescription(description);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
