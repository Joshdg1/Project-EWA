package com.flo4.server.rest;

import com.flo4.server.models.Project;
import com.flo4.server.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    EntityRepository<Project> projectRepository;

    @GetMapping(path = "", produces = "application/json")
    public List<Project> getAllProjects() {
        return this.projectRepository.findAll();
    }

    @GetMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<Project> getOneProject(@PathVariable() int id) {
        Project project = this.projectRepository.findById(id);

        if (project == null) {
            throw new RuntimeException("Project was not found.");
        }

        return ResponseEntity.ok().body(project);
    }

    @Transactional
    @PostMapping(path = "/add", produces = "application/json")
    public ResponseEntity<Project> addNewProject(@RequestBody Project newProject) {

        //Save the new project into the repository.
        Project savedProject = this.projectRepository.save(newProject);

        return ResponseEntity.ok().body(savedProject);

    }
}
