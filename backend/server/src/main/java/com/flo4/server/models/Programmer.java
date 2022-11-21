package com.flo4.server.models;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Programmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String address;

    private String city;

    private String postcode;


    @OneToMany(mappedBy = "programmer")
    private Set<Skill> skills;

    @OneToOne
    private Availability availability;
    private String workPreference;

    private String projectType;

    public Programmer() {
    }

    public Programmer(int id) {
        this.id = id;
    }

    public Programmer(int id, String firstName, String lastName, String email, String address,
                      String city, String postcode, Set<Skill> skills, Availability availability, String workPreference, String projectType) {
        this(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.city = city;
        this.postcode = postcode;
        this.skills = skills;
        this.availability = availability;
        this.workPreference = workPreference;
        this.projectType = projectType;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }


    public Set<Skill> getSkill() {
        return skills;
    }

    public void setSkill(Set<Skill> skill) {
        this.skills = skill;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public String getWorkPreference() {
        return workPreference;
    }

    public String getProjectType() {
        return projectType;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }


    public void setWorkPreference(String workPreference) {
        this.workPreference = workPreference;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }
}
