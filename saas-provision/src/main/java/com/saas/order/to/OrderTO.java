/*
 *  =========================================================================
 * Program Name: package com.saas.order.to.OrderTO
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
 * v1.3.0    - Initial Release         jixiaowei                  Mar 2, 2011
 * =====================================================================================
 */
package com.saas.order.to;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.format.datetime.DateFormatter;

import com.saas.common.IAppsConstants;
import com.saas.common.to.SCBaseTO;
import com.saas.pckge.to.PackageOrderTO;

public class OrderTO extends SCBaseTO {
    private static final long serialVersionUID = -4086021546706343977L;

    private String orderId;
    private String domainId;
    private String orderRefNum;
    private String orderStatus;
    private String requestedBy;
    private Timestamp requestDt;
    private String lastEmailNotificationTo;
    private Timestamp lastEmailNotificationDt;
    private String orderType;
    private String remarks;
    private List<PackageOrderTO> packageOrderList;
    private int packageOrderListNum;
    private int productOrderListNum;
    private Timestamp requestStartDt;
    private Timestamp requestEndDt;
    private String requestStartDtAsStr;
    private String requestEndDtAsStr;
    private String requestDtAsStr;

    public String getRequestStartDtAsStr() {
        return requestStartDtAsStr;
    }

    public void setRequestStartDtAsStr(String requestStartDtAsStr) {
        try {
            this.requestStartDtAsStr = requestStartDtAsStr;
//            this.requestStartDt = new Timestamp(DateFormatter.parseDate(requestStartDtAsStr,
//                    IAppsConstants.DATEFORMAT_D_M_Y).getTime());
        } catch (Exception e) {
            this.requestStartDt = null;
        }

    }

    public String getRequestEndDtAsStr() {
        return requestEndDtAsStr;
    }

    public void setRequestEndDtAsStr(String requestEndDtAsStr) {
        
        try {
            this.requestEndDtAsStr = requestEndDtAsStr;
//            this.requestEndDt = new Timestamp(DateFormatter.parseDate(requestEndDtAsStr,
//                    IAppsConstants.DATEFORMAT_D_M_Y).getTime());
        } catch (Exception e) {
            this.requestEndDt = null;
        }
    }

    public int getProductOrderListNum() {
        return productOrderListNum;
    }

    public void setProductOrderListNum(int productOrderListNum) {
        this.productOrderListNum = productOrderListNum;
    }

    public int getPackageOrderListNum() {
        return packageOrderListNum;
    }

    public void setPackageOrderListNum(int packageOrderListNum) {
        this.packageOrderListNum = packageOrderListNum;
    }

    public List<PackageOrderTO> getPackageOrderList() {
		return packageOrderList;
	}

	public void setPackageOrderList(List<PackageOrderTO> packageOrderList) {
		this.packageOrderList = packageOrderList;
	}

	public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getOrderRefNum() {
        return orderRefNum;
    }

    public void setOrderRefNum(String orderRefNum) {
        this.orderRefNum = orderRefNum;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getLastEmailNotificationTo() {
        return lastEmailNotificationTo;
    }

    public void setLastEmailNotificationTo(String lastEmailNotificationTo) {
        this.lastEmailNotificationTo = lastEmailNotificationTo;
    }

    public Timestamp getLastEmailNotificationDt() {
        return lastEmailNotificationDt;
    }

    public String getLastEmailNotificationDtAsStr() {
    	 return DateFormatUtils.format(this.lastEmailNotificationDt, IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
    }

    public void setLastEmailNotificationDt(Timestamp lastEmailNotificationDt) {
        this.lastEmailNotificationDt = lastEmailNotificationDt;
    }

    public Timestamp getRequestedDt() {
        return lastEmailNotificationDt;
    }

    public void setRequestedDt(Timestamp lastEmailNotificationDt) {
        this.lastEmailNotificationDt = lastEmailNotificationDt;
    }
    
    public void setRequestDtAsStr(String requestDtAsStr) {
    	try {
			this.requestDtAsStr = requestDtAsStr.trim();
//			this.requestDt = new Timestamp(DateFormatter.parseDate(
//					requestDtAsStr, IAppsConstants.DATEFORMAT_D_M_Y_H_M_S).getTime());
		} catch (Exception e) {
			this.requestDt = null;
		}
	}

	public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public Timestamp getRequestDt() {
        return requestDt;
    }

    public String getRequestDtAsStr() {
    	if (!StringUtils.isEmpty(this.requestDtAsStr)) {
			return this.requestDtAsStr;
		}
		try {
			this.requestDtAsStr = DateFormatUtils.format(this.getRequestDt(),
					IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
		} catch (Exception e) {
			this.requestDtAsStr = "";
		}
		return this.requestDtAsStr;
    }
    

    public void setRequestDt(Timestamp requestDt) {
        this.requestDt = requestDt;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Timestamp getRequestStartDt() {
        return requestStartDt;
    }

    public void setRequestStartDt(Timestamp requestStartDt) {
        this.requestStartDt = requestStartDt;
    }

    public Timestamp getRequestEndDt() {
        return requestEndDt;
    }

    public void setRequestEndDt(Timestamp requestEndDt) {
        this.requestEndDt = requestEndDt;
    }

}
