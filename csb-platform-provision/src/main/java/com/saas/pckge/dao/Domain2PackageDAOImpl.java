/*
 *  =========================================================================
 * Program Name: package com.saas.pckge.dao.Domain2PackageDAOImpl
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
 * v1.0     - Initial Release         samyang                   Mar 4, 2011
 * =====================================================================================
 */
package com.saas.pckge.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.csb.common.dao.SCBaseDAOImpl;
import com.saas.pckge.to.Domain2PackageTO;

public class Domain2PackageDAOImpl extends SCBaseDAOImpl implements Domain2PackageDAO {
    public int createDomain2Package(Domain2PackageTO domain2Package) {
        return create(domain2Package);
    }

    public int deleteDomain2Package(Domain2PackageTO domain2Package) {
        return delete(domain2Package);
    }

    public int updateDomain2Package(Domain2PackageTO domain2Package) {
        return update(domain2Package);
    }

    public Domain2PackageTO getDomain2Package(Domain2PackageTO domain2Package) {
        return null;
//    	return (Domain2PackageTO)pfwClient.materializeWith(domain2Package);
    }

    public List<Domain2PackageTO> getDomain2PackageList(Domain2PackageTO domain2Package) {
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("domainId", domain2Package.getDomainId());
        paraMap.put("domainPackageStatus", domain2Package.getDomainPackageStatus());
        paraMap.put("orderId", domain2Package.getOrderId());
        paraMap.put("packageId", domain2Package.getPackageId());
        paraMap.put("transferRefId", domain2Package.getTransferRefId());
//        return pfwClient.queryForList(Domain2PackageTO.class, "/domain2Package/getDomain2PackageList", paraMap);
        return null;
    }

    public List<Domain2PackageTO> searchDomain2PackageList(Domain2PackageTO domain2Package) {
        Map<String, Object> paraMap = new HashMap<String, Object>();

        //TODO
        return null;
        //return PaginationEnabler.queryForList(Domain2PackageTO.class, pfwClient, "/domain2Package/getDomain2PackageList", paraMap);
    }
    
    public List<Domain2PackageTO> getActiveDomain2PackageList(String domainId, String domainPackageStatus){
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("domainId", domainId);
        paraMap.put("domainPackageStatus", domainPackageStatus);
        paraMap.put("sortOrder", "p.PACKAGE_NAME");
        paraMap.put("orderType", "ASC");
//        return pfwClient.queryForList(Domain2PackageTO.class, "/domain2Package/getActiveDomain2PackageList", paraMap);
        return null;
    }

    public List<Domain2PackageTO> getActiveDomain2PackageList(String domainId, String orderId, String domainPackageStatus) {
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("domainId", domainId);
        paraMap.put("orderId", orderId);
        paraMap.put("domainPackageStatus", domainPackageStatus);
        paraMap.put("sortOrder", "p.PACKAGE_NAME");
        paraMap.put("orderType", "ASC");
//        return pfwClient.queryForList(Domain2PackageTO.class, "/domain2Package/getActiveDomain2PackageList", paraMap);
        return null;
    }
    
    public List<Domain2PackageTO> getActiveDomain2PackageListAndPage(String domainId, String domainPackageStatus){
    	Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("domainId", domainId);
        paraMap.put("domainPackageStatus", domainPackageStatus);
//        return PaginationEnabler.queryForList(Domain2PackageTO.class, pfwClient, "/domain2Package/getActiveDomain2PackageList", paraMap);
        return null;
    }
    
    public List<Domain2PackageTO> getOldDomain2PackageByIsvService(String proTxId){
    	Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("proTxId", proTxId);
//        return pfwClient.queryForList(Domain2PackageTO.class, "/domain2Package/getOldDomain2PackageByIsvServiceId", paraMap);
        return null;
    }

}