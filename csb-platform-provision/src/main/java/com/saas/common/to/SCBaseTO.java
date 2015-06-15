/*
 * =========================================================================
 *  Program Name:com.saas.common.to.SCBaseTO
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
 * ----------------------------------------------------------------------------
 *  Version    Remarks	              Author	    Editor          Date
 *  v1.0       - Initial Release	  zhujun	                    20/11/2009
 * =====================================================================================
 */

package com.saas.common.to;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.time.DateFormatUtils;


public class SCBaseTO {

    private static final long serialVersionUID = 6712212732263361986L;

    private Timestamp lastUpdatedDt;

    private String lastUpdatedBy;

    private Timestamp createdDt;

    private String createdBy;

    private int version;

    private String sDatePattern = "dd/MM/yyyy HH:mm:ss";

    public Timestamp getLastUpdatedDt() {
        return lastUpdatedDt;
    }

    public void setLastUpdatedDt(Timestamp lastUpdatedDt) {
        this.lastUpdatedDt = lastUpdatedDt;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Timestamp getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Timestamp createdDt) {
        this.createdDt = createdDt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getLastUpdatedDtAsStr() {
        return DateFormatUtils.format(lastUpdatedDt, sDatePattern);
    }

    public void setLastUpdatedDtAsStr(String lastUpdatedDtAsStr) {
        lastUpdatedDtAsStr = lastUpdatedDtAsStr == null ? null : lastUpdatedDtAsStr.trim();
        // if input value is not empty, convert to object.
        if (lastUpdatedDtAsStr != null) {
            // if valID, convert it.
            try {
                SimpleDateFormat formater = new SimpleDateFormat(sDatePattern);
                lastUpdatedDt = new Timestamp(formater.parse(lastUpdatedDtAsStr).getTime());
            } catch (java.text.ParseException e) {
                // do nothing.
            }

        } else {
            // string is empty, put to null.
            lastUpdatedDt = null;
        }
    }

    public String getCreatedDtAsStr() {
        return DateFormatUtils.format(createdDt, sDatePattern);
    }

    public void setCreatedDtAsStr(String createdDtAsStr) {
        createdDtAsStr = createdDtAsStr == null ? null : createdDtAsStr.trim();
        // if input value is not empty, convert to object.
        if (createdDtAsStr != null) {
            // if valID, convert it.
            try {
                SimpleDateFormat formater = new SimpleDateFormat(sDatePattern);
                createdDt = new Timestamp(formater.parse(createdDtAsStr).getTime());

            } catch (java.text.ParseException e) {
                // do nothing.
            }
        } else {
            // string is empty, put to null.
            createdDt = null;
        }
    }


}
