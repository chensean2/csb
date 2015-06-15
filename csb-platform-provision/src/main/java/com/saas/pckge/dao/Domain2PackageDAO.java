/*
 *  =========================================================================
 * Program Name: package com.saas.pckge.dao.Domain2PackageDAO
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

import com.saas.pckge.to.Domain2PackageTO;

public interface Domain2PackageDAO {

    public int createDomain2Package(Domain2PackageTO domain2Package);

    public int updateDomain2Package(Domain2PackageTO domain2Package);

    public int deleteDomain2Package(Domain2PackageTO domain2Package);

    public Domain2PackageTO getDomain2Package(Domain2PackageTO domain2Package);

    public List<Domain2PackageTO> getDomain2PackageList(Domain2PackageTO domain2Package);

    public List<Domain2PackageTO> searchDomain2PackageList(Domain2PackageTO domain2Package);
    
    public List<Domain2PackageTO> getActiveDomain2PackageList(String domainId, String domainPackageStatus);
    
    public List<Domain2PackageTO> getActiveDomain2PackageListAndPage(String domainId, String domainPackageStatus);
    
    public List<Domain2PackageTO> getOldDomain2PackageByIsvService(String proTxId);

    public List<Domain2PackageTO> getActiveDomain2PackageList(String domainId, String orderId, String domainPackageStatus);
}