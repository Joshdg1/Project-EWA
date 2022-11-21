package com.flo4.server.repository;


import com.flo4.server.models.Skill;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository("SKILL.JPA")
@Transactional
public class SkillRepository implements EntityRepository<Skill> {

    private List<Skill> skills;

    @PersistenceContext
    protected EntityManager entityManager;


    @Override
    public List<Skill> findAll() {
        TypedQuery<Skill> query = this.entityManager.createQuery("select s from Skill s", Skill.class);

        return query.getResultList();
    }

    @Override
    public Skill findById(int id) {
        return this.entityManager.find(Skill.class, id);
    }

    @Override
    public Skill save(Skill entity) {
        return this.entityManager.merge(entity);
    }

    @Override
    public Skill update(Skill entity, int id) {
        Skill updatedSKill = findById(id);

        if (updatedSKill == null) {
            return null;
        }

        updatedSKill.setProgrammerId(entity.getProgrammerId());
        updatedSKill.setName(entity.getName());
        updatedSKill.setLevel(entity.getLevel());


        return updatedSKill;
    }


    @Override
    public Skill deleteById(int id) {
        Skill skill = entityManager.find(Skill.class, id);
        entityManager.remove(skill);
        return skill;

    }

    @Override
    public List<Skill> findByQuery(String jpqlName, Object... params) {
        TypedQuery<Skill> query = this.entityManager.createNamedQuery(jpqlName, Skill.class);

        //Put all params into the query.
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }

        //Execute the query and return all the results.
        return query.getResultList();
    }
}
