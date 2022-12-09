package com.flo4.server.rest;

import com.flo4.server.Exceptions.NotFoundException;
import com.flo4.server.models.UserSkills;
import com.flo4.server.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
@RestController
@RequestMapping("skills")
@CrossOrigin(origins = "http://localhost:8080")
public class SkillController {
    private static final String notFound = "Skill with id %d was not found!";
    @Autowired
    EntityRepository<UserSkills> availabilityRepository;

    @GetMapping(path = "", produces = "application/json")
    public List<UserSkills> getAllProgrammers() {
        return this.availabilityRepository.findAll();
    }

    @GetMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<UserSkills> findOneSkill(@PathVariable() int id) {
        UserSkills UserSkills = this.availabilityRepository.findById(id);
        if (UserSkills == null) {
            throw new NotFoundException(String.format(notFound, id));
        }

        return ResponseEntity.ok().body(UserSkills);
    }

    @Transactional
    @PostMapping(path = "add", produces = "application/json")
    public ResponseEntity<UserSkills> addSkill(@RequestBody UserSkills UserSkills) {

        UserSkills newUserSkills = this.availabilityRepository.save(UserSkills);


        return ResponseEntity.ok().body(newUserSkills);
    }

    @DeleteMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<UserSkills> deleteSkill(@PathVariable int id) {
        UserSkills UserSkills = this.availabilityRepository.findById(id);

        if (UserSkills == null) {
            throw new NotFoundException(String.format(notFound, id));
        }

        this.availabilityRepository.deleteById(id);

        return ResponseEntity.ok().body(UserSkills);
    }

    @PutMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<UserSkills> updateSkill(@PathVariable int id, @RequestBody UserSkills UserSkills) {
        UserSkills updatedUserSkills = this.availabilityRepository.update(UserSkills, id);

        if (updatedUserSkills == null) {
            throw new NotFoundException(String.format(notFound, id));
        }
        return ResponseEntity.ok().body(updatedUserSkills);
}
}
