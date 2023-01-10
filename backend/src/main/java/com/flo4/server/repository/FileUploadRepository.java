package com.flo4.server.repository;


import com.flo4.server.models.FileUpload;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository("FILEUPLOAD.JPA")
@Transactional
public class FileUploadRepository implements EntityRepository<FileUpload> {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public List<FileUpload> findAll() {
        TypedQuery<FileUpload> query = this.entityManager.createQuery("select f from file_upload", FileUpload.class);
        return query.getResultList();
    }

    @Override
    public FileUpload findById(int id) {
        return this.entityManager.find(FileUpload.class, id);
    }

    @Override
    public FileUpload save(FileUpload entity) {
        return this.entityManager.merge(entity);
    }

    @Override
    public FileUpload update(FileUpload entity, int id) {
        FileUpload updatedFileUpload = findById(id);

        if (updatedFileUpload == null) {
            return null;
        }

        updatedFileUpload.setId(entity.getId());
        updatedFileUpload.setName(entity.getName());
        updatedFileUpload.setType(entity.getType());
        updatedFileUpload.setData(entity.getData());

        return updatedFileUpload;
    }

    @Override
    public FileUpload deleteById(int id) {
        FileUpload fileUpload = entityManager.find(FileUpload.class, id);
        entityManager.remove(fileUpload);
        return fileUpload;
    }

    @Override
    public List<FileUpload> findByQuery(String jpqlName, Object... params) {
        TypedQuery<FileUpload> query = this.entityManager.createNamedQuery(jpqlName, FileUpload.class);

        //Put all params into the query.
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }

        //Execute the query and return all the results.
        return query.getResultList();
    }
}
