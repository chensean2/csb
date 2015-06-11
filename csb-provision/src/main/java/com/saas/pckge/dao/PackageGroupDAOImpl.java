/*
 *  =========================================================================
 * Program Name: package com.saas.pckge.dao.PackageGroupDAOImpl
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

import com.csb.common.dao.SCBaseDAOImpl;
import com.saas.pckge.to.PackageGroupTO;

public class PackageGroupDAOImpl extends SCBaseDAOImpl implements PackageGroupDAO {
    public int createPackageGroup(PackageGroupTO packageGroup) {
        return create(packageGroup);
    }

    public int deletePackageGroup(PackageGroupTO packageGroup) {
        return delete(packageGroup);
    }

    public int updatePackageGroup(PackageGroupTO packageGroup) {
        return update(packageGroup);
    }

    public PackageGroupTO getPackageGroup(PackageGroupTO packageGroup) {
        return (PackageGroupTO) queryForObject(packageGroup);
    }

    public List<PackageGroupTO> getPackageGroupList(PackageGroupTO packageGroup) {
        Map<String, Object> paraMap = new HashMap<String, Object>();

        //TODO
        return null;
//        return pfwClient.queryForList(PackageGroupTO.class, "/packageGroup/getPackageGroupList", paraMap);
    }

    public List<PackageGroupTO> searchPackageGroupList(PackageGroupTO packageGroup) {
        Map<String, Object> paraMap = new HashMap<String, Object>();

        //TODO
        return null;
//        return PaginationEnabler.queryForList(PackageGroupTO.class, pfwClient, "/packageGroup/getPackageGroupList", paraMap);
    }

}