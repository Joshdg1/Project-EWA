package com.flo4.server.repository;

import com.flo4.server.models.UserAvailability;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository("AVAILABILITY.JPA")
@Transactional
public class AvailabilityRepository implements EntityRepository<UserAvailability> {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public List<UserAvailability> findAll() {
        TypedQuery<UserAvailability> query = this.entityManager.createQuery("select a from UserAvailability a", UserAvailability.class);

        return query.getResultList();
    }

    @Override
    public UserAvailability findById(int id) {
        return this.entityManager.find(UserAvailability.class, id);
    }

    @Override
    public UserAvailability save(UserAvailability entity) {
        return this.entityManager.merge(entity);
    }

    @Override
    public UserAvailability update(UserAvailability entity, int id) {
        UserAvailability updatedUserAvailability = findById(id);

        if (updatedUserAvailability == null) {
            return null;
        }

        updatedUserAvailability.setId(entity.getId());
        updatedUserAvailability.setStartDate(entity.getStartDate());
        updatedUserAvailability.setEndDate(entity.getEndDate());


        return updatedUserAvailability;
    }


    @Override
    public UserAvailability deleteById(int id) {
        UserAvailability userAvailability = entityManager.find(UserAvailability.class, id);
        entityManager.remove(userAvailability);
        return userAvailability;

    }

    @Override
    public List<UserAvailability> findByQuery(String jpqlName, Object... params) {
        TypedQuery<UserAvailability> query = this.entityManager.createNamedQuery(jpqlName, UserAvailability.class);

        //Put all params into the query.
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }

        //Execute the query and return all the results.
        return query.getResultList();
    }
}
