package com.csb.core.mybatis;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.csb.core.entity.AppCategory;

@Repository
public interface AppCategoryRepositoryMybatis {
	
	String GET_BY_ID = "select * from tbl_csb_app_category where  id = #{id}";
	
	@Select(GET_BY_ID)
	AppCategory findById(String id);
	
	//@Update for Update entity
	
	//@Delete for Delete entity
	
	//@Insert for Insert entity
}
