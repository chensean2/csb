/*
 *  =========================================================================
 * Program Name: package com.saas.product.service.UserProductService
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
 * v1.3.0     - Initial Release         jixiaowei                  Mar 2, 2011
 * =====================================================================================
 */
package com.saas.product.service;

import java.util.List;

import com.saas.common.to.UserTO;
import com.saas.product.to.UserProductTO;

public interface UserProductService {

    /**
     * this method is used to create UserProduct
     * version: 1.3.0
     */
    public void createUserProduct(UserProductTO userProduct);

    /**
     * this method is used to update UserProduct
     * version: 1.3.0
     */
    public void updateUserProduct(UserProductTO userProduct);

    /**
     * this method is used to delete UserProduct
     * version: 1.3.0
     */
    public void deleteUserProduct(UserProductTO userProduct);

    /**
     * this method is used to search UserProduct
     * version: 1.3.0
     */
    public UserProductTO getUserProduct(UserProductTO userProduct);

    /**
     * this method is used to get UserProduct List
     * version: 1.3.0
     */
    public List<UserProductTO> getUserProductList(UserProductTO userProduct);
    
    /**
     * this method is used to get UserProduct List
     * version: 1.3.0
     */
    public List<UserProductTO> getLatestUserProductList(UserProductTO userProduct);

    /**
     * this method is used to search UserProduct
     * version: 1.3.0
     */
    public List<UserProductTO> searchUserProductList(UserProductTO userProduct);

    /**
     * this method is used to check Product is Assigned for the user
     * version: 1.3.0
     */
    public boolean checkProductAssigned(String userId, String domainProductId);

    /**
     * this method is used to get UserProductLog List
     * version: 1.3.0
     * @param userProduct
     * @return
     */
    public List<UserProductTO> getUserProductLogList(UserProductTO userProduct);
    
    /**
     * this method is used to search UserProductLogList by pagination
     * version: 1.3.0
     * @param userProduct
     * @return
     */
    public List<UserProductTO> searchUserProductLogList(UserProductTO userProduct);
    
    /**
     * this method is used to get UserProduct List by domainproductid
     * version: 1.3.0
     * @param domainProductId
     * @return
     */
    public List<UserProductTO> getUserProductListByDomainProductId(String domainProductId);
    
    /**
     * this method is used to get UserProduct List by userProduct
     * version: 1.3.0
     * @param userProduct
     * @return
     */
    public List<UserProductTO> getUserProductListByUserIdAndServiceId(UserProductTO userProduct);
    public List<UserProductTO> getActiveUserProductByServiceId(UserProductTO userProduct);
    
    /**
     * this method is used to get updateUserProductStatus
     * version: 1.3.0
     * @param userProductId,userProductStatus
     * @return
     */
    public void updateUserProductStatus(String userProductId,String userProductStatus);
    
    public int updateUserProductStatusByProTxId(String proTxId,String userProductStatus);
    
    public List<UserProductTO> getAllAssignedUserProducts(UserProductTO userProduct);
    
    public List<UserProductTO> getAssignedSecurityUserProducts(UserProductTO userProduct);
    
    public List<UserProductTO> getToBeTerminateUserProducts(UserProductTO userProduct);
    
    public List<UserProductTO> getAllActiveAssignedUserProducts(UserProductTO userProduct);
    
    public UserProductTO getMainUserProduct(UserProductTO userProduct);
    
    public UserProductTO getUserProductByUserIdSubscriptionKey(UserProductTO userProduct);
    
    /**
     * this method is used to get matching user product records
     * version: 1.3.0
     * @param userProductId,userProductStatus
     * @return
     */
    public List<UserProductTO> getMatchingUserProducts(UserProductTO userProduct);
    
    public boolean validateHasAssignedService(String serviceId,UserTO userTO);
    
    
    public List<UserProductTO> getUserProductsNotAssignFail(UserProductTO userProduct);
    
    
    
    public List<UserTO> getAllUsersHasAssignedService(UserProductTO userProduct);
    
    
    public UserProductTO getUserProductByMappingId(UserProductTO userProduct);
    
    public String getCustomerId(String serviceId, String userId);
}