package com.flo4.server.repository;


import com.flo4.server.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;


@Repository("USER.JPA")
@Transactional
public class UserRepository implements EntityRepository<User> {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = this.entityManager.createQuery("select u from User u", User.class);

        return query.getResultList();
    }

    @Override
    public User findById(int id) {
        return this.entityManager.find(User.class, id);
    }

    @Override
    public User save(User entity) {
        return this.entityManager.merge(entity);
    }

    @Override
    public User update(User entity, int id) {
        User updatedUser = findById(id);

        if (updatedUser == null) {
            return null;
        }

        updatedUser.setEmail(entity.getEmail());
        updatedUser.setFirstName(entity.getFirstName());
        updatedUser.setLastName(entity.getLastName());
        updatedUser.setPassword(entity.getPassword());
        updatedUser.setPhoneNumber(entity.getPhoneNumber());


        return updatedUser;
    }

    @Override
    public User deleteById(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        return user;

    }

    @Override
    public List<User> findByQuery(String jpqlName, Object... params) {
        TypedQuery<User> query = this.entityManager.createNamedQuery(jpqlName, User.class);

        //Put all params into the query.
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }

        //Execute the query and return all the results.
        return query.getResultList();
    }

    //of de user returned
    //of returned null
    public User findByEmail(String email) {
        return this.entityManager.createQuery("select u from User u where email = ?1", User.class).setParameter(1, email).getSingleResult();
    }



//public User findByIdAndTokenAndExpired(int id, String refresh_token, LocalDateTime expired_at){
//    User user = this.entityManager
//            .createQuery("select u from User u inner join Token t on u.id = t.user where u.id = :id and t.refresh_token = :refresh_token and t.expired_at >= :expired_at", User.class)
//            .setParameter("id", id)
//            .setParameter("refresh_token", refresh_token)
//            .setParameter("expired_at", expired_at)
//            .getSingleResult();
//
//    if (user == null) {
//        throw new NoResultException("No matching user found");
//    }
//
//    return user;
//}

}
