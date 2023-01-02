package com.flo4.server.repository;

import com.flo4.server.models.PasswordResetTokenEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository("PASSWORDRESET.JPA")
@Transactional
public class PasswordResetRepository implements EntityRepository<PasswordResetTokenEntity>{

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public List<PasswordResetTokenEntity> findAll() {
        TypedQuery<PasswordResetTokenEntity> query = this.entityManager.createQuery("select t from password_reset_tokens a", PasswordResetTokenEntity.class);

        return query.getResultList();
    }

    @Override
    public PasswordResetTokenEntity findById(int id) {
        return this.entityManager.find(PasswordResetTokenEntity.class, id);
    }

    @Override
    public PasswordResetTokenEntity save(PasswordResetTokenEntity entity) {
        return this.entityManager.merge(entity);
    }

    @Override
    public PasswordResetTokenEntity update(PasswordResetTokenEntity entity, int id) {
        PasswordResetTokenEntity updatedPasswordResetTokenEntity = findById(id);

        if (updatedPasswordResetTokenEntity == null) {
            return null;
        }

        updatedPasswordResetTokenEntity.setId(entity.getId());
        updatedPasswordResetTokenEntity.setToken(entity.getToken());
        updatedPasswordResetTokenEntity.setUser(entity.getUser());

        return updatedPasswordResetTokenEntity;
    }

    @Override
    public PasswordResetTokenEntity deleteById(int id) {
        PasswordResetTokenEntity passwordResetTokenEntity = entityManager.find(PasswordResetTokenEntity.class, id);
        entityManager.remove(passwordResetTokenEntity);
        return passwordResetTokenEntity;
    }

    @Override
    public List<PasswordResetTokenEntity> findByQuery(String jpqlName, Object... params) {
        TypedQuery<PasswordResetTokenEntity> query = this.entityManager.createNamedQuery(jpqlName, PasswordResetTokenEntity.class);

        //Put all params into the query.
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }

        //Execute the query and return all the results.
        return query.getResultList();
    }


}
