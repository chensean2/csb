/*
 * =========================================================================
 *  Program Name: com.saas.common.IAppsConstants
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
package com.saas.common;

public interface IAppsConstants {

    // define for Common  
    public static final String SAAS_CONFIG = "saas-connect";
    public static final String SAAS_MESSAGE = "messages-saas-nachos";
    public static final String SAAS_MOBILE = "messages-mobile"; 
    public static final String SAAS_PROVISION = "saas-provision";
    public static final String MESSAGE_SAAS_CONFIG = "messages-saas";
    public static final String DATEFORMAT_Y_M_D = "yyyy-MM-dd";
    public static final String TIMESTAMPFORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String TIMESTAMP_TIMEZONEFORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static final String DATEFORMAT_D_M_Y_H_M_S = "dd/MM/yyyy HH:mm:ss";
    public static final String DATEFORMAT_D_MMM_Y_H_M_S = "dd-MMM-yyyy HH:mm:ss";
    public static final String DATEFORMAT_D_MMM_Y = "dd-MMM-yyyy";
    public static final String DATEFORMAT_H_M_S = "HH:mm:ss";
    public static final String DATEFORMAT_D_M_Y = "dd/MM/yyyy";
    public static final String TIME_ZONE = "Asia/Singapore";
    public static final String STATE_DISABLE = "Disable"; 
    public static final String STATE_ENABLE = "Enabled";
    public static final String IND_NO = "N"; 
    public static final String IND_YES = "Y"; 
    public static final String IND_TRUE = "true";
    public static final String IND_FALSE = "false";
    public static final String BY_SYSTEM = "SYSTEM";
    public static final String CREATE = "Create";
    public static final String UPDATE = "Update";
    public static final String DELETE = "Delete";
    public static final String NA = "NA";
    public static final String STATUS_NEW = "NEW";
    public static final String STATUS_ACTIVE = "ACTIVE";
    public static final String STATUS_DISABLED = "DISABLED";
    public static final String STATUS_LOCKED = "LOCKED";
    public static final String SMS_TASK_DATE_REGEX = "^(((0[1-9]|[12]\\d|3[01])\\/(0[13578]|1[02])\\/((19|[2-9]\\d)\\d{2}))|((0[1-9]|[12]\\d|30)\\/(0[13456789]|1[012])\\/((19|[2-9]\\d)\\d{2}))|((0[1-9]|1\\d|2[0-8])\\/02\\/((19|[2-9]\\d)\\d{2}))|(29\\/02\\/((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$";
    public static final String LDAP_SYNC_URL_REGEX = "^((\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.){3}(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])(:[1-9]|:([1-9]\\d)|:([1-9]\\d\\d)|:([1-9]\\d\\d\\d)|:([1-6][0-5][0-5][0-3][0-5]))?$";
    public static final String MOBILE_REGEX = "^[89]([0-9]{7})$";
    public static final String EMAIL_REGEX = "\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
    public static final String USER_TO = "userTO";
    public static final String USER_NAME = "userName";
    public static final String PGROUP_CODE = "pgroupCode";
    public static final String EMAIL = "email";
    public static final String DOMAIN_ID = "domainId";
    public static final String LOGIN_ID = "loginId";
    
    // define for Message
    public static final String ERROR_MESSAGE_UPDATE = "errors.common.update";
    public static final String ERROR_MESSAGE_DELETE = "errors.common.delete";
    public static final String ERROR_MESSAGE_ADD = "errors.common.submit";
    public static final String ERRORS_MESSAGE_REQUIRED = "errors.required";
    public static final String MSG_RECORD_DELETE_ELSEWHERE = "msg.record.deleted.elsewhere";
    public static final String MSG_RECORD_MODIFIED_ELSEWHERE = "msg.record.modified.elsewhere";
    public static final String ERROR_SYSTEM = "errors.common.system";
    public static final String MSG_SITE_CURRENTLY_UNDER_CONSTRUCTION = "msg.site.currently.under.construction";
    public static final String ERROR_MESSAGE_ASSIGN_NO_DEVICE_AVAILABLE = "errors.admin.productmanagement.assign.noDeviceAvailable";

    //QK PARAM MAP
    public static final String QK_SUPPORT_SECRET_KEY = "qksupport.secret.key";
    public static final String QK_SUPPORT_SUPPORT_URL = "qksupport.support.url";
    public static final String QK_SUPPORT_HELPDESK_URL = "qksupport.helpdesk.url";
    public static final String QK_SUPPORT_PROXY_ENABLE = "qksupport.proxy.enable";
    public static final String QK_SUPPORT_PROXY_HOST = "qksupport.proxy.host";
    public static final String QK_SUPPORT_PROXY_PORT = "qksupport.proxy.port";
    public static final String QK_SUPPORT_DEFAULT_USER_ID = "qksupport.default.userId";
    public static final String QK_SUPPORT_DEFAULT_COMPANY_ID = "qksupport.default.companyId";
    public static final String QK_SUPPORT_DEFAULT_USER_ID_READABLE = "qksupport.default.userIdReadable";
    public static final String QK_SUPPORT_DEFAULT_COMPANY_ID_READABLE = "qksupport.default.companyIdReadable";
    public static final String QK_PARAM_KEY = "key";
    public static final String QK_PARAM_COMPANY_ID = "company_id";
    public static final String QK_PARAM_COMPANY_NAME = "company_name";
    public static final String QK_PARAM_USER_ID = "user_id";
    public static final String QK_PARAM_FIRSTNAME = "firstname";
    public static final String QK_PARAM_LASTNAME = "lastname";
    public static final String QK_PARAM_PHONE = "phone";
    public static final String QK_PARAM_MOBILE = "mobile";
    public static final String QK_PARAM_EMAIL = "email";
    public static final String QK_PARAM_CATEGORY = "category";
    public static final String QK_PARAM_MESSAGE = "message";
    public static final String QK_PARAM_COMPANY_ID_READABLE = "company_id_readable";
    public static final String QK_PARAM_USER_ID_READABLE = "user_id_readable";
    public static final String QK_SUPPORT_HELPDESK_REQ_WHOLE_URL = "requestUrl";
    
    // define for Admin Config
    // config.blast.fax
    public static final String ADMIN_CONFIG_BLAST_FAX = "admin.config.blast.fax"; 
    // config.blast.mail
    public static final String ADMIN_CONFIG_BLAST_MAIL = "admin.config.blast.mail"; 
    // config.blast.sms
    public static final String ADMIN_CONFIG_BLAST_SMS = "admin.config.blast.sms"; 
    // config.fax
    public static final String ADMIN_CONFIG_FAX = "admin.config.fax";
    // config.mail.fax
    public static final String ADMIN_CONFIG_MAIL_FAX = "admin.config.mail.fax";
    // config.sync.schedule
    public static final String ADMIN_CONFIG_SYNC_SCHEDULE = "admin.config.sysaaschedule"; 

    // define for Admin Domain
    public static final String ADMIN_DOMAIN_DOMAINID = "domainID";
    // domain.blast.fax
    public static final String ADMIN_DOMAIN_BLASTFAX = "admin.domain.blastfax"; 
    
    // domain.blast.mail
    public static final String ADMIN_DOMAIN_BLASTMAIL = "admin.domain.blastmail"; 
    
    // domain.blast.sms
    public static final String ADMIN_DOMAIN_BLASTSMS = "admin.domain.blastsms";
    // domain.calendar.sync
    public static final String ADMIN_DOMAIN_CALENDAR = "admin.domain.calendar";
    // domain.contact.sync
    public static final String ADMIN_DOMAIN_SYsaasVCCODE_CONTACTS = "CONTACTS";
    public static final String ADMIN_DOMAIN_CONTACT = "admin.domain.contact";
    // domain.directory.sync
    public static final String ADMIN_DOMAIN_DIRECTORY_TYPE_LDAP = "ldap";
    public static final String ADMIN_DOMAIN_DIRECTORY_TYPE_GOOGLE = "google";
    public static final String ADMIN_DOMAIN_DIRECTORY = "domain.directory";
    // domain.fax.user
    public static final String ADMIN_DOMAIN_FAXUSER = "admin.domain.faxuser"; 
    public static final String ADMIN_DOMAIN_FAXUSER_PATH_BAK_FILE = "admin.domain.faxuser.path.bak.file";
    public static final String ADMIN_DOMAIN_FAXUSER_PATH_ERROR_FILE = "admin.domain.faxuser.path.error.file";
    public static final String ADMIN_DOMAIN_ITEM_NUMBER_ERROR = "admin.domain.item.number.error";
    public static final String ADMIN_DOMAIN_USERMAIL_FORMAT_ERROR = "admin.domain.user.email.error";
    public static final String ADMIN_DOMAIN_FIRSTNAME_EMPTY = "admin.domain.first.name.empty";
    public static final String ADMIN_DOMAIN_REMARK_ERROR = "admin.domain.remark.error";
    public static final String ADMIN_DOMAIN_TEL_EMPTY = "admin.domain.telephone.empty";
    public static final String ADMIN_DOMAIN_LASTNAME_EMPTY = "admin.domain.last.name.empty";
    public static final String ADMIN_DOMAIN_NO_DOMAIN_SETTED = "admin.domain.no.domain.set";
    public static final String ADMIN_DOMAIN_ERROR_MESSAGE = "admin.domain.error.message";
    public static final String ADMIN_DOMAIN_HEAD_NOT_MATCH = "admin.domain.head.not.match";
    public static final String ADMIN_DOMAIN_FAXUSER_LABEL_HEAD = "admin.domain.faxuser.lable.header";
    // domain.gapps
    public static final String ADMIN_DOMAIN_GAPPS = "admin.domain.gapps"; 
    // domain.imap
    public static final String ADMIN_DOMAIN_IMAP = "admin.domain.imap";
    // domain.ldap
    public static final String ADMIN_DOMAIN_IDAP = "admin.domain.idap"; 
    // domain.mail.fax
    public static final String ADMIN_DOMAIN_MAIL_FAX = "admin.domain.mailfax";
    // domain.mta
    public static final String ADMIN_DOMAIN_MTA = "admin.domain.mta";
    // domain.user.sync
    public static final String ADMIN_DOMAIN_USER = "admin.domain.user"; 
    // domain.webdav
    public static final String ADMIN_DOMAIN_WEBDAV = "admin.domain.webdav";

    // define for Admin reseller
    public static final String ADMIN_RESELLER = "admin.reseller";
    public static final String ADMIN_RESELLER_ADMIN = "admin.reseller.admin";

    // define for Admin tenant
    public static final String ADMIN_TENANT = "admin.tenant";
    
    // define for Admin termCondition
    public static final String ADMIN_TERM_CONDITION = "admin.term.condition";

    // define for Blast Base
    public static final String BLAST_JOB_STATUS_COMPLETED = "CP"; // completed
    public static final String BLAST_JOB_STATUS_ABORT = "AB"; 
    public static final String BLAST_JOB = "blast.job";
    public static final String BLAST_JOB_BATCH = "blast.job.batch";
    public static final String BLAST_JOB_BATCH_STATUS = "blast.job.batch.status";
    public static final String BLAST_JOB_STATUS = "blast.job.status";
    // blast job status
    public static final int BLAST_JOB_STATUS_REQUEST_RECEIVE_SUCCESS = 1;
    public static final int BLAST_JOB_STATUS_RESPONSE_MAIL_SENT_SUCCESS = 2;
    public static final int BLAST_JOB_STATUS_RESPONSE_MAIL_SENT_FAILED = 3;

    // defined for campaign
    public static final String  CAMPAIGN_UPLOAD_BLAST_LIST_SIZE = "campaign.upload.blast.list.size";
    public static final String CAMPAIGN_BLAST_LIST = "campaign.blast.list";
    public static final String CAMPAIGN_BLAST_TASK = "campaign.blast.task";
    public static final String CAMPAIGN_LABEL_HEAD = "campaign.label.head"; 
    public static final String CAMPAIGN_BLAST_TASK_DELETE_INDICATOR_YES = "Y";
    public static final String CAMPAIGN_BLAST_TASK_MAX_ATTACHMENT_SIZE = "campaign.blast.task.attach.size";

    // define for Common
    public static final String CodeBlastJobStatusComplete = "CP";
    public static final String CodeBlastJobItemStatusFailure = "F";
    public static final String CodeBlastJobItemStatusSuccess = "S";
    public static final String COMMON_USER = "label.admin.user"; 
    public static final String COMMON_DOMAIN_CONFIG_GOOGLE = "common.domain.config.google";
    public static final String COMMON_DOMAIN_CONFIG_LDAP = "common.domain.config.ldap";
    public static final String COMMON_DOMAIN_CONFIG_WEB_DAV = "common.domain.config.webDav";
    public static final String COMMON_DOMAIN = "common.domain";
    public static final String COMMON_KEY_RSA_PUBLIC_FILE_NAME = "key.rsa.public.fileName";
    public static final String COMMON_KEY_RSA_PRIVATE_FILE_NAME = "key.rsa.private.fileName";
    public static final String COMMON_KEY_TYPE_RSA = "key.type.rsa";
    public static final String COMMON_KEY_STORE_KEY_PATH = "key.store.keyPath";
    public static final String COMMON_STORE_ROOT_PATH = "store.rootPath";
    public static final String COMMON_KEY_STORE_FOLDER = "common.key.store.folder";
    public static final String COMMON_ATTR_DOMAIN_ID = "domainId";
    public static final int COMMON_CREDENTIAL_FIELD_ALLOWED_LOGIN_LEVEL = 1;
    public static final String COMMON_CREDENTIAL_FIELD_STATUS_CD = "A";
    public static final String COMMON_ADMIN_FIELD_READ_ACESS = "1";
    public static final String COMMON_ADMIN_FIELD_DELETE_ACESS = "1";
    public static final String COMMON_ADMIN_FIELD_CREATE_ACESS = "1";
    public static final String COMMON_ADMIN_FIELD_UPDATE_ACESS = "1";
    public static final String COMMON_APPS_NAME = "SaaSconnect";
    public static final String COMMON_ATTR_USERNAME = "username";
    public static final String COMMON_GOOGLE_DEFAULT_PASSWORD = "saas12345";
    public static final int COMMON_CREDENTIAL_FIELD_LOGICAL_DEL = 0;
    public static final String COMMON_SUBJECT2RES_ADMIN_ROLE_RESOURCES_ID = "role-admin-user";
    public static final String COMMON_SUBJECT2RES_NORMAL_ROLE_RESOURCES_ID = "role-normal-user";
    public static final String COMMON_USER_PRIVILEGE_ADMIN_REQEST = "msg.error.user.privilege.admin.reqest";
   // public static final String COMMON_BASE_GROUP_ID = "generic-saas-group-saas";
    //public static final String COMMON_UNIVERSAL_GROUP_ID = "REQ-group-universal";
    public static final String COMMON_DOMAINSERVICEHISTORY = "common.domainservicehistory";
    public static final String COMMON_USERSERVICEHISTORY = "common.userservicehistory";

    // define for Group Management
    public static final String GROUP_MANAGEMENT_MAIL_GROUP = "group.management.mail.group"; 

    // define for User Center
    public static final String USERCENTER_USER = "usercenter.user";
    public static final String USERCENTER_ATTR_BASE_DOMAIN_ID = "baseDomainId";
    public static final String USERCENTER_AUDIT_TYPE_CHANGE_PWD = "USER_PWD";
    public static final String USERCENTER_AUDIT_REF_SOURCE_CHANGE_PWD = "TBL_SS_USER";
    public static final String USERCENTER_AUDIT_FIELD_NAME_CHANGE_PWD_UPDATE = "UPDATE";
    public static final String USERCENTER_PGROUP_TYPE_DISPLAY_NAME = "DISP_NAME";
    public static final String USERCENTER_PGROUP_TYPE_DESIGNATION = "DESIGNATION";
    public static final String USERCENTER_PGROUP_TYPE_EMAIL = "EMAIL";
    public static final String USERCENTER_GGROUP_TYPE_PHONE = "PHONE";
    public static final String USERCENTER_DEPARTMENT = "usercenter.department";

    //define for MailFax MailSms
    public static final String SVC_MAIL_FAX = "svc.mail.fax";
    public static final String SVC_MAIL_SMS = "svc.mail.sms";
    
    //define for usage
    public static final String USER_USAGE = "user.usage";
    public static final String USER_PRIVILEGE = "user.privilege";
    public static final String DOMAIN_PRIVILEGE = "domain.privilege";
    public static final String USER_THRESHOLD = "user.threshold";
    public static final String DOMAIN_THRESHOLD = "domain.threshold";
    
    public static final String USER_USAGE_MAILFAX = "MAILFAX";
    public static final String USER_USAGE_FAXMAIL = "FAXMAIL";
    public static final String USER_USAGE_MAILSMS = "MAILSMS";
    public static final String USER_USAGE_MAILBLAST = "MAILBLAST";
    public static final String USER_USAGE_FAXBLAST = "FAXBLAST";
    public static final String USER_USAGE_SMSBLAST = "SMSBLAST";

    //define for privilege
    public static final String PRIVILEGE_GRANTED = "1";
    public static final String PRIVILEGE_NOT_GRANTED = "0";
    
    //define for threshold and quota
    public static final String QUOTA_DEFAULT = null;
    public static final String QUOTA_INFINITY = "-1";
    
    public static final int THRESHOLD_DEFAULT = -1; //Refer to domain threshold.
    public static final int THRESHOLD_UNLIMITED = 0; //no threshold set.
    public static final int THRESHOLD_MORETHEN = 0; //more then this will be valid threshold.
    public static final String THRESHOLD_DEFAULT_TEXT = "user.threshold.default.text";
    public static final String THRESHOLD_UNLIMITED_TEXT = "user.threshold.unlimited.text";
    
    public static final String THRESHOLD_DEFAULT_MAILFAX = "user.threshold.default.mailfax";
    public static final String THRESHOLD_DEFAULT_MAILSMS = "user.threshold.default.mailsms";
    public static final String THRESHOLD_DEFAULT_FAXMAIL = "user.threshold.default.faxmail";
    public static final String THRESHOLD_DEFAULT_MAILBLAST = "user.threshold.default.mailblast";
    public static final String THRESHOLD_DEFAULT_SMSBLAST = "user.threshold.default.smsblast";
    public static final String THRESHOLD_DEFAULT_FAXBLAST = "user.threshold.default.faxblast";
   
    //department management
    public static final String USERCENTER_DEPARTMENT_EXIST="errors.usercenter.department.user.exist";
    
    //########################################################
    // defined for SSO
    //########################################################
    public static final String SSO_MSG_ERROR_SAMLREQUEST="errors.sso.samlrequest";
    public static final String OTP_VERIFY_SUCCESS = "10000";
    public static final String OTP_VERIFY_FAILED = "10001";
    public static final String OTP_INVALID_REQUEST_ID = "10002";
    public static final String OTP_INVALID_REQUEST_TIMESTAMP = "10003";
    public static final String OTP_INVALID_OTP = "10004";
    public static final String OTP_INVALID_APPLICATION = "10005";
    public static final String OTP_WRONG_APPLICATION = "10006";
    public static final String OTP_SYSTEM_ERROR = "10099";
    public static final String OTP_NOT_BEFORE_MINUTES = "otp.not.before.minutes";
    public static final String OTP_NOT_ON_OR_AFTER_MINUTES = "otp.not.on.or.after.minutes";
    public static final String OTP_MSG_INVALID_REQUEST_ID = "otp.msg.invalid.request.id";
    public static final String OTP_MSG_INVALID_OTP = "otp.msg.invalid.otp";
    public static final String OTP_MSG_INVALID_APPLICATION = "otp.msg.invalid.application";
    public static final String OTP_MSG_OTP_VAERIFY_FAILED = "otp.msg.verify.failed";
    public static final String OTP_MSG_WRONG_APPLICATION = "otp.msg.wrong.application";
    public static final String OTP_MSG_INVALID_REQUEST_TIMESTAMP = "otp.msg.invalid.request.timestamp";
    public static final String OTP_MSG_VERIFY_SUCCESS = "otp.msg.verify.success";
    public static final String OTP_MSG_SYSTEM_ERROR = "otp.msg.system.error";
    
    //########################################################
    // defined for PROVISION
    //########################################################
    // Provisioning Request Validation
    public static final String PROVISION_VALIDATION_SYSMAP_PACKAGE_ORDER_ID="packageorderid";
    
    public static final String PROVISION_VALIDATION_ACCEPTED="request.is.accepted";
    public static final String PROVISION_VALIDATION_NOT_ACCEPTED="request.is.not.accepted";
    public static final String PROVISION_VALIDATION_CUSTID_REQUIRED="customerID.is.required";
    public static final String PROVISION_VALIDATION_CUSTID_INVALID="customerID.is.invalid";
    public static final String PROVISION_VALIDATION_NOTIFICATION_INVALID="notification.recipient.is.invalid";
    public static final String PROVISION_VALIDATION_ISVSVC_REQUIRED="isv.service.is.required";
    public static final String PROVISION_VALIDATION_ISVSVC_INVALID="10004.isv.service.is.invalid";
    public static final String PROVISION_VALIDATION_ISVSVC_PARA_INVALID="10005.isv.service.parameter.is.invalid";
    public static final String PROVISION_VALIDATION_ISVSVC_SEQ_INVALID="10006.isv.service.sequence.is.invalid";

    //Provision Status
    public static final String PROVISION_STATUS_PENDING="PD";
    public static final String PROVISION_STATUS_INPROCESS="IP";
    public static final String PROVISION_STATUS_COMPLETED="CP";
    public static final String PROVISION_STATUS_PENDINGRETRY="PT";
    public static final String PROVISION_STATUS_PENDINGROLLBACK="PR";
    public static final String PROVISION_STATUS_PROVISIONFAILED="FD";
    public static final String PROVISION_STATUS_ROLLBACKIMPROCESS="RI";
    public static final String PROVISION_STATUS_PENDINGMANUALROLLBACK="RM";
    public static final String PROVISION_STATUS_PENDINGINPROCESS="PI";
    
    //Provision Job
    public static final String PROVISION_SUCCESS_NOTIFICATION_SUBJECT="provision.notification.subject.success";
    public static final String PROVISION_FAILED_NOTIFICATION_SUBJECT="provision.notification.subject.failed";
    public static final String PROVISION_NOTIFICATION_ADMIN_EMAIL="provision.notification.admin.email"; 
    //Provision Service Status
    public static final String PROVISION_SERVICE_STATUS_SUCCESS="S";
    public static final String PROVISION_SERVICE_STATUS_FAILURE="F";
    public static final String PROVISION_SERVICE_STATUS_INPROCESS="I";

    //Rollback Service Status
    public static final String ROLLBACK_SERVICE_STATUS_SUCCESS="S";
    public static final String ROLLBACK_SERVICE_STATUS_FAILURE="F";
    public static final String ROLLBACK_SERVICE_STATUS_INPROCESS="I";
    
    //Rollback Status
    public static final String ROLLBACK_STATUS_INPROCESS="IP";
    public static final String ROLLBACK_STATUS_COMPLETED="CP";
    public static final String ROLLBACK_STATUS_PENDINGRETRY="PT";
    public static final String ROLLBACK_STATUS_ROLLBACKFAILED="FD";
    public static final String ROLLBACK_STATUS_PENDINGINPROCESS="PI";
    
    //Batch Job Type
    public static final String PROVISION_JOB_TYPE_PROVISION="PV";
    public static final String PROVISION_JOB_TYPE_ROLLBACK="RB";
    public static final String PROVISION_JOB_TYPE_RESPONSE="RM";
    public static final String PROVISION_JOB_TYPE_NOTIFICATION="SN";
    
    //Batch Job Name
    public static final String FREE_TRAIL_REMAINDER_JOB =  "SaaSconnect Apps Product Trial Expiry Reminder";
    public static final String PASSWORD_EXPIRE_CHECK_JOB =  "SaaSconnect Apps Password Expiry Check";
    public static final String SEND_COMPANY_MONTHLY_REPORT_JOB = "SaaSconnect Apps Send Company Montyly Report";
    public static final String PASSWORD_EXPIRE_REMAINDER_JOB = "SaaSconnect Apps Password Expiry Reminder";


    //Max Retry Times 
    public static final int MAX_RETRY_TIMES=3;
    
    //Notification
    public static final String NOTIFICATION_STATUS_SUCCESS="S";
    public static final String NOTIFICATION_STATUS_FAILURE="F";
    public static final String MAX_NOTIFICATION_SENDTIMES="max.notification.sendtimes";
    
    //adaptor name
    public static final String ADAPTOR_NAME_GOOGLE = "google";
    
    //adaptor operation
    public static final String SERVICE_OPERATION_EXECUTE = "execute";
  
    public static final String SERVICE_OPERATION_PARAMETER_USERNAME = "userName";
    public static final String SERVICE_OPERATION_PARAMETER_FAMILYNAME = "familyName";
    public static final String SERVICE_OPERATION_PARAMETER_GIVENNAME = "givenName";
    public static final String SERVICE_OPERATION_PARAMETER_PASSWORD = "password";
    public static final String SERVICE_OPERATION_PARAMETER_PASSWORDHASHFUNCTION = "passwordHashFunction";
    
    public static final String ISV_ADAPTOR_RETURN_CODE = "code";
    public static final String ISV_ADAPTOR_RETURN_MSG = "message";
    public static final String ISV_ADAPTOR_RETURN_DETAIL_MSG = "detailMsg";
    public static final String ISV_ADAPTOR_RETURN_DETAIL_SERVICE_MSG = "serviceDetailMsg";
    public static final String ISV_ADAPTOR_RETURN_ORDERID = "orderId";
    public static final String ISV_ADAPTOR_RETURN_DOMAIN_KEY = "domainKey";
    public static final String ISV_ADAPTOR_RETURN_CODE_TYPE = "codeType";
    public static final String ISV_ADAPTOR_RETURN_CODE_TYPE_SUCCESS = "S";
    public static final String ISV_ADAPTOR_RETURN_CODE_TYPE_ERROR = "E";
    
    public static final String SERVICE_PARAMETER_SERVICENAME = "serviceName";
    public static final String SERVICE_PARAMETER_SERVICECATEGORY = "serviceCategory";
    public static final String SERVICE_PARAMETER_SERVICEOPERATION = "serviceOperation";
    
    // provision service definition name
    public static final String PROVISION_SERVICE_DEF_DB = "db";
    public static final String PROVISION_SERVICE_DEF_GOOGLE = "google";
    public static final String PROVISION_SERVICE_DEF_LDAP = "ldap";
    
    // provision service definition categroy
    public static final String PROVISION_SERVICE_DEF_CATEGORY_GROUP = "group";
    public static final String PROVISION_SERVICE_DEF_CATEGORY_USER = "user";
    
    public static final String PROVISION_ERROR_SAME_REFID_SERVICEID = "error.same.refid.serviceid";
    
    
    //define for blast status report
    public static final String BLAST_TASK_STATUS_REPORT_HEAD = "blast.task.status.report.head";
    public static final String BLAST_TASK_TTATUS_REPORT_SUB_HEAD = "blast.task.status.report.subHead";
    public static final String BLAST_TASK_STATUS_REPORT_DOMAIN_NAME = "blast.task.status.report.domain.name";
    public static final String BLAST_TASK_STATUS_REPORT_BLAST_TASK_NAME = "blast.task.status.report.blast.task.name";
    public static final String BLAST_TASK_STATUS_REPORT_BLAST_TASK_DESC = "blast.task.status.report.blast.task.desc";
    public static final String BLAST_TASK_STATUS_REPORT_BLAST_TASK_TYPE = "blast.task.status.report.blast.task.type";
    public static final String BLAST_TASK_STATUS_REPORT_START_TIME = "blast.task.status.report.start.time";
    public static final String BLAST_TASK_STATUS_REPORT_END_TIME = "blast.task.status.report.end.time";
    public static final String BLAST_TASK_STATUS_REPORT_TOTAL_NUM_OF_RECIP = "blast.task.status.report.total.num.of.recip";
    public static final String BLAST_TASK_STATUS_REPORT_NUM_OF_SUCCESS = "blast.task.status.report.num.of.success";
    public static final String BLAST_TASK_STATUS_REPORT_NUM_OF_FAILURE = "blast.task.status.report.num.of.failure";
    public static final String BLAST_TASK_STATUS_REPORT_FOOT_COMPANY = "blast.task.status.report.foot.company";
    public static final String BLAST_TASK_STATUS_REPORT_FOOT_PAGE = "blast.task.status.report.foot.page";
    public static final String BLAST_TASK_STATUS_REPORT_FOOT_PRING_ON = "blast.task.status.report.foot.print.on";
    public static final String BLAST_TASK_STATUS_REPORT_SNO = "blast.task.status.report.sno";
   // define for sms daily reply report
    public static final String SMS_DAILY_REPORT_HEAD = "sms.daily.report.head";
    public static final String SMS_DAILY_REPORT_SUB_HEAD = "sms.daily.report.subHead";
    public static final String SMS_DAILY_REPORT_DOMAIN = "sms.daily.report.domain";
    public static final String SMS_DAILY_REPORT_REPORT_DATE = "sms.daily.report.report.date";
    public static final String SMS_DAILY_REPORT_SHOUT_CODE = "sms.daily.report.short.code";
    public static final String SMS_DAILY_REPORT_NO_RECIPIENT = "sms.daily.report.no.recipient";
    public static final String SMS_DAILY_REPORT_FOOT_COMPANY = "sms.daily.report.foot.company";
    public static final String SMS_DAILY_REPORT_FOOT_PAGE = "sms.daily.report.foot.page";
    public static final String SMS_DAILY_REPORT_FOOT_PRING_ON = "sms.daily.report.foot.print.on";

    //provision request respone returnCode
    public static final String PROVISION_REQUEST_ACCPTED_PROVISION = "10000";
    public static final String PROVISION_REQUEST_ACCPTED_ROLLBACK = "10001";
    public static final String PROVISION_REQUEST_PROVISION_SUCCESS = "10002";
    public static final String PROVISION_REQUEST_PROVISION_FAILED = "10003";
    public static final String PROVISION_REQUEST_PROVISION_INPROCESSING = "10004";
    public static final String PROVISION_REQUEST_ROLLBACK_SUCCESS = "10005";
    public static final String PROVISION_REQUEST_ROLLBACK_FAILED = "10006";
    public static final String PROVISION_REQUEST_ROLLBACK_INPROCESSING = "10007";
    public static final String PROVISION_REQUEST_SYSTEM_ERROR = "10099";
    
    public static final String PROVISION_REQUEST_ACCPTED_PROVISION_MSG = "isv.accepts.provisioning.request";
    public static final String PROVISION_REQUEST_ACCPTED_ROLLBACK_MSG = "isv.accepts.rollback.request";
    public static final String PROVISION_REQUEST_PROVISION_SUCCESS_MSG = "msg.provisioning.success";
    public static final String PROVISION_REQUEST_PROVISION_FAILED_MSG = "msg.provisioning.failed";
    public static final String PROVISION_REQUEST_PROVISION_INPROCESSING_MSG = "msg.provisionging.processing";
    public static final String PROVISION_REQUEST_ROLLBACK_SUCCESS_MSG = "msg.rollback.success";
    public static final String PROVISION_REQUEST_ROLLBACK_FAILED_MSG = "msg.rollback.failed";
    public static final String PROVISION_REQUEST_ROLLBACK_INPROCESSING_MSG = "msg.rollback.processing";
    public static final String PROVISION_REQUEST_SYSTEM_ERROR_MSG = "error.system";
    

    //########################################################
    // defined for twitter
    //########################################################
    public static final String ERROR_PUBLISH_DUPLICATE = "errors.campaign.publish.duplicate";
    public static final String SERVICE_ACC_STATUS_ACTIVE = "A";
    public static final String PUBLISH_STATUS_DRAFT = "D";
    public static final String PUBLISH_STATUS_INACTIVE = "I";
    public static final String PUBLISH_STATUS_ACTIVE = "A";
    public static final String SCHEDULE_JOB_GROUP_PUBLISH="publishGoogleCalEventJob";
    public static final String SCHEDULE_JOB_CLASSNAME_PUBLISH="com.saas.publish.job.PublishgCalEventJob";
    public static final String PUBLISH_MSG_ERROR_CALENDAR_DELETED="errors.campaign.publish.calendar.deleted";
    public static final String PUBLISH_MSG_ERROR_CALENDAR_NOT_PUBLIC="errors.campaign.publish.calendar.not.public";
  
    public static final String TWITTER_CONSUMER_KEY = "twitter.consumer.key";
    public static final String TWITTER_CONSUMER_SECRET = "twitter.consumer.secret";
    public static final String FACEBOOK_API_KEY = "facebook.api.key";
    public static final String FACEBOOK_SECRET_KEY = "facebook.secret.key";
    
    // ########################################################
    // defined for mobile
    //########################################################
    public static final String YOUTUBE = "YT";
    public static final String MOBILE_BLAST_JOB_CLASS_NAME = "mobile.blast.job.class.name";
    public static final String MOBILE_SEND_TYPE_MAIL = "mobile.send.type.mail";
    public static final String MOBILE_SEND_TYPE_MOBILE = "mobile.send.type.mobile";
    public static final String MOBILE_BLAST_TYPE_DRAFT = "mobile.blast.type.draft";
    public static final String MOBILE_BLAST_TYPE_ACTIVE = "mobile.blast.type.active";
    public static final String MOBILE_BLAST_TYPE_INACTIVE = "mobile.blast.type.inactive";
    public static final String MOBILE_BLAST_MAIL_MSG_FROM = "mobile.blast.notification.mail.msg.from";
    public static final String MOBILE_BLAST_MAIL_MSG_SUBJECT = "mobile.blast.notification.mail.msg.subject";
    public static final String MOBILE_BLAST_MAIL_MSG_BODY_PREFIX = "mobile.blast.notification.mail.msg.body.prefix";
    public static final String MOBILE_BLAST_TASK_SCHEDULE_TYPE_ONETIME = "mobile.blast.task.schedule.type.onetime";
    public static final String MOBILE_BLAST_DELETE_INDICATOR = "mobile.blast.delete.indicator";
    public static final String MOBILE_BLAST_ISADV = "mobile.blast.isAdv";
    public static final String MOBILE_BLAST_RECIPINET_TYPE_TO = "mobile.blast.recipient.type.to";
    public static final String MOBILE_BLAST_RUN_AFTER_RECEIVE_TIME = "mobile.blast.run.after.receive.time";
    public static final String YOUTUBE_APPLICATION_NAME = "youtube.application.name";
    public static final String YOUTUBE_DEVELOPER_ID = "youtube.developer.id";
    //########################################################
    // defined for service account
    //########################################################
    public static final String PUBLISH_SERVICE_ACCOUNT_Y="Y";
    public static final String PUBLISH_SERVICE_ACCOUNT_N="N";
    
  //########################################################
    // campaign report
    //########################################################
    public static final String MESSAGE_FILE = "messages-reports";
    public static final String MSG_ERROR_EXPORT_TO_FILE = "msg.error.export.to.file";
    public static final String REPORT_FILE_TYPE_EXCEL = "report.file.type.excel";
    public static final String REPORT_FILE_TYPE_PDF = "report.file.type.pdf";
    public static final String REPOROT_FILE_DEFAULT_NAME = "report.file.default.name";
    public static final String REPORT_FILE_TYPE_CSV = "report.file.type.csv";
    public static final String REPORT_FILE_S_NO = "report.file.s.no";

    public static final String SERVICE_ACCOUNT_PERMTYPE_DOMAIN = "D";
    public static final String SERVICE_ACCOUNT_PERMTYPE_GROUP = "G";
    public static final String SERVICE_ACCOUNT_PERMTYPE_USER = "U";

    public static final String SERVICE_ACCOUNT_SESSION_KEY = "KEY";
    public static final String SERVICE_ACCOUNT_SESSION_SECRET = "SECRET";
    
    
    //##########################################################
    //template report
    public static final String REPORT_TYPE_PDF = "PDF"; 
    public static final String REPORT_TYPE_RTF = "RTF";
    public static final String REPORT_TYPE_TXT = "TXT";
    public static final String REPORT_TYPE_CSV = "CSV";
    public static final String REPORT_TYPE_XLS = "XLS";
    
    public static final String TEMPLATE_CAMPAIGN_EMAIL_STATUS_REPORT_PDF = "RPT_CAMP_EMAIL_STATUS_PDF";
    public static final String TEMPLATE_CAMPAIGN_EMAIL_STATUS_REPORT_EXCEL = "RPT_CAMP_EMAIL_STATUS_EXCEL";
    public static final String TEMPLATE_NOTIFICATION_RESET_PASSWORD = "NOF_RESET_PWD";
    public static final String TEMPLATE_NOTIFICATION_NEW_ACCOUNT_RESET_PASSWORD_OTP = "NOF_NEW_ACCOUNT_RESET_PWD_OTP";
    public static final String TEMPLATE_NOTIFICATION_NEW_ACCOUNT_RESET_PASSWORD_NO_OTP = "NOF_NEW_ACCOUNT_RESET_PWD_NO_OTP";
    public static final String TEMPLATE_NOTIFICATION_CHANGE_PASSWORD = "NOF_CHANGE_PASSWORD";
    public static final String NOF_REPORT_USER_STATUS_REPORT = "NOF_REPORT_USER_STATUS_REPORT";
    public static final String NOF_saas_NOTIFY_GOOGLE_DELETE = "NOF_saas_NOTIFY_GOOGLE_DELETE";
    public static final String NOF_REPORT_MOBILE_SECURITY_REPORT = "NOF_REPORT_MOBILE_SECURITY_REPORT";
    
    // ########################################################
    // defined for PROVISION
    //########################################################
    
    
    // ########################################################
    // Status Code Definition (Begin)
    //#########################################################
    
    // Status code for account and session
    public static final String ACCOUNT_STATUS_ACTIVE = "ACTIVE";
    public static final String ACCOUNT_STATUS_TERMINATED = "TERMINATED";
    public static final String ACCOUNT_SESSION_STATUS_ACTIVE = "ACTIVE";
    public static final String ACCOUNT_SESSION_STATUS_LOCKED = "LOCKED";
    
    // Status code for assigning product process
    public static final String ASSIGN_STATUS_TYPE_ASSIGN = "ASSIGN";
    public static final String ASSIGN_STATUS_TYPE_UNASSIGN = "UNASSIGN";
    
    // Status code for package status
    public static final String PACKAGE_STATUS_ACTIVE = "ACTIVE";
    public static final String PACKAGE_STATUS_TERMINATED = "TERMINATED";
    public static final String PACKAGE_STATUS_PUBLISHED_YES = "Y";
    public static final String PACKAGE_STATUS_PUBLISHED_NO = "N";
    
    //Status code for package order status
    public static final String PACKAGE_ORDER_STATUS_PENDING = "PENDING";
    public static final String PACKAGE_ORDER_STATUS_INPROGRESS = "INPROGRESS";
    public static final String PACKAGE_ORDER_STATUS_SUCCESS = "SUCCESS";
    public static final String PACKAGE_ORDER_STATUS_FAILED = "FAILED";
    public static final String PACKAGE_ORDER_STATUS_CANCELLED = "CANCELLED";
    
    //Status code for package add on indicator
    public static final String PACKAGE_ADD_ON_INDICATOR_YES = "Y";
    public static final String PACKAGE_ADD_ON_INDICATOR_NO = "N";
    
    //Status code for package and product unlimited
    public static final String PACKAGE_PRODUCT_UNLIMITED_YES = "Y";
    public static final String PACKAGE_PRODUCT_UNLIMITED_NO = "N";
    
    // Status code for product status
    public static final String PRODUCT_STATUS_ACTIVE = "ACTIVE";
    public static final String PRODUCT_STATUS_TERMINATED = "TERMINATED";
    
    // Status code for order status
    public static final String ORDER_STATUS_DRAFT = "DRAFT";
    public static final String ORDER_STATUS_INPROGRESS = "INPROGRESS";
    public static final String ORDER_STATUS_COMPLETED = "COMPLETED";
    
    // Status code for order type
    public static final String ORDER_TYPE_ASSIGN = "ASSIGN";
    public static final String ORDER_TYPE_UNASSIGN = "UNASSIGN";
    
    // Status code for product2order status
    public static final String PRODUCT_ORDER_STATUS_PENDING = "PENDING";
    public static final String PRODUCT_ORDER_STATUS_INPROGRESS = "INPROGRESS";
    public static final String PRODUCT_ORDER_STATUS_SUCCESS = "SUCCESS";
    public static final String PRODUCT_ORDER_STATUS_FAILED = "FAILED";
    public static final String PRODUCT_ORDER_STATUS_CANCEL = "CANCEL";
    
    // Status code for user2product status
    public static final String USER_PRODUCT_STATUS_INPROGRESS = "INPROGRESS";
    public static final String USER_PRODUCT_STATUS_INACTIVE = "INACTIVE";
    public static final String USER_PRODUCT_STATUS_ACTIVE = "ACTIVE";
    public static final String USER_PRODUCT_STATUS_TERMINATED = "TERMINATED";
    public static final String USER_PRODUCT_LOCK_STATUS_YES = "Y";
    public static final String USER_PRODUCT_LOCK_STATUS_NO = "N";
    public static final String USER_PRODUCT_MULTI_LICENSE_IND_YES = "Y";
    public static final String USER_PRODUCT_MULTI_LICENSE_IND_NO = "N";
    
    // Status code for company status
    public static final String COMPANY_STATUS_PENDING = "PENDING";
    public static final String COMPANY_STATUS_ACTIVE = "ACTIVE";
    public static final String COMPANY_STATUS_SUSPEND = "SUSPEND";
    public static final String COMPANY_STATUS_TERMINATED = "TERMINATED";
    
    // Status code for provisioning and de-provisioning process
    public static final String PROVISIONING_STATUS_PENDING = "PENDING";
    public static final String PROVISIONING_STATUS_INPROGRESS = "INPROGRESS";
    public static final String PROVISIONING_STATUS_SUCCESS = "SUCCESS";
    public static final String PROVISIONING_STATUS_FAILED = "FAILED";
    
    // Status code for cancel package process
    public static final String CANCEL_PACKAGE_STATUS_DRAFT = "DRAFT";
    public static final String CANCEL_PACKAGE_STATUS_INPROGRESS = "INPROGRESS";
    public static final String CANCEL_PACKAGE_STATUS_COMPLETED = "COMPLETED";
    
    // Status code for request status
    public static final String REQUEST_STATUS_OPEN = "OPEN";
    public static final String REQUEST_STATUS_INPROGRESS = "INPROGRESS";
    public static final String REQUEST_STATUS_COMPLETED = "COMPLETED";
    public static final String REQUEST_STATUS_CLOSED = "CLOSED";
    
 // Status code for incident status
    public static final String INCIDENT_STATUS_OPEN = "OPEN";
    public static final String INCIDENT_STATUS_INPROGRESS = "INPROGRESS";
    public static final String INCIDENT_STATUS_COMPLETED= "COMPLETED";
    
    // Status code for service
    public static final String SERVICE_STATUS_ACTIVE = "Y";
    public static final String SERVICE_STATUS_INACTIVE = "N";
    
    // Category code for Service Ext
    public static final String SERVICE_EXT_CATEGORY_VIDEO = "VIDEO";
    public static final String SERVICE_EXT_CATEGORY_WEBINAR = "WEBINAR";
    public static final String SERVICE_EXT_CATEGORY_FACTSHEET = "FACTSHEET";
    public static final String SERVICE_EXT_CATEGORY_DOWNLOAD = "DOWNLOAD";
    public static final String SERVICE_EXT_CATEGORY_FAQ = "FAQ";
    public static final String SERVICE_EXT_CATEGORY_SWITCHING = "SWITCHING";
    public static final String SERVICE_EXT_CATEGORY_MIGRATE = "MIGRATE";
    public static final String SERVICE_EXT_CATEGORY_EXPERT = "EXPERT";
    public static final String SERVICE_EXT_CATEGORY_GETSTARTED = "GETSTARTED";
    
    //product service category
    public static final String SERVICE_CATEGORY_MAIN = "MAIN";
    
    // ########################################################
    // Status Code Definition (End)
    //########################################################
    
    // ########################################################
    // User Roles (Begin)
    //#########################################################
    public static final String ROLE_PROVISION_ADMIN = "ROLE_PROVISION_ADMIN";
    public static final String ROLE_PROVISION_USER = "ROLE_PROVISION_USER";
    public static final String ROLE_PROVISION_QK = "ROLE_PROVISION_QK";
    public static final String ROLE_CUSTOMER_ADMIN = "ROLE_CUSTOMER_ADMIN";
    public static final String ROLE_CUSTOMER_USER = "ROLE_CUSTOMER_USER";
    public static final String ROLE_PROVISION_CUSTOMER_CARE = "ROLE_PROVISION_CUSTOMER_CARE";
   
    public static final String ROLE_TYPE_LOG_ROLE = "LOG_ROLE";
    public static final String PORTAL_ALLOW_ROLE_ALL = "ALL";
   
    // ########################################################
    // User Roles (End)
    //#########################################################
    
    public static final String RESELLER_INDICATOR_Y = "Y";
    public static final String RESELLER_INDICATOR_N = "N";
    
    // ########################################################
    // Email Template
    public static final String NOF_saas_NOTIFY_QK_FAIL = "NOF_saas_NOTIFY_QK_FAIL";
    public static final String NOF_saas_NOTIFY_SMS_FAIL = "NOF_saas_NOTIFY_SMS_FAIL";
    public static final String NOF_saas_NOTIFY_FMOBILE_FAIL = "NOF_saas_NOTIFY_FMOBILE_FAIL";
    public static final String NOF_saas_NOTIFY_EXCEPTION = "NOF_saas_NOTIFY_EXCEPTION";
    public static final String NOF_BUY_LICENCE_ORDER = "NOF_BUY_LICENCE_ORDER";
    public static final String NOF_BUY_LICENCE_ORDER_SALES = "NOF_BUY_LICENCE_ORDER_SALES";
    
    //#########################################################
    //Customer Administrator
	public static final String NOF_CUSTOMER_ADMIN_CREATE_USER = "NOF_CUSTOMER_ADMIN_CREATE_USER";
	public static final String NOF_CUSTOMER_ADMIN_BULKIMPORT_USER = "NOF_COMPANY_BULK_IMPORT_USER";
    // provision
	public static final String NOF_PROVISION_CREATE_ADMIN_USER = "NOF_PROVISION_CREATE_ADMIN_USER";
    public static final String NOF_PROVISION_CREATE_USER = "NOF_PROVISION_CREATE_USER";
    public static final String NOF_PROVISION_TERMINATE_USER = "NOF_PROVISION_TERMINATE_USER";
    public static final String NOF_PROVISION_CHANGE_LOGIN_ID = "NOF_PROVISION_CHANGE_LOGIN_ID";
    public static final String NOF_PROVISION_RESET_PASSWORD = "NOF_PROVISION_RESET_PASSWORD";
    //company
    public static final String NOF_COMPANY_CREATE = "NOF_COMPANY_CREATE";
    public static final String NOF_COMPANY_LDAP_CREATE = "NOF_COMPANY_LDAP_CREATE";
    public static final String NOF_COMPANY_CREATE_USER = "NOF_COMPANY_CREATE_USER";
    public static final String NOF_COMPANY_TERMINATE_USER = "NOF_COMPANY_TERMINATE_USER";
    public static final String NOF_COMPANY_CHANGE_LOGIN_ID = "NOF_COMPANY_CHANGE_LOGIN_ID";
    public static final String NOF_COMPANY_RESET_PASSWORD = "NOF_COMPANY_RESET_PASSWORD";
    public static final String NOF_COMPANY_SUSPEND = "NOF_COMPANY_SUSPEND";
    public static final String NOF_COMPANY_REINSTATE = "NOF_COMPANY_REINSTATE";
    public static final String NOF_COMPANY_TERMINATE = "NOF_COMPANY_TERMINATE";
    public static final String NOF_COMPANY_UNLOCK_USER = "NOF_COMPANY_UNLOCK_USER";
    public static final String PROVISIONING_TEAM_EMAIL = "provisioning.team.email";
    public static final String HELP_CENTER_NUMBER = "help.center.number";
    
    
    //common
    public static final String NOF_FORGET_PASSWORD = "NOF_FORGET_PASSWORD";
    public static final String NOF_CHANGE_PASSWORD = "NOF_CHANGE_PASSWORD";
    public static final String NOF_CHANGE_PASSWORD_REMINDER = "NOF_CHANGE_PASSWORD_REMINDER";
	public static final String NOF_RESET_PWD = "NOF_RESET_PWD";
	public static final String NOF_QK_SYNCH_FAILED = "NOF_QK_SYNCH_FAILED";
	public static final String NOF_QK_SYNCH_USER_FAILED = "NOF_QK_SYNCH_USER_FAILED";
	public static final String NOF_QK_SYNCH_COMPANY_FAILED = "NOF_QK_SYNCH_COMPANY_FAILED";
    //product
    public static final String NOF_PACKAGE_PROVISION = "NOF_PACKAGE_PROVISION";
    public static final String NOF_PACKAGE_DEPROVISION = "NOF_PACKAGE_DEPROVISION";
    public static final String NOF_PACKAGE_OPT_OUT = "NOF_PACKAGE_OPT_OUT";
    public static final String NOF_PRODUCT_ASSIGN = "NOF_PRODUCT_ASSIGN";
    public static final String NOF_PRODUCT_ASSIGN_FAILED = "NOF_PRODUCT_ASSIGN_FAILED";
    public static final String NOF_PRODUCT_AUTO_ASSIGN_FAILED = "NOF_saas_AUTO_ASSIGN_FAILED";
    public static final String NOF_PRODUCT_UNASSIGN = "NOF_PRODUCT_UNASSIGN";
    public static final String NOF_PRODUCT_UNASSIGN_FAILED = "NOF_PRODUCT_UNASSIGN_FAILED";
    public static final String NOF_FREE_TRIAL_REMINDER = "NOF_FREE_TRIAL_REMINDER";
    public static final String NOF_saas_NOTIFY = "NOF_saas_NOTIFY";
    public static final String NOF_saas_NOTIFY_SUBJECT = "Optus OfficeApps Incident ID: ${incidentId}";
    //public static final String NOF_saas_NOTIFY_SUBJECT = "SaaSconnect Apps Incident ID: ${incidentId}";
    public static final String NOF_ORDER_REQUEST = "NOF_ORDER_REQUEST";
    public static final String NOF_PROVISION_WEBFAX_DOWNGRADE = "NOF_PROVISION_WEBFAX_DOWNGRADE";
    //batch job
    public static final String NOF_PASSWORD_EXPIRE_REMINDER = "NOF_PASSWORD_EXPIRE_REMINDER";
    public static final String NOF_saas_NOTIFY_BATCH_JOB = "NOF_saas_NOTIFY_BATCH_JOB";
    public static final String NOF_PRODUCT_SUSPEND_REMINDER = "NOF_PRODUCT_SUSPEND_REMINDER";
    public static final String NOF_COMPANY_MONTHLY_REPORT = "NOF_COMPANY_MONTHLY_REPORT";
    //
    
    // ########################################################
    // Provision
    //#########################################################
    public static final String SERVICE_MAP_SERVICE_ID = "serviceId";
    public static final String SERVICE_MAP_PRODUCT_NAME = "productName";
    public static final String SERVICE_MAP_CUSTOMER_ID = "customerId";
    public static final String SERVICE_MAP_COMPANY_LOGO = "companyLogo";
    public static final String SERVICE_MAP_DOMAIN_REF_ID = "domainRefId";
    public static final String SERVICE_MAP_DOMAIN_PRODUCT_ID = "domainProductId";
    public static final String SERVICE_MAP_USER_PRODUCT_ID = "userProductId";
    public static final String SERVICE_MAP_USER_PASSWORD = "password";
    public static final String SERVICE_MAP_USER_FIRSTNAME = "firstName";
    public static final String SERVICE_MAP_USER_LASTNAME = "lastName";
    public static final String SERVICE_MAP_USER_ROLE = "role";
    public static final String SERVICE_MAP_USER_NAME = "userName";
    public static final String SERVICE_MAP_DOMAIN_ID = "domainId";
    public static final String SERVICE_MAP_IS_SUSPEND = "isSuspend";
    public static final String SERVICE_MAP_ISV_SERVICE_ID = "isvServiceId";
    public static final String PARA_MAP_PRODUCT_NAME = "PRODUCT_NAME";
    public static final String PARA_MAP_CUSTOMER_ID = "CUSTOMER_ID";
    public static final String PARA_MAP_URL = "URL";
    public static final String PARA_MAP_BILLING_ACCOUNT = "BILLING_ACCOUNT";
    public static final String SERVICE_PARA_SEPERATER = "-;-";//for uniqueness
    public static final String SERVICE_KEY_SEPERATER = "<br />";
    public static final String ERROR_MANDATORY = "error.mandatory";
    public static final String SERVICE_FIELD_PRODUCT_NAME = "Product Name";
    public static final String SERVICE_FIELD_URL = "Url";
    public static final String SERVICE_FIELD_CUSTOMER_ID = "Customer Id";
    public static final String SERVICE_FIELD_BILLING_ACCOUNT = "Billing Account";
    // ########################################################
    // Provision
    //#########################################################
    public static final String REFERENCE_NUMBER_ORDER_ASSIGN = "reference.number.order.assign";
    public static final String REFERENCE_NUMBER_ORDER_UNASSIGN = "reference.number.order.unassign";
    public static final String REFERENCE_NUMBER_INCIDENT = "reference.number.incident";
    public static final String REFERENCE_NUMBER_REQUEST = "reference.number.request";
    public static final String REFERENCE_NUMBER_SAASID = "reference.number.saasid";
    public static final String REFERENCE_NUMBER_TRANSACTIONID = "reference.number.transactionid";
    public static final String REFERENCE_NUMBER_LICENCE_ORDER = "reference.number.licencel.order";
    public static final String EMAIL_DEFAULT_FROMNAME="email.default.fromName";
    public static final String SMS_DEFAULT_FROMNAME="sms.default.fromName";
    
    
    public static final String PRO_DES_CODE_ID_INPROGRESS="INPROGRESS";
    public static final String PRO_DES_CODE_ID_SUCCESS="SUCCESS";
    public static final String PRO_DES_CODE_ID_FAIL="FAIL";
    
    
    // ########################################################
    // User2Device status
    //#########################################################
    public static final String DEVICE_STATUS_PADDING="Pending";
    public static final String DEVICE_STATUS_ACTIVE="Active";
    public static final String DEVICE_STATUS_INACTIVE="In-active";
    public static final String DEVICE_STATUS_SUSPEND="Suspend";
    public static final String DEVICE_STATUS_TERMINATE="Terminate";
    
        
    // ########################################################
    // SMS Template
    //#########################################################
	public static final String NOF_SMS_CHANGE_PASSWORD = "NOF_SMS_CHANGE_PASSWORD";
	public static final String NOF_SMS_COMPANY_CHANGE_LOGIN_ID = "NOF_SMS_COMPANY_CHANGE_LOGIN_ID";
	public static final String NOF_SMS_COMPANY_CREATE = "NOF_SMS_COMPANY_CREATE";
	public static final String NOF_SMS_COMPANY_CREATE_USER = "NOF_SMS_COMPANY_CREATE_USER";
	public static final String NOF_SMS_COMPANY_REINSTATE = "NOF_SMS_COMPANY_REINSTATE";
	public static final String NOF_SMS_COMPANY_SUSPEND = "NOF_SMS_COMPANY_SUSPEND";
	public static final String NOF_SMS_COMPANY_TERMINATE = "NOF_SMS_COMPANY_TERMINATE";
	public static final String NOF_SMS_COMPANY_TERMINATE_USER = "NOF_SMS_COMPANY_TERMINATE_USER";
	public static final String NOF_SMS_CUSTOMER_ADMIN_CREATE_USER = "NOF_SMS_CUSTOMER_ADMIN_CREATE_USER";
	public static final String NOF_SMS_FORGET_PASSWORD = "NOF_SMS_FORGET_PASSWORD";
	public static final String NOF_SMS_FREE_TRIAL_REMINDER = "NOF_SMS_FREE_TRIAL_REMINDER";
	public static final String NOF_SMS_saas_NOTIFY = "NOF_SMS_saas_NOTIFY";
	public static final String NOF_SMS_PACKAGE_DEPROVISION = "NOF_SMS_PACKAGE_DEPROVISION";
	public static final String NOF_SMS_PACKAGE_OPT_OUT = "NOF_SMS_PACKAGE_OPT_OUT";
	public static final String NOF_SMS_PACKAGE_PROVISION = "NOF_SMS_PACKAGE_PROVISION";
	public static final String NOF_SMS_PACKAGE_PROVISION_LONG = "NOF_SMS_PACKAGE_PROVISION_LONG";
	public static final String NOF_SMS_PACKAGE_PROVISION_UPGRADE_DOWNGRADE = "NOF_SMS_PACKAGE_PROVISION_UPGRADE_DOWNGRADE";
	public static final String NOF_SMS_PASSWORD_EXPIRE_REMINDER = "NOF_SMS_PASSWORD_EXPIRE_REMINDER";
	public static final String NOF_SMS_PRODUCT_ASSIGN = "NOF_SMS_PRODUCT_ASSIGN";
	public static final String NOF_SMS_DEVICE_PRODUCT_ASSIGN = "NOF_SMS_DEVICE_PRODUCT_ASSIGN";
	public static final String NOF_SMS_PRODUCT_UNASSIGN = "NOF_SMS_PRODUCT_UNASSIGN";
	public static final String NOF_SMS_PROVISION_CHANGE_LOGIN_ID = "NOF_SMS_PROVISION_CHANGE_LOGIN_ID";
	public static final String NOF_SMS_PROVISION_CREATE_ADMIN_USER = "NOF_SMS_PROVISION_CREATE_ADMIN_USER";
	public static final String NOF_SMS_PROVISION_CREATE_USER = "NOF_SMS_PROVISION_CREATE_USER";
	public static final String NOF_SMS_PROVISION_TERMINATE_USER = "NOF_SMS_PROVISION_TERMINATE_USER";
	public static final String NOF_SMS_RESET_PWD = "NOF_SMS_RESET_PWD";
	public static final String NOF_SMS_EMPTY = "NOF_SMS_EMPTY";
	public static final String NOF_SMS_DOWNLOAD_LINK = "NOF_SMS_DOWNLOAD_LINK";
        public static final String NOF_SMS_DEVICE_DOWNLOAD_LINK = "NOF_SMS_DEVICE_DOWNLOAD_LINK";
	public static final String NOF_SMS_RESET_PASSWORD_NOTIFY = "NOF_SMS_RESET_PASSWORD_NOTIFY";
	
	
    
    
    //SMS PARAM MAP
    public static final String SMS_MESSAGE="MESSAGE";
    public static final String SMS_SESSIONTOKEN="SESSIONTOKEN";
    public static final String SMS_SENDER_NAME="SENDER_NAME";
    public static final String SMS_LIST_OF_RECIPIENTS="LIST_OF_RECIPIENTS";
    public static final String SMS_MSISDN="msisdn";
    public static final String SMS_SERVICE_ACCESS_ID="service.access.id";
    public static final String SMS_SERVICE_ACCESS_PASSWORD="service.access.passowrd";
    public static final String SMS_MESSAGE_ENCODING="message.encoding";
    public static final String SMS_CHARGEABLE_AMOUNT = "chargeable.amount";
    public static final String SMS_AUSTRALIAN_DOLLAR = "australian.dollar";
    public static final String SMS_PRODUCT_CODE = "product.code";
    public static final String SMS_REQUEST_METHOD = "request.method";
    public static final String SMS_PRODUCT_DESCRIPTION = "product.description";
    
    public static final String SERVICE_GOOGLE_APP = "svc_google_app";
    
    //Provision Common Service
    public static final String PROVISION_COMMON_PROXY_ENABLE = "provision.common.proxy.enable";
    public static final String PROVISION_COMMON_PROXY_HOST = "provision.common.proxy.host";
    public static final String PROVISION_COMMON_PROXY_PORT = "provision.common.proxy.port";
    public static final String PROVISION_COMMON_PARAM_SAAS_ID = "peopleGroup.pgroupCode";
    public static final String PROVISION_COMMON_PARAM_LOGIN_ID = "userTO.loginId";
    public static final String PROVISION_COMMON_PARAM_USER_PASSWORD = "userTO.password";
    public static final String PROVISION_COMMON_PARAM_TENANT_NAME = "peopleGroup.pgroupName";
    public static final String PROVISION_COMMON_PARAM_TENANT_PHONE_NUMBER = "peopleGroup.pgroupPhoneNum";
    public static final String PROVISION_COMMON_PARAM_USER_DISPLAYNAME = "userTO.displayName";
    public static final String PROVISION_COMMON_PARAM_USER_FIRSTNAME = "userTO.firstName";
    public static final String PROVISION_COMMON_PARAM_USER_LASTNAME = "userTO.lastName";
    public static final String PROVISION_COMMON_PARAM_USER_USERNAME = "userTO.userName";
    public static final String PROVISION_COMMON_PARAM = "param";

    
	// ########################################################
    // defined for Audit Report Category Action
    // ########################################################
	public static final String AUDIT_REPORT_CATEGORY_COMPANY = "COMPANY";
	public static final String AUDIT_REPORT_CATEGORY_USER = "USER";
	public static final String AUDIT_REPORT_CATEGORY_USER_ROLE = "USER_ROLE";
	public static final String AUDIT_REPORT_CATEGORY_USER_LOGIN_ID = "USER_LOGIN_ID";
	public static final String AUDIT_REPORT_CATEGORY_USER_AND_USER_LOGIN_ID = "USER|USER_LOGIN_ID";
	public static final String AUDIT_REPORT_CATEGORY_USER_LOGIN = "USER_LOGIN";
	public static final String AUDIT_REPORT_CATEGORY_PRODUCT = "PRODUCT";
	public static final String AUDIT_REPORT_CATEGORY_USER_PWD = "USER_PWD";
	
	public static final String AUDIT_REPORT_ACTION_CREATE = "CREATE";
	public static final String AUDIT_REPORT_ACTION_UPDATE = "UPDATE";
	public static final String AUDIT_REPORT_ACTION_DELETE = "DELETE";
	
	// ########################################################
	  // User Alias
	//#########################################################
	public static final String MSG_CUSTOMER_DELETE_USERALIAS_SUCCESS = "msg.customer.delete.useralias.success";
	public static final String ERROR_CUSTOMER_DELETE_USERALIAS = "error.customer.delete.useralias";
	public static final String MSG_CUSTOMER_CREATE_USERALIAS_SUCCESS = "msg.customer.create.useralias.success";
	public static final String ERROR_CUSTOMER_CREATE_USERALIAS_ENTITYEXISTS = "error.customer.create.useralias.entityexists";
	public static final String ERROR_CUSTOMER_CREATE_USERALIAS_RESERVED = "error.customer.create.useralias.reserved";
	public static final String ERROR_CUSTOMER_CREATE_USERALIAS_INVALID = "error.customer.create.useralias.invalid";
	public static final String ERROR_CUSTOMER_CREATE_USERALIAS_LIMITEXCEEDED = "error.customer.create.useralias.limitexceeded";
	public static final String ERROR_CUSTOMER_CREATE_USERALIAS_TOOMANY = "error.customer.create.useralias.toomany";
	public static final String ERROR_CUSTOMER_CREATE_USERALIAS_TIMEOUT = "error.customer.create.useralias.timeout";
	public static final String ERROR_CUSTOMER_DELETE_USERALIAS_TIMEOUT = "error.customer.delete.useralias.timeout";
	public static final String ERROR_CUSTOMER_CREATE_USERALIAS_OTHER = "error.customer.create.useralias.other";
	public static final String ERROR_CUSTOMER_CONNECT_GOOGLE_SERVER ="error.customer.connect.google.server";
	
	
	public static final String RESELLER_SERVICE_STATUS_IND_YES = "Y";
    public static final String RESELLER_SERVICE_STATUS_IND_NO = "N";
    public static final String TERMS_TYPE = "TERMS_CON";
    public static final String TERMS_TYPE_PRODUCT = "TERMS_PRODUCT";
    
    // SMS Create Action
    public static final String CREATEACTION = "CREATEACTION";
    public static final String PROVISION_SERVICE_STATUS = "S";
    
    // ########################################################
	  // Welcome email parameter
	//#########################################################
    public static final String PARAMETER_TOTAL_LICENSE = "welcome.email.para.total.license";//${totalLicensePurchased}
    public static final String PARAMETER_PACKAGE_NAME = "welcome.email.para.package.name";//${packageName}
    
    public static final String OPENSAML_SSO_STORE_PUBKEY = "opensaml.sso.store.pubKey";
    public static final String OPENSAML_SSO_STORE_PRIKEY = "opensaml.sso.store.priKey";
    public static final String OPENSAML_SSO_ISSUER = "opensaml.sso.issuer";
    public static final String OPENSAML_SSO_SUBJECT_TYPE = "opensaml.sso.subjectType";
    
    public static final String DASHBOARD_DISPLAYMULTI_SERVICES = "dashboard.displaymulti.services";
    
    //#############################################
    //  Three party
    //#############################################
    public static final String SERVICE_MAP_THREE_PARTY_SERVICE_ID = "serviceRefId";
    public static final String SERVICE_MAP_THREE_PARTY_SERVICE_TYPE = "serviceId";
    public static final String SERVICE_MAP_THREE_PARTY_USER_ID = "userId";
    
    
    public static final String GROUPS_SERVICES = "groups.services";
    public static final String COMBINE_SERVICES_IDS = "combine.services.ids";
    
    public static final String OTP_TYPE_RESET_PASSWORD = "RP";
    
    public static final String PHONE_NO_PREFIX_START_SYMBOL = "+";
    
    public static final String CUSTOMER_TYPE_BUSINESS_TYPE = "BUSINESS_TYPE";
    public static final String CUSTOMER_TYPE_CONSUMER_TYPE = "CONSUMER_TYPE";
    
    public static final String PACKAGE_AUTOUNASSIGN_INDICATOR = "package.autounassign.indicator";
    
    public static final String IMAGE_CONTEXT_PATH_PREFIX = "image.context.path.prefix";   
    
}
