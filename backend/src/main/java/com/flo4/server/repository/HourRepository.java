package com.flo4.server.repository;

import com.flo4.server.models.UserAvailability;
import com.flo4.server.models.UserHours;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository("HOUR.JPA")
@Transactional
public class HourRepository implements EntityRepository<UserHours>{

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public List<UserHours> findAll() {
        TypedQuery<UserHours> query = this.entityManager.createQuery("select h from UserHours h", UserHours.class);

        return query.getResultList();
    }

    @Override
    public UserHours findById(int id) {
        return this.entityManager.find(UserHours.class, id);
    }

    @Override
    public UserHours save(UserHours entity) {
        return this.entityManager.merge(entity);
    }

    @Override
    public UserHours update(UserHours entity, int id) {
        UserHours updatedUserAvailability = findById(id);

        if (updatedUserAvailability == null) {
            return null;
        }

        updatedUserAvailability.setHours(entity.getHours());
        updatedUserAvailability.setUser(entity.getUser());
        updatedUserAvailability.setIsApproved(entity.getIsApproved());
        updatedUserAvailability.setProject(entity.getProject());

        return updatedUserAvailability;
    }


    @Override
    public UserHours deleteById(int id) {
        UserHours userAvailability = entityManager.find(UserHours.class, id);
        entityManager.remove(userAvailability);
        return userAvailability;

    }

    @Override
    public List<UserHours> findByQuery(String jpqlName, Object... params) {
        TypedQuery<UserHours> query = this.entityManager.createNamedQuery(jpqlName, UserHours.class);

        //Put all params into the query.
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }

        //Execute the query and return all the results.
        return query.getResultList();
    }
}
