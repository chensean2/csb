/*
 *  =========================================================================
 * Program Name: package com.saas.pckge.service.PackageServiceImpl
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

import java.util.List;

import com.saas.common.ConcurrentUpdateException;
import com.saas.common.DaoRunTimeException;
import com.saas.common.exception.SCServiceException;
import com.saas.pckge.dao.PackageDAO;
import com.saas.pckge.to.PackageLicenceOrderTO;
import com.saas.pckge.to.PackageLicenceTO;
import com.saas.pckge.to.PackageTO;

public class PackageServiceImpl implements PackageService {

    private PackageDAO packageDAO;

    public void createPackage(PackageTO packageTO) {
    	packageDAO.createPackage(packageTO);
    }

    public void updatePackage(PackageTO packageTO) {
        try {
            int result = packageDAO.updatePackage(packageTO);

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

    public void deletePackage(PackageTO packageTO) {
        try {
            int result = packageDAO.deletePackage(packageTO);
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

    public PackageTO getPackage(PackageTO packageTO) {
        return packageDAO.getPackage(packageTO);
    }

    public List<PackageTO> getPackageList(PackageTO packageTO) {
        return packageDAO.getPackageList(packageTO);
    }

    public List<PackageTO> searchPackageList(PackageTO packageTO) {
        return packageDAO.searchPackageList(packageTO);
    }

    public void setPackageDAO(PackageDAO packageDAO) {
        this.packageDAO = packageDAO;
    }

    public PackageDAO getPackageDAO() {
        return packageDAO;
    }
    
    public PackageLicenceTO getPackageLicenceByPackageId(String packageId) {
        PackageLicenceTO packageLicence = packageDAO.getPackageLicenceByPackageId(packageId);
        if(packageLicence == null){
            return null;
        }
        PackageLicenceTO groupPackageLicenceTO = new PackageLicenceTO();
        groupPackageLicenceTO.setPackageGroupId(packageLicence.getPackageGroupId());
        List<PackageLicenceTO> groupPackageLicenceList = getPackageLicenceList(groupPackageLicenceTO);
        for(PackageLicenceTO packageLicenceTO : groupPackageLicenceList){
            if(packageLicenceTO.getPackageId().equals(packageId)){
                groupPackageLicenceList.remove(packageLicenceTO);
                break;
            }
        }
        packageLicence.setGroupPackageLicenceList(groupPackageLicenceList);
        
        return packageLicence;
    }
    public List<PackageLicenceTO> getPackageLicenceList(PackageLicenceTO packageLicenceTO){
        return packageDAO.getPackageLicenceList(packageLicenceTO);
    }
    public PackageLicenceTO getPackageLicenceTO(PackageLicenceTO packageLicenceTO){
        return packageDAO.getPackageLicenceTO(packageLicenceTO);
    }
    
    public void createPackageLicenceOrder(PackageLicenceOrderTO licenceOrderTO)
    {
    	packageDAO.createPackageLicenceOrder(licenceOrderTO);
    }

    public void updatePackageLicenceOrder(PackageLicenceOrderTO licenceOrderTO)
    {
        try {
            int result = packageDAO.updatePackageLicenceOrder(licenceOrderTO);

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

    public void deletePackageLicenceOrder(PackageLicenceOrderTO licenceOrderTO)
    {
        try {
            int result = packageDAO.deletePackageLicenceOrder(licenceOrderTO);
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

    public PackageLicenceOrderTO getPackageLicenceOrder(PackageLicenceOrderTO licenceOrderTO)
    {
    	return packageDAO.getPackageLicenceOrder(licenceOrderTO);
    }

}