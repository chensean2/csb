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
package com.saas.sso.util;

public interface IAppsConstants {
    //########################################################
    // defined for Sys Common 
    //########################################################
    // defined for config file
    public static final String SAAS_CONFIG = "messages-saas";
    public static final String DEFAULT_CONFIG="iframe-default";
    // defined for common parameter
    public static final String USER_TO = "userTO";
    public static final String USER_NAME = "userName";
    public static final String DOMAIN_ID = "domainId"; 
    public static final String BASE_DOMAIN_ID = "baseDomainId";
    public static final String PGROUP_CODE = "pgroupCode";
    // defined for code table
    public static final String STATUS_NEW = "NEW";
    public static final String STATUS_ACTIVE = "ACTIVE";
    public static final String STATUS_DISABLED = "DISABLED";
    public static final String STATUS_LOCKED = "LOCKED";
    public static final String SCHEDULE_STATUS_INPROGRESS = "INPROGRESS";
    public static final String SCHEDULE_STATUS_CANCEL = "CANCELLED";
    public static final String SCHEDULE_STATUS_NEW = "NEW";
    public static final String SCHEDULE_STATUS_DONE = "DONE";
    public static final String IND_YES = "Y";
    public static final String IND_NO = "N";
    public static final String MOBILE_REGEX = "^[+]{0,1}[0-9]+$";
    public static final String EMAIL_REGEX = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
    public static final String DATE_REGEX = "^(((0[1-9]|[12]\\d|3[01])\\/(0[13578]|1[02])\\/((19|[2-9]\\d)\\d{2}))|((0[1-9]|[12]\\d|30)\\/(0[13456789]|1[012])\\/((19|[2-9]\\d)\\d{2}))|((0[1-9]|1\\d|2[0-8])\\/02\\/((19|[2-9]\\d)\\d{2}))|(29\\/02\\/((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$";
    public static final String MUTI_EMAIL_REGEX = "^(\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*;)*\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    // defined for forward path
    public static final String COMMAND_FORWARD_FAILURE = "failure";//
    public static final String COMMAND_FORWARD_SUCCESS = "success";
    public static final String COMMAND_FORWARD_CONCURRENCY_FAILURE = "concurrency.failure";
    public static final String COMMAND_FORWARD_ERROR = "validation.error";
    // defined for date format
    public static final String TIMESTAMPFORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATA_FORMAT_D_M_Y = "dd/MM/yyyy";
    public static final String DATE_FORMAT_Y_M_D = "yyyy-MM-dd";
    public static final String TIME_FORMAT_H_M_S = "HH:mm:ss";
    public static final String TIME_FORMAT_K_M_S = "kk:mm:ss";
    // defined for return message
    public static final String MSG_ERRORS_SYSTEM = "errors.common.system";
    public static final String MSG_ERRORS_REQUIRED = "errors.required";
    public static final String MSG_ERRORS_INVALID = "errors.invalid";
    public static final String MSG_SUCCESS_DELETE = "msg.record.delete.success";
    public static final String MSG_SUCCESS_SUBMIT = "msg.record.submit.success";
    public static final String MSG_RECORD_MODIFIED_ELSEWHERE = "msg.record.modified.elsewhere";
    public static final String MSG_ERROR_EMAIL = "errors.email";
    
    //########################################################
    // defined for common
    // defined for Admin 
    //########################################################
    public static final String ADMIN_OBH_RESETPWD_MESSAGE = "msg.admin.password.reset";
    public static final String ADMIN_ERROR_RESET_PASSWORD = "errors.admin.password.reset";
    public static final String ADMIN_ERROR_DOMAIN_NOT_EXIST = "errors.admin.domain.not.exist";
    public static final String ADMIN_ERROR_SEND_EMAIL = "errors.admin.email.sent";
    public static final String ADMIN_ERROR_SEND_SMS = "errors.admin.sms.send";
    public static final String ADMIN_RESET_PWD_SEND_SMS_FAILED = "errors.admin.password.sms.send.failed";
    public static final String ADMIN_RESET_PWD_SEND_MAIL_FAILED = "errors.admin.password.mail.send.failed";
    public static final String ADMIN_SUCCESS_SEND_EMAIL = "msg.admin.email.send";
    public static final String ADMIN_SUCCESS_SEND_SMS = "msg.admin.sms.send";
    // define for user
    public static final String ADMIN_USER_RESET_PASSWORD_LOGIN_ID_NOT_EXIST = "errors.admin.user.login.id.not.exist";
    public static final String ADMIN_USER_ACCOUNT_DISABLED = "msg.admin.user.account.disabled";
    public static final String ADMIN_USER_TO_ADMIN_MAIL = "admin.user.to.admin.email";
    public static final String ADMIN_USER_TO_SMS = "admin.user.to.sms";
    public static final String ADMIN_USER_TO_MAIL = "admin.user.to.email";
    public static final String ADMIN_USER_RESET_PWD_SUBJECT = "msg.admin.user.password.reset.request";
    public static final String ADMIN_USER_RESET_PWD_MESSAGE = "msg.admin.user.password.reset.message";
    public static final String ADMIN_USER_RESET_PWD_FROM = "msg.admin.user.password.reset.from";
    public static final String ADMIN_USER_NEW_PWD_SUBJECT = "msg.admin.user.password.new.request";
    public static final String ADMIN_USER_NEW_PWD_MESSAGE = "msg.admin.user.password.new.message";
    public static final String ADMIN_USER_NEW_PWD_FROM = "msg.admin.user.password.new.from";
    // define for user admin
    public static final String ADMIN_USERADMIN_USER = "admin.useradmin.user";
    public static final String ADMIN_USERADMIN_USER_LOG_ROLE = "admin.useradmin.user.log.role";
    public static final String ADMIN_USERADMIN_USER_DELETE_FAILED = "errors.admin.useradmin.user.delete";
    public static final String ADMIN_USERADMIN_USER_FIND_ROLES_FAILED = "errors.admin.useradmin.roles.find";
    public static final String ADMIN_USERADMIN_USER_ADD_FAILED = "errors.admin.useradmin.user.add";
    public static final String ADMIN_USERADMIN_USER_EXIST = "errors.admin.useradmin.user.exist";
    public static final String ADMIN_USERADMIN_USER_UPDATE_FAILED = "errors.admin.useradmin.user.update";
    public static final String ADMIN_THEME_THEMETYPE = "label.admin.themeManagement.themeForm.themeType";
    public static final String ADMIN_COMPANY_LOGO = "label.admin.themeManagement.themeForm.companyLogo";
    //########################################################
    // defined for Campaign
    //########################################################
    public static final String CAMPAIGN_ERRORS_AUTH_ERROR = "errors.campaign.blast.authentication.incorrect";
    public static final String CAMPAIGN_DATEFORMAT_ERROR = "errors.campaign.scheduleBlast.dateFormat";
    public static final String CAMPAIGN_DATETIME_PERIOD_ERROR="errors.campaign.scheduleBlast.date.compare";
    public static final String CAMPAIGN_STARTDATE_ERROR="errors.campaign.scheduleBlast.date.compare.today";
    public static final String CAMPAIGN_TASK_LIMITED_NUMBER = "msg.campaign.manage.task.limited";
    public static final String BLAST_TASK_ERROR_REQUIRE_PARAM = "errors.camapign.blast.mandatory.param";
    public static final String BLAST_TASK_ERROR_DOUBLE_PARAMVALUE = "errors.camapign.blast.duplicate.param";
    public static final String BLAST_TASK_RECIPIENT_SPECIAL_CHAR = "label.campaign.recipient.specialChar";
    public static final String CAMPAIGN_SCHEDULE_TYPE_RECURRENT = "label.campaign.schedule.type.recurrent";
    public static final String CAMPAIGN_SCHEDULE_TYPE_ONETIME = "label.campaign.schedule.type.onetime";
    public static final String CAMPAIGN_SCHEDULE_TYPE_DAILY = "label.campaign.schedule.type.daily";
    public static final String CAMPAIGN_SCHEDULE_TYPE_WEEKLY = "label.campaign.schedule.type.weekly";
    public static final String CAMPAIGN_SCHEDULE_TYPE_MONTHLY = "label.campaign.schedule.type.monthly";
    public static final String CAMPAIGN_SCHEDULE_JOBCLASSNAME = "label.campaign.scheudle.jobClassName";
    public static final String CAMPAIGN_RECIPIENT_ACCTAH_SIZE_TOO_LARGE = "errors.campaign.recipient.attachment.size";
    public static final String CAMAPAGN_INTERVAL_DAY_REGEX =  "^[0-9]{1,3}$";
    public static final String CAMAPAGN_TASK_NAME_DUPLICATED = "errors.campaign.manage.task.name.duplicate";
    public static final String CAMAPAGN_BLAST_NAME_DUPLICATED = "errors.campaign.blast.name.duplicate";
    public static final String CAMAPAGN_BLAST_UPLOAD_FULL = "msg.campaign.blast.list.upload.full";
    public static final String CAMAPAGN_BLAST_UPLOAD_PART = "msg.campaign.blast.list.upload.part";
    // defined for blast list
    public static final String BLAST_LIST_UPLOAD_FAILED = "errors.campaign.blast.list.upload";
    public static final String BLAST_LIST_TYPE_MAILBLAST = "blast.list.type.mailblast";
    public static final String BLAST_LIST_FIRST_NAME = "errors.campaign.blast.list.first.name";
    public static final String BLAST_LIST_LAST_NAME = "errors.campaign.blast.list.last.name";
    public static final String BLAST_LIST_CONTACT = "errors.campaign.blast.list.contact";
    public static final String BLAST_LIST_EMAIL = "errors.campaign.blast.list.email.format";
    public static final String BLAST_LIST_MAIL_ERROR = "errors.campaign.blast.list.mail";
    public static final String BLAST_LIST_PHONE_ERROR = "msg.campaign.blast.list.addRecipient.phone";
    public static final String BLAST_LIST_EMAIL_FORMAT_RULE = "blast.list.email.format.rule";
    public static final String BLAST_LIST_MOBILE_NUMBER = "errors.campaign.blast.list.mobile.number";
    public static final String BLAST_LIST_NUMBER_ERROR = "errors.campaign.blast.list.blast.number";
    public static final String BLAST_LIST_MOBILE_RULE = "errors.campaign.blast.list.mobile.rule";
    public static final String BLAST_LIST_CATEGORY_UCASE_FSI = "blast.list.category.ucase.fsi";
    public static final String BLAST_LIST_CATEGORY_UCASE_CONSUMER = "blast.list.category.ucase.consumer";
    public static final String BLAST_LIST_CATEGORY_UCASE_EDUCATION = "blast.list.category.ucase.education";
    public static final String BLAST_LIST_CATEGORY_UCASE_INSURANCE = "blast.list.category.ucase.insurance";
    public static final String BLAST_LIST_CATEGORY_UCASE_NOTSPECIFIED = "blast.list.category.ucase.not.specified";
    public static final String BLAST_LIST_CATEGORY_UCASE_MANUFACTURING = "blast.list.category.ucase.manufacturing";
    public static final String BLAST_LIST_CATEGORY_CCASE_FSI = "blast.list.category.ccase.fsi";
    public static final String BLAST_LIST_CATEGORY_CCASE_CONSUMER = "blast.list.category.ccase.consumer";
    public static final String BLAST_LIST_CATEGORY_CCASE_EDUCATION = "blast.list.category.ccase.educatioin";
    public static final String BLAST_LIST_CATEGORY_CCASE_INSURANCE = "blast.list.category.ccase.insurance";
    public static final String BLAST_LIST_CATEGORY_CCASE_NOTSPECIFIED = "blast.list.category.ccase.not.specified";
    public static final String BLAST_LIST_CATEGORY_CCASE_MANUFACTURING = "blast.list.category.ccase.manufacturing";
    public static final String BLAST_LIST_LIST_NAME = "blast.list.list.name";
    public static final String BLAST_LIST_LIST_TYPE = "blast.list.list.type";
    public static final String BLAST_LIST_CATEGORY = "blast.list.list.category";
    public static final String BLAST_LIST_CSV_FILE = "blast.list.csv.file";
    // defined for manage task
    public static final String MANAGE_TASK_NEW_BLAST_NAME = "label.campaign.manageTask.taskForm.newBlastName";
    public static final String MANAGE_TASK_SCHEDULE_TYPE_RECURRENT = "label.campaign.schedule.type.recurrent";
    public static final String MANAGE_TASK_SCHEDULE_TYPE_ONETIME = "label.campaign.schedule.type.onetime";
    public static final String MANAGE_TASK_SCHEDULE_TYPE_DAILY = "label.campaign.schedule.type.daily";
    public static final String MANAGE_TASK_SCHEDULE_TYPE_WEEKLY = "label.campaign.schedule.type.weekly";
    public static final String MANAGE_TASK_SCHEDULE_TYPE_MONTHLY = "label.campaign.schedule.type.monthly";
    public static final String MANAGE_TASK_END_DATE = "label.campaign.manageTask.taskForm.endDate";
    public static final String MANAGE_TASK_DAYS_OF_WEEK = "label.campaign.manageTask.taskForm.daysofWeek";
    public static final String MANAGE_TASK_WRONG_DATETIME = "errors.campaign.manage.task.date.compare.today";
    public static final String MANAGE_TASK_START_DATE = "label.campaign.manageTask.taskForm.startDate";
    public static final String MANAGE_TASK_MONTHLY = "label.campaign.manageTask.taskForm.dayofMonth";
    public static final String MANAGE_TASK_WRONG_ENDDATE = "errors.campaign.manage.task.date.compare";
    public static final String MANAGE_TASK_DATE = "label.campaign.manageTask.taskForm.date";
    public static final String MANAGE_TASK_LISTNAME_SPLIT = "label.campaign.manageTask.taskList.listName.split";
    public static final String MANAGE_TASK_ERROR_INTERVAL_DAY_LENGTH = "errors.campaign.scheduleBlast.interval.day.length";
    public static final String MANAGE_TASK_ERROR_INTERVAL_DAY_PATTERN = "errors.campaign.scheduleBlast.interval.day.pattern";
    public static final String MANAGE_TASK_CANCEL_TASK_SUCCESS = "msg.campaign.manage.task.cancel.success";
    // defined for sms task
    public static final String SMS_TASK_BLAST_NAME = "label.campaign.smsBlast.blastForm.blastName";
    public static final String SMS_TASK_STATUSREPLYTO = "label.campaign.smsBlast.blastForm.statusReportTo";
    public static final String SMS_TASK_FROM = "label.campaign.smsBlast.blastForm.msgFrom";
    public static final String SMS_TASK_REPLYTO = "label.campaign.smsBlast.blastForm.msgReplyTo";
    public static final String SMS_TASK_MESSAGEBODY = "label.campaign.smsBlast.blastForm.msgBody";
    public static final String SMS_TASK_LOAD_TYPE_SMSBLAST = "sms.task.load.type.sms.blast";
    public static final String SMS_TASK_REQUEST_TYPE = "label.campaign.smsBlast.request.type";
    public static final String SMS_TASK_MESSAGE_SUBJECT = "sms.task.message.subject";
    public static final String SMS_TASK_DEST_TYPE = "sms.task.dest.type";
    public static final String SMS_TASK_MSG_SUCCESS_BLASTTASK = "sms.task.msg.success.blastTask";//TODO: will delete
    public static final String SMS_TASK_DESTTYPE_TO = "label.campaign.smsBlast.destType.to";
    public static final String SMS_TASK_BLASTTYPE = "label.campaign.smsBlast.blastType";
    public static final String SMS_TASK_REQUEST_PARAMVALUE_FIRSTNAME = "label.campaign.smsBlast.request.paramValue.firstName";
    public static final String SMS_TASK_REQUEST_PARAMVALUE_LASTNAME = "label.campaign.smsBlast.request.paramValue.lastName";
    public static final String SMS_TASK_REQUEST_PARAMVALUE_CONTACT = "label.campaign.smsBlast.request.paramValue.contact";
    public static final String SMS_TASK_MUSTUSE_PARAM = "errors.campaign.smsBlast.parameter.use";
    public static final String SMS_TASK_REPLYTO_ERROR = "errors.campaign.smsBlast.replyTo";
    //define for mail task
    public static final String MAIL_TASK_SEARCH_BLAST_LISTNAME_SPLIT = "label.campaign.mailBlast.searchBlast.listName.split";
    public static final String MAIL_TASK_AUTHSTR = "label.campaign.mailBlast.blastForm.authStr";
    public static final String MAIL_TASK_STATUSREPLYTO = "label.campaign.mailBlast.blastForm.statusRepTo";
    public static final String MAIL_TASK_FROM = "label.campaign.mailBlast.blastForm.from";
    public static final String MAIL_TASK_REPLYTO = "label.campaign.mailBlast.blastForm.replyTo";
    public static final String MAIL_TASK_MESSAGESUBJECT = "label.campaign.mailBlast.blastForm.messageSubject";
    public static final String MAIL_TASK_MESSAGEBODY = "label.campaign.mailBlast.blastForm.messageBody";
    public static final String MAIL_TASK_BLASTTYPE = "label.campaign.mailBlast.blastType";
    public static final String MAIL_TASK_REQUEST_TYPE = "label.campaign.mailBlast.request.type";
    public static final String MAIL_TASK_REQUEST_PARAMVALUE_FIRSTNAME = "label.campaign.mailBlast.request.paramValue.firstName";
    public static final String MAIL_TASK_REQUEST_PARAMVALUE_LASTNAME = "label.campaign.mailBlast.request.paramValue.lastName";
    public static final String MAIL_TASK_REQUEST_PARAMVALUE_CONTACT = "label.campaign.mailBlast.request.paramValue.contact";
    public static final String MAIL_TASK_BLAST_NAME = "label.campaign.mailBlast.blastForm.blastName";
    public static final String MAIL_TASK_MUSTUSE_PARAM = "errors.campaign.mailBlast.parameter.use";
    //define for fax task
    public static final String FAX_TASK_AUTHSTR = "label.campaign.faxBlast.blastForm.authStr"; 
    public static final String FAX_TASK_STATUSREPLYTO = "label.campaign.faxBlast.blastForm.statusRepTo";
    public static final String FAX_TASK_FROM = "label.campaign.faxBlast.blastForm.from";
    public static final String FAX_TASK_REPLYTO = "label.campaign.faxBlast.blastForm.replyTo";
    public static final String FAX_TASK_MESSAGESUBJECT = "label.campaign.faxBlast.blastForm.messageSubject";
    public static final String FAX_TASK_MESSAGEBODY = "label.campaign.faxBlast.blastForm.messageBody";
    public static final String FAX_TASK_BLASTTYPE = "label.campaign.faxBlast.blastType";
    public static final String FAX_TASK_SEARCH_BLAST_LISTNAME_SPLIT = "label.campaign.faxBlast.searchBlast.listName.split";
    public static final String FAX_TASK_REQUEST_TYPE = "label.campaign.faxBlast.request.type";
    public static final String FAX_TASK_REQUEST_PARAMVALUE_FIRSTNAME = "label.campaign.faxBlast.request.paramValue.firstName";
    public static final String FAX_TASK_REQUEST_PARAMVALUE_LASTNAME = "label.campaign.faxBlast.request.paramValue.lastName";
    public static final String FAX_TASK_REQUEST_PARAMVALUE_CONTACT = "label.campaign.faxBlast.request.paramValue.contact";
    public static final String FAX_TASK_REQUEST_DESTTYPE_TO = "label.campaign.faxBlast.destType.to";
    public static final String FAX_TASK_MUSTUSE_PARAM = "errors.campaign.faxBlast.parameter.use";
    //define for schedule task
    public static final String SCHEDULE_TASK_DRAFT_SUCCESS = "msg.campaign.scheduleBlast.draft.save";
    public static final String SCHEDULE_TASK_DATE = "label.campaign.scheduleBlast.blastForm.date";
    public static final String SCHEDULE_TASK_START_DATE = "label.campaign.scheduleBlast.blastForm.startDate";
    public static final String SCHEDULE_TASK_END_DATE = "label.campaign.scheduleBlast.blastForm.endDate";
    public static final String SCHEDULE_TASK_DAYS_OF_WEEK = "label.campaign.scheduleBlast.blastForm.daysOfWeek";
    public static final String SCHEDULE_TASL_DAYS_OF_MONTH = "label.campaign.scheduleBlast.blastForm.daysOfMonth";
    public static final String SCHEDULE_TASK_IN_PROGRESS = "errors.campaign.scheduleBlast.run.inprogress";
    //########################################################
    // defined for User Center
    //########################################################
    public static final String USERCENTER_ERROR_ACCOUNT_LOCKED = "errors.usercenter.account.locked";
    public static final String USERCENTER_USER_LOCKED = "errors.usercenter.user.locked";
    public static final String USERCENTER_ERROR_ACCOUNT_NOTEXIST = "errors.usercenter.account.not.exist";
    public static final String USERCENTER_ERROR_GENPASSWORD_EXPIRED = "errors.usercenter.password.expired";
    public static final String USERCENTER_ERROR_LOGIN_INVALID = "errors.usercenter.login.invalid";
    public static final String USERCENTER_MSG_SUCCESS_CHANGE_PASSWORD = "msg.usercenter.password.change";
    public static final String USERCENTER_MSG_ERROR_CHANGE_PASSWORD = "errors.usercenter.password.change";
    public static final String USERCENTER_MSG_ERROR_EDITUSERPASS_WRONGCURPASS = "errors.usercenter.password.current.incorrect";
    public static final String USERCENTER_PWD_MIN_LENGTH = "usercenter.pwd.min.length";
    public static final String USERCENTER_PWD_OLD_PASSWORD_RESTRICTED = "usercenter.pwd.max.old.password.restricted";
    public static final String USERCENTER_MSG_ERROR_PASSWORD_UNMATCHCONFIRM = "errors.usercenter.password.confirm.not.match";
    public static final String USERCENTER_MSG_ERROR_PASSWORD_TOOSHORT = "errors.usercenter.password.too.short";
    public static final String USERCENTER_MSG_ERROR_PASSWORD_TRAILINGBLANK = "errors.usercenter.password.trailing.blank";
    public static final String USERCENTER_ERROR_PASSWORD_MATCHUSERID = "errors.usercenter.password.user.same";
    public static final String USERCENTER_MSG_PASSWORD_RECENTUSED = "errors.usercenter.password.recent.used";
    public static final String USERCENTER_ERROR_RETRY_EXCEEDED_CHALLENGEQUESTION = "errors.usercenter.challenge.question.exceeded";
    public static final String USERCENTER_ERROR_NO_CHALLENGEQUESTION = "errors.usercenter.challenge.question.empty";
    public static final String USERCENTER_NUM_TRIES_EXCEEDED = "errors.usercenter.password.reset.exceeded";
    public static final String USERCENTER_RESET_PWD_ERROR = "errors.usercenter.password.reset.answer";
    public static final String USERCENTER_ERROR_NO_CHALLENGE_CONTACT = "errors.usercenter.challenge.contact.not.exist";
    public static final String USERCENTER_ERROR_CHALLENGE_INVALID = "errors.usercenter.challenge.answer.invalid";
    public static final String USERCENTER_GOOGLE_ACS_URLPREFIX = "usercenter.google.acs.urlPrefix";
    public static final String USERCENTER_GOOGLE_ACS_URLPOSTFIX = "usercenter.google.acs.urlPostfix";
    public static final String USERCENTER_GOOGLE_ACS_URLMAILRELAYPREFIX = "usercenter.google.acs.urlMailRelayPrefix";
    public static final String USERCENTER_GOOGLE_ACS_URLCALENDARRELAYPREFIX = "usercenter.google.acs.urlCalendarRelayPrefix";
    public static final String USERCENTER_GOOGLE_ACS_URLCONTACTSRELAYPREFIX = "usercenter.google.acs.urlContactsRelayPrefix";
    public static final String USERCENTER_GOOGLE_ACS_URLDOCSRELAYPREFIX = "usercenter.google.acs.urlDocsRelayPrefix";
    public static final String USERCENTER_GOOGLE_ACS_URLSITERELAYPREFIX = "usercenter.google.acs.urlSitesRelayPrefix";
    public static final String USERCENTER_AUDIT_TYPE_LOGIN = "usercenter.error.audit.type.login";
    public static final String USERCENTER_LOGIN_FAIL = "errors.usercenter.user.login.disabled";
    public static final String USERCENTER_LOGIN_SUCCESS = "msg.usercenter.login";
    public static final String USERCENTER_PWD_EXPIRED = "msg.usercenter.password.new.expired";
    public static final String USERCENTER_USER_NEED_RESET_PWD = "msg.usercenter.password.reset.request";
    public static final String USERCENTER_USER_PWD_EXPIRED = "msg.usercenter.password.expired";
    public static final String USERCENTER_ATTEMPT_LOGIN_SUCCESS = "msg.usercenter.password.change.login";
    public static final String USERCENTER_USER_LOGIN_LOCKED = "errors.usercenter.user.login.locked";
    public static final String USERCENTER_ATTEMPT_LOGIN_UNSUCCESS = "errors.usercenter.login";
    public static final String USERCENTER_AUDIT_REF_SOURCE_LOGIN = "usercenter.audit.ref.source.login";
    public static final String USERCENTER_AUDIT_TYPE_CHANGE_PWD = "usercenter.audit.type.change.pwd";
    public static final String USERCENTER_AUDIT_REF_SOURCE_CHANGE_PWD = "usercenter.audit.ref.source.change.pwd";
    public static final String USERCENTER_AUDIT_FIELD_NAME_CHANGE_PWD_FIRST_TIME = "usercenter.audit.field.name.change.pwd.first.name";
    public static final String USERCENTER_AUDIT_FIELD_NAME_CHANGE_PWD_UPDATE = "usercenter.audit.field.name.change.pwd.update";
    public static final String USERCENTER_AUDIT_TYPE_RESET_PWD = "usercenter.audit.type.reset.pwd";
    public static final String USERCENTER_AUDIT_REF_SOURCE_RESET_PWD = "usercenter.audit.ref.source.reset.pwd";
    public static final String USERCENTER_AUDIT_FIELD_NAME_RESET_PWD = "usercenter.audit.field.name.reset.pwd";
    public static final String USERCENTER_ATTR_TEMP_USER_ID = "usercenter.temp.userId";
    public static final String USERCENTER_ATTR_TEMP_FIRST_LOGIN = "usercenter.temp.first.login";
    public static final String USERCENTER_ATTR_TEMP_CHANGE_PASSWORD = "usercenter.temp.change.password";
    public static final String USERCENTER_LOGIN_TYPE_LDAP = "usercenter.login.type.ldap";
    public static final String USERCENTER_MSG_ERROR_ACCOUNT_DISABLED = "errors.usercenter.account.disabled";
    public static final String USERCENTER_FIRST_NAME = "usercenter.first.name";
    public static final String USERCENTER_DEPARTMENT_IN_USE = "errors.usercenter.department.in.use";
   
    // challenge
    public static final String CHALLENGE_CONTACT_EMAIL = "challenge.contact.email";
    public static final String CHALLENGE_CONTACT_SMS = "challenge.contact.sms";
    public static final String CHALLENGE_CONTACT_EMAIL_SMS = "challenge.contact.emailsms";
    public static final String CHALLENGE_MSG_SUCCESS_CHANGE_CHALLENGE = "msg.usercenter.clallenge.password.change";
    // group management

    public static final String USERCENTER_GROUPMANAGERMENT_GOOGLE_GROUP_EMAIL_PERMISSION = "google.group.emailPermission";
    public static final String USERCENTER_GROUPMANAGERMENT_MSG_SUCCESS_ADD_GROUP = "msg.usercenter.groupmanagerment.group.add";
    public static final String USERCENTER_GROUPMANAGERMENT_MSG_SUCCESS_EDIT_GROUP = "msg.usercenter.groupmanagerment.group.edit";
    public static final String USERCENTER_GROUPMANAGERMENT_ERROR_EDITGROUP = "errors.usercenter.groupmanagerment.group.edit";
    public static final String USERCENTER_GROUPMANAGERMENT_ADD_EDITGROUP = "errors.usercenter.groupmanagerment.group.add";
    public static final String USERCENTER_GROUPMANAGERMENT_GROUP_EXIST = "errors.usercenter.groupmanagerment.group.exist";
    public static final String USERCENTER_GROUPMANAGERMENT_ERROR_REMOVEGROUP = "errors.usercenter.groupmanagerment.group.delete";
    public static final String USERCENTER_GROUPMANAGERMENT_ERROR_GROUPMEMBER = "errors.usercenter.groupmanagerment.group.member.exist";
    public static final String USERCENTER_GROUPMANAGERMENT_ERROR_ADD_GROUPMEMBER = "errors.usercenter.groupmanagerment.group.member.add";
    public static final String USERCENTER_ERROR_READFILE = "errors.usercenter.file.read";
    public static final String USERCENTER_ERROR_INVALID_FILETYPE = "errors.usercenter.file.invalid";
    public static final String USERCENTER_GROUPMANAGERMENT_MEMBER_ADD = "msg.usercenter.groupmanagerment.member.add";
    public static final String USERCENTER_GROUPMANAGERMENT_MEMBER_DELETE = "msg.usercenter.groupmanagerment.member.delete";
    public static final String USERCENTER_GROUPMANAGERMENT_MEMBER_DELETE_FAILED = "errors.usercenter.groupmanagerment.group.member.delete";
    public static final String USERCENTER_GROUPMANAGERMENT_GROUP_USED = "errors.usercenter.groupmanagerment.in.use";
    // people finder
    public static final String USERCENTER_PEOPLEFIND_MSG_SUCCESS_ADD_CONTACT = "msg.usercenter.peoplefind.contact.add";
    public static final String USERCENTER_PEOPLEFIND_ERROR_ADD_CONTACT = "errors.usercenter.peoplefind.contact.add";
    public static final String USERCENTER_PEOPLEFIND_ERROR_ADD_CONTACT_PERMISSION = "errors.usercenter.peoplefind.contact.permission.add";

    // personal particulars
    public static final String USERCENTER_PARTICULAR_USER_EDIT_FAILED = "errors.usercenter.pariculars.user.update";

    //department management
    public static final String USERCENTER_DEPARTMENT_EXIST="errors.usercenter.department.user.exist";
    public static final String USERCENTER_DEPARTMENT_DUPICATE_EXIST="errors.usercenter.department.duplicate.exist";

    //contact us
    public static final String USERCENTER_CONTACTUS_MAIL_FROM="feedback.to";
    
}
