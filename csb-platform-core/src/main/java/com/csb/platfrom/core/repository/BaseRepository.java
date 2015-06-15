package com.csb.platfrom.core.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.csb.platform.core.entity.AbstractEntity;

@NoRepositoryBean
public interface BaseRepository<M extends AbstractEntity<Long>, ID extends Serializable> extends PagingAndSortingRepository<M, ID>,
		JpaSpecificationExecutor<ID> {

}
