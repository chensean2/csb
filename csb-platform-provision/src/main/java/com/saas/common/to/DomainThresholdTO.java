/*
 * =========================================================================
 *  Program Name: com.saas.common.to.userThresholdTO
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

public class DomainThresholdTO extends SCBaseTO {

    private static final long serialVersionUID = -4095643636798908733L;
    
    private String domainID;
    private int mailfax;
    private int faxmail;
    private int mailsms;
    private int mailblast;
    private int smsblast;
    private int faxblast;
    private int defMailfax;
    private int defFaxmail;
    private int defMailsms;
    private int defMailblast;
    private int defSmsblast;
    private int defFaxblast;
    
	public int getDefMailfax() {
		return defMailfax;
	}
	public void setDefMailfax(int defMailfax) {
		this.defMailfax = defMailfax;
	}
	public int getDefFaxmail() {
		return defFaxmail;
	}
	public void setDefFaxmail(int defFaxmail) {
		this.defFaxmail = defFaxmail;
	}
	public int getDefMailsms() {
		return defMailsms;
	}
	public void setDefMailsms(int defMailsms) {
		this.defMailsms = defMailsms;
	}
	public int getDefMailblast() {
		return defMailblast;
	}
	public void setDefMailblast(int defMailblast) {
		this.defMailblast = defMailblast;
	}
	public int getDefSmsblast() {
		return defSmsblast;
	}
	public void setDefSmsblast(int defSmsblast) {
		this.defSmsblast = defSmsblast;
	}
	public int getDefFaxblast() {
		return defFaxblast;
	}
	public void setDefFaxblast(int defFaxblast) {
		this.defFaxblast = defFaxblast;
	}
	public String getDomainID() {
		return domainID;
	}
	public void setDomainID(String domainID) {
		this.domainID = domainID;
	}
	public int getMailfax() {
		return mailfax;
	}
	public void setMailfax(int mailfax) {
		this.mailfax = mailfax;
	}
	public int getFaxmail() {
		return faxmail;
	}
	public void setFaxmail(int faxmail) {
		this.faxmail = faxmail;
	}
	public int getMailsms() {
		return mailsms;
	}
	public void setMailsms(int mailsms) {
		this.mailsms = mailsms;
	}
	public int getMailblast() {
		return mailblast;
	}
	public void setMailblast(int mailblast) {
		this.mailblast = mailblast;
	}
	public int getSmsblast() {
		return smsblast;
	}
	public void setSmsblast(int smsblast) {
		this.smsblast = smsblast;
	}
	public int getFaxblast() {
		return faxblast;
	}
	public void setFaxblast(int faxblast) {
		this.faxblast = faxblast;
	}
	
}
