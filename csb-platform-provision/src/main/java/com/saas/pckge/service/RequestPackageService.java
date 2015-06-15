/*
 *  =========================================================================
 * Program Name: package com.saas.pckge.service.RequestPackageService
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
 * v1.3.0     - Initial Release         jixiaowei                  Mar 2, 2011
 * =====================================================================================
 */
package com.saas.pckge.service;

import java.util.List;

import com.saas.pckge.to.RequestPackageTO;

public interface RequestPackageService {

    /**
     * this method is used to create RequestPackage
     * version: 1.3.0
     */
    public void createRequestPackage(RequestPackageTO requestPackage);

    /**
     * this method is used to update RequestPackage
     * version: 1.3.0
     */
    public void updateRequestPackage(RequestPackageTO requestPackage);

    /**
     * this method is used to delete RequestPackage
     * version: 1.3.0
     */
    public void deleteRequestPackage(RequestPackageTO requestPackage);

    /**
     * this method is used to search RequestPackage
     * version: 1.3.0
     */
    public RequestPackageTO getRequestPackage(RequestPackageTO requestPackage);

    /**
     * this method is used to get RequestPackage List
     * version: 1.3.0
     */
    public List<RequestPackageTO> getRequestPackageList(RequestPackageTO requestPackage);

    /**
     * this method is used to search RequestPackage
     * version: 1.3.0
     */
    public List<RequestPackageTO> searchRequestPackageList(RequestPackageTO requestPackage);

}