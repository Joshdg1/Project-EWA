package com.flo4.server.repository;

import com.flo4.server.models.PasswordResetTokens;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository("PASSWORDRESET.JPA")
@Transactional
public class PasswordResetRepository implements EntityRepository<PasswordResetTokens>{

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public List<PasswordResetTokens> findAll() {
        TypedQuery<PasswordResetTokens> query = this.entityManager.createQuery("select t from password_reset_tokens a", PasswordResetTokens.class);

        return query.getResultList();
    }

    @Override
    public PasswordResetTokens findById(int id) {
        return this.entityManager.find(PasswordResetTokens.class, id);
    }

    @Override
    public PasswordResetTokens save(PasswordResetTokens entity) {
        return this.entityManager.merge(entity);
    }

    @Override
    public PasswordResetTokens update(PasswordResetTokens entity, int id) {
        PasswordResetTokens updatedPasswordResetTokens = findById(id);

        if (updatedPasswordResetTokens == null) {
            return null;
        }

        updatedPasswordResetTokens.setId(entity.getId());
        updatedPasswordResetTokens.setToken(entity.getToken());
        updatedPasswordResetTokens.setUser_id(entity.getUser_id());

        return updatedPasswordResetTokens;
    }

    @Override
    public PasswordResetTokens deleteById(int id) {
        PasswordResetTokens passwordResetTokens = entityManager.find(PasswordResetTokens.class, id);
        entityManager.remove(passwordResetTokens);
        return passwordResetTokens;
    }

    @Override
    public List<PasswordResetTokens> findByQuery(String jpqlName, Object... params) {
        TypedQuery<PasswordResetTokens> query = this.entityManager.createNamedQuery(jpqlName, PasswordResetTokens.class);

        //Put all params into the query.
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }

        //Execute the query and return all the results.
        return query.getResultList();
    }


}
