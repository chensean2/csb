/*
 *  =========================================================================
 * Program Name: package com.saas.pckge.dao.Domain2ProductDAO
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
package com.saas.pckge.dao;

import java.util.List;

import com.saas.pckge.to.Domain2ProductTO;

public interface Domain2ProductDAO {

    public int createDomain2Product(Domain2ProductTO domain2Product);

    public int updateDomain2Product(Domain2ProductTO domain2Product);

    public int deleteDomain2Product(Domain2ProductTO domain2Product);

    public Domain2ProductTO getDomain2Product(Domain2ProductTO domain2Product);

    public List<Domain2ProductTO> getDomain2ProductList(Domain2ProductTO domain2Product);

    public List<Domain2ProductTO> searchDomain2ProductList(Domain2ProductTO domain2Product);
    
    public List<Domain2ProductTO> getDomain2ProductListByDomainPackageIdAndUserId(String domainPackageId, String domainProductId, String userId);

    public Integer getLicenseAssigned(String domainPackageId, String domainProductId, String userId);
    
  //changed the serviceCategory with package level
//    public List<Domain2ProductTO> getDomainProductListByDomainPackageIdAndServiceCategory(String domainPackageId, String serviceCategory);
    
    public List<Domain2ProductTO> getMainDomainProduct(String domainPackageId);
    
    public boolean checkUnCompletedService(String domainId, String serviceId);
    
    public boolean checkOrderStatus(String domainId, String serviceId, String orderType, String orderStatus, String packageOrderStatus, String productOrderStatus, String excluedProTxId);
    
    public List<Domain2ProductTO> getActiveDomain2ProductList(Domain2ProductTO domain2Product);
    
    public List<Domain2ProductTO> getActiveDomain2ProductsByDomainId(Domain2ProductTO domain2Product);
    
}