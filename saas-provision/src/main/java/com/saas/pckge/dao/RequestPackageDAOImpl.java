/*
 *  =========================================================================
 * Program Name: package com.saas.pckge.dao.RequestPackageDAOImpl
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
import com.saas.pckge.to.RequestPackageTO;

public class RequestPackageDAOImpl extends SCBaseDAOImpl implements RequestPackageDAO {
    public int createRequestPackage(RequestPackageTO requestPackage) {
        return create(requestPackage);
    }

    public int deleteRequestPackage(RequestPackageTO requestPackage) {
        return delete(requestPackage);
    }

    public int updateRequestPackage(RequestPackageTO requestPackage) {
        return update(requestPackage);
    }

    public RequestPackageTO getRequestPackage(RequestPackageTO requestPackage) {
        return (RequestPackageTO) queryForObject(requestPackage);
    }

    public List<RequestPackageTO> getRequestPackageList(RequestPackageTO requestPackage) {
        Map<String, Object> paraMap = new HashMap<String, Object>();

        //TODO
        return null;
//        return pfwClient.queryForList(RequestPackageTO.class, "/requestPackage/getRequestPackageList", paraMap);
    }

    public List<RequestPackageTO> searchRequestPackageList(RequestPackageTO requestPackage) {
        Map<String, Object> paraMap = new HashMap<String, Object>();

        //TODO
        return null;
//        return PaginationEnabler.queryForList(RequestPackageTO.class, pfwClient, "/requestPackage/getRequestPackageList", paraMap);
    }

}