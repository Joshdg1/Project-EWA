package com.flo4.server.repository;

import com.flo4.server.models.Programmer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository("PROGRAMMER.JPA")
@Transactional
public class ProgrammerRepository implements EntityRepository<Programmer> {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public List<Programmer> findAll() {
        TypedQuery<Programmer> query = this.entityManager.createQuery("select pr from Programmer pr", Programmer.class);

        return query.getResultList();
    }

    @Override
    public Programmer findById(int id) {
        return this.entityManager.find(Programmer.class, id);
    }

    @Override
    public Programmer save(Programmer entity) {
        return this.entityManager.merge(entity);
    }

    @Override
    public Programmer update(Programmer entity, int id) {
        Programmer updatedProgrammer = findById(id);

        if (updatedProgrammer == null) {
            return null;
        }

        updatedProgrammer.setFirstName(entity.getFirstName());
        updatedProgrammer.setLastName(entity.getLastName());
        updatedProgrammer.setEmail(entity.getEmail());
        updatedProgrammer.setAddress(entity.getAddress());
        updatedProgrammer.setCity(entity.getCity());
        updatedProgrammer.setPostcode(entity.getPostcode());
        updatedProgrammer.setWorkPreference(entity.getWorkPreference());
        updatedProgrammer.setProjectType(entity.getProjectType());

        return updatedProgrammer;
    }


    @Override
    public Programmer deleteById(int id) {
        Programmer programmer = entityManager.find(Programmer.class, id);
        entityManager.remove(programmer);
        return programmer;

    }

    @Override
    public List<Programmer> findByQuery(String jpqlName, Object... params) {
        TypedQuery<Programmer> query = this.entityManager.createNamedQuery(jpqlName, Programmer.class);

        //Put all params into the query.
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }

        //Execute the query and return all the results.
        return query.getResultList();
    }
}
