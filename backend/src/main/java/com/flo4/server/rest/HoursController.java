package com.flo4.server.rest;

import com.flo4.server.Exceptions.NotFoundException;
import com.flo4.server.models.*;

import com.flo4.server.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("hours")
public class HoursController {
    private static final String notFound = "Availability with id %d was not found!";
    @Autowired
    EntityRepository<UserHours> userHoursEntityRepository;

    @Autowired
    EntityRepository<Project> projectEntityRepository;

    @Autowired
    EntityRepository<User> userEntityRepository;

    @GetMapping(path = "", produces = "application/json")
    public List<UserHours> getAllHours() {
        return this.userHoursEntityRepository.findAll();
    }

    @GetMapping(path = "{id}", produces = "application/json")
    public List<UserHours> findHoursByUser(@PathVariable() int  id) {
        User ourUser = this.userEntityRepository.findById(id);
        List<UserHours> hoursList = new ArrayList<>(this.userHoursEntityRepository.findAll());
        List<UserHours> updatedList = new ArrayList<>();
        for (UserHours userHours : hoursList){
            if (userHours.getUser().getId() == ourUser.getId()){
                updatedList.add(userHours);
            }
        }
        return updatedList;
    }
    @GetMapping(path = "project={project}", produces = "application/json")
    public List<UserHours> findUserHourByProject(@PathVariable() int project){
        return this.userHoursEntityRepository.findByQuery("Hours_find_by_Project", project);
    }
    @Transactional
    @PostMapping(path = "add", produces = "application/json")
    public ResponseEntity<UserHours> addAvailability(@RequestBody getUserHours userHours) {
        UserHours userHours1 = new UserHours();
        userHours1.setHours(userHours.getHours());
        userHours1.setProject(userHours.getProject());
        userHours1.setUser(this.userEntityRepository.findById(userHours.getUserID()));

        UserHours newUserAvailability = this.userHoursEntityRepository.save(userHours1);

        return ResponseEntity.ok().body(newUserAvailability);
    }
    @DeleteMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<UserHours> deleteAvailability(@PathVariable int id) {
        UserHours userAvailability = this.userHoursEntityRepository.findById(id);

        if (userAvailability == null) {
            throw new NotFoundException(String.format(notFound, id));
        }
        this.userHoursEntityRepository.deleteById(id);

        return ResponseEntity.ok().body(userAvailability);
    }

    @PutMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<UserHours> updateAvailability(@PathVariable int id, @RequestBody getUserHours userHours1) {

        UserHours userHours = new UserHours();
        userHours.setHours(userHours1.getHours());
        userHours.setProject(userHours1.getProject());
        userHours.setUser(this.userEntityRepository.findById(userHours1.getUserID()));
        userHours.setIsApproved(userHours1.getIsApproved());
        System.out.println(id);
        UserHours updatedUserAvailability = this.userHoursEntityRepository.update(userHours, id);

        if (updatedUserAvailability == null) {
            throw new NotFoundException(String.format(notFound, id));
        }
        return  ResponseEntity.ok().body(updatedUserAvailability);
    }
}
