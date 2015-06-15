package com.saas.webservices.util;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import java.util.Properties;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

import com.saas.webservices.config.IsvConstants;
import com.saas.webservices.data.RequestEntity;
import com.saas.webservices.data.RequestItem;
import com.saas.webservices.data.RequestObject;
import com.saas.webservices.data.ResponseObject;
import com.saas.webservices.data.ResponseResult;

public class IsvXmlParser {

    private static Properties config;

    public static Properties getConfigProperties(boolean forceReload) throws Exception {
        if (null == config || forceReload) {
            PropertiesLoader loader = new PropertiesLoader();
            config = loader.loadProps(IsvConstants.SAAS_WEBSERVICES_CONFIG);
        }

        return config;
    }
    
    public static String createRequest(RequestObject reqObject) throws Exception {
        Properties configProp = getConfigProperties(false);
        Document doc = new Document();
        Namespace xmlNs = Namespace.getNamespace(configProp.getProperty(IsvConstants.REQ_XMLNS));

        Element root = new Element(configProp.getProperty(IsvConstants.REQ_TAG), xmlNs);
        Element headerInfo = new Element(configProp.getProperty(IsvConstants.REQ_TAG_HEADER), xmlNs);
        Element bodyInfo = new Element(configProp.getProperty(IsvConstants.REQ_TAG_BODY), xmlNs);

        // Set Header Info
        headerInfo.setAttribute(configProp.getProperty(IsvConstants.REQ_TAG_HEADER_USERID), reqObject.getUserId());
        headerInfo.setAttribute(configProp.getProperty(IsvConstants.REQ_TAG_HEADER_PASSWORD), reqObject.getPassword());
        headerInfo.setAttribute(configProp.getProperty(IsvConstants.REQ_TAG_HEADER_APPLICATION), reqObject
                .getApplication());
        headerInfo.setAttribute(configProp.getProperty(IsvConstants.REQ_TAG_HEADER_ENV), reqObject.getEnvironment());
        headerInfo.setAttribute(configProp.getProperty(IsvConstants.REQ_TAG_HEADER_VERSION), reqObject.getVersion());
        headerInfo.setAttribute(configProp.getProperty(IsvConstants.REQ_TAG_HEADER_CREAT_DT), IsvCommon.getDateString(
                reqObject.getDateTime(), configProp.getProperty(IsvConstants.COMMON_DATE_FORMAT_1)));
        headerInfo.setAttribute(configProp.getProperty(IsvConstants.REQ_TAG_HEADER_REQ_NUM), reqObject.getRequestNo());

        // Set Body Info
        for (RequestEntity entity : reqObject.getRequestEntities()) {
            // Set Entity Info
            Element entityInfo = new Element(configProp.getProperty(IsvConstants.REQ_TAG_ENTITY), xmlNs);
            entityInfo.setAttribute(configProp.getProperty(IsvConstants.REQ_TAG_ENTITY_NAME), entity.getName());
            entityInfo.setAttribute(configProp.getProperty(IsvConstants.REQ_TAG_ENTITY_ACTION), entity.getAction());

            for (RequestItem item : entity.getItems()) {
                // Set Entity Info
                Element itemInfo = new Element(configProp.getProperty(IsvConstants.REQ_TAG_ITEM), xmlNs);
                itemInfo
                        .setAttribute(configProp.getProperty(IsvConstants.REQ_TAG_ITEM_FIELD_NAME), item.getFieldName());
                itemInfo.setAttribute(configProp.getProperty(IsvConstants.REQ_TAG_ITEM_DATA_TYPE), item.getDataType());
                itemInfo.setAttribute(configProp.getProperty(IsvConstants.REQ_TAG_ITEM_VALUE), item.getValue());
                entityInfo.addContent(itemInfo);
            }
            bodyInfo.addContent(entityInfo);
        }

        // Setup XML
        doc.setRootElement(root);
        root.addContent(headerInfo);
        root.addContent(bodyInfo);

        return new XMLOutputter().outputString(doc);
    }
    
    public static String createResponse(ResponseObject responseObject) throws Exception {
        Properties configProp = getConfigProperties(false);
        Document doc = new Document();
        Namespace xmlNs = Namespace.getNamespace(configProp.getProperty(IsvConstants.RES_XMLNS));

        Element root = new Element(configProp.getProperty(IsvConstants.RES_TAG), xmlNs);
        doc.setRootElement(root);
        
        // Set Body Info
        for (ResponseResult results : responseObject.getResponseResults()) {
            // Set Entity Info
            Element resultInfo = new Element(configProp.getProperty(IsvConstants.RES_TAG_RESULT), xmlNs);
            resultInfo.setAttribute(configProp.getProperty(IsvConstants.RES_TAG_RESULT_RETURN_CODE), results.getReturnCode());
            resultInfo.setAttribute(configProp.getProperty(IsvConstants.RES_TAG_RESULT_RETURN_MESSAGE), results.getReturnMessage());
            resultInfo.setAttribute(configProp.getProperty(IsvConstants.RES_TAG_RESULT_REQUEST_NUM), results.getRequestNo());
            resultInfo.setAttribute(configProp.getProperty(IsvConstants.RES_TAG_RESULT_MORE_INFO), results.getMoreInfo());

            for (RequestItem item : results.getItems()) {
                // Set Item Info
                Element itemInfo = new Element(configProp.getProperty(IsvConstants.REQ_TAG_ITEM), xmlNs);
                itemInfo.setAttribute(configProp.getProperty(IsvConstants.RES_TAG_ITEM_FIELD_NAME), item.getFieldName());
                itemInfo.setAttribute(configProp.getProperty(IsvConstants.RES_TAG_ITEM_DATA_TYPE), item.getDataType());
                itemInfo.setAttribute(configProp.getProperty(IsvConstants.RES_TAG_ITEM_VALUE), item.getValue());
                resultInfo.addContent(itemInfo);
            }
            root.addContent(resultInfo);
        }
        return new XMLOutputter().outputString(doc);
    }

    public static ResponseObject parseResponse(String resXml) throws Exception {
        Properties configProp = getConfigProperties(false);
        SAXBuilder builder = new SAXBuilder();
        Reader in = new StringReader(resXml);
        Document doc = builder.build(in);

        Element root = doc.getRootElement();
        List<?> entities = root.getChildren(configProp.getProperty(IsvConstants.RES_TAG_RESULT), root.getNamespace());

        ResponseObject responseObject = null;
        if(entities.size() > 0)
        {
            responseObject = new ResponseObject();
        }
        for (int i = 0; i < entities.size(); i++) {
            Element e = (Element) entities.get(i);
            ResponseResult responseResult = new ResponseResult(e.getAttributeValue(configProp
                    .getProperty(IsvConstants.RES_TAG_RESULT_RETURN_CODE)), e.getAttributeValue(configProp
                    .getProperty(IsvConstants.RES_TAG_RESULT_RETURN_MESSAGE)), e.getAttributeValue(configProp
                    .getProperty(IsvConstants.RES_TAG_RESULT_REQUEST_NUM)), e.getAttributeValue(configProp
                    .getProperty(IsvConstants.RES_TAG_RESULT_MORE_INFO)));

            List<?> item = e.getChildren(configProp.getProperty(IsvConstants.RES_TAG_ITEM), e.getNamespace());
            for (int j = 0; j < item.size(); j++) {
                Element element = (Element) item.get(j);
                RequestItem resItem = new RequestItem(element.getAttributeValue(configProp
                        .getProperty(IsvConstants.RES_TAG_ITEM_FIELD_NAME)), element.getAttributeValue(configProp
                        .getProperty(IsvConstants.RES_TAG_ITEM_DATA_TYPE)), element.getAttributeValue(configProp
                        .getProperty(IsvConstants.RES_TAG_ITEM_VALUE)));
                responseResult.addItems(resItem);
            }
            responseObject.addResponseResults(responseResult);
        }
        return responseObject;
    }
}
