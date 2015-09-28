package com.csb.core.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csb.core.entity.AppCategory;
import com.csb.core.mapper.CsbAppCategoryMapper;

@Service("appCategoryService")
public class AppCategoryServiceImpl implements AppCategoryService
{
	@Autowired
	private CsbAppCategoryMapper csbAppCategoryMapper;
	
	@Transactional
	@Override
	public AppCategory selectById(long id)
	{
		 return csbAppCategoryMapper.selectByPrimaryKey(id);
	}
}