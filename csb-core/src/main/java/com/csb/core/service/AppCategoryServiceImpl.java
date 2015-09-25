package com.csb.core.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csb.core.entity.AppCategory;
import com.csb.core.mybatis.AppCategoryRepositoryMybatis;

@Service("appCategoryService")
public class AppCategoryServiceImpl implements AppCategoryService
{
	@Autowired
	private AppCategoryRepositoryMybatis appCategoryRepositoryMybatis;
	
	@Transactional
	@Override
	public AppCategory getAppCategory(String id)
	{
		AppCategory appCategory = new AppCategory();
		appCategory = appCategoryRepositoryMybatis.findById(id);
		return appCategory;
	}
}