/*
 *  =========================================================================
 * Program Name: package com.saas.pckge.dao.PackageDAOImpl
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
package com.saas.pckge.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.saas.common.dao.SCBaseDAOImpl;
import com.saas.pckge.to.PackageLicenceOrderTO;
import com.saas.pckge.to.PackageLicenceTO;
import com.saas.pckge.to.PackageTO;

public class PackageDAOImpl extends SCBaseDAOImpl implements PackageDAO {
    public int createPackage(PackageTO packageTO) {
        return create(packageTO);
    }

    public int deletePackage(PackageTO packageTO) {
        return delete(packageTO);
    }

    public int updatePackage(PackageTO packageTO) {
        return update(packageTO);
    }

    public PackageTO getPackage(PackageTO packageTO) {
        return (PackageTO) queryForObject(packageTO);
    }

    public List<PackageTO> getPackageList(PackageTO packageTO) {
        Map<String, Object> paraMap = new HashMap<String, Object>();

        paraMap.put("packageStatus", packageTO.getPackageStatus());
        paraMap.put("packageGroupId", packageTO.getPackageGroupId());
        return null;
//        return pfwClient.queryForList(PackageTO.class, "/package/getPackageList", paraMap);
    }

    public List<PackageTO> searchPackageList(PackageTO packageTO) {
        Map<String, Object> paraMap = new HashMap<String, Object>();

        //TODO
        return null;
//        return PaginationEnabler.queryForList(PackageTO.class, pfwClient, "/package/getPackageList", paraMap);
    }
    
    public PackageLicenceTO getPackageLicenceByPackageId(String packageId){
        Map<String, Object> paraMap = new HashMap<String, Object>();

        paraMap.put("packageId", packageId);
//        List<PackageLicenceTO> list = pfwClient.queryForList(PackageLicenceTO.class, "/package/getPackageLicenceList", paraMap);
//        if(list != null && list.size() == 1){
//            return list.get(0);
//        }
        return null;
    }
    public List<PackageLicenceTO> getPackageLicenceList(PackageLicenceTO packageLicenceTO){
        Map<String, Object> paraMap = new HashMap<String, Object>();
        
        paraMap.put("packageGroupId", packageLicenceTO.getPackageGroupId());
        return null;
//        return pfwClient.queryForList(PackageLicenceTO.class, "/package/getPackageLicenceList", paraMap);
    }
    
    public PackageLicenceTO getPackageLicenceTO(PackageLicenceTO packageLicenceTO) {
        return (PackageLicenceTO) queryForObject(packageLicenceTO);
    }

    public int createPackageLicenceOrder(PackageLicenceOrderTO licenceOrderTO)
    {
    	return create(licenceOrderTO);
    }

    public int updatePackageLicenceOrder(PackageLicenceOrderTO licenceOrderTO)
    {
    	return update(licenceOrderTO);
    }

    public int deletePackageLicenceOrder(PackageLicenceOrderTO licenceOrderTO)
    {
    	return delete(licenceOrderTO);
    }

    public PackageLicenceOrderTO getPackageLicenceOrder(PackageLicenceOrderTO licenceOrderTO)
    {
    	return (PackageLicenceOrderTO) queryForObject(licenceOrderTO);
    }
    
}