//package com.flo4.server.rest;
//
//import com.flo4.server.Exceptions.NotFoundException;
//import com.flo4.server.models.Project;
//import com.flo4.server.models.UserProject;
//import com.flo4.server.repository.EntityRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//@RestController
//@RequestMapping("userProjects")
//@CrossOrigin(origins = "http://localhost:8080")
//public class UserProjectController {
//    @Autowired
//    EntityRepository<UserProject> projectRepository;
//
//    @GetMapping(path = "", produces = "application/json")
//    public List<UserProject> getAllProjects() {
//        return this.projectRepository.findAll();
//    }
//
//    @GetMapping(path = "{id}", produces = "application/json")
//    public ResponseEntity<UserProject> getOneProject(@PathVariable() int id) {
//        UserProject userProject = this.projectRepository.findById(id);
//
//        if (userProject == null) {
//            throw new NotFoundException(String.format("Project with id %d was not found!", id));
//        }
//
//        return ResponseEntity.ok().body(userProject);
//    }
//
//    @Transactional
//    @PostMapping(path = "add", produces = "application/json")
//    public ResponseEntity<UserProject> addNewProject(@RequestBody UserProject newProject) {
//
//        //Save the new project into the repository.
//        UserProject savedProject = this.projectRepository.save(newProject);
//
//        return ResponseEntity.ok().body(savedProject);
//
//    }
//
//    @DeleteMapping(path = "{id}", produces = "application/json")
//    public ResponseEntity<UserProject> deleteProject(@PathVariable() int id) {
//        UserProject project = this.projectRepository.findById(id);
//
//        if (project == null) {
//            throw new NotFoundException(String.format("Project with id %d was not found!", id));
//        }
//
//        this.projectRepository.deleteById(id);
//
//        return ResponseEntity.ok().body(project);
//    }
//
//    @PutMapping(path = "{id}", produces = "application/json")
//    public ResponseEntity<UserProject> updateProject(@PathVariable() int id, @RequestBody UserProject project) {
//
//        UserProject updatedProject = this.projectRepository.update(project, id);
//
//        if (updatedProject == null) {
//            throw new NotFoundException(String.format("Project with id:%d was not found!", id));
//        }
//
//        return ResponseEntity.ok().body(updatedProject);
//
//    }
//
//}
