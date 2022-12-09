package com.flo4.server.repository;

import old.Client;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository("CLIENT.JPA")
@Transactional
public class ClientRepository implements EntityRepository<Client> {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public List<Client> findAll() {
        TypedQuery<Client> query = this.entityManager.createQuery("select c from Client c", Client.class);

        return query.getResultList();
    }

    @Override
    public Client findById(int id) {
        return this.entityManager.find(Client.class, id);
    }

    @Override
    public Client save(Client entity) {
        return this.entityManager.merge(entity);
    }

    @Override
    public Client update(Client entity, int id) {
        Client updatedClient = findById(id);

        if (updatedClient == null) {
            return null;
        }

        updatedClient.setName(entity.getName());
        updatedClient.setEmail(entity.getEmail());
        updatedClient.setAddress(entity.getAddress());
        updatedClient.setCity(entity.getCity());
        updatedClient.setPostcode(entity.getPostcode());
        updatedClient.setProjectType(entity.getProjectType());

        return updatedClient;
    }


    @Override
    public Client deleteById(int id) {
        Client client = entityManager.find(Client.class, id);
        entityManager.remove(client);
        return client;

    }

    @Override
    public List<Client> findByQuery(String jpqlName, Object... params) {
        TypedQuery<Client> query = this.entityManager.createNamedQuery(jpqlName, Client.class);

        //Put all params into the query.
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }

        //Execute the query and return all the results.
        return query.getResultList();
    }
}

