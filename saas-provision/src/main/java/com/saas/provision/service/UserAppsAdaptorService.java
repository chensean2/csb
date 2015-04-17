package com.saas.provision.service;

import java.util.List;
import java.util.Map;

import com.saas.common.to.LicenseTO;
import com.saas.common.to.UserTO;
import com.saas.pckge.to.Domain2ProductTO;

public interface UserAppsAdaptorService {
    
        //prepare data for init apps
	//public Map<String,Object> initUserApps(UserTO user,Domain2ProductTO mainDomainProduct,Integer pkgOrderNo,MultiPackageLicenseHelpTO multiHelpTO);
	
	//valid fail need to refresh license info
//	public Map<String, Object> refreshPkgLicense(UserTO user,PackageHelperTO packageHelper);
	
	//updateLicensesRefKey
	public void updateLicensesRefKey(List<LicenseTO> licenseTOList);
	
	
}
