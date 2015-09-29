package com.csb.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.common.Mapper;


public abstract class BaseServiceImpl<T> implements BaseService<T> {
    
    @Autowired
    protected Mapper<T> mapper;
    
    @Override
    public T get(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public Long save(T entity) {
        return new Long(mapper.insert(entity));
        
    }

    @Override
    public int update(T entity) {
       return mapper.updateByPrimaryKey(entity);
    }

    @Override
    public void delete(Long id) {
        mapper.deleteByPrimaryKey(id);

    }
    @Override
    public List<T> find(T entity){
        return mapper.select(entity);
    }
    @Override
    public int count(T entity){
        return mapper.selectCount(entity);
    }
}