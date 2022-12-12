package old;

import com.flo4.server.models.Project;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String email;

    private String address;

    private String city;

    private String postcode;

    // todo add skills

    // todo add availability
//    private String availability;
    private String projectType;

    @OneToMany(mappedBy = "client")
    private Set<Project> projects;

    public Client() {
    }

    public Client(int id) {
        this.id = id;
    }

    public Client(int id, String name, String email, String address, String city, String postcode, String projectType, Set<Project> projects) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.city = city;
        this.postcode = postcode;
        this.projectType = projectType;
        this.setProjects(projects);
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public String getProjectType() {
        return projectType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

}
