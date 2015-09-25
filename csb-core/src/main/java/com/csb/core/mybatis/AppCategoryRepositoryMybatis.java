package com.csb.core.mybatis;

import org.springframework.stereotype.Repository;

import com.csb.core.entity.AppCategory;

//@Repository
public interface AppCategoryRepositoryMybatis {
	
	AppCategory findById(String id);
}
