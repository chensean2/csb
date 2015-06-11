/*
 *  =========================================================================
 * Program Name: package com.saas.pckge.service.Domain2ProductService
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
 * v1.0     - Initial Release         samyang                  Mar 4, 2011
 * =====================================================================================
 */
package com.saas.pckge.service;

import java.util.List;

import com.saas.pckge.to.Domain2PackageTO;
import com.saas.pckge.to.Domain2ProductTO;
import com.saas.pckge.to.PackageOrderTO;

public interface Domain2ProductService {

    /**
     * this method is used to create Domain2Product
     * version: 1.3.0
     */
    public void createDomain2Product(Domain2ProductTO domain2Product);

    /**
     * this method is used to update Domain2Product
     * version: 1.3.0
     */
    public void updateDomain2Product(Domain2ProductTO domain2Product);

    /**
     * this method is used to delete Domain2Product
     * version: 1.3.0
     */
    public void deleteDomain2Product(Domain2ProductTO domain2Product);

    /**
     * this method is used to search Domain2Product
     * version: 1.3.0
     */
    public Domain2ProductTO getDomain2Product(Domain2ProductTO domain2Product);

    /**
     * this method is used to get Domain2Product List
     * version: 1.3.0
     */
    public List<Domain2ProductTO> getDomain2ProductList(Domain2ProductTO domain2Product);

    /**
     * this method is used to search Domain2Product
     * version: 1.3.0
     */
    public List<Domain2ProductTO> searchDomain2ProductList(Domain2ProductTO domain2Product);
    
    /**
     * this method is used to get Domain2Product list by domain package id
     * version: 1.3.0
     */
    public List<Domain2ProductTO> getDomain2ProductListByDomainPackageIdAndUserId(String domainPackageId, String domainProductId, String userId);
    
    /**
     * this method is used to get domain product list by domain package id and service category
     * version: 1.3.0
     */
  //changed the serviceCategory with package level
//    public List<Domain2ProductTO> getDomainProductListByDomainPackageIdAndServiceCategory(String domainPackageId, String serviceCategory);
    public Domain2ProductTO getMainDomainProduct(String domainPackageId);
    
    public Integer getLicenseAssigned(String domainPackageId, String domainProductId, String userId);
    
    public Domain2ProductTO getMainDomainProductByDomainPackageId(Domain2PackageTO domain2Package);
    
    public void prepareExtMailByDomainPackage(List<Domain2PackageTO> domain2PackageList,StringBuffer packageNameBuffer,StringBuffer extMailBuffer);
    
    public void prepareExtMailByPackageOrder(List<PackageOrderTO> packageOrderList,StringBuffer packageNameBuffer,StringBuffer extMailBuffer);
    
    public boolean checkUnCompletedService(String domainId, String serviceId);
   
    public boolean checkOrderStatus(String domainId, String serviceId, String orderType, String orderStatus, String packageOrderStatus, String productOrderStatus);
    
    public boolean checkOrderStatusExcludeProTxId(String domainId, String serviceId, String orderType, String orderStatus, String packageOrderStatus, String productOrderStatus, String excluedProTxId);
    
    public List<Domain2ProductTO> getActiveDomain2ProductList(Domain2ProductTO domain2Product);
    
    public List<Domain2ProductTO> getActiveDomain2ProductsByDomainId(Domain2ProductTO domain2Product);
    public boolean checkActiveService(String domainId, String serviceId);
}