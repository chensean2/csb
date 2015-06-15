/*
 *  =========================================================================
 * Program Name: package com.saas.pckge.to.Domain2PackageHelpTO
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
 * v1.0     - Initial Release         zhanganshou                  Mar 30, 2013
 * =====================================================================================
 */
package com.saas.pckge.to;

import java.util.ArrayList;
import java.util.List;

public class PackageDetailHelpTO {

	private List<PackageLicenceOrderTO> packageLicenceOrderList;

	public List<PackageLicenceOrderTO> getPackageLicenceOrderList() {
		return packageLicenceOrderList;
	}

	public void setPackageLicenceOrderList(List<PackageLicenceOrderTO> packageLicenceOrderList) {
		this.packageLicenceOrderList = packageLicenceOrderList;
	}

	public void setPackageLicenceOrderList(int i, PackageLicenceOrderTO packageLicenceOrderTO) {
        while (i >= packageLicenceOrderList.size()) {
        	packageLicenceOrderList.add(null);
        }
        packageLicenceOrderList.set(i, packageLicenceOrderTO);
    }

    public PackageLicenceOrderTO getPackageLicenceOrderList(int i) {
        if (packageLicenceOrderList == null) {
        	packageLicenceOrderList = new ArrayList<PackageLicenceOrderTO>();
        }
        
        while (i >= packageLicenceOrderList.size()) {
        	packageLicenceOrderList.add(new PackageLicenceOrderTO());
        }
        return packageLicenceOrderList.get(i);
    }
	
}
