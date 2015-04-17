/*
 * =========================================================================
 *  Program Name: com.saas.common.to.ServiceSubTO
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

import com.saas.common.to.SCBaseTO;

public class ServiceSubTO extends SCBaseTO {

	private static final long serialVersionUID = 5608166918559872974L;
	private String serviceSubId;// SERVICE_SUB_ID
	private String serviceId;// SERVICE_ID
	private String subName;// SUB_NAME
	private String subDesc;// SUB_DESC
	private byte[] subIcon;// SUB_ICON
	private String subSeq;// SUB_SEQ
	private String subLaunchUrl;// SUB_LAUNCH_URL
	private String subType;// SUB_TYPE
	private String subIconOnPath;//SUB_ICON_ON_PATH
	private String subIconOffPath;//SUB_ICON_OFF_PATH
	private String termConditionContent;//TERM_CONDITION_CONTENT
	private String termConditionIndicator;//TERM_CONDITION_INDICATOR
	private List<UserProductTO> user2Product;
	
	public String getTermConditionContent() {
		return termConditionContent;
	}
	public void setTermConditionContent(String termConditionContent) {
		this.termConditionContent = termConditionContent;
	}
	
	public String getServiceSubId() {
		return serviceSubId;
	}
	public void setServiceSubId(String serviceSubId) {
		this.serviceSubId = serviceSubId;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getSubDesc() {
		return subDesc;
	}
	public void setSubDesc(String subDesc) {
		this.subDesc = subDesc;
	}
	public byte[] getSubIcon() {
		return subIcon;
	}
	public void setSubIcon(byte[] subIcon) {
		this.subIcon = subIcon;
	}
	public String getSubSeq() {
		return subSeq;
	}
	public void setSubSeq(String subSeq) {
		this.subSeq = subSeq;
	}
	public String getSubLaunchUrl() {
		return subLaunchUrl;
	}
	public void setSubLaunchUrl(String subLaunchUrl) {
		this.subLaunchUrl = subLaunchUrl;
	}
	public String getSubType() {
		return subType;
	}
	public void setSubType(String subType) {
		this.subType = subType;
	}
	public String getSubIconOnPath() {
		return subIconOnPath;
	}
	public void setSubIconOnPath(String subIconOnPath) {
		this.subIconOnPath = subIconOnPath;
	}
	public String getSubIconOffPath() {
		return subIconOffPath;
	}
	public void setSubIconOffPath(String subIconOffPath) {
		this.subIconOffPath = subIconOffPath;
	}
	public List<UserProductTO> getUser2Product() {
		return user2Product;
	}
	public void setUser2Product(List<UserProductTO> user2Product) {
		this.user2Product = user2Product;
	}
    
        public String getTermConditionIndicator() {
            return termConditionIndicator;
        }
    
        public void setTermConditionIndicator(String termConditionIndicator) {
            this.termConditionIndicator = termConditionIndicator;
        }
	
	
}
