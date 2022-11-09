package com.flo4.server.dao;

import com.flo4.server.models.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectDao {
    int insertProject(Project project);
    List<Project> selectAllProjects();

    //
    public Optional<Project> selectedProjectById(int id);
}
