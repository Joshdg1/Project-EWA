package com.flo4.server.rest;

import com.flo4.server.Exceptions.NotFoundException;
import com.flo4.server.models.Skill;
import com.flo4.server.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

public class SkillController {
    private static final String notFound = "Project with id %d was not found!";
    @Autowired
    EntityRepository<Skill> availabilityRepository;

    @GetMapping(path = "", produces = "application/json")
    public List<Skill> getAllProgrammers() {
        return this.availabilityRepository.findAll();
    }

    @GetMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<Skill> findOneProgrammer(@PathVariable() int id) {
        Skill skill = this.availabilityRepository.findById(id);
        if (skill == null) {
            throw new NotFoundException(String.format(notFound, id));
        }

        return ResponseEntity.ok().body(skill);
    }

    @Transactional
    @PostMapping(path = "add", produces = "application/json")
    public ResponseEntity<Skill> addProgrammer(@RequestBody Skill skill) {

        Skill newSkill = this.availabilityRepository.save(skill);


        return ResponseEntity.ok().body(newSkill);
    }

    @DeleteMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<Skill> deleteProgrammer(@PathVariable int id) {
        Skill skill = this.availabilityRepository.findById(id);

        if (skill == null) {
            throw new NotFoundException(String.format(notFound, id));
        }

        this.availabilityRepository.deleteById(id);

        return ResponseEntity.ok().body(skill);
    }

    @PutMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<Skill> updateProgrammer(@PathVariable int id, @RequestBody Skill skill) {
        Skill updatedSkill = this.availabilityRepository.update(skill, id);

        if (updatedSkill == null) {
            throw new NotFoundException(String.format(notFound, id));
        }
        return ResponseEntity.ok().body(updatedSkill);
}
}
