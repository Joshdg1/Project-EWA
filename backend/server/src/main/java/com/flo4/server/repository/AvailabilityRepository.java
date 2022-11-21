package com.flo4.server.repository;

import com.flo4.server.models.Availability;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository("AVAILABILITY.JPA")
@Transactional
public class AvailabilityRepository implements EntityRepository<Availability> {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public List<Availability> findAll() {
        TypedQuery<Availability> query = this.entityManager.createQuery("select p from Programmer p", Availability.class);

        return query.getResultList();
    }

    @Override
    public Availability findById(int id) {
        return this.entityManager.find(Availability.class, id);
    }

    @Override
    public Availability save(Availability entity) {
        return this.entityManager.merge(entity);
    }

    @Override
    public Availability update(Availability entity, int id) {
        Availability updatedProgrammer = findById(id);

        if (updatedProgrammer == null) {
            return null;
        }

        updatedProgrammer.setId(entity.getId());
        updatedProgrammer.setStartDate(entity.getStartDate());
        updatedProgrammer.setEndDate(entity.getEndDate());


        return updatedProgrammer;
    }


    @Override
    public Availability deleteById(int id) {
        Availability availability = entityManager.find(Availability.class, id);
        entityManager.remove(availability);
        return availability;

    }

    @Override
    public List<Availability> findByQuery(String jpqlName, Object... params) {
        TypedQuery<Availability> query = this.entityManager.createNamedQuery(jpqlName, Availability.class);

        //Put all params into the query.
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }

        //Execute the query and return all the results.
        return query.getResultList();
    }
}
