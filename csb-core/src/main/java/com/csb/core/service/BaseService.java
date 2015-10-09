package com.csb.core.service;

import java.util.List;

public interface BaseService<T> {

    T get(Long id);

    Long save(T entity);

    int update(T entity);

    void delete(Long id);

    List<T> find(T entity);
    
    T findByUniqueKey(T entity);

    int count(T entity);
    
    List<T> findAll();
    
    void batchInsert(List<T> entityList);
}
