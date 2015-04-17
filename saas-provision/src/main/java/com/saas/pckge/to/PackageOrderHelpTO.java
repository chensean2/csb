/*
 * =========================================================================
 * Program Name: com.saas.pckge.to.PackageOrderHelpTO.java
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
 * v1.0     - Initial Release          Wu Ming Shan               Mar 15, 2011
 * =====================================================================================
 */
package com.saas.pckge.to;

import java.util.ArrayList;
import java.util.List;

public class PackageOrderHelpTO {
    private List<PackageOrderTO> packageOrderList;
    private List<PackageTO> allActivePackageList;

    public List<PackageOrderTO> getPackageOrderList() {
        return packageOrderList;
    }

    public void setPackageOrderList(List<PackageOrderTO> packageOrderList) {
        this.packageOrderList = packageOrderList;
    }

    public void setPackageOrderListTO(int i, PackageOrderTO packageOrderTO) {
        while (i >= packageOrderList.size()) {
            packageOrderList.add(null);
        }
        packageOrderList.set(i, packageOrderTO);
    }

    public PackageOrderTO getPackageOrderListTO(int i) {
        if (packageOrderList == null) {
            packageOrderList = new ArrayList<PackageOrderTO>();
        }
        while (i >= packageOrderList.size()) {
            packageOrderList.add(new PackageOrderTO());
        }
        return packageOrderList.get(i);
    }
    
    public List<PackageTO> getAllActivePackageList() {
        return allActivePackageList;
    }

    public void setAllActivePackageList(List<PackageTO> allActivePackageList) {
        this.allActivePackageList = allActivePackageList;
    }

    public void setAllActivePackageListTO(int i, PackageTO packageTO) {
        while (i >= allActivePackageList.size()) {
            allActivePackageList.add(null);
        }
        allActivePackageList.set(i, packageTO);
    }

    public PackageTO getAllActivePackageListTO(int i) {
        if (allActivePackageList == null) {
            allActivePackageList = new ArrayList<PackageTO>();
        }
        while (i >= allActivePackageList.size()) {
            allActivePackageList.add(new PackageTO());
        }
        return allActivePackageList.get(i);
    }
    
    public String getLengthOfPackageOrderList() {
        if(null == packageOrderList || packageOrderList.isEmpty()) {
            return "0";
        }
        
        return String.valueOf(packageOrderList.size());
    }

}
