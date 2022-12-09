package com.flo4.server.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String company;
    private int hoursWorked;

//    @OneToMany(mappedBy = "project")
//    private Set<Programmer> programmers;

    //@todo make it possible to have nullable on false and add client
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    public Project() {

    }

    public Project(int id) {
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
//     * @param programmers
     * @param client
     */
    public Project(int id, String title, String description, String company, int hoursWorked, Client client) {
        this(id);
        this.setTitle(title);
        this.setDescription(description);
        this.setCompany(company);
        this.setHoursWorked(hoursWorked);
//        this.setProgrammers(programmers);
        this.setClient(client);
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
//
//    public Set<Programmer> getProgrammers() {
//        return programmers;
//    }
//
//    public void setProgrammers(Set<Programmer> programmers) {
//        this.programmers = programmers;
//    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
