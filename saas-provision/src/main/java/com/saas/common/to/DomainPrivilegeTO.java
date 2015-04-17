/*
 * =========================================================================
 *  Program Name: com.saas.common.to.domainPrivilegeTO
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

public class DomainPrivilegeTO extends SCBaseTO {

    private static final long serialVersionUID = -4095643636798908733L;
    
    private String domainID;
    private String mailfax;
    private String faxmail;
    private String mailsms;
    private String mailblast;
    private String smsblast;
    private String faxblast;
	public String getDomainID() {
		return domainID;
	}
	public void setDomainID(String domainID) {
		this.domainID = domainID;
	}
	public String getMailfax() {
		return mailfax;
	}
	public void setMailfax(String mailfax) {
		this.mailfax = mailfax;
	}
	public String getFaxmail() {
		return faxmail;
	}
	public void setFaxmail(String faxmail) {
		this.faxmail = faxmail;
	}
	public String getMailsms() {
		return mailsms;
	}
	public void setMailsms(String mailsms) {
		this.mailsms = mailsms;
	}
	public String getMailblast() {
		return mailblast;
	}
	public void setMailblast(String mailblast) {
		this.mailblast = mailblast;
	}
	public String getSmsblast() {
		return smsblast;
	}
	public void setSmsblast(String smsblast) {
		this.smsblast = smsblast;
	}
	public String getFaxblast() {
		return faxblast;
	}
	public void setFaxblast(String faxblast) {
		this.faxblast = faxblast;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
}
