package com.flo4.server.repository;

import java.util.List;

public interface EntityRepository<E> {
    List<E> findAll();

    E findById(int id);

    E save(E entity);

    E deleteById(int id);

    List<E> findByQuery(String jpqlName, Object... params);
}

