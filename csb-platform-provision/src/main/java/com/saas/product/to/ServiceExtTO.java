/*
 *  =========================================================================
 * Program Name: package com.saas.product.to.AASvcExtTO
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
 * v1.0     - Initial Release         jixiaowei                  Mar 17, 2011
 * =====================================================================================
 */
package com.saas.product.to;

import com.saas.common.to.SCBaseTO;

public class ServiceExtTO extends SCBaseTO {
    /**
     * 
     */
    private static final long serialVersionUID = 4470476737785839470L;
    private String serviceExtID;
    private String serviceID;
    private String category;
    private String serviceExtType;
    private String itemName;
    private String itemDesc;
    private String itemUrl;
    private Integer itemSequence;
    private byte[] itemIcon;
    private String itemIconOnPath;
    private String itemIconOffPath;
    
    public String getServiceExtID() {
        return serviceExtID;
    }

    public void setServiceExtID(String serviceExtID) {
        this.serviceExtID = serviceExtID;
    }
    
    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }
    
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public String getServiceExtType() {
        return serviceExtType;
    }

    public void setServiceExtType(String serviceExtType) {
        this.serviceExtType = serviceExtType;
    }
    
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }
    
    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }
    
    public Integer getItemSequence() {
        return itemSequence;
    }

    public void setItemSequence(Integer itemSequence) {
        this.itemSequence = itemSequence;
    }

    public byte[] getItemIcon() {
        return itemIcon;
    }

    public void setItemIcon(byte[] itemIcon) {
        this.itemIcon = itemIcon;
    }

	public String getItemIconOnPath() {
		return itemIconOnPath;
	}

	public void setItemIconOnPath(String itemIconOnPath) {
		this.itemIconOnPath = itemIconOnPath;
	}

	public String getItemIconOffPath() {
		return itemIconOffPath;
	}

	public void setItemIconOffPath(String itemIconOffPath) {
		this.itemIconOffPath = itemIconOffPath;
	}

	
}
