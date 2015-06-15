package com.saas.webservices.data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ResponseResult {

    private String returnCode;
    private String returnMessage;
    private String requestNo;
    private String moreInfo;
    private List<RequestItem> items;

    public ResponseResult(String returnCode, String returnMessage, String requestNo, String moreInfo) {
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
        this.requestNo = requestNo;
        this.moreInfo = moreInfo;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public List<RequestItem> getItems() {
        return items;
    }

    public void setItems(List<RequestItem> responseItems) {
        this.items = responseItems;
    }

    public void addItems(RequestItem responseItems) {
        if (this.items == null) {
            this.items = new LinkedList<RequestItem>();
        }
        this.items.add(responseItems);
    }

    public void clearItems() {
        this.items = new LinkedList<RequestItem>();
    }

    public Map<String, String> getItemsMap() {
        if (null == this.items) {
            return null;
        }
        Map<String, String> map = new HashMap<String, String>();
        for (RequestItem item : this.items) {
            map.put(item.getFieldName(), item.getValue());
        }
        return map;
    }
}
