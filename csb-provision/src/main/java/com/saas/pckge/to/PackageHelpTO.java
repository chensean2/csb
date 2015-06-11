/*
 *  =========================================================================
 * Program Name: package com.saas.pckge.to.PackageTO
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
package com.saas.pckge.to;

import java.util.ArrayList;
import java.util.List;

public class PackageHelpTO {
    
    private List<PackageTO> packageList = new ArrayList<PackageTO>();
    private List<Domain2PackageTO> existPackageList = new ArrayList<Domain2PackageTO>();
    private List<PackageTO> newPackageList = new ArrayList<PackageTO>();
    

    public List<PackageTO> getPackageList() {
        return packageList;
    }

    public void setPackageList(List<PackageTO> packageList) {
        this.packageList = packageList;
    }
    
    public void setPackageListTO(int i, PackageTO packageTO) {
        while (i >= packageList.size()) {
            packageList.add(null);
        }
        packageList.set(i, packageTO);
    }

    public PackageTO getPackageListTO(int i) {
        if (packageList == null) {
            packageList = new ArrayList<PackageTO>();
        }
        while (i >= packageList.size()) {
            packageList.add(new PackageTO());
        }
        return packageList.get(i);
    }

    public List<Domain2PackageTO> getExistPackageList() {
        return existPackageList;
    }

    public void setExistPackageList(List<Domain2PackageTO> existPackageList) {
        this.existPackageList = existPackageList;
    }
    
    public void setExistPackageListTO(int i, Domain2PackageTO domain2PackageTO) {
        while (i >= existPackageList.size()) {
            existPackageList.add(null);
        }
        existPackageList.set(i, domain2PackageTO);
    }

    public Domain2PackageTO getExistPackageListTO(int i) {
        if (existPackageList == null) {
            existPackageList = new ArrayList<Domain2PackageTO>();
        }
        while (i >= existPackageList.size()) {
            existPackageList.add(new Domain2PackageTO());
        }
        return existPackageList.get(i);
    }

    public List<PackageTO> getNewPackageList() {
        return newPackageList;
    }

    public void setNewPackageList(List<PackageTO> newPackageList) {
        this.newPackageList = newPackageList;
    }
    
    public void setNewPackageListTO(int i, PackageTO packageTO) {
        while (i >= newPackageList.size()) {
            newPackageList.add(null);
        }
        newPackageList.set(i, packageTO);
    }

    public PackageTO getNewPackageListTO(int i) {
        if (newPackageList == null) {
            newPackageList = new ArrayList<PackageTO>();
        }
        while (i >= newPackageList.size()) {
            newPackageList.add(new PackageTO());
        }
        return newPackageList.get(i);
    }
    
    
    
}
