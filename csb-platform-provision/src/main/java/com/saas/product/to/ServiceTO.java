/*
 * =========================================================================
 *  Program Name: com.saas.common.to.ServiceTO
 *
 *  Copyright 2009 saas Pte. Ltd. All Rights Reserved
 *
 *  This software is confidential and proprietary to saas Pte. Ltd. You shall
 *  use this software only in accordance with the terms of the license
 *  agreement you entered into with saas.  No aspect or part or all of this
 *  software may be reproduced, modified or disclosed without full and
 *  direct written authorisation from saas.
 *
 *  saas SUPPLIES THIS SOFTWARE ON AN "AS IS" BASIS. saas MAKES NO
 *  REPRESENTATIONS OR WARRANTIES, EITHER EXPRESSLY OR IMPLIEDLY, ABOUT THE
 *  SUITABILITY OR NON-INFRINGEMENT OF THE SOFTWARE. saas SHALL NOT BE LIABLE
 *  FOR ANY LOSSES OR DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
 *  MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 *
 *  Change Revision
 * -------------------------------------------------------------------------
 *  Version    Remarks
 *  v1.0       - Initial Release
 * =========================================================================
 */
package com.saas.product.to;

import java.util.List;
import java.util.Map;

import com.saas.common.to.SCBaseTO;

public class ServiceTO extends SCBaseTO {

    /**
	 * 
	 */
    private static final long serialVersionUID = -22932298695078633L;
    private String serviceId;
    private String serviceName;
    private String serviceDescription;
    private byte[] serviceLogo;
    private String serviceCategory;
    private String serviceLaunchUrl;
    private String serviceType;
    private String serviceSignOutUrl;//SERVICE_SIGN_OUT_URL
    private String serviceProvisionUrl;//SERVICE_PROVISION_URL
    private String serviceUserName;//SERVICE_USERNAME
    private String servicePassword;//SERVICE_PASSWORD
    private String serviceStatus;
    private String expandSubIndicator;//EXPAND_SUB_INDICATOR
    private String provisionConfigUrl;
    private String assignConfigUrl;
    private String serviceDefName;
    private String serviceDefVersion;
    private String serviceLogoOnPath;//SERVICE_LOGO_ON_PATH
    private String serviceLogoOffPath;//SERVICE_LOGO_OFF_PATH
    private String moreAppIconOn;
    private String moreAppIconOff;
    private String moreAppLaunchUrl;
    private String moreAppName;
    private String moreAppDesc;
    private String termConditionContent;//TERM_CONDITION_CONTENT
    private String termConditionIndicator;//TERM_CONDITION_INDICATOR
    private String dashboardDisplayIndicator;
    private String provisionConfigUpdateUrl;//
    private String issuer;
    private String ssoAcsUrl;//SSO_ACS_URL
    private String ssoRelayState;// SSO_RELAY_STATE
    private String ssoUrl;//SSO_URL
    
    private List<ServiceExtTO> serviceExtList;
    private Map<String, Boolean> categoryMap;

    public String getTermConditionIndicator() {
        return termConditionIndicator;
    }

    public void setTermConditionIndicator(String termConditionIndicator) {
        this.termConditionIndicator = termConditionIndicator;
    }

    public String getTermConditionContent() {
        return termConditionContent;
    }

    public void setTermConditionContent(String termConditionContent) {
        this.termConditionContent = termConditionContent;
    }

    public String getProvisionConfigUpdateUrl() {
        return provisionConfigUpdateUrl;
    }

    public void setProvisionConfigUpdateUrl(String provisionConfigUpdateUrl) {
	this.provisionConfigUpdateUrl = provisionConfigUpdateUrl;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public byte[] getServiceLogo() {
        return serviceLogo;
    }

    public void setServiceLogo(byte[] serviceLogo) {
        this.serviceLogo = serviceLogo;
    }

    public String getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(String serviceCategory) {
        this.serviceCategory = serviceCategory;
    }

    public String getServiceLaunchUrl() {
        return serviceLaunchUrl;
    }

    public void setServiceLaunchUrl(String serviceLaunchUrl) {
        this.serviceLaunchUrl = serviceLaunchUrl;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

	public String getServiceSignOutUrl() {
		return serviceSignOutUrl;
	}

	public void setServiceSignOutUrl(String serviceSignOutUrl) {
		this.serviceSignOutUrl = serviceSignOutUrl;
	}

	public String getServiceProvisionUrl() {
		return serviceProvisionUrl;
	}

	public void setServiceProvisionUrl(String serviceProvisionUrl) {
		this.serviceProvisionUrl = serviceProvisionUrl;
	}

	public String getServiceUserName() {
		return serviceUserName;
	}

	public void setServiceUserName(String serviceUserName) {
		this.serviceUserName = serviceUserName;
	}

	public String getServicePassword() {
		return servicePassword;
	}

	public void setServicePassword(String servicePassword) {
		this.servicePassword = servicePassword;
	}

	public String getExpandSubIndicator() {
		return expandSubIndicator;
	}

	public void setExpandSubIndicator(String expandSubIndicator) {
		this.expandSubIndicator = expandSubIndicator;
	}

	public String getProvisionConfigUrl() {
		return provisionConfigUrl;
	}

	public void setProvisionConfigUrl(String provisionConfigUrl) {
		this.provisionConfigUrl = provisionConfigUrl;
	}

	public String getAssignConfigUrl() {
		return assignConfigUrl;
	}

	public void setAssignConfigUrl(String assignConfigUrl) {
		this.assignConfigUrl = assignConfigUrl;
	}

	public String getServiceDefName() {
		return serviceDefName;
	}

	public void setServiceDefName(String serviceDefName) {
		this.serviceDefName = serviceDefName;
	}

	public String getServiceDefVersion() {
		return serviceDefVersion;
	}

	public void setServiceDefVersion(String serviceDefVersion) {
		this.serviceDefVersion = serviceDefVersion;
	}

	public String getServiceLogoOnPath() {
		return serviceLogoOnPath;
	}

	public void setServiceLogoOnPath(String serviceLogoOnPath) {
		this.serviceLogoOnPath = serviceLogoOnPath;
	}

	public String getServiceLogoOffPath() {
		return serviceLogoOffPath;
	}

	public void setServiceLogoOffPath(String serviceLogoOffPath) {
		this.serviceLogoOffPath = serviceLogoOffPath;
	}

	public String getMoreAppIconOn() {
		return moreAppIconOn;
	}

	public void setMoreAppIconOn(String moreAppIconOn) {
		this.moreAppIconOn = moreAppIconOn;
	}

	public String getMoreAppIconOff() {
		return moreAppIconOff;
	}

	public void setMoreAppIconOff(String moreAppIconOff) {
		this.moreAppIconOff = moreAppIconOff;
	}

	public String getMoreAppLaunchUrl() {
		return moreAppLaunchUrl;
	}

	public void setMoreAppLaunchUrl(String moreAppLaunchUrl) {
		this.moreAppLaunchUrl = moreAppLaunchUrl;
	}

        public String getMoreAppName() {
            return moreAppName;
        }

        public void setMoreAppName(String moreAppName) {
            this.moreAppName = moreAppName;
        }

        public String getMoreAppDesc() {
            return moreAppDesc;
        }

        public void setMoreAppDesc(String moreAppDesc) {
            this.moreAppDesc = moreAppDesc;
        }

	public String getDashboardDisplayIndicator() {
	    return dashboardDisplayIndicator;
	}

	public void setDashboardDisplayIndicator(String dashboardDisplayIndicator) {
	    this.dashboardDisplayIndicator = dashboardDisplayIndicator;
	}

        public String getIssuer() {
            return issuer;
        }

        public void setIssuer(String issuer) {
            this.issuer = issuer;
        }

        public String getSsoAcsUrl() {
            return ssoAcsUrl;
        }

        public void setSsoAcsUrl(String ssoAcsUrl) {
            this.ssoAcsUrl = ssoAcsUrl;
        }

        public String getSsoRelayState() {
            return ssoRelayState;
        }

        public void setSsoRelayState(String ssoRelayState) {
            this.ssoRelayState = ssoRelayState;
        }

		public String getSsoUrl() {
			return ssoUrl;
		}

		public void setSsoUrl(String ssoUrl) {
			this.ssoUrl = ssoUrl;
		}

        public List<ServiceExtTO> getServiceExtList() {
            return serviceExtList;
        }

        public void setServiceExtList(List<ServiceExtTO> serviceExtList) {
            this.serviceExtList = serviceExtList;
        }

        public Map<String, Boolean> getCategoryMap() {
            return categoryMap;
        }

        public void setCategoryMap(Map<String, Boolean> categoryMap) {
            this.categoryMap = categoryMap;
        }
		
}
