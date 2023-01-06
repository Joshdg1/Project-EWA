package com.flo4.server.rest;

import com.flo4.server.Exceptions.NotFoundException;

import com.flo4.server.models.GetUserAvailability;
import com.flo4.server.models.User;
import com.flo4.server.models.UserAvailability;
import com.flo4.server.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("availability")
public class AvailabilityController {
    private static final String notFound = "Availability with id %d was not found!";
    @Autowired
    EntityRepository<UserAvailability> availabilityRepository;

    @Autowired
    EntityRepository<User> userEntityRepository;

    @GetMapping(path = "", produces = "application/json")
    public List<UserAvailability> getAllProgrammers() {
        return this.availabilityRepository.findAll();
    }

    @GetMapping(path = "{id}", produces = "application/json")
    public List<UserAvailability> findAvailabilityByUser(@PathVariable() int  id) {
        User ourUser = this.userEntityRepository.findById(id);
       List<UserAvailability> availabilityList = new ArrayList<>(this.availabilityRepository.findAll());
       List<UserAvailability> updatedList = new ArrayList<>();
       for (UserAvailability userAvailability : availabilityList){
           if (userAvailability.getUser().getId() == ourUser.getId()){
               updatedList.add(userAvailability);
           }
       }

        return updatedList;
    }

    @Transactional
    @PostMapping(path = "add", produces = "application/json")
    public ResponseEntity<UserAvailability> addAvailability(@RequestBody GetUserAvailability userAvailability) {
        UserAvailability userAvailability1 = new UserAvailability();
        userAvailability1.setTitle(userAvailability.getTitle());
        userAvailability1.setStartDate(userAvailability.getStartDate());
        userAvailability1.setEndDate(userAvailability.getEndDate());
        userAvailability1.setUser(this.userEntityRepository.findById(userAvailability.getUserId()));
        UserAvailability newUserAvailability = this.availabilityRepository.save(userAvailability1);


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
    public ResponseEntity<UserAvailability> updateAvailability(@PathVariable int id, @RequestBody GetUserAvailability userAvailability) {

        UserAvailability userAvailability1 = new UserAvailability();
        userAvailability1.setId(id);
        userAvailability1.setTitle(userAvailability.getTitle());
        userAvailability1.setStartDate(userAvailability.getStartDate());
        userAvailability1.setEndDate(userAvailability.getEndDate());
        userAvailability1.setUser(this.userEntityRepository.findById(userAvailability.getUserId()));

        UserAvailability updatedUserAvailability = this.availabilityRepository.update(userAvailability1, id);

        if (updatedUserAvailability == null) {
            throw new NotFoundException(String.format(notFound, id));
        }
        return ResponseEntity.ok().body(updatedUserAvailability);
    }
}
