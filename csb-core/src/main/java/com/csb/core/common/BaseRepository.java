package com.csb.core.common;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<M extends AbstractEntity<Long>, ID extends Serializable> extends JpaRepository<M, ID>, JpaSpecificationExecutor<ID> {

}
