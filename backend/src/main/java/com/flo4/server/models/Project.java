package com.flo4.server.models;

import com.flo4.server.models.old.Client;

import javax.persistence.*;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String startDate;
    private String endDate;

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
}
