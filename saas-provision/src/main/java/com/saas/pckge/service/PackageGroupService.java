/*
 *  =========================================================================
 * Program Name: package com.saas.pckge.service.PackageGroupService
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

import com.saas.pckge.to.PackageGroupTO;

public interface PackageGroupService {

    /**
     * this method is used to create PackageGroup
     * version: 1.3.0
     */
    public void createPackageGroup(PackageGroupTO packageGroup);

    /**
     * this method is used to update PackageGroup
     * version: 1.3.0
     */
    public void updatePackageGroup(PackageGroupTO packageGroup);

    /**
     * this method is used to delete PackageGroup
     * version: 1.3.0
     */
    public void deletePackageGroup(PackageGroupTO packageGroup);

    /**
     * this method is used to search PackageGroup
     * version: 1.3.0
     */
    public PackageGroupTO getPackageGroup(PackageGroupTO packageGroup);

    /**
     * this method is used to get PackageGroup List
     * version: 1.3.0
     */
    public List<PackageGroupTO> getPackageGroupList(PackageGroupTO packageGroup);

    /**
     * this method is used to search PackageGroup
     * version: 1.3.0
     */
    public List<PackageGroupTO> searchPackageGroupList(PackageGroupTO packageGroup);

}