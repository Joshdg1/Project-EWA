package com.flo4.server.rest;

import com.flo4.server.Exceptions.NotFoundException;
import com.flo4.server.models.GetUserAvailability;
import com.flo4.server.models.User;

import com.flo4.server.models.UserHours;
import com.flo4.server.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class HoursController {
    private static final String notFound = "Availability with id %d was not found!";
    @Autowired
    EntityRepository<UserHours> availabilityRepository;

    @Autowired
    EntityRepository<User> userEntityRepository;

    @GetMapping(path = "", produces = "application/json")
    public List<UserHours> getAllProgrammers() {
        return this.availabilityRepository.findAll();
    }

    @GetMapping(path = "{id}", produces = "application/json")
    public List<UserHours> findAvailabilityByUser(@PathVariable() int  id) {
        User ourUser = this.userEntityRepository.findById(id);
        List<UserHours> hoursList = new ArrayList<>(this.availabilityRepository.findAll());
        List<UserHours> updatedList = new ArrayList<>();
        for (UserHours userAvailability : hoursList){
            if (userAvailability.getUser().getId() == ourUser.getId()){
                updatedList.add(userAvailability);
            }
        }

        return updatedList;
    }

    @Transactional
    @PostMapping(path = "add", produces = "application/json")
    public ResponseEntity<UserHours> addAvailability(@RequestBody GetUserAvailability userAvailability) {
        UserHours userHours = new UserHours();
        userHours.setTitle(userAvailability.getTitle());
        userHours.setStart(userAvailability.getStartDate());
        userHours.setEnd(userAvailability.getEndDate());
        userHours.setUser(this.userEntityRepository.findById(userAvailability.getUserId()));
        UserHours newUserAvailability = this.availabilityRepository.save(userHours);


        return ResponseEntity.ok().body(newUserAvailability);
    }

    @DeleteMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<UserHours> deleteAvailability(@PathVariable int id) {
        UserHours userAvailability = this.availabilityRepository.findById(id);

        if (userAvailability == null) {
            throw new NotFoundException(String.format(notFound, id));
        }

        this.availabilityRepository.deleteById(id);

        return ResponseEntity.ok().body(userAvailability);
    }

    @PutMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<UserHours> updateAvailability(@PathVariable int id, @RequestBody GetUserAvailability userAvailability) {

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
