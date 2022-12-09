package com.flo4.server.models.old;

import com.flo4.server.models.UserAvailability;

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
//
//    @OneToMany(mappedBy = "programmer")
//    private Set<UserSkill> userSkills;

    @OneToOne
    private UserAvailability userAvailability;
    private String workPreference;

    private String projectType;

//    @ManyToOne
//    @JoinColumn(name = "project_id", nullable = false)
//    private Project project;

    public Programmer() {
    }

    public Programmer(int id) {
        this.id = id;
    }

//    public Programmer(int id, String firstName, String lastName, String email, String address,
//                      String city, String postcode, UserAvailability userAvailability, String workPreference,
//                      String projectType, Set<UserSkill> userSkills) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.address = address;
//        this.city = city;
//        this.postcode = postcode;
//        this.userAvailability = userAvailability;
//        this.workPreference = workPreference;
//        this.projectType = projectType;
////        this.project = project;
//        this.userSkills = userSkills;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


//    public Set<UserSkill> getSkill() {
//        return userSkills;
//    }
//
//    public void setSkill(Set<UserSkill> userSkill) {
//        this.userSkills = userSkill;
//    }

    public UserAvailability getAvailability() {
        return userAvailability;
    }

    public void setAvailability(UserAvailability userAvailability) {
        this.userAvailability = userAvailability;
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

//    public Set<UserSkill> getSkills() {
//        return userSkills;
//    }
//
//    public void setSkills(Set<UserSkill> userSkills) {
//        this.userSkills = userSkills;
//    }

//    public Project getProject() {
//        return project;
//    }
//
//    public void setProject(Project project) {
//        this.project = project;
//    }
}
