package com.flo4.server.rest;

import com.flo4.server.Exceptions.NotFoundException;
import com.flo4.server.models.CreateProject;
import com.flo4.server.models.Project;
//import com.flo4.server.models.UserProject;
import com.flo4.server.models.User;
import com.flo4.server.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("projects")
public class ProjectController {

    @Qualifier("PROJECT.JPA")
    @Autowired
    EntityRepository<Project> projectRepository;

    @Autowired
    EntityRepository<User> userRepository;

    @GetMapping(path = "", produces = "application/json")
    public List<Project> getAllProjects() {

        return this.projectRepository.findAll();
    }

    @GetMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<Project> getOneProject(@PathVariable() int id) {
        Project project = this.projectRepository.findById(id);

        if (project == null) {
            throw new NotFoundException(String.format("Project with id %d was not found!", id));
        }

        return ResponseEntity.ok().body(project);
    }

    @Transactional
    @PostMapping(path = "add", produces = "application/json")
    public ResponseEntity<Project> addNewProject(@RequestBody CreateProject createProject) {
        User client = this.userRepository.findById(createProject.getClient_id());
        Project newProject = new Project(createProject.getId(), client, createProject.getName(), createProject.getDescription(), createProject.getStart_date(), createProject.getEnd_date());

        for (Integer programmer_id : createProject.getProgrammer_ids()) {
            User programmer = this.userRepository.findById(programmer_id);
            newProject.addUser(programmer);
        }

        //Save the new project into the repository.
        Project savedProject = this.projectRepository.save(newProject);

        return ResponseEntity.ok().body(savedProject);
    }

    @DeleteMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<Project> deleteProject(@PathVariable() int id) {
        Project project = this.projectRepository.findById(id);

        if (project == null) {
            throw new NotFoundException(String.format("Project with id %d was not found!", id));
        }

        this.projectRepository.deleteById(id);

        return ResponseEntity.ok().body(project);
    }

    @PutMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<Project> updateProject(@PathVariable() int id, @RequestBody CreateProject createProject) {
        Project project = this.projectRepository.findById(id);
        User client = this.userRepository.findById(createProject.getClient_id());
        project.setClient(client);
        project.setTitle(createProject.getName());
        project.setDescription(createProject.getDescription());
        project.setStartDate(createProject.getStart_date());
        project.setEndDate(createProject.getEnd_date());

        project.setUsers(new ArrayList<>());
        for (Integer programmer_id : createProject.getProgrammer_ids()) {
            User programmer = this.userRepository.findById(programmer_id);
            project.addUser(programmer);
        }

        Project updatedProject = this.projectRepository.update(project, id);

        if (updatedProject == null) {
            throw new NotFoundException(String.format("Project with id:%d was not found!", id));
        }

        return ResponseEntity.ok().body(updatedProject);

    }


}

