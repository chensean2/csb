/*
 * =========================================================================
 *  Program Name: com.saas.common.to.DomainUserPrivilegeTO
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

package com.saas.common.to;

public class ResellerDomainPrivilegeTO {

    private static final long serialVersionUID = -4095143636798901732L;

    private String resellerId;
    private String domainId;
    private String domainName;
    private String mailFax;
    private String faxMail;
    private String mailSms;
    private String mailBlast;
    private String smsBlast;
    private String faxBlast;
    private String dayUsageMailFax;
    private String dayUsageMailSms;
	public String getResellerId() {
		return resellerId;
	}
	public void setResellerId(String resellerId) {
		this.resellerId = resellerId;
	}
	public String getDomainId() {
		return domainId;
	}
	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public String getMailFax() {
		return mailFax;
	}
	public void setMailFax(String mailFax) {
		this.mailFax = mailFax;
	}
	public String getFaxMail() {
		return faxMail;
	}
	public void setFaxMail(String faxMail) {
		this.faxMail = faxMail;
	}
	public String getMailSms() {
		return mailSms;
	}
	public void setMailSms(String mailSms) {
		this.mailSms = mailSms;
	}
	public String getMailBlast() {
		return mailBlast;
	}
	public void setMailBlast(String mailBlast) {
		this.mailBlast = mailBlast;
	}
	public String getSmsBlast() {
		return smsBlast;
	}
	public void setSmsBlast(String smsBlast) {
		this.smsBlast = smsBlast;
	}
	public String getFaxBlast() {
		return faxBlast;
	}
	public void setFaxBlast(String faxBlast) {
		this.faxBlast = faxBlast;
	}
	public String getDayUsageMailFax() {
		return dayUsageMailFax;
	}
	public void setDayUsageMailFax(String dayUsageMailFax) {
		this.dayUsageMailFax = dayUsageMailFax;
	}
	public String getDayUsageMailSms() {
		return dayUsageMailSms;
	}
	public void setDayUsageMailSms(String dayUsageMailSms) {
		this.dayUsageMailSms = dayUsageMailSms;
	}
    

}
