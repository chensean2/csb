/*
 *  =========================================================================
 * Program Name: package com.saas.product.dao.UserProductDAOImpl
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
package com.saas.product.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.saas.common.IAppsConstants;
import com.saas.common.dao.SCBaseDAOImpl;
import com.saas.common.exception.SCServiceException;
import com.saas.product.to.UserProductTO;

public class UserProductDAOImpl extends SCBaseDAOImpl implements UserProductDAO {
    private Logger log = LoggerFactory.getLogger(UserProductDAOImpl.class);
    
    private static final String SERVICE_ID = "serviceId";
    private static final String DOMAIN_PRODUCT_ID = "domainProductId";
    private static final String DOMAIN_ID = "domainId";

    public int createUserProduct(UserProductTO userProduct) {
        int i = create(userProduct);
       
        return i;
    }

    public int deleteUserProduct(UserProductTO userProduct) {
        UserProductTO userProductTO = this.getUserProduct(userProduct);
        
        if (null == userProductTO) {
            throw new SCServiceException(IAppsConstants.MSG_RECORD_MODIFIED_ELSEWHERE);
        }
        int i = delete(userProduct);
       
        return i;
    }

    public int updateUserProduct(UserProductTO userProduct) {
        UserProductTO oldUserProductTO = this.getUserProduct(userProduct);
        int i = update(userProduct);

        return i;
    }

    public UserProductTO getUserProduct(UserProductTO userProduct) {
        return (UserProductTO) queryForObject(userProduct);
    }
    
    public List<UserProductTO> getMatchingUserProducts(UserProductTO userProduct) {
//    	return pfwClient.getMatchingRecords(userProduct);
    	return null;
    }
    
    public List<UserProductTO> getUserProductList(UserProductTO userProduct) {
        Map<String, Object> paraMap = new HashMap<String, Object>();

        paraMap.put("userId", userProduct.getUserId());
        paraMap.put("proTxId", userProduct.getProTxId());
        paraMap.put("domainProductId", userProduct.getDomainProductId());
        paraMap.put("userProductId", userProduct.getUserProductId());
        paraMap.put("serviceId", userProduct.getServiceId());
        return null;
//        return pfwClient.queryForList(UserProductTO.class, "/userProduct/getUserProductList", paraMap);
    }
    
    public List<UserProductTO> getLatestUserProductList(UserProductTO userProduct) {
    	Map<String, Object> paraMap = new HashMap<String, Object>();

        paraMap.put("userId", userProduct.getUserId());
        paraMap.put("domainProductId", userProduct.getDomainProductId());
        return null;
//        return pfwClient.queryForList(UserProductTO.class, "/userProduct/getLatestUserProductList", paraMap);
    }
    
    public List<UserProductTO> searchUserProductList(UserProductTO userProduct) {
        Map<String, Object> paraMap = new HashMap<String, Object>();

        paraMap.put("userId", userProduct.getUserId());
        return null;
//        return PaginationEnabler.queryForList(UserProductTO.class, pfwClient, "/userProduct/getUserProductList", paraMap);
    }
    
    public List<UserProductTO> getUserProductListForCheckProductAssigned(String userId, String domainProductId){
        Map<String, Object> paraMap = new HashMap<String, Object>();

        paraMap.put("userId", userId);
        paraMap.put("domainProductId", domainProductId);
        return null;
//        return pfwClient.queryForList(UserProductTO.class, "/userProduct/getUserProductListForCheckProductAssigned", paraMap);
    }
    
    public List<UserProductTO> getUserProductLogList(UserProductTO userProduct) {
    	Map<String, Object> paraMap = new HashMap<String, Object>();
    	
    	paraMap.put("userId", userProduct.getUserId());
    	return null;
//    	return pfwClient.queryForList(UserProductTO.class, "/userProduct/getUserProductLogList", paraMap);
    }
    
    public List<UserProductTO> searchUserProductLogList(UserProductTO userProduct) {
        Map<String, Object> paraMap = new HashMap<String, Object>();
    	
    	paraMap.put("userId", userProduct.getUserId()); 
    	return null;
//    	return PaginationEnabler.queryForList(UserProductTO.class, pfwClient, "/userProduct/getUserProductLogList", paraMap);
    }
    
    public List<UserProductTO> getUserProductListByDomainProductId(String domainProductId){
        Map<String, Object> paraMap = new HashMap<String, Object>();

        paraMap.put("domainProductId", domainProductId);
        return null;
//        return pfwClient.queryForList(UserProductTO.class, "/userProduct/getUserProductListByDomainProductId", paraMap);
    }

    public List<UserProductTO> getUserProductListByUserIdAndServiceId(UserProductTO userProduct) {
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("userId", userProduct.getUserId());
        paraMap.put("serviceId", userProduct.getServiceId());
//        return pfwClient.queryForList(UserProductTO.class, "/userProduct/queryUserProductListByUserIdAndServiceId",
//                paraMap);
        return null;
    }

    public List<UserProductTO> getActiveUserProductByServiceId(UserProductTO userProduct) {
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("userId", userProduct.getUserId());
        paraMap.put("serviceId", userProduct.getServiceId());
//        return pfwClient.queryForList(UserProductTO.class, "/userProduct/getActiveUserProductByServiceId", paraMap);
        return null;
    }
	
    public int updateUserProductStatusByProTxId(String proTxId, String userProductStatus) {
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("proTxId", proTxId); 
        paraMap.put("userProductStatus", userProductStatus); 
        
//        List<UserProductTO> list = this.pfwClient.queryForList(UserProductTO.class,
//                "/userProduct/queryUserProductStatusByProTxId", paraMap);

//        int value = ((Integer)this.pfwClient.executeMapSQL("/userProduct/updateUserProductStatusByProTxId", paraMap)).intValue();
//        for (int i = 0; i < list.size(); i++) {
//            UserProductTO userProductTONewValue = this.getUserProduct(list.get(i));
//            XStream xstream = new XStream();
//            String userProductNewValue = xstream.toXML(userProductTONewValue);
//            String userProductOldValue = xstream.toXML(list.get(i));
//            try {
//                auditTrailService.createAuditTrail("UPDATE_USER_PRODUCT", userProductTONewValue.getUserProductId(),
//                        "TBL_SS_USER2PRODUCT", "UPDATE", userProductTONewValue.getLastUpdatedBy(),
//                        userProductOldValue, userProductNewValue);
//            } catch (Exception e) {
//                log.error("auditTrail for update user product failed", e);
//                log.error("UPDATE_USER2PRODUCT-New Value" + userProductNewValue);
//                log.error("UPDATE_USER2PRODUCT-Old Value" + userProductOldValue);
//            }
//        }

        return 0;
    }
    
    public List<UserProductTO> getAllAssignedUserProducts(UserProductTO userProduct){
    	Map<String, Object> paraMap = new HashMap<String, Object>();

        paraMap.put("userId", userProduct.getUserId());
        paraMap.put("domainId", userProduct.getDomainId());
        paraMap.put("proTxId", userProduct.getProTxId());
        paraMap.put("domainProductId", userProduct.getDomainProductId());
        paraMap.put("userProductId", userProduct.getUserProductId());
        paraMap.put("serviceId", userProduct.getServiceId());
        paraMap.put("userDeviceMapId", userProduct.getUserDeviceMapId());
        paraMap.put("ext1", userProduct.getExt1());
        paraMap.put("ext2", userProduct.getExt2());
        paraMap.put("ext3", userProduct.getExt3());
        paraMap.put("ext5", userProduct.getExt5());
        return null;
//    	return pfwClient.queryForList(UserProductTO.class, "/userProduct/getAllAssignedUserProducts", paraMap);
    }
    
    public List<UserProductTO> getAssignedSecurityUserProducts(UserProductTO userProduct){
        Map<String, Object> paraMap = new HashMap<String, Object>();

        paraMap.put("userId", userProduct.getUserId());
        paraMap.put("domainId", userProduct.getDomainId());
        return null;
//        return pfwClient.queryForList(UserProductTO.class, "/userProduct/getAssignedSecurityUserProducts", paraMap);
    }
    
    
    public List<UserProductTO> getUserProductByUserIdSubscriptionKey(UserProductTO userProduct){
        Map<String, Object> paraMap = new HashMap<String, Object>();

        paraMap.put("userId", userProduct.getUserId());
        paraMap.put("serviceId", userProduct.getServiceId());
        paraMap.put("serviceRefId", userProduct.getServiceRefId());
        return null;
//        return pfwClient.queryForList(UserProductTO.class, "/userProduct/getUserProductByUserIdSubscriptionKey", paraMap);
    }
    
    
    
    public List<UserProductTO> getAllActiveAssignedUserProducts(UserProductTO userProduct){
        Map<String, Object> paraMap = new HashMap<String, Object>();

        paraMap.put("userId", userProduct.getUserId());
        paraMap.put("domainId", userProduct.getDomainId());
        paraMap.put("proTxId", userProduct.getProTxId());
        paraMap.put("domainProductId", userProduct.getDomainProductId());
        paraMap.put("userProductId", userProduct.getUserProductId());
        paraMap.put("serviceId", userProduct.getServiceId());
        paraMap.put("userDeviceMapId", userProduct.getUserDeviceMapId());
        paraMap.put("ext1", userProduct.getExt1());
        paraMap.put("ext2", userProduct.getExt2());
        paraMap.put("ext3", userProduct.getExt3());
        return null;
//        return pfwClient.queryForList(UserProductTO.class, "/userProduct/getAllActiveAssignedUserProducts", paraMap);
    }
    
    
    public List<UserProductTO> getAssigendUserProducts(UserProductTO userProduct) {
        Map<String, Object> paraMap = new HashMap<String, Object>();

        paraMap.put("userId", userProduct.getUserId());
        paraMap.put("proTxId", userProduct.getProTxId());
        paraMap.put("domainProductId", userProduct.getDomainProductId());
        paraMap.put("userProductId", userProduct.getUserProductId());
        paraMap.put("serviceId", userProduct.getServiceId());
        paraMap.put("userDeviceMapId", userProduct.getUserDeviceMapId());
        paraMap.put("ext1", userProduct.getExt1());
        paraMap.put("ext2", userProduct.getExt2());
        paraMap.put("ext3", userProduct.getExt3());
        return null;
//        return PaginationEnabler.queryForList(UserProductTO.class, pfwClient, "/userProduct/getAllAssignedUserProducts", paraMap);
    }
    
    public List<UserProductTO> getUserProductsNotAssignFail(UserProductTO userProduct){
    	Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("userId", userProduct.getUserId());
        paraMap.put("serviceId", userProduct.getServiceId());
        return null;
//    	return pfwClient.queryForList(UserProductTO.class, "/userProduct/getUserProductsNotAssignFail", paraMap);
    }
    
    public List<UserProductTO> getToBeTerminateUserProducts(UserProductTO userProduct){
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("userId", userProduct.getUserId());
        paraMap.put("serviceId", userProduct.getServiceId());
        return null;
//        return pfwClient.queryForList(UserProductTO.class, "/userProduct/getToBeTerminateUserProducts", paraMap);
    }
    
    public List<UserProductTO> getUserProductListForAllCompanyUsers(UserProductTO userProduct){
        Map<String, Object> paraMap = new HashMap<String, Object>();

        paraMap.put("userId", userProduct.getUserId());
        paraMap.put("proTxId", userProduct.getProTxId());
        paraMap.put("domainProductId", userProduct.getDomainProductId());
        paraMap.put("userProductId", userProduct.getUserProductId());
        paraMap.put("serviceId", userProduct.getServiceId());
        return null;
//        return pfwClient.queryForList(UserProductTO.class, "/userProduct/getUserProductListForAllCompanyUsers", paraMap);
    }
    
    
}