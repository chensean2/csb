package com.csb.core.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.common.Mapper;

import com.csb.common.util.Reflections;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    protected Mapper<T> mapper;

    @Override
    public T get(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public Long save(T entity) {
        Date currentDate = new Date();
        Reflections.invokeSetter(entity, "createdDt", currentDate);
        Reflections.invokeSetter(entity, "createdBy", "system");
        Reflections.invokeSetter(entity, "lastUpdatedDt", currentDate);
        Reflections.invokeSetter(entity, "lastUpdatedBy", "system");
        Reflections.invokeSetter(entity, "version", 1);
        mapper.insert(entity);
        return (Long) Reflections.invokeGetter(entity, "id");

    }

    @Override
    public int update(T entity) {
        Long id = (Long) Reflections.invokeGetter(entity, "id");
        Integer version = (Integer) Reflections.invokeGetter(entity, "version");
        T currentEntity = get(id);
        if (currentEntity == null || version != (Integer) Reflections.invokeGetter(currentEntity, "version")) {
            throw new RuntimeException(String.format("concurrent update for entity: {0}, id: {1}", entity, id));
        }

        Date currentDate = new Date();
        Reflections.invokeSetter(entity, "lastUpdatedDt", currentDate);
        Reflections.invokeSetter(entity, "lastUpdatedBy", "system");
        Reflections.invokeSetter(entity, "version", version + 1);
        return mapper.updateByPrimaryKey(entity);
    }

    @Override
    public void delete(Long id) {
        mapper.deleteByPrimaryKey(id);

    }

    @Override
    public List<T> find(T entity) {
        return mapper.select(entity);
    }

    @Override
    public int count(T entity) {
        return mapper.selectCount(entity);
    }
}