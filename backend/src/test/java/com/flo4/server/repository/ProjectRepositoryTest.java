package com.flo4.server.repository;

import com.flo4.server.models.Project;
import com.flo4.server.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = {Repository.class, Entity.class}))
class ProjectRepositoryTest {

    @Autowired
    private ProjectInMemoryRepository projectEntityRepository;
    Project project1, project2, project3;

    @Test
    void saveTest() {
        Date startDate1 = new Date(12 - 8 - 2023);
        Date endDate1 = new Date(24 - 8 - 2023);
        Date startDate2 = new Date(12 - 8 - 2022);
        Date endDate2 = new Date(24 - 8 - 2022);
        User user1 = new User(1);
        User user2 = new User(2);
        User user3 = new User(3);

        this.project1 = new Project(1, user1, "EWA", "Big project", startDate1, endDate1);
        this.project2 = new Project(2, user2, "PAD", "Decent sized project", startDate2, endDate2);
        this.project3 = new Project(3, user3, "FYS", "Small project", startDate1, endDate2);


        projectEntityRepository.save(project1);
        projectEntityRepository.save(project2);
        projectEntityRepository.save(project3);

        Project foundProject2 = projectEntityRepository.findById(2);
        Project foundProject3 = projectEntityRepository.findById(3);

        assertEquals(this.project2, foundProject2);
        assertEquals(this.project3, foundProject3);
    }


    @Test
    void findAllTest() {
        assertNotNull(projectEntityRepository.findAll());
        assertEquals(3, projectEntityRepository.findAll().size());
    }

    @Test
    void findByIdTest() {
        User user4 = new User(4);
        Project project4 = new Project(4, user4, "CLOUD", "Big project", new Date(10 - 8 - 2002),
                new Date(18 - 6 - 2007));

        projectEntityRepository.save(project4);

        assertEquals(project4, projectEntityRepository.findById(4));
    }

    @Test
    void updateTest() {
        User user5 = new User(5);
        Project project5 = new Project(5, user5, "FYS", "Small project", new Date(10 - 8 - 2002),
                new Date(18 - 6 - 2007));
        Project project5New = new Project(5, user5, "CLOUD", "Big project", new Date(10 - 8 - 2002),
                new Date(18 - 6 - 2007));
        projectEntityRepository.save(project5);

        Project project = projectEntityRepository.findById(5);

        assertEquals(project.getTitle(), "FYS");
        assertEquals(project.getDescription(), "Small project");

        projectEntityRepository.update(project5New, 5);

        Project updatedProject = projectEntityRepository.findById(5);

        assertEquals(updatedProject.getTitle(), "CLOUD");
        assertEquals(updatedProject.getDescription(), "Big project");

    }

    @Test
    void deleteByIdTest() {
        Project project = projectEntityRepository.deleteById(2);
        assertEquals(project.getTitle(), "Truly removed");
    }
}