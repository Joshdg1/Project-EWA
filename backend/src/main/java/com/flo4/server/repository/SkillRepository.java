package com.flo4.server.repository;


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
        UserSkills updatedSKill = findById(id);

        if (updatedSKill == null) {
            return null;
        }

//        updatedSKill.setId(entity.getId());
        updatedSKill.setName(entity.getName());
        updatedSKill.setLevel(entity.getLevel());
        updatedSKill.setUser(entity.getUser());

        return updatedSKill;
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
}
