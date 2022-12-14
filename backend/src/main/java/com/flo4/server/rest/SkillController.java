package com.flo4.server.rest;

import com.flo4.server.Exceptions.NotFoundException;
import com.flo4.server.models.GetUserSkills;
import com.flo4.server.models.User;
import com.flo4.server.models.UserAvailability;
import com.flo4.server.models.UserSkills;
import com.flo4.server.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("skills")
@CrossOrigin(origins = "http://localhost:8080")
public class SkillController {
    private static final String notFound = "Skill with id %d was not found!";
    @Autowired
    EntityRepository<UserSkills> SkillRepository;
    @Autowired
    EntityRepository<User> userEntityRepository;

    @GetMapping(path = "", produces = "application/json")
    public List<UserSkills> getAllProgrammers() {
        return this.SkillRepository.findAll();
    }

    @GetMapping(path = "{id}", produces = "application/json")
    public List<UserSkills> findSkillsByUser(@PathVariable() int id) {
        User ourUser = this.userEntityRepository.findById(id);
        List<UserSkills> skillList = new ArrayList<>(this.SkillRepository.findAll());
        List<UserSkills> updatedList = new ArrayList<>();
        for (UserSkills userSkills : skillList) {
            if (userSkills.getUser().getId() == ourUser.getId()) {
                updatedList.add(userSkills);
            }
        }

        return updatedList;
    }


    @Transactional
    @PostMapping(path = "add", produces = "application/json")
    public ResponseEntity<UserSkills> addSkill(@RequestBody GetUserSkills UserSkills) {

        UserSkills userSkills = new UserSkills();
        userSkills.setName(UserSkills.getSkillName());
        userSkills.setLevel(UserSkills.getSkillLevel());
        userSkills.setUser(this.userEntityRepository.findById(UserSkills.getUserId()));

        UserSkills newUserSkills = this.SkillRepository.save(userSkills);


        return ResponseEntity.ok().body(newUserSkills);
    }

    @DeleteMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<UserSkills> deleteSkill(@PathVariable int id) {
        UserSkills UserSkills = this.SkillRepository.findById(id);

        if (UserSkills == null) {
            throw new NotFoundException(String.format(notFound, id));
        }

        this.SkillRepository.deleteById(id);

        return ResponseEntity.ok().body(UserSkills);
    }

    @PutMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<UserSkills> updateSkill(@PathVariable int id, @RequestBody UserSkills UserSkills) {
        UserSkills updatedUserSkills = this.SkillRepository.update(UserSkills, id);

        if (updatedUserSkills == null) {
            throw new NotFoundException(String.format(notFound, id));
        }
        return ResponseEntity.ok().body(updatedUserSkills);
    }
}
