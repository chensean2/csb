/*
 * =========================================================================
 *  Program Name: com.saas.common.to.DomainTO
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

import java.sql.Timestamp;
import java.util.Calendar;

import org.apache.commons.lang3.time.DateFormatUtils;

import com.csb.common.IAppsConstants;

public class DomainTO extends SCBaseTO {

    private static final long serialVersionUID = -4095643636798908733L;
    
    private String domainId;
    private String domainName;
    private String resellerId;
    private String tenantId;
    private int userCountTotal;
    private String userCountTotalAsStr;
    private int userCountAssigned;
    private String userCountAssignedAsStr;
    private int userCountBasic;
    private String userCountBasicAsStr;
    private String isActiveInd="Y";
    private String isReadyInd;
    private String isTrialInd;
    private java.util.Date trialStartDt;
    private int newPasswordEffectiveMins;
    private String newPasswordEffectiveMinsAsStr;
    private int passwordEffectiveDays;
    private String passwordEffectiveDaysAsStr;
    private int lockedAcctDurationMins;
    private String lockedAcctDurationMinsAsStr;
    private int loginAttempts;
    private String loginAttemptsAsStr;
    private int challengeLockDurationMins;
    private String challengeLockDurationMinsAsStr;
    private int challengeAttempts;
    private String challengeAttemptsAsStr;
    private String challengeContact;
    private String resellerIndicator;//RESELLER_INDICATOR
    private String termOfConditionIndicate;
	private Timestamp termOfConditionDt;
	private String termOfConditionDtAsString;
	private String domainType;

    public String getResellerId() {
        return resellerId;
    }

    public void setResellerId(String resellerId) {
        this.resellerId = resellerId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
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

    public String getChallengeContact() {
        return challengeContact;
    }

    public void setChallengeContact(String challengeContact) {
        this.challengeContact = challengeContact;
    }

    public int getUserCountTotal() {
        return userCountTotal;
    }

    public void setUserCountTotal(int userCountTotal) {
        this.userCountTotal = userCountTotal;
        if(userCountTotal!=0){
            this.userCountTotalAsStr = Integer.toString(userCountTotal).trim();
        }else{
            this.userCountTotalAsStr="";
        }
       
    }

    public int getUserCountAssigned() {
        return userCountAssigned;
    }

    public void setUserCountAssigned(int userCountAssigned) {
        this.userCountAssigned = userCountAssigned;
        if(userCountAssigned!=0){
            this.userCountAssignedAsStr = Integer.toString(userCountAssigned).trim();
        }else{
            this.userCountAssignedAsStr="";
        }
    }

    public int getUserCountBasic() {
        return userCountBasic;
    }

    public void setUserCountBasic(int userCountBasic) {
        this.userCountBasic = userCountBasic;
        if(userCountBasic!=0){
            this.userCountBasicAsStr = Integer.toString(userCountBasic).trim();
        }else{
            this.userCountBasicAsStr="";
        }
    }

    public String getIsActiveInd() {
        return isActiveInd;
    }

    public void setIsActiveInd(String isActiveInd) {
        this.isActiveInd = isActiveInd;
    }

    public String getIsReadyInd() {
        return isReadyInd;
    }

    public void setIsReadyInd(String isReadyInd) {
        this.isReadyInd = isReadyInd;
    }

    public String getIsTrialInd() {
        return isTrialInd;
    }

    public void setIsTrialInd(String isTrialInd) {
        this.isTrialInd = isTrialInd;
    }

    public java.util.Date getTrialStartDt() {
        return trialStartDt;
    }

    public void setTrialStartDt(java.util.Date trialStartDt) {
        this.trialStartDt = trialStartDt;
    }

    public int getNewPasswordEffectiveMins() {
        return newPasswordEffectiveMins;
    }

    public void setNewPasswordEffectiveMins(int newPasswordEffectiveMins) {
        this.newPasswordEffectiveMins = newPasswordEffectiveMins;
        if(newPasswordEffectiveMins!=0){
            this.newPasswordEffectiveMinsAsStr = Integer.toString(newPasswordEffectiveMins).trim();
        }else{
            this.newPasswordEffectiveMinsAsStr="";
        }
       
    }

    public int getPasswordEffectiveDays() {
        return passwordEffectiveDays;
    }

    public void setPasswordEffectiveDays(int passwordEffectiveDays) {
        this.passwordEffectiveDays = passwordEffectiveDays;
        if(passwordEffectiveDays!=0){
            this.passwordEffectiveDaysAsStr = Integer.toString(passwordEffectiveDays).trim();
        }else{
            this.passwordEffectiveDaysAsStr="";
        }
    }

    public int getLockedAcctDurationMins() {
        return lockedAcctDurationMins;
    }

    public void setLockedAcctDurationMins(int lockedAcctDurationMins) {
        this.lockedAcctDurationMins = lockedAcctDurationMins;
        if(lockedAcctDurationMins!=0){
            this.lockedAcctDurationMinsAsStr = Integer.toString(lockedAcctDurationMins).trim();
        }else{
            this.lockedAcctDurationMinsAsStr="";
        }
    }

    public int getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(int loginAttempts) {
        this.loginAttempts = loginAttempts;
        if(loginAttempts!=0){
            this.loginAttemptsAsStr = Integer.toString(loginAttempts).trim();
        }else{
            this.loginAttemptsAsStr="";
        }
    }

    public int getChallengeLockDurationMins() {
        return challengeLockDurationMins;
    }

    public void setChallengeLockDurationMins(int challengeLockDurationMins) {
        this.challengeLockDurationMins = challengeLockDurationMins;
        if(challengeLockDurationMins!=0){
            this.challengeLockDurationMinsAsStr = Integer.toString(challengeLockDurationMins).trim();
        }else{
            this.challengeLockDurationMinsAsStr="";
        }
    }

    public int getChallengeAttempts() {
        return challengeAttempts;
    }

    public void setChallengeAttempts(int challengeAttempts) {
        this.challengeAttempts = challengeAttempts;
        if(challengeAttempts!=0){
            this.challengeAttemptsAsStr = Integer.toString(challengeAttempts).trim();
        }else{
            this.challengeAttemptsAsStr="";
        }
    }

    public String getUserCountTotalAsStr() {
        return userCountTotalAsStr;
    }

    public void setUserCountTotalAsStr(String userCountTotalAsStr) {
        this.userCountTotalAsStr = userCountTotalAsStr;
        try{
        this.userCountTotal = Integer.parseInt(userCountTotalAsStr);
        }catch(Exception e){
            
        }
    }

    public String getUserCountAssignedAsStr() {
        return userCountAssignedAsStr;
    }

    public void setUserCountAssignedAsStr(String userCountAssignedAsStr) {
        this.userCountAssignedAsStr = userCountAssignedAsStr;
        try{
        this.userCountAssigned = Integer.parseInt(userCountAssignedAsStr);
        }catch(Exception e){
        }
    }

    public String getUserCountBasicAsStr() {
        return userCountBasicAsStr;
    }

    public void setUserCountBasicAsStr(String userCountBasicAsStr) {
        this.userCountBasicAsStr = userCountBasicAsStr;
        try{
        this.userCountBasic = Integer.parseInt(userCountBasicAsStr);
        }catch(Exception e){
        }
    }

    public String getNewPasswordEffectiveMinsAsStr() {
        return newPasswordEffectiveMinsAsStr;
    }

    public void setNewPasswordEffectiveMinsAsStr(String newPasswordEffectiveMinsAsStr) {
        this.newPasswordEffectiveMinsAsStr = newPasswordEffectiveMinsAsStr;
        try{
        this.newPasswordEffectiveMins = Integer.parseInt(newPasswordEffectiveMinsAsStr);
        }catch(Exception e){
        }
    }

    public String getPasswordEffectiveDaysAsStr() {
        return passwordEffectiveDaysAsStr;
    }

    public void setPasswordEffectiveDaysAsStr(String passwordEffectiveDaysAsStr) {
        this.passwordEffectiveDaysAsStr = passwordEffectiveDaysAsStr;
        try{
        this.passwordEffectiveDays = Integer.parseInt(passwordEffectiveDaysAsStr);
        }catch(Exception e){
        }
    }

    public String getLockedAcctDurationMinsAsStr() {
        return lockedAcctDurationMinsAsStr;
    }

    public void setLockedAcctDurationMinsAsStr(String lockedAcctDurationMinsAsStr) {
        this.lockedAcctDurationMinsAsStr = lockedAcctDurationMinsAsStr;
        try{
        this.lockedAcctDurationMins = Integer.parseInt(lockedAcctDurationMinsAsStr);
        }catch(Exception e){
        }
    }

    public String getLoginAttemptsAsStr() {
        return loginAttemptsAsStr;
    }

    public void setLoginAttemptsAsStr(String loginAttemptsAsStr) {
        this.loginAttemptsAsStr = loginAttemptsAsStr;
        try{
        this.loginAttempts = Integer.parseInt(loginAttemptsAsStr);
        }catch(Exception e){
        }
    }

    public String getChallengeLockDurationMinsAsStr() {
        return challengeLockDurationMinsAsStr;
    }

    public void setChallengeLockDurationMinsAsStr(String challengeLockDurationMinsAsStr) {
        this.challengeLockDurationMinsAsStr = challengeLockDurationMinsAsStr;
        try{
        this.challengeLockDurationMins = Integer.parseInt(challengeLockDurationMinsAsStr);
        }catch(Exception e){
        }
    }

    public String getChallengeAttemptsAsStr() {
        return challengeAttemptsAsStr;
    }

    public void setChallengeAttemptsAsStr(String challengeAttemptsAsStr) {
        this.challengeAttemptsAsStr = challengeAttemptsAsStr;
        try{
        this.challengeAttempts = Integer.parseInt(challengeAttemptsAsStr);
        }catch(Exception e){
        }
    }

	public String getResellerIndicator() {
		return resellerIndicator;
	}

	public void setResellerIndicator(String resellerIndicator) {
		this.resellerIndicator = resellerIndicator;
	}

	public String getTermOfConditionIndicate() {
		return termOfConditionIndicate;
	}

	public void setTermOfConditionIndicate(String termOfConditionIndicate) {
		this.termOfConditionIndicate = termOfConditionIndicate;
	}
    public Timestamp getTermOfConditionDt() {
        return termOfConditionDt;
    }

	public void setTermOfConditionDt(Timestamp termOfConditionDt) {
		this.termOfConditionDt = termOfConditionDt;

	}

	public String getTermOfConditionDtAsString() {
		try {
			this.termOfConditionDtAsString = DateFormatUtils.format(
					this.termOfConditionDt,
					IAppsConstants.DATEFORMAT_D_MMM_Y_H_M_S);
		} catch (Exception e) {
			this.termOfConditionDtAsString = "";
		}
		return termOfConditionDtAsString;
	}

	public void setTermOfConditionDtAsString(String termOfConditionDtAsString) {
		try {
			this.termOfConditionDtAsString = termOfConditionDtAsString;
			Calendar c = Calendar.getInstance();
//			c.setTime(DateFormatter.parseDate(termOfConditionDtAsString.trim(),
//					IAppsConstants.DATEFORMAT_D_MMM_Y_H_M_S));
			this.termOfConditionDt = new Timestamp(c.getTime().getTime());
		} catch (Exception e) {
			this.termOfConditionDt = null;
		}
	}
	
    public String getDomainType() {
        return domainType;
    }

    public void setDomainType(String domainType) {
        this.domainType = domainType;
    }
}
