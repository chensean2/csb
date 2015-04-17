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

public class DomainUserPrivilegeTO {

    private static final long serialVersionUID = -4095143636798901732L;

    private String domainId;
    private String userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String mailFax;
    private String faxMail;
    private String mailSms;
    private String mailBlast;
    private String smsBlast;
    private String faxBlast;
    private String dayUsageMailFax;
    private String dayUsageMailSms;
    //private String role;
    private String groupId;
    private String resourceId;
    private int mailfaxThreshold;
    private int mailsmsThreshold;

	public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    /*public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }*/

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public int getMailfaxThreshold() {
		return mailfaxThreshold;
	}

	public void setMailfaxThreshold(int mailfaxThreshold) {
		this.mailfaxThreshold = mailfaxThreshold;
	}

	public int getMailsmsThreshold() {
		return mailsmsThreshold;
	}

	public void setMailsmsThreshold(int mailsmsThreshold) {
		this.mailsmsThreshold = mailsmsThreshold;
	}

}
