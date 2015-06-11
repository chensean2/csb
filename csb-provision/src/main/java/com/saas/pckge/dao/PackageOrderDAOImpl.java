/*
 *  =========================================================================
 * Program Name: package com.saas.pckge.dao.PackageOrderDAOImpl
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
 * v1.0     - Initial Release         jixiaowei                   Mar 4, 2011
 * =====================================================================================
 */
package com.saas.pckge.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.csb.common.dao.SCBaseDAOImpl;
import com.saas.pckge.to.PackageOrderTO;

public class PackageOrderDAOImpl extends SCBaseDAOImpl implements PackageOrderDAO {
    public int createPackageOrder(PackageOrderTO packageOrder) {
        return create(packageOrder);
    }

    public int deletePackageOrder(PackageOrderTO packageOrder) {
        return delete(packageOrder);
    }
    
    public int deletePackageOrderByOrderId(PackageOrderTO packageOrder){
    	 Map<String, Object> paraMap = new HashMap<String, Object>();
         paraMap.put("orderId", packageOrder.getOrderId());
//         pfwClient.executeMapSQL("/packageOrder/deletePackageOrderByOrderId", paraMap);
         return 0;
    }

    public int updatePackageOrder(PackageOrderTO packageOrder) {
        return update(packageOrder);
    }

    public PackageOrderTO getPackageOrder(PackageOrderTO packageOrder) {
        return (PackageOrderTO) queryForObject(packageOrder);
    }

    public List<PackageOrderTO> getPackageOrderList(PackageOrderTO packageOrder) {
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("orderId", packageOrder.getOrderId());
        paraMap.put("notPackageOrderStatus", packageOrder.getPackageOrderStatus());
        paraMap.put("oldDomainPackageId", packageOrder.getOldDomainPackageId());
        return null;
//        return pfwClient.queryForList(PackageOrderTO.class, "/packageOrder/getPackageOrderList", paraMap);
    }

    public List<PackageOrderTO> searchPackageOrderList(PackageOrderTO packageOrder) {
        Map<String, Object> paraMap = new HashMap<String, Object>();

        //TODO
        return null;
//        return PaginationEnabler.queryForList(PackageOrderTO.class, pfwClient, "/packageOrder/getPackageOrderList", paraMap);
    }

}