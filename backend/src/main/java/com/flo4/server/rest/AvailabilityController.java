package com.flo4.server.rest;

import com.flo4.server.Exceptions.NotFoundException;
import com.flo4.server.models.UserAvailability;
import com.flo4.server.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("availability")
@CrossOrigin(origins = "http://localhost:8080")
public class AvailabilityController {
    private static final String notFound = "Availability with id %d was not found!";
    @Autowired
    EntityRepository<UserAvailability> availabilityRepository;

    @GetMapping(path = "", produces = "application/json")
    public List<UserAvailability> getAllProgrammers() {
        return this.availabilityRepository.findAll();
    }

    @GetMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<UserAvailability> findOneAvailability(@PathVariable() int  id) {

        UserAvailability userAvailability = this.availabilityRepository.findById(id);
        if (userAvailability == null) {
            throw new NotFoundException(String.format(notFound, id));
        }

        return ResponseEntity.ok().body(userAvailability);
    }

    @Transactional
    @PostMapping(path = "add", produces = "application/json")
    public ResponseEntity<UserAvailability> addAvailability(@RequestBody UserAvailability userAvailability) {

        UserAvailability newUserAvailability = this.availabilityRepository.save(userAvailability);


        return ResponseEntity.ok().body(newUserAvailability);
    }

    @DeleteMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<UserAvailability> deleteAvailability(@PathVariable int id) {
        UserAvailability userAvailability = this.availabilityRepository.findById(id);

        if (userAvailability == null) {
            throw new NotFoundException(String.format(notFound, id));
        }

        this.availabilityRepository.deleteById(id);

        return ResponseEntity.ok().body(userAvailability);
    }

    @PutMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<UserAvailability> updateAvailability(@PathVariable int id, @RequestBody UserAvailability userAvailability) {
        UserAvailability updatedUserAvailability = this.availabilityRepository.update(userAvailability, id);

        if (updatedUserAvailability == null) {
            throw new NotFoundException(String.format(notFound, id));
        }
        return ResponseEntity.ok().body(updatedUserAvailability);
    }
}
