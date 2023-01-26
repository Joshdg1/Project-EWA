package com.flo4.server.rest;

import com.flo4.server.models.Project;
import com.flo4.server.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProjectControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getAllProjects() {

        // Create 2 new projects.
        User user1 = new User(1);
        Project project = new Project(1, user1, "EWA", "Big project", new Date(17 - 7 - 2022),
                new Date(17 - 7 - 2023));

        User user2 = new User(2);
        Project project2 = new Project(2, user2, "PAD", "Small project", new Date(17 - 7 - 2022),
                new Date(17 - 7 - 2023));

        //Do 2 post requests.
        this.restTemplate.postForEntity("/projects/add", project, Project.class);
        this.restTemplate.postForEntity("/projects/add", project2, Project.class);

        //Do a getAll request
        ResponseEntity<Project[]> response = this.restTemplate.getForEntity("/projects", Project[].class);


        assertEquals(HttpStatus.OK, response.getStatusCode());

        Project[] projects = response.getBody();

        assertNotNull(projects);
        assertEquals(2, projects.length);

    }

    @Test
    void saveProject() {
        User user = new User(1);
        Project project = new Project(1, user, "EWA", "Big project", new Date(17 - 7 - 2022),
                new Date(17 - 7 - 2023));

        ResponseEntity<Project> response = this.restTemplate.postForEntity("/projects/add", project, Project.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

    }
}