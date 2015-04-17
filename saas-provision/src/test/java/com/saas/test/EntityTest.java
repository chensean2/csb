package com.saas.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.saas.entity.AppPackage;
import com.saas.entity.AppProduct;
import com.saas.repository.AppGroupRepository;
import com.saas.repository.AppPackageRepository;
import com.saas.repository.AppProductRepository;

public class EntityTest extends BaseIT {

	@Autowired
	public AppGroupRepository appGroupRepositoy;
	
	@Autowired
	public AppPackageRepository appPackageRepositoy;
	@Autowired
	public AppProductRepository appProductRepository;
	/*@Test
    public void testAppGroup() {
		List<AppGroup> appGroupList = Lists.newArrayList(appGroupRepositoy.findAll());
		System.out.println(appGroupList.size());
	}*/
	
	@Test
    public void testAppPackage() {
		List<AppPackage> appPackageList = Lists.newArrayList(appPackageRepositoy.findAll());
		for(AppPackage appPackage : appPackageList){
			if(appPackage.getAppProductList().size() > 0){
				System.out.println(appPackage.getPackageName() + "" + appPackage.getAppProductList().size());
			}
		}
	}
	
	@Test
    public void testAppProduct() {
		List<AppProduct> appProductList = Lists.newArrayList(appProductRepository.findAll());
		for(AppProduct appProduct : appProductList){
//			if(appProduct.getAppPackageList().size() > 0){
//				System.out.println(appProduct.getProductName() + "" + appProduct.getAppPackageList().size());
//			}
			if(appProduct.getAppService() != null){
				System.out.println(appProduct.getAppService().getServiceName());
			}
			
		}
	}
}
