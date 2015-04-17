/*
 *  =========================================================================
 * Program Name: package com.saas.pckge.service.PackageGroupServiceImpl
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
package com.saas.pckge.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.saas.common.ConcurrentUpdateException;
import com.saas.common.DaoRunTimeException;
import com.saas.common.exception.SCServiceException;
import com.saas.pckge.dao.PackageGroupDAO;
import com.saas.pckge.to.PackageGroupTO;

public class PackageGroupServiceImpl implements PackageGroupService {

    private PackageGroupDAO packageGroupDAO;

    public void createPackageGroup(PackageGroupTO packageGroup) {
    	packageGroupDAO.createPackageGroup(packageGroup);
    }

    public void updatePackageGroup(PackageGroupTO packageGroup) {
        try {
            int result = packageGroupDAO.deletePackageGroup(packageGroup);

            if (0 == result) {
                throw new ConcurrentUpdateException();
            }
        } catch (DaoRunTimeException e) {
            if (e.getWrappedException() instanceof ConcurrentUpdateException) {
               throw new ConcurrentUpdateException();
            } else {
               throw new SCServiceException(e);
            }
        }
    }

    public void deletePackageGroup(PackageGroupTO packageGroup) {
        try {
            int result = packageGroupDAO.deletePackageGroup(packageGroup);
            if (0 == result) {
                throw new ConcurrentUpdateException();
            }
        } catch (DaoRunTimeException e) {
            if (e.getWrappedException() instanceof ConcurrentUpdateException) {
                throw new ConcurrentUpdateException();
            } else {
                 throw new SCServiceException(e);
            }
        }
    }

    public PackageGroupTO getPackageGroup(PackageGroupTO packageGroup) {
        return packageGroupDAO.getPackageGroup(packageGroup);
    }

    public List<PackageGroupTO> getPackageGroupList(PackageGroupTO packageGroup) {
        Map<String, Object> paraMap = new HashMap<String, Object>();

        // TODO

        return packageGroupDAO.getPackageGroupList(packageGroup);
    }

    public List<PackageGroupTO> searchPackageGroupList(PackageGroupTO packageGroup) {
        return packageGroupDAO.searchPackageGroupList(packageGroup);
    }

    public void setPackageGroupDAO(PackageGroupDAO packageGroupDAO) {
        this.packageGroupDAO = packageGroupDAO;
    }

    public PackageGroupDAO getPackageGroupDAO() {
        return packageGroupDAO;
    }
}