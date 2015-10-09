package com.csb.core.service;

import org.springframework.stereotype.Service;

import com.csb.core.mapper.AppProductMapper;
import com.csb.core.model.AppProduct;

@Service("appProductService")
public class AppProductServiceImpl extends BaseServiceImpl<AppProduct> implements AppProductService {
    
    public AppProductMapper getMapper() {
        return (AppProductMapper)mapper;
    }
}