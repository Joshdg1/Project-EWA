package com.flo4.server.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String company;
    private int hoursWorked;
    //@Todo add Programmer


    public Project(){

    }

    public Project(int id){
        this.id = id;
    }

    /**
     * Constructor
     *
     * @param id
     * @param title
     * @param description
     * @param company
     * @param hoursWorked
     */
    public Project(int id, String title, String description, String company, int hoursWorked) {
        this(id);
        this.setTitle(title);
        this.setDescription(description);
        this.setCompany(company);
        this.setHoursWorked(hoursWorked);
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

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}
