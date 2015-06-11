/*
 *  =========================================================================
 * Program Name: package com.saas.product.service.UserProductServiceImpl
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
 * v1.3.0     - Initial Release         jixiaowei                   Mar 2, 2011
 * =====================================================================================
 */
package com.saas.product.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.csb.common.ConcurrentUpdateException;
import com.csb.common.DaoRunTimeException;
import com.csb.common.IAppsConstants;
import com.csb.common.SpringApplicationContextHolder;
import com.csb.common.exception.SCServiceException;
import com.saas.common.to.UserTO;
import com.saas.pckge.service.Domain2PackageService;
import com.saas.pckge.service.Domain2ProductService;
import com.saas.pckge.to.Domain2PackageTO;
import com.saas.pckge.to.Domain2ProductTO;
import com.saas.product.dao.ProductOrderDAO;
import com.saas.product.dao.ServiceDAO;
import com.saas.product.dao.UserProductDAO;
import com.saas.product.to.ProductOrderTO;
import com.saas.product.to.ServiceTO;
import com.saas.product.to.UserProductTO;
import com.saas.provision.service.AdaptorService;
import com.saas.provision.service.ProvisionService;
import com.saas.provision.to.IsvAdaptorTO;
import com.saas.provision.util.IsvSvc;

public class UserProductServiceImpl implements UserProductService {

    private static Logger log = LoggerFactory.getLogger(UserProductServiceImpl.class);
    private UserProductDAO userProductDAO;
    private ServiceDAO serviceDAO;
    private Domain2ProductService domain2ProductService;
    private ProvisionService provisionService;
    private ProductOrderDAO productOrderDAO;
    private ApplicationContext appContext;
    private Domain2PackageService domain2PackageService;
    
    public ServiceDAO getServiceDAO() {
		return serviceDAO;
	}

	public void setServiceDAO(ServiceDAO serviceDAO) {
		this.serviceDAO = serviceDAO;
	}

	public void createUserProduct(UserProductTO userProduct) {
    	userProductDAO.createUserProduct(userProduct);
    }

	public void updateUserProduct(UserProductTO userProduct) {
        try {
            int result = userProductDAO.updateUserProduct(userProduct);

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

    /**
     * @return the domain2ProductService
     */
    public Domain2ProductService getDomain2ProductService() {
        return domain2ProductService;
    }

    /**
     * @param domain2ProductService the domain2ProductService to set
     */
    public void setDomain2ProductService(Domain2ProductService domain2ProductService) {
        this.domain2ProductService = domain2ProductService;
    }

    /**
     * @return the provisionService
     */
    public ProvisionService getProvisionService() {
        return provisionService;
    }

    /**
     * @param provisionService the provisionService to set
     */
    public void setProvisionService(ProvisionService provisionService) {
        this.provisionService = provisionService;
    }

    /**
     * @return the productOrderDAO
     */
    public ProductOrderDAO getProductOrderDAO() {
        return productOrderDAO;
    }

    /**
     * @param productOrderDAO the productOrderDAO to set
     */
    public void setProductOrderDAO(ProductOrderDAO productOrderDAO) {
        this.productOrderDAO = productOrderDAO;
    }

    /**
     * @return the domain2PackageService
     */
    public Domain2PackageService getDomain2PackageService() {
        return domain2PackageService;
    }

    /**
     * @param domain2PackageService the domain2PackageService to set
     */
    public void setDomain2PackageService(Domain2PackageService domain2PackageService) {
        this.domain2PackageService = domain2PackageService;
    }

    public void deleteUserProduct(UserProductTO userProduct) {
        try {
            int result = userProductDAO.deleteUserProduct(userProduct);
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

    public void updateUserProductStatus(String userProductId,String userProductStatus){
    	UserProductTO userProduct = new UserProductTO();
    	userProduct.setUserProductId(userProductId);
    	userProduct = userProductDAO.getUserProduct(userProduct);
    	if(userProductStatus.equals(IAppsConstants.USER_PRODUCT_STATUS_ACTIVE)){
    		userProduct.setProDescCodeId(IAppsConstants.PRO_DES_CODE_ID_SUCCESS);
    	}else{
    		userProduct.setProDescCodeId(IAppsConstants.PRO_DES_CODE_ID_FAIL);
    	}
    	userProduct.setUserProductStatus(userProductStatus);
    	updateUserProduct(userProduct);
    }
    
    public UserProductTO getUserProduct(UserProductTO userProduct) {
        return userProductDAO.getUserProduct(userProduct);
    }

    public List<UserProductTO> getUserProductList(UserProductTO userProduct) {
        return userProductDAO.getUserProductList(userProduct);
    }
    
    public List<UserProductTO> getLatestUserProductList(UserProductTO userProduct) {
    	return userProductDAO.getLatestUserProductList(userProduct);
    }
    
    public List<UserProductTO> searchUserProductList(UserProductTO userProduct) {
        return userProductDAO.searchUserProductList(userProduct);
    }

    public boolean checkProductAssigned(String userId, String domainProductId){
        UserProductTO userProduct = new UserProductTO();
        userProduct.setUserId(userId);
        userProduct.setDomainProductId(domainProductId);
        List<UserProductTO> result = userProductDAO.getUserProductList(userProduct);
        if(result != null && result.size() > 0){
            return true;
        }
        return false;
    }

    public List<UserProductTO> getUserProductLogList(UserProductTO userProduct) {
    	return userProductDAO.getUserProductLogList(userProduct);
    }
    
    public List<UserProductTO> searchUserProductLogList(UserProductTO userProduct) {
    	return userProductDAO.searchUserProductLogList(userProduct);
    }
    
    public List<UserProductTO> getUserProductListByDomainProductId(String domainProductId){
        return userProductDAO.getUserProductListByDomainProductId(domainProductId);
    }
    
    public List<UserProductTO> getUserProductListByUserIdAndServiceId(UserProductTO userProduct){
    	return userProductDAO.getUserProductListByUserIdAndServiceId(userProduct);
    }
    public List<UserProductTO> getActiveUserProductByServiceId(UserProductTO userProduct){
        return userProductDAO.getActiveUserProductByServiceId(userProduct);
    }
    
    public List<UserProductTO> getMatchingUserProducts(UserProductTO userProduct) {
    	return userProductDAO.getMatchingUserProducts(userProduct);
    }
    
    
    public boolean validateHasAssignedService(String serviceId,UserTO userTO){
    	boolean hasAssigned = false;
		
		UserProductTO userProduct = new UserProductTO();
        userProduct.setUserId(userTO.getUserId());
        userProduct.setServiceId(serviceId);
        List<UserProductTO> userProductList = userProductDAO.getUserProductList(userProduct);

        if (null != userProductList && userProductList.size()>0) {
        	hasAssigned = true;
        }
        
        return hasAssigned;
    }
    
    public List<UserProductTO> getUserProductsNotAssignFail(UserProductTO userProduct){
    	return userProductDAO.getUserProductsNotAssignFail(userProduct);
    }
    
    public List<UserProductTO> getToBeTerminateUserProducts(UserProductTO userProduct){
        return userProductDAO.getToBeTerminateUserProducts(userProduct);
    }
    
    public void setUserProductDAO(UserProductDAO userProductDAO) {
        this.userProductDAO = userProductDAO;
    }

    public UserProductDAO getUserProductDAO() {
        return userProductDAO;
    }

    public int updateUserProductStatusByProTxId(String proTxId, String userProductStatus) {
        return this.userProductDAO.updateUserProductStatusByProTxId(proTxId, userProductStatus);
    }
    
    public List<UserProductTO> getAllAssignedUserProducts(UserProductTO userProduct){
    	return this.userProductDAO.getAllAssignedUserProducts(userProduct);
    }
    
    public List<UserProductTO> getAssignedSecurityUserProducts(UserProductTO userProduct){
        return this.userProductDAO.getAssignedSecurityUserProducts(userProduct);
    }
    
    public List<UserProductTO> getAllActiveAssignedUserProducts(UserProductTO userProduct){
        return this.userProductDAO.getAllActiveAssignedUserProducts(userProduct);
    }
    
    
    public UserProductTO getUserProductByMappingId(UserProductTO userProduct){
    	 List<UserProductTO> userProductList = userProductDAO.getAllAssignedUserProducts(userProduct);
    	 if (null != userProductList && userProductList.size()>0) {
         	return userProductList.get(0);
         }
         
         return null;
    }
    
    public UserProductTO getMainUserProduct(UserProductTO userProduct){
    	List<UserProductTO> userProductList = userProductDAO.getAllAssignedUserProducts(userProduct);
    	if (null != userProductList && userProductList.size()>0) {
            return userProductList.get(0);
	    }
	    return null;
    	
    }
    
    public UserProductTO getUserProductByUserIdSubscriptionKey(UserProductTO userProduct){
        List<UserProductTO> userProductList = userProductDAO.getUserProductByUserIdSubscriptionKey(userProduct);
        if (null != userProductList && userProductList.size()>0) {
            return userProductList.get(0);
            }
            return null;
    } 
    
    
    public List<UserTO> getAllUsersHasAssignedService(UserProductTO userProduct){
        List<UserTO> userList = null;
        List<UserProductTO> userProductListRst = userProductDAO.getUserProductListForAllCompanyUsers(userProduct);
        if(userProductListRst != null && !userProductListRst.isEmpty()){
            userList = new ArrayList<UserTO>();
            UserTO userTO = null;
            for(UserProductTO userProductRst : userProductListRst){
                userTO  = new UserTO();
                userTO.setUserId(userProductRst.getUserId());
                //userTO = userDAO.getUser(userTO);
                //userList.add(userTO);
            }
        }
        return userList;
    }
    
    
    /**
     * This method is used to get the customer id(master MSN for ODA)
     * @param domain2PackageTO
     * @return
     */
    public String getCustomerId(String serviceId, String userId) {
        try {
            ServiceTO serviceTO = new ServiceTO();
            serviceTO.setServiceId(serviceId);
            serviceTO = serviceDAO.getService(serviceTO);

            if (serviceTO == null) {
                log.info("get serviceTO is empty by serviceId: " + serviceId);
                return null;
            }

            IsvAdaptorTO adaptorTO = provisionService.getSvcAdaptorTO(serviceId, IsvSvc.SERVICE_DEF_CATEGORY_USER, IsvSvc.SERVICE_DEF_OPERATION_GETCUSTOMERID);

            if (adaptorTO == null || adaptorTO.getIsvAdaptorEndpoint() == null) {
                log.info("get adaptorTO or adaptorTO.getIsvAdaptorEndpoint() is empty by serviceId: " + serviceId);
                return null;
            }

            UserProductTO userProduct = new UserProductTO();
            userProduct.setUserId(userId);
            userProduct.setServiceId(serviceId);
            List<UserProductTO> result = this.getActiveUserProductByServiceId(userProduct);
            if (result == null || result.isEmpty()) {
                log.info("The user does not have the product. serverId:" + serviceId);
                return null;
            }
            userProduct = result.get(0);
            Domain2ProductTO domain2Product = new Domain2ProductTO();
            domain2Product.setDomainProductId(userProduct.getDomainProductId());
            Domain2ProductTO domain2ProductTO = domain2ProductService.getDomain2Product(domain2Product);

            Domain2PackageTO domain2PackageTO = new Domain2PackageTO();
            domain2PackageTO.setDomainPackageId(domain2ProductTO.getDomainPackageId());
            domain2PackageTO = domain2PackageService.getDomain2Package(domain2PackageTO);

            ProductOrderTO productOrderTO = productOrderDAO.getProductOrder(domain2PackageTO.getOrderId(), domain2PackageTO.getPackageId(), domain2ProductTO.getServiceId());

            if (productOrderTO == null || productOrderTO.getProTxId() == null || productOrderTO.getProTxId().isEmpty()) {
                log.info("productOrderTO or productOrderTO.getProTxId() is empty.");
                return null;
            }

            if (appContext == null) {
                appContext = SpringApplicationContextHolder.get();
            }
            AdaptorService adaptor = (AdaptorService) appContext.getBean(adaptorTO.getIsvAdaptorEndpoint());
            Map<String, String> paraMap = new HashMap<String, String>();
            paraMap.put(IAppsConstants.SERVICE_MAP_ISV_SERVICE_ID, productOrderTO.getProTxId());
            Map<String, Object> responseMap = adaptor.execute(paraMap, new HashMap<String, String>());

            String customerId = (String) responseMap.get(IAppsConstants.SERVICE_MAP_CUSTOMER_ID);
            return customerId;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            return null;
        }
    }
}