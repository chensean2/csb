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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.saas.common.to.SCBaseTO;

public class PackageLicenceTO extends SCBaseTO {

    private static final long serialVersionUID = -8989074068277712550L;

    private String packageLicenceId;
    private String packageId;
    private String packageName;
    private String packageNameLink;
    private String packageDesc;
    private String packageGroupId;
    private String licenceDisplay;
    private String licenceType;
    
    private String licenceDesc;
    private String quotaDesc;
    private String planDesc;
    
    private String currentLicence;
    private List<PackageLicenceTO> groupPackageLicenceList; 
    public List<PackageLicenceTO> getGroupPackageLicenceList() {
        return groupPackageLicenceList;
    }

    public void setGroupPackageLicenceList(List<PackageLicenceTO> groupPackageLicenceList) {
        this.groupPackageLicenceList = groupPackageLicenceList;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageLicenceId() {
        return packageLicenceId;
    }

    public void setPackageLicenceId(String packageLicenceId) {
        this.packageLicenceId = packageLicenceId;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getLicenceDisplay() {
        return licenceDisplay;
    }

    public void setLicenceDisplay(String licenceDisplay) {
        this.licenceDisplay = licenceDisplay;
    }

    public String getLicenceType() {
        return licenceType;
    }

    public void setLicenceType(String licenceType) {
        this.licenceType = licenceType;
    }

    public String getPackageDesc() {
        return packageDesc;
    }

    public void setPackageDesc(String packageDesc) {
        this.packageDesc = packageDesc;
    }

    public String getLicenceDesc() {
        return licenceDesc;
    }

    public void setLicenceDesc(String licenceDesc) {
        this.licenceDesc = licenceDesc;
    }

    public String getQuotaDesc() {
        return quotaDesc;
    }

    public void setQuotaDesc(String quotaDesc) {
        this.quotaDesc = quotaDesc;
    }

    public String getPlanDesc() {
        return planDesc;
    }

    public void setPlanDesc(String planDesc) {
        this.planDesc = planDesc;
    }

    public String getPackageGroupId() {
        return packageGroupId;
    }

    public void setPackageGroupId(String packageGroupId) {
        this.packageGroupId = packageGroupId;
    }

    public String getCurrentLicence() {
        return currentLicence;
    }

    public void setCurrentLicence(String currentLicence) {
        this.currentLicence = currentLicence;
    }
    
    public Map<String,String> getLicenceDescAsList() {
        Map<String,String> licenceDescMap = new HashMap<String, String>();
        if(StringUtils.isNotEmpty(licenceDesc)){
            String[] licenceArray = licenceDesc.split(";");
            for(String licenceStr : licenceArray){
                licenceDescMap.put(licenceStr, licenceStr);
            }
        }
        return licenceDescMap;
    }

    public String getPackageNameLink() {
        return packageNameLink;
    }

    public void setPackageNameLink(String packageNameLink) {
        this.packageNameLink = packageNameLink;
    }
    

}
