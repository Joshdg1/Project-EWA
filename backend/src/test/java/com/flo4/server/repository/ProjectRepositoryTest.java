package com.flo4.server.repository;

import com.flo4.server.models.Project;
import com.flo4.server.models.User;
import org.junit.jupiter.api.BeforeEach;
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
        classes = { Repository.class, Entity.class }))
class ProjectRepositoryTest {

    @Autowired
    private ProjectInMemoryRepository projectEntityRepository;
    Project project1, project2;

    @BeforeEach
    void setup() {
        Date startDate1 = new Date(12-8-2023);
        Date endDate1 = new Date(24-8-2023);
        Date startDate2 = new Date(12-8-2022);
        Date endDate2 = new Date(24-8-2022);
        User user1 = new User(1);
        User user2 = new User(2);
        this.project1 = new Project(1, user1, "EWA", "Big project", startDate1, endDate1);
        this.project2 = new Project(2, user2, "PAD", "Decent sized project", startDate2, endDate2);

        projectEntityRepository.save(project1);
        projectEntityRepository.save(project2);

    }

    @Test
    void findAllTest() {

    }

    @Test
    void findByIdTest() {
        Project projectFound = projectEntityRepository.findById(1);
        assertEquals(this.project1, projectFound);
    }

    @Test
    void saveTest() {
    }

    @Test
    void updateTest() {
    }

    @Test
    void deleteByIdTest() {
        Project project = projectEntityRepository.deleteById(2);
        assertEquals(project.getTitle(), "Truly removed");
    }

    @Test
    void findByQueryTest() {
    }
}