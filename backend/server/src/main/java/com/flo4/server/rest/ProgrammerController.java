package com.flo4.server.rest;

import com.flo4.server.Exceptions.NotFoundException;
import com.flo4.server.models.Programmer;
import com.flo4.server.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("programmers")
public class ProgrammerController {
    private static final String notFound = "Project with id %d was not found!";
    @Autowired
    EntityRepository<Programmer> programmerRepository;

    @GetMapping(path = "", produces = "application/json")
    public List<Programmer> getAllProgrammers() {
        return this.programmerRepository.findAll();
    }

    @GetMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<Programmer> findOneProgrammer(@PathVariable() int id) {
        Programmer programmer = this.programmerRepository.findById(id);
        if (programmer == null) {
            throw new NotFoundException(String.format(notFound, id));
        }

        return ResponseEntity.ok().body(programmer);
    }

    @Transactional
    @PostMapping(path = "add", produces = "application/json")
    public ResponseEntity<Programmer> addProgrammer(@RequestBody Programmer programmer) {

        Programmer newProgrammer = this.programmerRepository.save(programmer);


        return ResponseEntity.ok().body(newProgrammer);
    }

    @DeleteMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<Programmer> deleteProgrammer(@PathVariable int id) {
        Programmer programmer = this.programmerRepository.findById(id);

        if (programmer == null) {
            throw new NotFoundException(String.format(notFound, id));
        }

        this.programmerRepository.deleteById(id);

        return ResponseEntity.ok().body(programmer);
    }

    @PutMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<Programmer> updateProgrammer(@PathVariable int id, @RequestBody Programmer programmer) {
        Programmer updateProgrammer = this.programmerRepository.update(programmer, id);

        if (updateProgrammer == null) {
            throw new NotFoundException(String.format(notFound, id));
        }
        return ResponseEntity.ok().body(updateProgrammer);
    }
}
