package com.flo4.server.repository;


import com.flo4.server.models.UserAvailability;
import com.flo4.server.models.UserSkills;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository("SKILL.JPA")
@Transactional
public class SkillRepository implements EntityRepository<UserSkills> {

    private List<UserSkills> userSkills;

    @PersistenceContext
    protected EntityManager entityManager;


    @Override
    public List<UserSkills> findAll() {
        TypedQuery<UserSkills> query = this.entityManager.createQuery("select s from UserSkills s", UserSkills.class);

        return query.getResultList();
    }

    @Override
    public UserSkills findById(int id) {
        return this.entityManager.find(UserSkills.class, id);
    }

    @Override
    public UserSkills save(UserSkills entity) {
        return this.entityManager.merge(entity);
    }

    @Override
    public UserSkills update(UserSkills entity, int id) {
        UserSkills updatedSkill = findById(id);

        if (updatedSkill == null) {
            return null;
        }

//        updatedSKill.setId(entity.getId());
        updatedSkill.setName(entity.getName());
        updatedSkill.setLevel(entity.getLevel());
        updatedSkill.setUser(entity.getUser());

        return updatedSkill;
    }


    @Override
    public UserSkills deleteById(int id) {
        UserSkills UserSkills = entityManager.find(UserSkills.class, id);
        entityManager.remove(UserSkills);
        return UserSkills;

    }

    @Override
    public List<UserSkills> findByQuery(String jpqlName, Object... params) {
        TypedQuery<UserSkills> query = this.entityManager.createNamedQuery(jpqlName, UserSkills.class);

        //Put all params into the query.
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }

        //Execute the query and return all the results.
        return query.getResultList();
    }

    public UserSkills updateProgrammerSkill(int skillsId, double skillLevel) {
//        return this.entityManager.createQuery
//                ("UPDATE UserSkills s SET level = ?1 WHERE s.id = ?2",
//                        UserSkills.class).setParameter(1, skillLevel).setParameter(2, skillsId).getSingleResult();
        UserSkills updatedSkill = findById(skillsId);

        if (updatedSkill == null) {
            return null;
        }

        updatedSkill.setLevel(skillLevel);



        return updatedSkill;

    }
}
