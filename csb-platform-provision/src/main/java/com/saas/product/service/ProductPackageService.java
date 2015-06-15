/*
 *  =========================================================================
 * Program Name: package com.saas.product.service.ProductPackageService
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

import com.saas.product.to.ProductPackageTO;

public interface ProductPackageService {

    /**
     * this method is used to create ProductPackage
     * version: 1.3.0
     */
    public void createProductPackage(ProductPackageTO productPackage);

    /**
     * this method is used to update ProductPackage
     * version: 1.3.0
     */
    public void updateProductPackage(ProductPackageTO productPackage);

    /**
     * this method is used to delete ProductPackage
     * version: 1.3.0
     */
    public void deleteProductPackage(ProductPackageTO productPackage);

    /**
     * this method is used to search ProductPackage
     * version: 1.3.0
     */
    public ProductPackageTO getProductPackage(ProductPackageTO productPackage);

    /**
     * this method is used to get ProductPackage List
     * version: 1.3.0
     */
    public List<ProductPackageTO> getProductPackageList(ProductPackageTO productPackage);

    /**
     * this method is used to search ProductPackage
     * version: 1.3.0
     */
    public List<ProductPackageTO> searchProductPackageList(ProductPackageTO productPackage);

}