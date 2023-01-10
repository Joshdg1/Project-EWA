package com.flo4.server.repository;


import com.flo4.server.models.PasswordResetTokens;
import com.flo4.server.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Repository("USER.JPA")
@Transactional
public class UserRepository implements EntityRepository<User> {

    @PersistenceContext
    protected EntityManager entityManager;

    /**
     *
     * @return a list of all users
     */
    @Override
    public List<User> findAll() {
        TypedQuery<User> query = this.entityManager.createQuery("select u from User u", User.class);

        return query.getResultList();
    }

    /**
     * @param id
     * @return a user with a certain id
     */
    @Override
    public User findById(int id) {
        return this.entityManager.find(User.class, id);
    }

    /**
     * Saves a user
     * @param entity
     */
    @Override
    public User save(User entity) {
        return this.entityManager.merge(entity);
    }

    /**
     * Updates the user with a certain id
     * @param entity
     * @param id
     * @return
     */
    @Override
    public User update(User entity, int id) {
        User updatedUser = findById(id);

        if (updatedUser == null) {
            return null;
        }

        updatedUser.setEmail(entity.getEmail());
        updatedUser.setFirstName(entity.getFirstName());
        updatedUser.setLastName(entity.getLastName());
        updatedUser.setPhoneNumber(entity.getPhoneNumber());
        updatedUser.setCompanyName(entity.getCompanyName());
        updatedUser.setUserType(entity.getUserType());
        return updatedUser;
    }

    /**
     * Delete a user with a certain id
     * @param id
     * @return
     */
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

    public List<User> findAllProgrammers() {
        TypedQuery<User> query = this.entityManager.createQuery("select u from User u WHERE user_type = 'programmer'", User.class);

        return query.getResultList();
    }

    public List<User> findAllClients() {
        TypedQuery<User> query = this.entityManager.createQuery("select u from User u where user_type = 'client'", User.class);

        return query.getResultList();
    }


    public User findUserByToken(String token) {
        User user = this.entityManager
                .createQuery("SELECT u FROM User u INNER JOIN password_reset_tokens p ON u.id = p.user_id WHERE p.token = ?1", User.class)
                .setParameter(1, token)
                .getSingleResult();

        if (user == null) {
            throw new NoResultException("No matching user");
        }

        return user;
    }

    public PasswordResetTokens findToken(String token) {
        return this.entityManager.createQuery("SELECT token FROM password_reset_tokens WHERE token = ?1", PasswordResetTokens.class)
                .setParameter(1, token)
                .getSingleResult();

    }

//    public List<User> findAllCompanies() {
//        TypedQuery<User> query = this.entityManager.createQuery("SELECT company_name from user WHERE company_name IS NOT NULL", User.class);
//
//        return query.getResultList();
//    }

//    public PasswordResetTokens deleteToken(String token) {
//        return this.entityManager.createQuery("UPDATE password_reset_tokens SET token = NULL, user_id = NULL where token = ?1", PasswordResetTokens.class)
//                .setParameter(1, token)
//                .getSingleResult();
//    }

//    public PasswordResetTokens deleteByToken(String token) {
//        PasswordResetTokens passwordResetTokens = this.findToken(token);
//        entityManager.remove(passwordResetTokens);
//        return passwordResetTokens;
//    }


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
