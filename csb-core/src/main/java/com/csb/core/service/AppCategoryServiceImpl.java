package com.csb.core.service;

import org.springframework.stereotype.Service;

import com.csb.core.mapper.AppCategoryMapper;
import com.csb.core.model.AppCategory;

@Service("appCategoryService")
public class AppCategoryServiceImpl extends BaseServiceImpl<AppCategory> implements AppCategoryService
{
    public AppCategoryMapper getMapper() {
        return (AppCategoryMapper)mapper;
    }
}