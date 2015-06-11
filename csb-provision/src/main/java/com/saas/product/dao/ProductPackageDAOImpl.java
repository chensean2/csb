/*
 *  =========================================================================
 * Program Name: package com.saas.product.dao.ProductPackageDAOImpl
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

import com.csb.common.IAppsConstants;
import com.csb.common.dao.SCBaseDAOImpl;
import com.csb.common.exception.SCServiceException;
import com.saas.product.to.ProductPackageTO;

public class ProductPackageDAOImpl extends SCBaseDAOImpl implements ProductPackageDAO {
    private Logger log = LoggerFactory.getLogger(ProductPackageDAOImpl.class);

    public int createProductPackage(ProductPackageTO productPackage) {
        int i = create(productPackage);
       
        return i;
    }

    public int deleteProductPackage(ProductPackageTO productPackage) {
        ProductPackageTO productPackageTO = this.getProductPackage(productPackage);
        
        if (null == productPackageTO) {
            throw new SCServiceException(IAppsConstants.MSG_RECORD_MODIFIED_ELSEWHERE);
        }
        
        int i = delete(productPackage);
       
        return i;
    }

    public int updateProductPackage(ProductPackageTO productPackage) {
        ProductPackageTO oldproductPackageTO = this.getProductPackage(productPackage);
        int i = update(productPackage);

        return i;
    }

    public ProductPackageTO getProductPackage(ProductPackageTO productPackage) {
        return (ProductPackageTO) queryForObject(productPackage);
    }

    public List<ProductPackageTO> getProductPackageList(ProductPackageTO productPackage) {
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("packageId", productPackage.getPackageId());
        return null;
//        return pfwClient.queryForList(ProductPackageTO.class, "/productPackage/getProductPackageList", paraMap);
    }

    public List<ProductPackageTO> searchProductPackageList(ProductPackageTO productPackage) {
        Map<String, Object> paraMap = new HashMap<String, Object>();

        paraMap.put("packageId", productPackage.getPackageId());
        return null;
//        return PaginationEnabler.queryForList(ProductPackageTO.class, pfwClient, "/productPackage/getProductPackageList", paraMap);
    }

}