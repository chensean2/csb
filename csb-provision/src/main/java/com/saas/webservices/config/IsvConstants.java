package com.saas.webservices.config;

public interface IsvConstants {
    public static final String SAAS_WEBSERVICES_CONFIG = "saas-webservices-config";
    public static final String SAAS_WEBSERVICES_PROVISION = "saas-webservices-provision";
    public static final String PROPERTIES_POST = ".properties";

    // Common Constant
    public static final String COMMON_DATE_FORMAT_1 = "config.datetime.format.default";

    // Interface Constant
    public static final String REQ_ENTITY_NAME_CUSTOMER = "CUSTOMER";
    public static final String REQ_ENTITY_NAME_PRODUCT = "PRODUCT";
    public static final String REQ_ENTITY_NAME_USER = "USER";

    public static final String REQ_ENTITY_ACTION_CREATE = "CREATE";
    public static final String REQ_ENTITY_ACTION_RETRIEVE = "RETRIEVE";
    public static final String REQ_ENTITY_ACTION_UPDATE = "UPDATE";
    public static final String REQ_ENTITY_ACTION_DELETE = "DELETE";

    public static final String REQ_ENTITY_ITEM_DATATYPE_STRING = "string";
    public static final String REQ_ENTITY_ITEM_DATATYPE_INT = "integer";

    public static final String CUSTOMER_ITEM_SAASID = "SAASID";
    public static final String CUSTOMER_ITEM_CUSTNAME = "CUSTNAME";
    public static final String CUSTOMER_ITEM_CUSTDOMAIN = "CUSTDOMAIN";
    public static final String CUSTOMER_ITEM_CUSTSTATUS = "CUSTSTATUS";

    public static final String PRODUCT_ITEM_PRODID = "PRODID";
    public static final String PRODUCT_ITEM_PRODID_NEW = "NEWPRODID";
    public static final String PRODUCT_ITEM_QTY = "QTY";
    public static final String PRODUCT_ITEM_TRIALIND = "TRIALIND";

    public static final String USER_ITEM_USERID = "USERID";
    public static final String USER_ITEM_FIRSTNAME = "FIRSTNAME";
    public static final String USER_ITEM_LASTNAME = "LASTNAME";
    public static final String USER_ITEM_ROLE = "ROLE";
    public static final String USER_ITEM_EMAIL = "EMAIL";
    public static final String USER_ITEM_USERSTATUS = "USERSTATUS";

    public static final String ITEM_STATUS_ACTIVE = "ACTIVE";
    public static final String ITEM_STATUS_SUSPEND = "SUSPEND";

    public static final String ITEM_INDICATOR_YES = "Y";
    public static final String ITEM_INDICATOR_NO = "N";

    public static final String ITEM_ROLE_ADMIN = "ADMIN";
    public static final String ITEM_ROLE_USER = "USER";

    public static final String ENV_SIT = "SIT";
    public static final String ENV_UAT = "UAT";
    public static final String ENV_PRD = "PRD";

    // XML Request Constant
    public static final String REQ_TAG = "service.request.tag";
    public static final String REQ_XMLNS = "service.request.xmlns";
    public static final String REQ_TAG_HEADER = "service.request.tag.header";
    public static final String REQ_TAG_HEADER_USERID = "service.request.tag.header.userid";
    public static final String REQ_TAG_HEADER_PASSWORD = "service.request.tag.header.password";
    public static final String REQ_TAG_HEADER_APPLICATION = "service.request.tag.header.application";
    public static final String REQ_TAG_HEADER_ENV = "service.request.tag.header.env";
    public static final String REQ_TAG_HEADER_VERSION = "service.request.tag.header.adapterversion";
    public static final String REQ_TAG_HEADER_CREAT_DT = "service.request.tag.header.createdatetime";
    public static final String REQ_TAG_HEADER_REQ_NUM = "service.request.tag.header.requestno";
    public static final String REQ_TAG_BODY = "service.request.tag.body";
    public static final String REQ_TAG_ENTITY = "service.request.tag.entity";
    public static final String REQ_TAG_ENTITY_NAME = "service.request.tag.entity.name";
    public static final String REQ_TAG_ENTITY_ACTION = "service.request.tag.entity.action";
    public static final String REQ_TAG_ITEM = "service.request.tag.item";
    public static final String REQ_TAG_ITEM_FIELD_NAME = "service.request.tag.fieldname";
    public static final String REQ_TAG_ITEM_DATA_TYPE = "service.request.tag.datatype";
    public static final String REQ_TAG_ITEM_VALUE = "service.request.tag.value";

    // XML Response Constant
    public static final String RES_TAG = "service.response.tag";
    public static final String RES_XMLNS = "service.response.xmlns";
    public static final String RES_TAG_RESULT = "service.response.tag.result";
    public static final String RES_TAG_RESULT_RETURN_CODE = "service.response.tag.result.returncode";
    public static final String RES_TAG_RESULT_RETURN_MESSAGE = "service.response.tag.result.returnmessage";
    public static final String RES_TAG_RESULT_REQUEST_NUM = "service.response.tag.result.requestno";
    public static final String RES_TAG_RESULT_MORE_INFO = "service.response.tag.result.moreinfo";
    public static final String RES_TAG_ITEM = "service.response.tag.item";
    public static final String RES_TAG_ITEM_FIELD_NAME = "service.response.tag.fieldname";
    public static final String RES_TAG_ITEM_DATA_TYPE = "service.response.tag.datatype";
    public static final String RES_TAG_ITEM_VALUE = "service.response.tag.value";

}
