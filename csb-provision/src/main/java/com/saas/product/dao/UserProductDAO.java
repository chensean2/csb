/*
 *  =========================================================================
 * Program Name: package com.saas.product.dao.UserProductDAO
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
package com.saas.product.dao;

import java.util.List;

import com.saas.product.to.UserProductTO;

public interface UserProductDAO {

    public int createUserProduct(UserProductTO userProduct);

    public int updateUserProduct(UserProductTO userProduct);

    public int deleteUserProduct(UserProductTO userProduct);

    public UserProductTO getUserProduct(UserProductTO userProduct);

    public List<UserProductTO> getUserProductList(UserProductTO userProduct);
    
    public List<UserProductTO> getLatestUserProductList(UserProductTO userProduct);
    
    public List<UserProductTO> searchUserProductList(UserProductTO userProduct);
    
    public List<UserProductTO> getUserProductListForCheckProductAssigned(String userId, String domainProductId);

    public List<UserProductTO> getUserProductLogList(UserProductTO userProduct);
    
    public List<UserProductTO> searchUserProductLogList(UserProductTO userProduct);
    
    public List<UserProductTO> getUserProductListByDomainProductId(String domainProductId);

    public List<UserProductTO> getUserProductListByUserIdAndServiceId(UserProductTO userProduct);
    public List<UserProductTO> getActiveUserProductByServiceId(UserProductTO userProduct);
    
    public int updateUserProductStatusByProTxId(String proTxId,String userProductStatus);
    
    public List<UserProductTO> getMatchingUserProducts(UserProductTO userProduct);
    
    public List<UserProductTO> getAllAssignedUserProducts(UserProductTO userProduct);
    
    public List<UserProductTO> getUserProductByUserIdSubscriptionKey(UserProductTO userProduct);
    
    public List<UserProductTO> getAllActiveAssignedUserProducts(UserProductTO userProduct);
    
    public List<UserProductTO> getAssigendUserProducts(UserProductTO userProduct);
    
    public List<UserProductTO> getAssignedSecurityUserProducts(UserProductTO userProduct);
    
    public List<UserProductTO> getUserProductsNotAssignFail(UserProductTO userProduct);
    
    public List<UserProductTO> getToBeTerminateUserProducts(UserProductTO userProduct);
    
    public List<UserProductTO> getUserProductListForAllCompanyUsers(UserProductTO userProduct);
    
    
}