package com.flo4.server.rest;

import com.flo4.server.Exceptions.NotFoundException;
import com.flo4.server.models.GetUserSkills;
import com.flo4.server.models.User;
import com.flo4.server.models.UserAvailability;
import com.flo4.server.models.UserSkills;
import com.flo4.server.repository.EntityRepository;
import com.flo4.server.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("skills")
public class SkillController {
    private static final String notFound = "Skill with id %d was not found!";
    @Autowired
    EntityRepository<UserSkills> SkillRepository;
    @Autowired
    com.flo4.server.repository.SkillRepository SkillRepository2;
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
        User user = this.userEntityRepository.findById(UserSkills.getUser_id());

        UserSkills userSkill = new UserSkills(
               0,
                UserSkills.getName(),
                UserSkills.getLevel(),
                user
        );

        UserSkills newUserSkills = this.SkillRepository.save(userSkill);

        return ResponseEntity.ok().body(newUserSkills);
    }

    @Transactional
    @PutMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<UserSkills> updateSkill(@PathVariable int id, @RequestBody GetUserSkills UserSkills) {
        User user = this.userEntityRepository.findById(UserSkills.getUser_id());

        UserSkills userSkill = new UserSkills(
                id,
                UserSkills.getName(),
                UserSkills.getLevel(),
                user
        );

        UserSkills updatedUserSkills = this.SkillRepository.update(userSkill, id);

        if (updatedUserSkills == null) {
            throw new NotFoundException(String.format(notFound, id));
        }

        return ResponseEntity.ok().body(updatedUserSkills);
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



    @PutMapping(path = "userSkills/{id}", produces = "application/json")
    public List<UserSkills> updateProgrammerSkill(@PathVariable() int id, int skillId) {
        User ourUser = this.userEntityRepository.findById(id);
        List<UserSkills> skillList = new ArrayList<>(this.SkillRepository.findAll());
        List<UserSkills> updatedList = new ArrayList<>();
        for (UserSkills userSkills : skillList) {
            if (userSkills.getUser().getId() == ourUser.getId()) {
                updatedList.add(userSkills);
            }
        }
        for (UserSkills userSkills: updatedList){
            if (userSkills.getId() == skillId){
               UserSkills userSkillsUpdated = this.SkillRepository2.updateProgrammerSkill(userSkills.getId(), userSkills.getLevel());
              updatedList.set(updatedList.indexOf(userSkills), userSkillsUpdated);
            }
        }

        return updatedList;
    }
}
