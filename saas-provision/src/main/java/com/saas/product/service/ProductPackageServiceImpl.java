/*
 *  =========================================================================
 * Program Name: package com.saas.product.service.ProductPackageServiceImpl
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

import java.util.List;

import com.saas.common.ConcurrentUpdateException;
import com.saas.common.DaoRunTimeException;
import com.saas.common.exception.SCServiceException;
import com.saas.product.dao.ProductPackageDAO;
import com.saas.product.to.ProductPackageTO;

public class ProductPackageServiceImpl implements ProductPackageService {

    private ProductPackageDAO productPackageDAO;

    public void createProductPackage(ProductPackageTO productPackage) {
    	productPackageDAO.createProductPackage(productPackage);
    }

    public void updateProductPackage(ProductPackageTO productPackage) {
        try {
            int result = productPackageDAO.updateProductPackage(productPackage);

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

    public void deleteProductPackage(ProductPackageTO productPackage) {
        try {
            int result = productPackageDAO.deleteProductPackage(productPackage);
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

    public ProductPackageTO getProductPackage(ProductPackageTO productPackage) {
        return productPackageDAO.getProductPackage(productPackage);
    }

    public List<ProductPackageTO> getProductPackageList(ProductPackageTO productPackage) {
        return productPackageDAO.getProductPackageList(productPackage);
    }

    public List<ProductPackageTO> searchProductPackageList(ProductPackageTO productPackage) {
        return productPackageDAO.searchProductPackageList(productPackage);
    }

    public void setProductPackageDAO(ProductPackageDAO productPackageDAO) {
        this.productPackageDAO = productPackageDAO;
    }

    public ProductPackageDAO getProductPackageDAO() {
        return productPackageDAO;
    }
}