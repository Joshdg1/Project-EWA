package com.flo4.server.repository;

import com.flo4.server.models.Project;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjectInMemoryRepository implements EntityRepository<Project> {

    private List<Project> projects;

    public ProjectInMemoryRepository(List<Project> projects) {
        this.projects = new ArrayList<>();
    }

    @Override
    public List<Project> findAll() {
        return this.projects;
    }

    @Override
    public Project findById(int id) {
        return projects.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Project save(Project entity) {
        projects.add(entity);
        return entity;
    }

    @Override
    public Project update(Project entity, int id) {
        Project project = this.findById(id);
        project.setUsers(entity.getUsers());
        project.setClient(entity.getClient());
        project.setTitle(entity.getTitle());
        project.setDescription(entity.getDescription());
        project.setStartDate(entity.getStartDate());
        project.setEndDate(entity.getEndDate());
        return project;
    }

    @Override
    public Project deleteById(int id) {
        Project project = this.findById(id);
        projects.remove(project);
        project.setTitle("Truly removed");
        return project;
    }

    @Override
    public List<Project> findByQuery(String jpqlName, Object... params) {
        return null;
    }
}
