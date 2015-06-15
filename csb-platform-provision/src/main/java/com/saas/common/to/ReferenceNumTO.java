/*
 *  =========================================================================
 * Program Name: package com.saas.common.to.ReferenceNumTO
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
package com.saas.common.to;

import java.sql.Timestamp;
import java.util.Locale;
import java.text.SimpleDateFormat;
import com.saas.common.to.SCBaseTO;

public class ReferenceNumTO extends SCBaseTO {
    /**
     * 
     */
    private static final long serialVersionUID = -3650258384575116062L;
    private String refID;
    private String refPre;
    private String refDateFormat;
    private Integer refIndexStart;
    private Integer refIndexEnd;
    private Integer refIndexCurrent;
    private Integer refNumDigit;
    private String refReset;
    private String refSeperator;
    private Timestamp refUpdatedDt;
    
    public String getRefID() {
        return refID;
    }

    public void setRefID(String refID) {
        this.refID = refID;
    }
    
    public String getRefPre() {
        return refPre;
    }

    public void setRefPre(String refPre) {
        this.refPre = refPre;
    }
    
    public String getRefDateFormat() {
        return refDateFormat;
    }

    public void setRefDateFormat(String refDateFormat) {
        this.refDateFormat = refDateFormat;
    }
    
    public Integer getRefIndexStart() {
        return refIndexStart;
    }

    public void setRefIndexStart(Integer refIndexStart) {
        this.refIndexStart = refIndexStart;
    }
    
    public Integer getRefIndexEnd() {
        return refIndexEnd;
    }

    public void setRefIndexEnd(Integer refIndexEnd) {
        this.refIndexEnd = refIndexEnd;
    }
    
    public Integer getRefIndexCurrent() {
        return refIndexCurrent;
    }

    public void setRefIndexCurrent(Integer refIndexCurrent) {
        this.refIndexCurrent = refIndexCurrent;
    }
    
    public Integer getRefNumDigit() {
        return refNumDigit;
    }

    public void setRefNumDigit(Integer refNumDigit) {
        this.refNumDigit = refNumDigit;
    }
    
    public String getRefReset() {
        return refReset;
    }

    public void setRefReset(String refReset) {
        this.refReset = refReset;
    }
    
    public String getRefSeperator() {
        return refSeperator;
    }

    public void setRefSeperator(String refSeperator) {
        this.refSeperator = refSeperator;
    }
    
    public Timestamp getRefUpdatedDt() {
        return refUpdatedDt;
    }

    public void setRefUpdatedDt(Timestamp refUpdatedDt) {
        this.refUpdatedDt = refUpdatedDt;
    }

    public String getRefUpdatedDtAsStr(String format) {
        if (null == format || "".equals(format)) {
            format = "dd/MM/yyyy HH:mm:ss";
        }
        
        if(null == refUpdatedDt) {
            return "";
        }
        
        return new SimpleDateFormat(format, Locale.US).format(refUpdatedDt);
    }
}
