/*
 *  =========================================================================
 * Program Name: package com.saas.pckge.dao.PackageDAO
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
package com.saas.pckge.dao;

import java.util.List;

import com.saas.pckge.to.PackageLicenceOrderTO;
import com.saas.pckge.to.PackageLicenceTO;
import com.saas.pckge.to.PackageTO;

public interface PackageDAO {

    public int createPackage(PackageTO packageTO);

    public int updatePackage(PackageTO packageTO);

    public int deletePackage(PackageTO packageTO);

    public PackageTO getPackage(PackageTO packageTO);

    public List<PackageTO> getPackageList(PackageTO packageTO);

    public List<PackageTO> searchPackageList(PackageTO packageTO);
    
    public PackageLicenceTO getPackageLicenceByPackageId(String packageId);
    public List<PackageLicenceTO> getPackageLicenceList(PackageLicenceTO packageLicenceTO);
    public PackageLicenceTO getPackageLicenceTO(PackageLicenceTO packageLicenceTO);
    public int createPackageLicenceOrder(PackageLicenceOrderTO licenceOrderTO);

    public int updatePackageLicenceOrder(PackageLicenceOrderTO licenceOrderTO);

    public int deletePackageLicenceOrder(PackageLicenceOrderTO licenceOrderTO);

    public PackageLicenceOrderTO getPackageLicenceOrder(PackageLicenceOrderTO licenceOrderTO);
    
}