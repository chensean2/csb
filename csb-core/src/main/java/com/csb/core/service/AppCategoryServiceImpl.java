package com.csb.core.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csb.core.mapper.CsbAppCategoryMapper;
import com.csb.core.model.CsbAppCategory;

@Service("appCategoryService")
public class AppCategoryServiceImpl implements AppCategoryService
{
	@Autowired
	private CsbAppCategoryMapper csbAppCategoryMapper;
	
	@Transactional
	@Override
	public CsbAppCategory selectById(long id)
	{
		 return csbAppCategoryMapper.selectByPrimaryKey(id);
	}
}