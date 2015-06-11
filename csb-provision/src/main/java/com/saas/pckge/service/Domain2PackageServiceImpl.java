/*
 *  =========================================================================
 * Program Name: package com.saas.pckge.service.Domain2PackageServiceImpl
 *
 * Copyright 2009 saas Pte. Ltd. All Rights Reserved
 *
 * This software is confidential and proprietary to saas Pte. Ltd. You shall
 * use this software only in accordance with the terms of the license
 * agreement you entered into with saas.  No aspect or part or all of this
 * software may be reproduced, modified or disclosed without full and
 * direct written authorisation from saas.
 *
 * saas SUPPLIES THIS SOFTWARE ON AN "AS IS" BASIS. saas MAKES NO
 * REPRESENTATIONS OR WARRANTIES, EITHER EXPRESSLY OR IMPLIEDLY, ABOUT THE
 * SUITABILITY OR NON-INFRINGEMENT OF THE SOFTWARE. saas SHALL NOT BE LIABLE
 * FOR ANY LOSSES OR DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
 * MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 * Change Revision
 * ----------------------------------------------------------------------------
 * Version    Remarks                  Author        Editor          Date
 * v1.0     - Initial Release         samyang                   Mar 4, 2011
 * =====================================================================================
 */
package com.saas.pckge.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.csb.common.ConcurrentUpdateException;
import com.csb.common.DaoRunTimeException;
import com.csb.common.IAppsConstants;
import com.csb.common.SpringApplicationContextHolder;
import com.csb.common.exception.SCServiceException;
import com.saas.pckge.dao.Domain2PackageDAO;
import com.saas.pckge.to.Domain2PackageTO;
import com.saas.pckge.to.Domain2ProductTO;
import com.saas.pckge.to.PackageOrderTO;
import com.saas.pckge.to.PackageTO;
import com.saas.product.dao.ProductOrderDAO;
import com.saas.product.to.ProductOrderTO;
import com.saas.product.to.UserProductTO;
import com.saas.provision.service.AdaptorService;
import com.saas.provision.service.ProvisionService;
import com.saas.provision.to.IsvAdaptorTO;
import com.saas.provision.to.IsvServiceParaTO;
import com.saas.provision.util.IsvSvc;

public class Domain2PackageServiceImpl implements Domain2PackageService {

	private static Logger log = LoggerFactory.getLogger(Domain2PackageServiceImpl.class);
    private Domain2PackageDAO domain2PackageDAO;
    private Domain2ProductService domain2ProductService;
    private PackageService packageService;
    private ApplicationContext appContext;
    
    
    public ProvisionService getProvisionService() {
		return provisionService;
	}

	public void setProvisionService(ProvisionService provisionService) {
		this.provisionService = provisionService;
	}

	public ProductOrderDAO getProductOrderDAO() {
		return productOrderDAO;
	}

	public void setProductOrderDAO(ProductOrderDAO productOrderDAO) {
		this.productOrderDAO = productOrderDAO;
	}

	private ProvisionService provisionService;
    private ProductOrderDAO productOrderDAO;
    
    public void createDomain2Package(Domain2PackageTO domain2Package) {
    	if(domain2Package.isCombineIndicator() && StringUtils.isNotEmpty(domain2Package.getPreviousPackageName())){
    		domain2Package.setPackageName(domain2Package.getPreviousPackageName());
    	}
        domain2PackageDAO.createDomain2Package(domain2Package);
    }

    public void updateDomain2Package(Domain2PackageTO domain2Package) {
        try {
        	if(domain2Package.isCombineIndicator()&& StringUtils.isNotEmpty(domain2Package.getPreviousPackageName())){
        		domain2Package.setPackageName(domain2Package.getPreviousPackageName());
        	}
        	
            int result = domain2PackageDAO.updateDomain2Package(domain2Package);

            if (0 == result) {
                throw new ConcurrentUpdateException();
            }
        } catch (DaoRunTimeException e) {
            if (e.getWrappedException() instanceof ConcurrentUpdateException) {
               throw new ConcurrentUpdateException();
            } else {
               throw new SCServiceException(e);
            }
        }
    }

    public void deleteDomain2Package(Domain2PackageTO domain2Package) {
        try {
            int result = domain2PackageDAO.deleteDomain2Package(domain2Package);
            if (0 == result) {
                throw new ConcurrentUpdateException();
            }
        } catch (DaoRunTimeException e) {
            if (e.getWrappedException() instanceof ConcurrentUpdateException) {
                throw new ConcurrentUpdateException();
            } else {
                 throw new SCServiceException(e);
            }
        }
    }

    public Domain2PackageTO getDomain2Package(Domain2PackageTO domain2Package) {
    	Domain2PackageTO domain2PackageTO = domain2PackageDAO.getDomain2Package(domain2Package);
    	//construct domain2package
    	domain2PackageTO = constructDomain2Package(domain2PackageTO);
        return domain2PackageTO;
    }
    
    public Domain2PackageTO constructDomain2Package(Domain2PackageTO domain2PackageTO){
    	try{
    		if(domain2PackageTO == null){
    			return domain2PackageTO;
    		}
    		Domain2ProductTO domain2ProductTO = domain2ProductService.getMainDomainProduct(domain2PackageTO.getDomainPackageId());
    		ProductOrderTO productOrderTO = productOrderDAO.getProductOrder(domain2PackageTO.getOrderId(),domain2PackageTO.getPackageId(),domain2ProductTO.getServiceId());
    		
    		if(productOrderTO == null || productOrderTO.getProTxId() == null || productOrderTO.getProTxId().isEmpty()){
    			log.info("productOrderTO or productOrderTO.getProTxId() is empty.");
    			return domain2PackageTO;
    		}
    		
        	IsvAdaptorTO adaptorTO = provisionService.getSvcAdaptorTO(domain2ProductTO.getServiceId(),
        												IsvSvc.SERVICE_DEF_CATEGORY_SERVICE,
        													IsvSvc.SERVICE_DEF_OPERATION_UPDATEPACKAGENAME);
        	
        	if(adaptorTO == null || adaptorTO.getIsvAdaptorEndpoint() == null){
        		log.info("adaptorTO or adaptorTO.getIsvAdaptorEndpoint() is empty.");
    			return domain2PackageTO;
        	}
        	
            if (appContext == null) {
                appContext = SpringApplicationContextHolder.get();
            }
            AdaptorService adaptor = (AdaptorService) appContext.getBean(adaptorTO.getIsvAdaptorEndpoint());
            Map<String, String> paraMap = new HashMap<String, String>();
            paraMap.put(IAppsConstants.SERVICE_MAP_ISV_SERVICE_ID, productOrderTO.getProTxId());
            Map<String, Object> responseMap = adaptor.execute(paraMap, new HashMap<String, String>());
            
            String productName = (String)responseMap.get(IAppsConstants.SERVICE_MAP_PRODUCT_NAME);
            if(!(productName.isEmpty() || domain2PackageTO.isCombineIndicator())){
					domain2PackageTO.setPreviousPackageName(domain2PackageTO.getPackageName());
					domain2PackageTO.setPackageName(domain2PackageTO.getPackageName() + " - " + productName);
					domain2PackageTO.setCombineIndicator(true);
            }
            return domain2PackageTO;	
    	}catch(Exception ex){
    		log.error(ex.getMessage(),ex);
    		return domain2PackageTO;
    	}
    }
    
    public PackageOrderTO constructPackageOrder(PackageOrderTO packageOrderTO){
    	try{
    		if(packageOrderTO == null){
    			return packageOrderTO;
    		}
    		PackageTO packageTO = new PackageTO();
    		packageTO.setPackageId(packageOrderTO.getPackageId());
    		packageTO = packageService.getPackage(packageTO);
    			
    		ProductOrderTO productOrderTO = productOrderDAO.getProductOrder(packageOrderTO.getOrderId(),packageOrderTO.getPackageId(),packageTO.getMainServiceId());
    		if(productOrderTO == null || productOrderTO.getProTxId() == null){
    			log.info("productOrderTO or productOrderTO.getProTxId() is empty.");
    			return packageOrderTO;
    		}
    		
        	IsvAdaptorTO adaptorTO = provisionService.getSvcAdaptorTO(packageTO.getMainServiceId(),
        												IsvSvc.SERVICE_DEF_CATEGORY_SERVICE,
        													IsvSvc.SERVICE_DEF_OPERATION_UPDATEPACKAGENAME);
        	
        	if(adaptorTO == null || adaptorTO.getIsvAdaptorEndpoint() == null){
        		log.info("adaptorTO or adaptorTO.getIsvAdaptorEndpoint() is empty.");
    			return packageOrderTO;
        	}
        	
            if (appContext == null) {
                appContext = SpringApplicationContextHolder.get();
            }
            AdaptorService adaptor = (AdaptorService) appContext.getBean(adaptorTO.getIsvAdaptorEndpoint());
            Map<String, String> paraMap = new HashMap<String, String>();
            paraMap.put(IAppsConstants.SERVICE_MAP_ISV_SERVICE_ID, productOrderTO.getProTxId());
            Map<String, Object> responseMap = adaptor.execute(paraMap, new HashMap<String, String>());
            
            String productName = (String)responseMap.get(IAppsConstants.SERVICE_MAP_PRODUCT_NAME);
            if(!(productName.isEmpty() || packageOrderTO.isCombineIndicator())){
            	packageOrderTO.setPreviousPackageName(packageOrderTO.getPackageName());
            	packageOrderTO.setPackageName(packageOrderTO.getPackageName() + " - " + productName);
				packageOrderTO.setCombineIndicator(true);
            }
            return packageOrderTO;	
    	}catch(Exception ex){
    		log.error("",ex);
    		return packageOrderTO;
    	}
    }
    
    public UserProductTO constructUserProduct(UserProductTO userProductTO){
    	try{
    		if(userProductTO == null){
    			return userProductTO;
    		}
    		Domain2ProductTO domain2Product = new Domain2ProductTO();
    		domain2Product.setDomainProductId(userProductTO.getDomainProductId());
    		domain2Product = domain2ProductService.getDomain2Product(domain2Product);
    		Domain2PackageTO domain2Package =  new Domain2PackageTO();
    		domain2Package.setDomainPackageId(domain2Product.getDomainPackageId());
    		domain2Package = getDomain2Package(domain2Package); 
    		//old value
    		userProductTO.setPackageName(domain2Package.getPackageName());
    		
    		domain2Package = constructDomain2Package(domain2Package);
    		
            if(!(domain2Package.getPackageName().isEmpty() || userProductTO.isCombineIndicator())){
            	userProductTO.setPreviousPackageName(userProductTO.getPackageName());
            	//new value
            	userProductTO.setPackageName(domain2Package.getPackageName());
            	userProductTO.setCombineIndicator(true);
            }
            return userProductTO;	
    	}catch(Exception ex){
    		log.error("",ex);
    		return userProductTO;
    	}
    }
    

    public List<Domain2PackageTO> getDomain2PackageList(Domain2PackageTO domain2Package) {
    	List<Domain2PackageTO> domain2PackageList = domain2PackageDAO.getDomain2PackageList(domain2Package);
    	for(Domain2PackageTO domain2PackageTO : domain2PackageList){
    		//construct domain2package
        	domain2PackageTO = constructDomain2Package(domain2PackageTO);
    	}
        return domain2PackageList;
    }

    public List<Domain2PackageTO> searchDomain2PackageList(Domain2PackageTO domain2Package) {
    	List<Domain2PackageTO> domain2PackageList = domain2PackageDAO.searchDomain2PackageList(domain2Package);
    	
    	for(Domain2PackageTO domain2PackageTO : domain2PackageList){
    		//construct domain2package
        	domain2PackageTO = constructDomain2Package(domain2PackageTO);
    	}
    	
        return domain2PackageList;
    }
    
    public List<Domain2PackageTO> getActiveDomain2PackageList(String domainId, String domainPackageStatus){
    	List<Domain2PackageTO> domain2PackageList = domain2PackageDAO.getActiveDomain2PackageList(domainId, domainPackageStatus);
    	
    	for(Domain2PackageTO domain2PackageTO : domain2PackageList){
    		//construct domain2package
        	domain2PackageTO = constructDomain2Package(domain2PackageTO);
    	}
    	
        return domain2PackageList;
    }
    
    public List<Domain2PackageTO> getActiveDomain2PackageListAndPage(
    		String domainId, String domainPackageStatus) {
    	List<Domain2PackageTO> domain2PackageList = domain2PackageDAO.getActiveDomain2PackageListAndPage(domainId, domainPackageStatus);
    	for(Domain2PackageTO domain2PackageTO : domain2PackageList){
    		//construct domain2package
        	domain2PackageTO = constructDomain2Package(domain2PackageTO);
    	}
    	return domain2PackageList;
    }
    
    public List<Domain2PackageTO> getActiveDomainPackageListByDomainId(String domainId){
        List<Domain2PackageTO> domainPackageList = getActiveDomain2PackageList(domainId,IAppsConstants.PACKAGE_STATUS_ACTIVE);
        // get total license left
        if (domainPackageList != null) {
             for (Domain2PackageTO domain2packageItem : domainPackageList) {
                 // get main domain product list by domain package id
                 List<Domain2ProductTO> domain2productList = domain2ProductService.getDomain2ProductListByDomainPackageIdAndUserId(domain2packageItem.getDomainPackageId(), null, null);
                 PackageTO packageTO = new PackageTO();
                 packageTO.setPackageId(domain2packageItem.getPackageId());
                 packageTO = packageService.getPackage(packageTO);
                 if (null != domain2productList && !domain2productList.isEmpty()) {
                     
                       for (Domain2ProductTO domain2productItem : domain2productList) {
                           if (domain2productItem.getServiceId().equalsIgnoreCase(packageTO.getMainServiceId())) {
                               domain2packageItem.setTotalLicenseLeft(domain2productItem.getTotalLicenseLeft());
                               domain2packageItem.setLicenceQuota(packageTO.getLicenceQuota());
                               domain2packageItem.setLicencePlan(packageTO.getLicencePlan());
                               break;
                           }
                       }
                 }
             }
        }
        return domainPackageList;
    }
    
    public Domain2PackageTO getOldDomain2PackageByIsvService(String proTxId){
    	 List<Domain2PackageTO> domain2PackageList = domain2PackageDAO.getOldDomain2PackageByIsvService(proTxId);
    	 if(domain2PackageList!=null&&domain2PackageList.size()>0){
    		 Domain2PackageTO domain2PackageTO = domain2PackageList.get(0);
    		 //construct domain2package
    		 domain2PackageTO = constructDomain2Package(domain2PackageTO);
    		 return domain2PackageTO;
    	 }else{
    		 return null;
    	 }
    	 
    }
    
    public List<Domain2PackageTO> getActiveDomain2PackageList(String domainId, String orderId, String domainPackageStatus) {
        return domain2PackageDAO.getActiveDomain2PackageList(domainId, orderId, domainPackageStatus);
    }

    public void setDomain2PackageDAO(Domain2PackageDAO domain2PackageDAO) {
        this.domain2PackageDAO = domain2PackageDAO;
    }

    public Domain2PackageDAO getDomain2PackageDAO() {
        return domain2PackageDAO;
    }

    public Domain2ProductService getDomain2ProductService() {
        return domain2ProductService;
    }

    public void setDomain2ProductService(Domain2ProductService domain2ProductService) {
        this.domain2ProductService = domain2ProductService;
    }

    public PackageService getPackageService() {
        return packageService;
    }

    public void setPackageService(PackageService packageService) {
        this.packageService = packageService;
    }
    
    public Map<String, String> getServiceParameters(String domainProductId, String productId){
    	Domain2ProductTO domain2Product = new Domain2ProductTO();
    	domain2Product.setDomainProductId(domainProductId);
    	domain2Product = domain2ProductService.getDomain2Product(domain2Product);
    	
    	Domain2PackageTO domain2Package = new Domain2PackageTO();
    	domain2Package.setDomainPackageId(domain2Product.getDomainPackageId());
    	domain2Package = this.getDomain2Package(domain2Package);
    	
    	ProductOrderTO productOrder = new ProductOrderTO();
    	productOrder.setOrderId(domain2Package.getOrderId());
    	productOrder.setProductId(productId);
    	List<ProductOrderTO> productOrderList = productOrderDAO.getProductOrderList(productOrder);    
    	productOrder = null;
    	if(productOrderList != null && productOrderList.size() > 0){
    		productOrder = productOrderList.get(0);
    	}
    	if(productOrder != null){
    		String isvServiceId = productOrder.getProTxId();
    		if (StringUtils.isNotEmpty(isvServiceId)) {
    			List<IsvServiceParaTO>  isvServiceParaList = provisionService.getIsvServiceParaList(isvServiceId);
        		
        		if (null != isvServiceParaList && !isvServiceParaList.isEmpty()) {
					Map<String, String> parameterMap = new HashMap<String, String>();
        			
					for (IsvServiceParaTO isvServicePara : isvServiceParaList) {
						parameterMap.put(isvServicePara.getServiceParaName(), isvServicePara.getServiceParaNewValue());
					}
					return parameterMap;
				}
        	}
    	}
    	
        return null;
    }

}