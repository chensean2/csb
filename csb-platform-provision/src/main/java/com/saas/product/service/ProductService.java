/*
 *  =========================================================================
 * Program Name: package com.saas.product.service.ProductService
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
import com.saas.order.to.OrderTO;
import com.saas.product.to.ProductTO;

public interface ProductService {

    /**
     * this method is used to create Product
     * version: 1.3.0
     */
    public void createProduct(ProductTO product);

    /**
     * this method is used to update Product
     * version: 1.3.0
     */
    public void updateProduct(ProductTO product);

    /**
     * this method is used to delete Product
     * version: 1.3.0
     */
    public void deleteProduct(ProductTO product);

    /**
     * this method is used to search Product
     * version: 1.3.0
     */
    public ProductTO getProduct(ProductTO product);

    /**
     * this method is used to get Product List
     * version: 1.3.0
     */
    public List<ProductTO> getProductList(ProductTO product);

    /**
     * this method is used to search Product
     * version: 1.3.0
     */
    public List<ProductTO> searchProductList(ProductTO product);
    
    /**
     * this method is used to execute auto assign for API(Web Service) 
     * @param order
     * @param contactUser
     */
    public void executeAutoAssignForAPI(OrderTO order, UserTO contactUser);

}