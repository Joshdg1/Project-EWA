package com.flo4.server.rest;

import com.flo4.server.Exceptions.NotFoundException;
import com.flo4.server.models.CreateProject;
import com.flo4.server.models.Project;
import com.flo4.server.models.User;
import com.flo4.server.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("projects")
public class ProjectController {

    @Qualifier("ProjectInMemory")
    @Autowired
    EntityRepository<Project> projectRepository;

    @Autowired
    EntityRepository<User> userRepository;

    /**
     * @return all projects found in the database.
     */
    @GetMapping(path = "", produces = "application/json")
    public List<Project> getAllProjects() {

        return this.projectRepository.findAll();
    }

    /**
     * @param id
     * @return RepsoneEntity with the found project in its body.
     */
    @GetMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<Project> getOneProject(@PathVariable() int id) {
        Project project = this.projectRepository.findById(id);

        if (project == null) {
            throw new NotFoundException(String.format("Project with id %d was not found!", id));
        }

        return ResponseEntity.ok().body(project);
    }

    /**
     * @param createProject
     * @return ResponseEntity with the new project in its body.
     */
    @PostMapping(path = "add", produces = "application/json")
    public ResponseEntity<Project> addNewProject(@RequestBody Project createProject) {

        //Save the new project into the repository.
        Project savedProject = this.projectRepository.save(createProject);

        return ResponseEntity.ok().body(savedProject);
    }

    /**
     * @param id
     * @return ResponseEntity with the deleted projects in its body.
     */
    @DeleteMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<Project> deleteProject(@PathVariable() int id) {
        Project project = this.projectRepository.findById(id);

        if (project == null) {
            throw new NotFoundException(String.format("Project with id %d was not found!", id));
        }

        this.projectRepository.deleteById(id);

        return ResponseEntity.ok().body(project);
    }

    /**
     *
     * @param id
     * @param createProject
     * @return ResponseEntity with the updated project in its body.
     */
    @PutMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<Project> updateProject(@PathVariable() int id, @RequestBody CreateProject createProject) {
        Project project = this.projectRepository.findById(id);
        User client = this.userRepository.findById(createProject.getClient_id());
        project.setClient(client);
        project.setTitle(createProject.getName());
        project.setDescription(createProject.getDescription());
        project.setStartDate(createProject.getStart_date());
        project.setEndDate(createProject.getEnd_date());

        //Call the update from the repository to update the given project in the database.
        Project updatedProject = this.projectRepository.update(project, id);

        if (updatedProject == null) {
            throw new NotFoundException(String.format("Project with id:%d was not found!", id));
        }

        return ResponseEntity.ok().body(updatedProject);

    }
}

