package com.saas.webservices;

import java.util.Date;

import com.saas.webservices.config.IsvConstants;
import com.saas.webservices.data.RequestEntity;
import com.saas.webservices.data.RequestItem;
import com.saas.webservices.data.RequestObject;
import com.saas.webservices.data.ResponseObject;
import com.saas.webservices.data.ResponseResult;
import com.saas.webservices.util.IsvXmlParser;

public class CommonIsvHelper {

    public static RequestEntity generateCustomerCreate(String saasId, String customerName, String customerDomain) {
        RequestEntity entity = new RequestEntity(IsvConstants.REQ_ENTITY_NAME_CUSTOMER,
                IsvConstants.REQ_ENTITY_ACTION_CREATE);
        entity.addItem(new RequestItem(IsvConstants.CUSTOMER_ITEM_SAASID, IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING,
                saasId));
        entity.addItem(new RequestItem(IsvConstants.CUSTOMER_ITEM_CUSTNAME,
                IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING, customerName));
        entity.addItem(new RequestItem(IsvConstants.CUSTOMER_ITEM_CUSTDOMAIN,
                IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING, customerDomain));
        return entity;
    }

    public static RequestEntity generateCustomerUpdate(String saasId, String customerName, String customerDomain,
            boolean active) {
        RequestEntity entity = new RequestEntity(IsvConstants.REQ_ENTITY_NAME_CUSTOMER,
                IsvConstants.REQ_ENTITY_ACTION_UPDATE);
        entity.addItem(new RequestItem(IsvConstants.CUSTOMER_ITEM_SAASID, IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING,
                saasId));
        entity.addItem(new RequestItem(IsvConstants.CUSTOMER_ITEM_CUSTNAME,
                IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING, customerName));
        entity.addItem(new RequestItem(IsvConstants.CUSTOMER_ITEM_CUSTDOMAIN,
                IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING, customerDomain));
        entity.addItem(new RequestItem(IsvConstants.CUSTOMER_ITEM_CUSTSTATUS,
                IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING, active ? IsvConstants.ITEM_STATUS_ACTIVE
                        : IsvConstants.ITEM_STATUS_SUSPEND));
        return entity;
    }

    public static RequestEntity generateCustomerDelete(String saasId) {
        RequestEntity entity = new RequestEntity(IsvConstants.REQ_ENTITY_NAME_CUSTOMER,
                IsvConstants.REQ_ENTITY_ACTION_DELETE);
        entity.addItem(new RequestItem(IsvConstants.CUSTOMER_ITEM_SAASID, IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING,
                saasId));
        return entity;
    }

    public static RequestEntity generateProductCreate(String saasId, String prodId, int quantity, boolean trial) {
        RequestEntity entity = new RequestEntity(IsvConstants.REQ_ENTITY_NAME_PRODUCT,
                IsvConstants.REQ_ENTITY_ACTION_CREATE);
        entity.addItem(new RequestItem(IsvConstants.CUSTOMER_ITEM_SAASID, IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING,
                saasId));
        entity.addItem(new RequestItem(IsvConstants.PRODUCT_ITEM_PRODID, IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING,
                prodId));
        entity.addItem(new RequestItem(IsvConstants.PRODUCT_ITEM_QTY, IsvConstants.REQ_ENTITY_ITEM_DATATYPE_INT,
                Integer.toString(quantity)));
        entity.addItem(new RequestItem(IsvConstants.PRODUCT_ITEM_TRIALIND,
                IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING, trial ? IsvConstants.ITEM_INDICATOR_YES
                        : IsvConstants.ITEM_INDICATOR_NO));
        return entity;
    }

    public static RequestEntity generateProductUpdate(String saasId, String prodId, String newProdId, int quantity,
            boolean trial) {
        RequestEntity entity = new RequestEntity(IsvConstants.REQ_ENTITY_NAME_PRODUCT,
                IsvConstants.REQ_ENTITY_ACTION_UPDATE);
        entity.addItem(new RequestItem(IsvConstants.CUSTOMER_ITEM_SAASID, IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING,
                saasId));
        entity.addItem(new RequestItem(IsvConstants.PRODUCT_ITEM_PRODID, IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING,
                prodId));
        entity.addItem(new RequestItem(IsvConstants.PRODUCT_ITEM_PRODID_NEW,
                IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING, newProdId));
        entity.addItem(new RequestItem(IsvConstants.PRODUCT_ITEM_QTY, IsvConstants.REQ_ENTITY_ITEM_DATATYPE_INT,
                Integer.toString(quantity)));
        entity.addItem(new RequestItem(IsvConstants.PRODUCT_ITEM_TRIALIND,
                IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING, trial ? IsvConstants.ITEM_INDICATOR_YES
                        : IsvConstants.ITEM_INDICATOR_NO));
        return entity;
    }

    public static RequestEntity generateProductDelete(String saasId, String prodId, int quantity, boolean trial) {
        RequestEntity entity = new RequestEntity(IsvConstants.REQ_ENTITY_NAME_PRODUCT,
                IsvConstants.REQ_ENTITY_ACTION_DELETE);
        entity.addItem(new RequestItem(IsvConstants.CUSTOMER_ITEM_SAASID, IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING,
                saasId));
        entity.addItem(new RequestItem(IsvConstants.PRODUCT_ITEM_PRODID, IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING,
                prodId));
        entity.addItem(new RequestItem(IsvConstants.PRODUCT_ITEM_QTY, IsvConstants.REQ_ENTITY_ITEM_DATATYPE_INT,
                Integer.toString(quantity)));
        entity.addItem(new RequestItem(IsvConstants.PRODUCT_ITEM_TRIALIND,
                IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING, trial ? IsvConstants.ITEM_INDICATOR_YES
                        : IsvConstants.ITEM_INDICATOR_NO));
        return entity;
    }

    public static RequestEntity generateUserCreate(String saasId, String userId, String firstName, String lastName,
            boolean admin, String email) {
        RequestEntity entity = new RequestEntity(IsvConstants.REQ_ENTITY_NAME_USER,
                IsvConstants.REQ_ENTITY_ACTION_CREATE);
        entity.addItem(new RequestItem(IsvConstants.CUSTOMER_ITEM_SAASID, IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING,
                saasId));
        entity.addItem(new RequestItem(IsvConstants.USER_ITEM_USERID, IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING,
                userId));
        entity.addItem(new RequestItem(IsvConstants.USER_ITEM_FIRSTNAME, IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING,
                firstName));
        entity.addItem(new RequestItem(IsvConstants.USER_ITEM_LASTNAME, IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING,
                lastName));
        entity.addItem(new RequestItem(IsvConstants.USER_ITEM_ROLE, IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING,
                admin ? IsvConstants.ITEM_ROLE_ADMIN : IsvConstants.ITEM_ROLE_USER));
        entity.addItem(new RequestItem(IsvConstants.USER_ITEM_EMAIL, IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING,
                email));
        return entity;
    }

    public static RequestEntity generateUserUpdate(String saasId, String userId, String firstName, String lastName,
            boolean admin, String email, boolean active) {
        RequestEntity entity = new RequestEntity(IsvConstants.REQ_ENTITY_NAME_USER,
                IsvConstants.REQ_ENTITY_ACTION_UPDATE);
        entity.addItem(new RequestItem(IsvConstants.CUSTOMER_ITEM_SAASID, IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING,
                saasId));
        entity.addItem(new RequestItem(IsvConstants.USER_ITEM_USERID, IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING,
                userId));
        entity.addItem(new RequestItem(IsvConstants.USER_ITEM_FIRSTNAME, IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING,
                firstName));
        entity.addItem(new RequestItem(IsvConstants.USER_ITEM_LASTNAME, IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING,
                lastName));
        entity.addItem(new RequestItem(IsvConstants.USER_ITEM_ROLE, IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING,
                admin ? IsvConstants.ITEM_ROLE_ADMIN : IsvConstants.ITEM_ROLE_USER));
        entity.addItem(new RequestItem(IsvConstants.USER_ITEM_EMAIL, IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING,
                email));
        entity.addItem(new RequestItem(IsvConstants.USER_ITEM_USERSTATUS, IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING,
                active ? IsvConstants.ITEM_STATUS_ACTIVE : IsvConstants.ITEM_STATUS_SUSPEND));
        return entity;
    }

    public static RequestEntity generateUserDelete(String saasId, String userId) {
        RequestEntity entity = new RequestEntity(IsvConstants.REQ_ENTITY_NAME_USER,
                IsvConstants.REQ_ENTITY_ACTION_DELETE);
        entity.addItem(new RequestItem(IsvConstants.CUSTOMER_ITEM_SAASID, IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING,
                saasId));
        entity.addItem(new RequestItem(IsvConstants.USER_ITEM_USERID, IsvConstants.REQ_ENTITY_ITEM_DATATYPE_STRING,
                userId));
        return entity;
    }

    public static void main(String[] args) {
        try {
            RequestObject reqObject = new RequestObject("userid", "password", "application", "env", "adapterversion",
                    new Date(), "requestno");

            System.out.println("Customer ::");
            reqObject.addRequestEntities(CommonIsvHelper.generateCustomerCreate("SAASID", "CUSTNAME", "CUSTDOMAIN"));
            reqObject.addRequestEntities(CommonIsvHelper.generateCustomerUpdate("SAASID", "CUSTNAME", "CUSTDOMAIN", true));
            reqObject.addRequestEntities(CommonIsvHelper.generateCustomerDelete("SAASID"));
            System.out.println(IsvXmlParser.createRequest(reqObject));
            reqObject.clearRequestEntities();

            System.out.println("Product ::");
            reqObject.addRequestEntities(CommonIsvHelper.generateProductCreate("SAASID", "PRODID", 1, true));
            reqObject.addRequestEntities(CommonIsvHelper.generateProductUpdate("SAASID", "PRODID", "NEWPRODID", 1, true));
            reqObject.addRequestEntities(CommonIsvHelper.generateProductDelete("SAASID", "PRODID", 1, false));
            System.out.println(IsvXmlParser.createRequest(reqObject));
            reqObject.clearRequestEntities();

            System.out.println("User ::");
            reqObject
                    .addRequestEntities(CommonIsvHelper.generateUserCreate("SAASID", "USERID", "FIRSTNAME", "LASTNAME", true, "EMAIL"));
            reqObject.addRequestEntities(CommonIsvHelper.generateUserUpdate("SAASID", "USERID", "FIRSTNAME", "LASTNAME", true, "EMAIL",
                    true));
            reqObject.addRequestEntities(CommonIsvHelper.generateUserDelete("SAASID", "USERID"));
            System.out.println(IsvXmlParser.createRequest(reqObject));
            reqObject.clearRequestEntities();

            System.out.println("Response ::");
            ResponseObject tempResponse = new ResponseObject();
            ResponseResult tempResult = new ResponseResult("returncode", "returnmessage", "requestno", "moreinfo");
            RequestItem tempItem = new RequestItem("fieldname", "datatype", "value");
            tempResult.addItems(tempItem);
            tempResponse.addResponseResults(tempResult);
            String tempString = IsvXmlParser.createResponse(tempResponse);
            System.out.println(tempString);

            System.out.println("Parse Response ::");
            ResponseObject tempresult = IsvXmlParser.parseResponse(tempString);

            for (ResponseResult result : tempresult.getResponseResults()) {
                System.out.println("Result ::");
                System.out.println(result.getReturnCode());
                System.out.println(result.getReturnMessage());
                System.out.println(result.getRequestNo());
                System.out.println(result.getMoreInfo());
                System.out.println(result.getItemsMap().get("fieldname"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
