/*
 *  =========================================================================
 * Program Name: package com.saas.pckge.service.Domain2PackageService
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
import java.util.Map;

import com.saas.pckge.to.Domain2PackageTO;
import com.saas.pckge.to.PackageOrderTO;
import com.saas.product.to.UserProductTO;

public interface Domain2PackageService {

    /**
     * this method is used to create Domain2Package
     * version: 1.3.0
     */
    public void createDomain2Package(Domain2PackageTO domain2Package);

    /**
     * this method is used to update Domain2Package
     * version: 1.3.0
     */
    public void updateDomain2Package(Domain2PackageTO domain2Package);

    /**
     * this method is used to delete Domain2Package
     * version: 1.3.0
     */
    public void deleteDomain2Package(Domain2PackageTO domain2Package);

    /**
     * this method is used to search Domain2Package
     * version: 1.3.0
     */
    public Domain2PackageTO getDomain2Package(Domain2PackageTO domain2Package);

    /**
     * this method is used to get Domain2Package List
     * version: 1.3.0
     */
    public List<Domain2PackageTO> getDomain2PackageList(Domain2PackageTO domain2Package);

    /**
     * this method is used to search Domain2Package
     * version: 1.3.0
     */
    public List<Domain2PackageTO> searchDomain2PackageList(Domain2PackageTO domain2Package);
    
    /**
     * this method is used to get Active Domain2Package List
     * version: 1.3.0
     */
    public List<Domain2PackageTO> getActiveDomain2PackageList(String domainId, String domainPackageStatus);
    
    /**
     * this method is used to get Active Domain2Package List and pagination
     * version: 1.3.0
     */
    public List<Domain2PackageTO> getActiveDomain2PackageListAndPage(String domainId, String domainPackageStatus);
    
    /**
     * this method is used to get Active DomainPackage List by domain id
     * version: 1.3.0
     */
    public List<Domain2PackageTO> getActiveDomainPackageListByDomainId(String domainId);
    
    /**
     * this method is used to get Old DomainPackage List by Isv service id
     * version: 1.3.0
     */
    public Domain2PackageTO getOldDomain2PackageByIsvService(String proTxId);
    
    public PackageOrderTO constructPackageOrder(PackageOrderTO packageOrderTO);
    
    public Domain2PackageTO constructDomain2Package(Domain2PackageTO domain2PackageTO);
    
    public UserProductTO constructUserProduct(UserProductTO userProductTO);
    
    /**
     * this method is used to get active DomainPackage List by domainId, orderId and domain package status; add for auto assign product.
     * version: 1.3.0
     */
    public List<Domain2PackageTO> getActiveDomain2PackageList(String domainId, String orderId, String domainPackageStatus);

    public Map<String, String> getServiceParameters(String domainProductId, String productId);
}