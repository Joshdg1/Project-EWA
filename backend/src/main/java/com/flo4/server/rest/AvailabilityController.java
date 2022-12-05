package com.flo4.server.rest;

import com.flo4.server.Exceptions.NotFoundException;
import com.flo4.server.models.Availability;
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
    EntityRepository<Availability> availabilityRepository;

    @GetMapping(path = "", produces = "application/json")
    public List<Availability> getAllProgrammers() {
        return this.availabilityRepository.findAll();
    }

    @GetMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<Availability> findOneAvailability(@PathVariable() int  id) {

        Availability availability = this.availabilityRepository.findById(id);
        if (availability == null) {
            throw new NotFoundException(String.format(notFound, id));
        }

        return ResponseEntity.ok().body(availability);
    }

    @Transactional
    @PostMapping(path = "add", produces = "application/json")
    public ResponseEntity<Availability> addAvailability(@RequestBody Availability availability) {

        Availability newAvailability = this.availabilityRepository.save(availability);


        return ResponseEntity.ok().body(newAvailability);
    }

    @DeleteMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<Availability> deleteAvailability(@PathVariable int id) {
        Availability availability = this.availabilityRepository.findById(id);

        if (availability == null) {
            throw new NotFoundException(String.format(notFound, id));
        }

        this.availabilityRepository.deleteById(id);

        return ResponseEntity.ok().body(availability);
    }

    @PutMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<Availability> updateAvailability(@PathVariable int id, @RequestBody Availability availability) {
        Availability updatedAvailability = this.availabilityRepository.update(availability, id);

        if (updatedAvailability == null) {
            throw new NotFoundException(String.format(notFound, id));
        }
        return ResponseEntity.ok().body(updatedAvailability);
    }
}
