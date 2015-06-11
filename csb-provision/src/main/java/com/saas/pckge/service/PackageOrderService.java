/*
 *  =========================================================================
 * Program Name: package com.saas.pckge.service.PackageOrderService
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
 * v1.0     - Initial Release         jixiaowei                  Mar 4, 2011
 * =====================================================================================
 */
package com.saas.pckge.service;

import java.util.List;

import com.saas.pckge.to.PackageOrderTO;

public interface PackageOrderService {

    /**
     * this method is used to create PackageOrder
     * version: 1.3.0
     */
    public void createPackageOrder(PackageOrderTO packageOrder);

    /**
     * this method is used to update PackageOrder
     * version: 1.3.0
     */
    public void updatePackageOrder(PackageOrderTO packageOrder);

    /**
     * this method is used to delete PackageOrder
     * version: 1.3.0
     */
    public void deletePackageOrder(PackageOrderTO packageOrder);
    /**
     * this method is used to delete PackageOrder
     * version: 1.3.0
     */
    public void deletePackageOrderByOrderId(PackageOrderTO packageOrder);

    /**
     * this method is used to search PackageOrder
     * version: 1.3.0
     */
    public PackageOrderTO getPackageOrder(PackageOrderTO packageOrder);

    /**
     * this method is used to get PackageOrder List
     * version: 1.3.0
     */
    public List<PackageOrderTO> getPackageOrderList(PackageOrderTO packageOrder);

    /**
     * this method is used to search PackageOrder
     * version: 1.3.0
     */
    public List<PackageOrderTO> searchPackageOrderList(PackageOrderTO packageOrder);

}