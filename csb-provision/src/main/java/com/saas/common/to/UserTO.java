/*
 * =========================================================================
 *  Program Name: com.saas.common.to.UserTO
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
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.format.datetime.DateFormatter;

import com.csb.common.IAppsConstants;

public class UserTO extends SCBaseTO {

	private static final long serialVersionUID = -7191032974506083000L;

	private String userId;
	private String loginId;
	private String userName;
	private String domainId;
	private String password;
	private java.sql.Timestamp lastPasswordChangeDt;// Date
	private java.sql.Timestamp newPasswordGenDt;
	private String challengeQuestion;
	private String challengeQuestion1;
	private String challengeAnswer;
	private String challengeAnswer1;
	private String challengeMobileNum;
	private String challengeEmail;
	private Date challengeFailDt;
	private int challengeCount;
	private String accountStatus;
	private String accountSessionStatus;
	private java.sql.Timestamp accountSessionDt;
	private java.sql.Timestamp accountStatusDt;
	private java.sql.Timestamp accountDisabledDt;
	private java.sql.Timestamp lastLoginDt;
	private java.sql.Timestamp lastLoginFailDt;
	private int loginFailCount;
	private String authStr;
	private String exchangeEmail;
	private String exchangePassword;
	private String googlePassword;
	private String baseDomainId;
	private String pgroupCode;
	private String displayName;
	private String firstName;
	private String lastName;
	private String designation;
	private String email;
	private String phoneNum;
	private String mobileNum;
	private String userType;
	private String pgroupname;
	private String rolesId[];
	private String provisionStatus;
	private String errorCode;
	private String errorDesc;
	private String resourcesId;
	private String notificationMail;
	private String domainName;
	private String memberEmail;
	private java.lang.String existInd = IAppsConstants.IND_NO;
	private String additionalFieldsValue;
	private String priContactInd;
	private String noExpiryInd;
	private String remarks;
	private String disableReason;
	private String tenantName;

	private String accountSessionDtAsStr;
	private String accountStatusDtAsStr;
	private String accountDisabledDtAsStr;
	private String lastLoginDtAsStr;
	private String trustedIP;// TRUSTED_IP
	private String loginRoleName;// RESOURCE_NAME
	private String loginRoleId;// RESOURCES_ID
	private String emailIndicateNotification;// EMAIL_NOTIFICATION_INDICATE
	private String smsIndicateNotification; // SMS_NOTIFICATION_INDICATE
	private String emailPasswordIndicate;
	private String smsPasswordIndicate;

	private String isHaveGoogleApp;
	private String googleAppDomainProductId;
	private String termOfConditionIndicate;
	private Timestamp startDt;
	private String startDateAsString;
	private Timestamp endDt;
	private String endDateAsString;
	private String companyName;
	private String extBusinessAccountNum;
	
	private Timestamp termOfConditionDt;
	private String termOfConditionDtAsString;
	private Timestamp lastSendPwdRemainderDt; 
	private String nickNames[];
	private String userBaseDN;
	private String stayLoginIndicator;
	private Timestamp sessionExpiryDt;
	
	private String termOfConditionServiceName;// for termOfCondition product
	private String orgNumber;// for Synchronous Call to QK During Customer creation and User creation, ref to tenant.ext1

	public String getTermOfConditionServiceName() {
		return termOfConditionServiceName;
	}

	public void setTermOfConditionServiceName(String termOfConditionServiceName) {
		this.termOfConditionServiceName = termOfConditionServiceName;
	}

	public Timestamp getLastSendPwdRemainderDt() {
		return lastSendPwdRemainderDt;
	}

	public void setLastSendPwdRemainderDt(Timestamp lastSendPwdRemainderDt) {
		this.lastSendPwdRemainderDt = lastSendPwdRemainderDt;
	}

	public Timestamp getStartDt() {
            return startDt;
        }
	
	    public void setStartDt(Timestamp startDt) {
	        try {
	            this.startDt = startDt;
	        } catch (Exception e) {
	        }
	    }
	    
	    public String getStartDateAsString() {
	        return startDateAsString;
	    }

	    public void setStartDateAsString(String startDateAsString) {
	                try {
	                        this.startDateAsString = startDateAsString;
//	                        this.startDt = new Timestamp(DateFormatter.parseDate(
//	                                        startDateAsString, IAppsConstants.DATEFORMAT_D_M_Y)
//	                                        .getTime());
	                } catch (Exception e) {
	                        this.startDt = null;
	                }
	    }
	    
	    public Timestamp getEndDt() {
	        return endDt;
	    }

	    public void setEndDt(Timestamp endDt) {
	        try {
	            this.endDt = endDt;
	        } catch (Exception e) {
	        }
	    }

	    public String getEndDateAsString() {
	        return endDateAsString;
	    }

	        public void setEndDateAsString(String endDateAsString) {
	                try {
	                        this.endDateAsString = endDateAsString;
	                        Calendar c = Calendar.getInstance();
//	                        c.setTime(DateFormatter.parseDate(endDateAsString.trim(),
//	                                        IAppsConstants.DATEFORMAT_D_M_Y));
	                        this.endDt = new Timestamp(c.getTime().getTime());
	                } catch (Exception e) {
	                        this.endDt = null;
	                }
	        }

	public String getIsHaveGoogleApp() {
		return isHaveGoogleApp;
	}

	public void setIsHaveGoogleApp(String isHaveGoogleApp) {
		this.isHaveGoogleApp = isHaveGoogleApp;
	}

	public String getGoogleAppDomainProductId() {
		return googleAppDomainProductId;
	}

	public void setGoogleAppDomainProductId(String googleAppDomainProductId) {
		this.googleAppDomainProductId = googleAppDomainProductId;
	}

	public String getEmailPasswordIndicate() {
		return emailPasswordIndicate;
	}

	public void setEmailPasswordIndicate(String emailPasswordIndicate) {
		this.emailPasswordIndicate = emailPasswordIndicate;
	}

	public String getSmsPasswordIndicate() {
		return smsPasswordIndicate;
	}

	public void setSmsPasswordIndicate(String smsPasswordIndicate) {
		this.smsPasswordIndicate = smsPasswordIndicate;
	}

	public java.sql.Timestamp getAccountStatusDt() {
		return accountStatusDt;
	}

	public void setAccountStatusDt(java.sql.Timestamp accountStatusDt) {
		this.accountStatusDt = accountStatusDt;
	}

	public String getAdditionalFieldsValue() {
		return additionalFieldsValue;
	}

	public void setAdditionalFieldsValue(String additionalFieldsValue) {
		this.additionalFieldsValue = additionalFieldsValue;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public java.lang.String getExistInd() {
		return existInd;
	}

	public void setExistInd(java.lang.String existInd) {
		this.existInd = existInd;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String[] getRolesId() {
		return rolesId;
	}

	public void setRolesId(String[] rolesId) {
		this.rolesId = rolesId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getChallengeQuestion() {
		return challengeQuestion;
	}

	public void setChallengeQuestion(String challengeQuestion) {
		this.challengeQuestion = challengeQuestion;
	}

	public String getChallengeAnswer() {
		return challengeAnswer;
	}

	public void setChallengeAnswer(String challengeAnswer) {
		this.challengeAnswer = challengeAnswer;
	}

	public String getChallengeMobileNum() {
		return challengeMobileNum;
	}

	public void setChallengeMobileNum(String challengeMobileNum) {
		this.challengeMobileNum = challengeMobileNum;
	}

	public String getChallengeEmail() {
		return challengeEmail;
	}

	public void setChallengeEmail(String challengeEmail) {
		this.challengeEmail = challengeEmail;
	}

	public Date getChallengeFailDt() {
		return challengeFailDt;
	}

	public void setChallengeFailDt(Date challengeFailDt) {
		this.challengeFailDt = challengeFailDt;
	}

	public int getChallengeCount() {
		return challengeCount;
	}

	public void setChallengeCount(int challengeCount) {
		this.challengeCount = challengeCount;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getAccountSessionStatus() {
		return accountSessionStatus;
	}

	public void setAccountSessionStatus(String accountSessionStatus) {
		this.accountSessionStatus = accountSessionStatus;
	}

	public java.sql.Timestamp getAccountSessionDt() {
		return accountSessionDt;
	}

	public void setAccountSessionDt(java.sql.Timestamp accountSessionDt) {
		this.accountSessionDt = accountSessionDt;
	}

	public void setLoginFailCount(int loginFailCount) {
		this.loginFailCount = loginFailCount;
	}

	public String getAuthStr() {
		return authStr;
	}

	public java.sql.Timestamp getLastPasswordChangeDt() {
		return lastPasswordChangeDt;
	}

	public void setLastPasswordChangeDt(java.sql.Timestamp lastPasswordChangeDt) {
		this.lastPasswordChangeDt = lastPasswordChangeDt;
	}

	public java.sql.Timestamp getNewPasswordGenDt() {
		return newPasswordGenDt;
	}

	public void setNewPasswordGenDt(java.sql.Timestamp newPasswordGenDt) {
		this.newPasswordGenDt = newPasswordGenDt;
	}

	public java.sql.Timestamp getAccountDisabledDt() {
		return accountDisabledDt;
	}

	public void setAccountDisabledDt(java.sql.Timestamp accountDisabledDt) {
		this.accountDisabledDt = accountDisabledDt;
	}

	public java.sql.Timestamp getLastLoginFailDt() {
		return lastLoginFailDt;
	}

	public void setLastLoginFailDt(java.sql.Timestamp lastLoginFailDt) {
		this.lastLoginFailDt = lastLoginFailDt;
	}

	public int getLoginFailCount() {
		return loginFailCount;
	}

	public void setAuthStr(String authStr) {
		this.authStr = authStr;
	}

	public String getExchangeEmail() {
		return exchangeEmail;
	}

	public void setExchangeEmail(String exchangeEmail) {
		this.exchangeEmail = exchangeEmail;
	}

	public String getExchangePassword() {
		return exchangePassword;
	}

	public void setExchangePassword(String exchangePassword) {
		this.exchangePassword = exchangePassword;
	}

	public String getGooglePassword() {
		return googlePassword;
	}

	public void setGooglePassword(String googlePassword) {
		this.googlePassword = googlePassword;
	}

	public String getBaseDomainId() {
		return baseDomainId;
	}

	public void setBaseDomainId(String baseDomainId) {
		this.baseDomainId = baseDomainId;
	}

	public String getPgroupCode() {
		return pgroupCode;
	}

	public void setPgroupCode(String pgroupCode) {
		this.pgroupCode = pgroupCode;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPgroupname() {
		return pgroupname;
	}

	public void setPgroupname(String pgroupname) {
		this.pgroupname = pgroupname;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public java.sql.Timestamp getLastLoginDt() {
		return lastLoginDt;
	}

	public void setLastLoginDt(java.sql.Timestamp lastLoginDt) {
		this.lastLoginDt = lastLoginDt;
	}

	public String getProvisionStatus() {
		return provisionStatus;
	}

	public void setProvisionStatus(String provisionStatus) {
		this.provisionStatus = provisionStatus;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	public String getResourcesId() {
		return resourcesId;
	}

	public void setResourcesId(String resourcesId) {
		this.resourcesId = resourcesId;
	}

	public String getNotificationMail() {
		return notificationMail;
	}

	public void setNotificationMail(String notificationMail) {
		this.notificationMail = notificationMail;
	}

	public String getPriContactInd() {
		return priContactInd;
	}

	public void setPriContactInd(String priContactInd) {
		this.priContactInd = priContactInd;
	}

	public String getNoExpiryInd() {
		return noExpiryInd;
	}

	public void setNoExpiryInd(String noExpiryInd) {
		this.noExpiryInd = noExpiryInd;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDisableReason() {
		return disableReason;
	}

	public void setDisableReason(String disableReason) {
		this.disableReason = disableReason;
	}

	public String getChallengeQuestion1() {
		return challengeQuestion1;
	}

	public void setChallengeQuestion1(String challengeQuestion1) {
		this.challengeQuestion1 = challengeQuestion1;
	}

	public String getChallengeAnswer1() {
		return challengeAnswer1;
	}

	public void setChallengeAnswer1(String challengeAnswer1) {
		this.challengeAnswer1 = challengeAnswer1;
	}

	public String getAccountSessionDtAsStr() {
		if (!StringUtils.isEmpty(this.accountSessionDtAsStr)) {
			return this.accountSessionDtAsStr;
		}
		try {
			this.accountSessionDtAsStr = DateFormatUtils.format(this
					.getAccountSessionDt(),
					IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
		} catch (Exception e) {
			this.accountSessionDtAsStr = "";
		}
		return this.accountSessionDtAsStr;
	}

	public String getAccountStatusDtAsStr() {
		if (!StringUtils.isEmpty(this.accountStatusDtAsStr)) {
			return this.accountStatusDtAsStr;
		}
		try {
			this.accountStatusDtAsStr = DateFormatUtils.format(this
					.getAccountStatusDt(),
					IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
		} catch (Exception e) {
			this.accountStatusDtAsStr = "";
		}
		return this.accountStatusDtAsStr;
	}

	public void setAccountSessionDtAsStr(String accountSessionDtAsStr) {
		this.accountSessionDtAsStr = accountSessionDtAsStr;
	}

	public void setAccountStatusDtAsStr(String accountStatusDtAsStr) {
		this.accountStatusDtAsStr = accountStatusDtAsStr;
	}

	public void setAccountDisabledDtAsStr(String accountDisabledDtAsStr) {
		this.accountDisabledDtAsStr = accountDisabledDtAsStr;
	}

	public String getAccountDisabledDtAsStr() {
		if (!StringUtils.isEmpty(this.accountDisabledDtAsStr)) {
			return this.accountDisabledDtAsStr;
		}
		try {
			this.accountDisabledDtAsStr = DateFormatUtils.format(this
					.getAccountDisabledDt(),
					IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
		} catch (Exception e) {
			this.accountDisabledDtAsStr = "";
		}
		return this.accountDisabledDtAsStr;
	}

	public String getLastLoginDtAsStr() {
		if (!StringUtils.isEmpty(this.lastLoginDtAsStr)) {
			return this.lastLoginDtAsStr;
		}
		try {
			this.lastLoginDtAsStr = DateFormatUtils.format(this
					.getLastLoginDt(), IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
		} catch (Exception e) {
			this.lastLoginDtAsStr = "";
		}
		return this.lastLoginDtAsStr;
	}

	public void setLastLoginDtAsStr(String lastLoginDtAsStr) {
		this.lastLoginDtAsStr = lastLoginDtAsStr;
	}

	public String getTrustedIP() {
		return trustedIP;
	}

	public void setTrustedIP(String trustedIP) {
		this.trustedIP = trustedIP;
	}

	public String getLoginRoleName() {
		return loginRoleName;
	}

	public void setLoginRoleName(String loginRoleName) {
		this.loginRoleName = loginRoleName;
	}

	public String getLoginRoleId() {
		return loginRoleId;
	}

	public void setLoginRoleId(String loginRoleId) {
		this.loginRoleId = loginRoleId;
	}

	public String getEmailIndicateNotification() {
		return emailIndicateNotification;
	}

	public void setEmailIndicateNotification(String emailIndicateNotification) {
		this.emailIndicateNotification = emailIndicateNotification;
	}

	public String getSmsIndicateNotification() {
		return smsIndicateNotification;
	}

	public void setSmsIndicateNotification(String smsIndicateNotification) {
		this.smsIndicateNotification = smsIndicateNotification;
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
                this.termOfConditionDtAsString = DateFormatUtils.format(this
                                .termOfConditionDt,
                                IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
        } catch (Exception e) {
                this.termOfConditionDtAsString = "";
        }
        return termOfConditionDtAsString;
        }
    
        public void setTermOfConditionDtAsString(String termOfConditionDtAsString) {
            try {
                this.termOfConditionDtAsString = termOfConditionDtAsString;
                Calendar c = Calendar.getInstance();
//                c.setTime(DateFormatter.parseDate(termOfConditionDtAsString.trim(), IAppsConstants.DATEFORMAT_D_M_Y));
                this.termOfConditionDt = new Timestamp(c.getTime().getTime());
            } catch (Exception e) {
                this.termOfConditionDt = null;
            }
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getExtBusinessAccountNum() {
            return extBusinessAccountNum;
        }

        public void setExtBusinessAccountNum(String extBusinessAccountNum) {
            this.extBusinessAccountNum = extBusinessAccountNum;
        }

        public String[] getNickNames() {
            return nickNames;
        }

        public void setNickNames(String[] nickNames) {
            this.nickNames = nickNames;
        }

        public String getOrgNumber() {
            return orgNumber;
        }

        public void setOrgNumber(String orgNumber) {
            this.orgNumber = orgNumber;
        }

		public String getUserBaseDN() {
			return userBaseDN;
		}

		public void setUserBaseDN(String userBaseDN) {
			this.userBaseDN = userBaseDN;
		}
		
		public String getStayLoginIndicator() {
			return stayLoginIndicator;
		}

		public void setStayLoginIndicator(String stayLoginIndicator) {
			this.stayLoginIndicator = stayLoginIndicator;
		}
		
		public Timestamp getSessionExpiryDt() {
			return sessionExpiryDt;
		}

		public void setSessionExpiryDt(Timestamp sessionExpiryDt) {
			this.sessionExpiryDt = sessionExpiryDt;
		}

}
