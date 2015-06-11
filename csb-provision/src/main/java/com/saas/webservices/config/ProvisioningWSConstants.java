package com.saas.webservices.config;

public interface ProvisioningWSConstants {
    public static final String SAAS_WEBSERVICES_PROVISION = "saas-webservices-provision";
    public static final String PROPERTIES_POST = ".properties";

    // Provisioning Service (Web service) - Common
    public static final String WEBSERVICE_PORVISIONING_ADMINISTRATOR_USER_ID = "service.provisioning.common.administrator.user.id";
    public static final String WEBSERVICE_PORVISIONING_STATUS_TYPE = "service.provisioning.common.status.type";
    public static final String CODETYPE_COUNTRY_TYPE = "service.provisioning.common.country.type";
    public static final String CODETYPE_DOMAIN_TYPE = "service.provisioning.common.domain.type";

    // regular expressions
    public static final String PHONE_NUMBER_REGULAR_EXPRESSION = "service.provisioning.common.phone.number.regex";
    public static final String FAX_NUMBER_REGULAR_EXPRESSION = "service.provisioning.common.fax.number.regex";
    public static final String MOBILE_NUMBER_REGULAR_EXPRESSION = "service.provisioning.common.mobile.number.regex";
    public static final String EMAIL_REGULAR_EXPRESSION = "service.provisioning.common.email.regex";
    public static final String URL_REGULAR_EXPRESSION = "service.provisioning.common.url.regex";
    public static final String NUMBER_REGULAR_EXPRESSION = "service.provisioning.common.number.regex";
    public static final String MSN_REGULAR_EXPRESSION = "service.provisioning.common.msn.regex";

    // Customer Provisioning Service (Web service)
    public static final String CUST_SUCCESS = "service.provisioning.customer.success";
    public static final String CUST_MANDATORY_FIELD_EMPTY = "service.provisioning.customer.mandatory.field.empty";
    public static final String CUST_INVALID_COMPANY_ID = "service.provisioning.customer.invalid.company.id";
    public static final String CUST_FIELD_LENGTH_EXCEEDED = "service.provisioning.customer.field.length.exceeded";
    public static final String CUST_SAME_SAAS_ACCOUNT_NO_EXISTS = "service.provisioning.customer.same.saas.account.no.exists";
    public static final String CUST_INVALID_COMPANY_LOGO_FORMAT = "service.provisioning.customer.invalid.company.logo.format";
    public static final String CUST_INVALID_COMPANY_LOGO_SIZE = "service.provisioning.customer.invalid.company.logo.size";
    public static final String CUST_INVALID_COMPANY_LOGO_HEIGHT = "service.provisioning.customer.invalid.company.logo.height";
    public static final String CUST_INVALID_COMPANY_LOGO_WIDTH = "service.provisioning.customer.invalid.company.logo.width";
    public static final String CUST_INVALID_COMPANY_URL = "service.provisioning.customer.invalid.company.url";
    public static final String CUST_INVALID_PHONE_NUMBER = "service.provisioning.customer.invalid.phone.number";
    public static final String CUST_INVALID_FAX_NUMBER = "service.provisioning.customer.invalid.fax.number";
    public static final String CUST_INVALID_COUNTRY = "service.provisioning.customer.invalid.country";
    public static final String CUST_INVALID_DOMAIN_TYPE = "service.provisioning.customer.invalid.domain.type";
    public static final String CUST_INVALID_MASTER_MSN_ERROR = "service.provisioning.customer.invalid.master.msn";
    public static final String CUST_EXSIT_MASTER_MSN_ERROR = "service.provisioning.customer.exsit.master.msn";
    public static final String CUST_INVALID_BILLING_CYCLE_START_DATE_ERROR = "service.provisioning.customer.invalid.billing.cycle.startDt";
    public static final String CUST_SUSPEND_FAILED = "service.provisioning.customer.suspend.failed";
    public static final String CUST_DELETE_FAILED = "service.provisioning.customer.delete.failed";
    public static final String CUST_DELETE_FAILED_PACKAGE_FOUND = "service.provisioning.customer.delete.failed.purchased.package.found";
    public static final String CUST_DELETE_FAILED_PENDING_ORDER_FOUND = "service.provisioning.customer.delete.failed.pending.order.found";
    public static final String CUST_DELETE_FAILED_PRODUCT_FOUND = "service.provisioning.customer.delete.failed.product.found";
    public static final String CUST_REINSTATE_FAILED = "service.provisioning.customer.reinstate.failed";
    public static final String CUST_LDAP_ERROR_OCCURRED = "service.provisioning.customer.ldap.error.occurred";
    public static final String CUST_UNKNOWN_ERROR = "service.provisioning.customer.unknown.error";
    public static final String CUST_GENERAL_ERROR = "service.provisioning.customer.general.error";
    // Message in description field
    public static final String CUST_MSG_FOR_TERMINATE_COMPANY_FAILURE = "msg.for.terminate.company.failure";
    public static final String CUST_MSG_FOR_TERMINATE_COMPANY_HAS_PRODUCTS_FAILURE = "msg.for.terminate.company.has.products.failure";
    public static final String CUST_MSG_FOR_TERMINATE_COMPANY_SERVICES_INPROGESS_FAILURE = "msg.for.terminate.company.services.inprogress.failure";

    public static final String CUST_VALID_IMAGE_TYPES = "service.provisioning.customer.valid.image.types";
    public static final String CUST_COMPANY_LOGO_MAX_SIZE = "theme.logo.max.size";
    public static final String CUST_COMPANY_LOGO_HEIGHT = "customer.company.logo.height";
    public static final String CUST_COMPANY_LOGO_WIDTH = "customer.company.logo.width";

    // field length for Customer module
    public static final String CUST_FIELDLENGTH_SUSPENDED_REASON = "service.provisioning.customer.fieldlength.suspendedReason";
    public static final String CUST_FIELDLENGTH_REINSTATED_REASON = "service.provisioning.customer.fieldlength.reinstatedReason";
    public static final String CUST_FIELDLENGTH_DELETED_REASON = "service.provisioning.customer.fieldlength.deletedReason";
    public static final String CUST_FIELDLENGTH_COMPANY_NAME = "service.provisioning.customer.fieldlength.companyName";
    public static final String CUST_FIELDLENGTH_SAAS_ACCOUNT_NO = "service.provisioning.customer.fieldlength.saasAccountNo";
    public static final String CUST_FIELDLENGTH_BUSINESS_REG_NO = "service.provisioning.customer.fieldlength.businessRegNo";
    public static final String CUST_FIELDLENGTH_BILLING_ADDRESS1 = "service.provisioning.customer.fieldlength.billingAddress1";
    public static final String CUST_FIELDLENGTH_BILLING_ADDRESS2 = "service.provisioning.customer.fieldlength.billingAddress2";
    public static final String CUST_FIELDLENGTH_CITY = "service.provisioning.customer.fieldlength.city";
    public static final String CUST_FIELDLENGTH_STATE = "service.provisioning.customer.fieldlength.state";
    public static final String CUST_FIELDLENGTH_POSTAL_CODE = "service.provisioning.customer.fieldlength.postalCode";
    public static final String CUST_FIELDLENGTH_COUNTRY = "service.provisioning.customer.fieldlength.country";
    public static final String CUST_FIELDLENGTH_PHONE_NUMBER = "service.provisioning.customer.fieldlength.phoneNumber";
    public static final String CUST_FIELDLENGTH_FAX_NUMBER = "service.provisioning.customer.fieldlength.faxNumber";
    public static final String CUST_FIELDLENGTH_MSN = "service.provisioning.customer.fieldlength.master.msn";
    public static final String CUST_FIELDLENGTH_DEALER_CODE = "service.provisioning.customer.fieldlength.dealer.code";

    // User Provisioning Service (Web service)
    public static final String USER_SUCCESS = "service.provisioning.user.success";
    public static final String USER_MANDATORY_FIELD_EMPTY = "service.provisioning.user.mandatory.field.empty";
    public static final String USER_SAME_LOGIN_ID_EXISTS = "service.provisioning.user.same.login.id.exists";
    public static final String USER_UNSECURED_PASSWORD = "service.provisioning.user.unsecured.password";
    public static final String USER_INVALID_EMAIL = "service.provisioning.user.invalid.email";
    public static final String USER_INVALID_PHONE_NUMBER = "service.provisioning.user.invalid.phone.number";
    public static final String USER_INVALID_MOBILE_NUMBER = "service.provisioning.user.invalid.mobile.number";
    public static final String USER_INVALID_USER_ROLE = "service.provisioning.user.invalid.user.role";
    public static final String USER_SAME_CHALLENGE_QUESTION_SUBMITTED = "service.provisioning.user.challenge.question.submitted";
    public static final String USER_SAME_CHALLENGE_ANSWER_SUBMITTED = "service.provisioning.user.challenge.answer.submitted";
    public static final String USER_INVALID_USER_ID = "service.provisioning.user.invalid.user.id";
    public static final String USER_INVALID_LOGIN_ID = "service.provisioning.user.invalid.login.id";
    public static final String USER_DELETE_FAILED = "service.provisioning.user.delete.failed";
    public static final String USER_CHANGE_LOGIN_FAILED = "service.provisioning.user.change.login.failed";
    public static final String USER_CHANGE_PASSWORD_FAILED = "service.provisioning.user.change.password.failed";
    public static final String USER_ADMIN_ONLY_PRIMARY_CONTACT = "service.provisioning.user.admin.only.primary.contact";
    public static final String USER_FIELD_LENGTH_EXCEEDED = "service.provisioning.user.field.length.exceeded";
    public static final String USER_STATUS_NOT_ACTIVE = "service.provisioning.user.status.not.active";
    public static final String USER_LOGIN_ID_SAME_AS_ALTERNATE_EMAIL = "service.provisioning.user.login.id.same.as.alternate.email";
    public static final String USER_LDAP_ERROR_OCCURRED = "service.provisioning.user.ldap.error.occurred";
    public static final String USER_DELETE_LAST_ADMIN_NOT_ALLOWED = "service.provisioning.user.delete.last.admin.not.allowed";
    public static final String USER_ASSIGNED_PRODUCT_FOUND = "service.provisioning.user.assigned.product.found";
    public static final String USER_MUST_HAVE_ONE_ADMIN = "service.provisioning.user.must.have.one.admin";
    public static final String USER_SAME_ALTERNATE_EMAIL= "service.provisioning.user.same.alternate.email";
    public static final String USER_UNKNOWN_ERROR = "service.provisioning.user.unknown.error";
    public static final String USER_GENERAL_ERROR = "service.provisioning.user.general.error";
    
    // Message in description field
    public static final String USER_MSG_FOR_DELETE_USER_HAS_PRODUCTS_FAILURE = "msg.for.delete.user.has.products.failure";
    
    // field length for User module
    public static final String USER_FIELDLENGTH_LOGIN_ID = "service.provisioning.user.fieldlength.loginId";
    public static final String USER_FIELDLENGTH_NEW_LOGIN_ID = "service.provisioning.user.fieldlength.newLoginId";
    public static final String USER_FIELDLENGTH_DISPLAY_NAME = "service.provisioning.user.fieldlength.displayName";
    public static final String USER_FIELDLENGTH_FIRST_NAME = "service.provisioning.user.fieldlength.firstName";
    public static final String USER_FIELDLENGTH_LAST_NAME = "service.provisioning.user.fieldlength.lastName";
    public static final String USER_FIELDLENGTH_EMAIL = "service.provisioning.user.fieldlength.email";
    public static final String USER_FIELDLENGTH_ALTERNATE_EMAIL = "service.provisioning.user.fieldlength.alternateEmail";
    public static final String USER_FIELDLENGTH_DESIGNATION = "service.provisioning.user.fieldlength.designation";
    public static final String USER_FIELDLENGTH_DEPARTMENT = "service.provisioning.user.fieldlength.department";
    public static final String USER_FIELDLENGTH_PHONE_NUMBER = "service.provisioning.user.fieldlength.phoneNumber";
    public static final String USER_FIELDLENGTH_MOBILE_NUMBER = "service.provisioning.user.fieldlength.mobileNumber";
    public static final String USER_FIELDLENGTH_DELETE_REASON = "service.provisioning.user.fieldlength.deleted.reason";
    
    //Customer user types
    public static final String USER_ROLE_ADMIN = "ADMIN";
    public static final String USER_ROLE_USER = "USER";

    // Package Provisioning Service (Web service)
    public static final String PACK_SUCCESS = "service.provisioning.package.success";
    public static final String PACK_MANDATORY_FIELD_EMPTY = "service.provisioning.package.mandatory.field.empty";
    public static final String PACK_INVALID_COMPANY_ID = "service.provisioning.package.invalid.company.id";
    public static final String PACK_INVALID_ACTION_TYPE = "service.provisioning.package.invalid.action.type";
    public static final String PACK_INVALID_QUANTITY = "service.provisioning.package.invalid.quantity";
    public static final String PACK_INVALID_PACKAGE_ID = "service.provisioning.package.invalid.package.id";
    public static final String PACK_INVALID_PRODUCT_ID = "service.provisioning.package.invalid.product.id";
    public static final String PACK_INVALID_VALUE = "service.provisioning.package.invalid.value";
    public static final String PACK_UNAUTHORIZED_PURCHASE = "service.provisioning.package.unauthorized.purchase";
    public static final String PACK_PACKAGE_ALREADY_PURCHASED = "service.provisioning.package.already.purchase";
    public static final String PACK_MAXIMUM_QUANTITY_EXCEEDED = "service.provisioning.package.maximu.quantity.exceeded";
    public static final String PACK_INVALID_REFERENCE_NUMBER = "service.provisioning.package.invalid.reference.number";
    public static final String PACK_INVALID_ORDER_PACKAGE_ID = "service.provisioning.package.invalid.order.package.id";
    public static final String PACK_INVALID_ORDER_PRODUCT_ID = "service.provisioning.package.invalid.order.product.id";
    public static final String PACK_INVALID_COMPANY_PACKAGE_ID = "service.provisioning.package.invalid.company.package.id";
    public static final String PACK_RETRY_COUNT_EXCEEDED = "service.provisioning.package.retry.count.exceeded";
    public static final String PACK_PRODUCT_LICENSE_STILL_IN_USE = "service.provisioning.package.product.license.still.in.use";
    public static final String PACK_FIELD_LENGTH_EXCEEDED = "service.provisioning.package.field.length.exceeded";
    public static final String PACK_TSA_PRODUCT_INVALID = "service.provisioning.package.tsa.product.invalid";
    public static final String PACK_PRODUCT_MISSING = "service.provisioning.package.product.missing";
    public static final String PACK_PRODUCT_INFORMATION_INVALID = "service.provisioning.package.product.information.invalid";
    public static final String PACK_PRODUCT_MSN_INVALID = "service.provisioning.package.product.msn.invalid";
    public static final String PACK_PRODUCT_URL_INVALID = "service.provisioning.package.product.url.invalid";
    public static final String PACK_PRODUCT_SEMVALUE_INVALID = "service.provisioning.package.product.semValue.invalid";
    public static final String PACK_PRODUCT_MSN_DUPLICATE= "service.provisioning.package.product.msn.duplicate";
    public static final String PACK_PRODUCT_URL_DUPLICATE = "service.provisioning.package.product.url.duplicate";
    public static final String PACK_PRODUCT_SEMVALUE_SAME = "service.provisioning.package.product.semValue.same";
    public static final String PACK_UNKNOWN_ERROR = "service.provisioning.package.unknown.error";
    public static final String PACK_GENERAL_ERROR = "service.provisioning.package.general.error";
    
    //field length for Package module
    public static final String PACK_FIELDLENGTH_PACKAGE_ACTION = "service.provisioning.package.fieldlength.packageAction";
    public static final String PACK_FIELDLENGTH_INFO_DESCRIPTION = "service.provisioning.package.fieldlength.infoDescription";
    public static final String PACK_FIELDLENGTH_INFO_VALUE = "service.provisioning.package.fieldlength.infoValue";

    public static final String PACK_TSA = "service.provisioning.package.tsa";
    public static final String PACK_ID = "service.provisioning.package.id";
    public static final String PROD_SEO = "service.provisioning.product.seo";
    public static final String PROD_SEM = "service.provisioning.product.sem";
    
    // OTPAuthenticationService Service (Web service)
    public static final String GENERATE_OTP_SUCCESS = "service.provisioning.otp.generate.success";
    public static final String GENERATE_OTP_MANDATORY_FIELD_EMPTY = "service.provisioning.otp.generate.mandatory.field.empty";
    public static final String GENERATE_OTP_UNKNOWN_ERROR = "service.provisioning.otp.generate.unknown.error";
    public static final String GENERATE_OTP_GENERAL_ERROR = "service.provisioning.otp.generate.general.error";
    
    public static final String VALIDATE_OTP_SUCCESS = "service.provisioning.validate.otp.success";
    public static final String VALIDATE_OTP_MANDATORY_FIELD_EMPTY = "service.provisioning.validate.otp.mandatory.field.empty";
    public static final String VALIDATE_OTP_ACCOUNT_LOCKED="service.provisioning.validate.otp.account.locked";
    public static final String VALIDATE_OTP_EXPIRED="service.provisioning.validate.otp.expired";
    public static final String VALIDATE_OTP_INVALID="service.provisioning.validate.otp.invalid";
    public static final String VALIDATE_SERVICE_TYPE_UNKNOWN = "service.provisioning.validate.serviceType.unknown";
    public static final String VALIDATE_SERVICE_ID_INVALID = "service.provisioning.validate.serviceId.invalid";
    public static final String VALIDATE_OTP_UNKNOWN_ERROR = "service.provisioning.validate.otp.unknown.error";
    public static final String VALIDATE_OTP_GENERAL_ERROR = "service.provisioning.validate.otp.general.error";
}
