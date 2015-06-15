package com.saas.webservices.data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RequestEntity {

    private String name;
    private String action;
    private List<RequestItem> items;

    public RequestEntity(String name, String action, List<RequestItem> items) {
        this.name = name;
        this.action = action;
    }

    public RequestEntity(String name, String action) {
        this.name = name;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<RequestItem> getItems() {
        return items;
    }

    public void setItems(List<RequestItem> items) {
        this.items = items;
    }

    public void addItem(RequestItem items) {
        if (this.items == null) {
            this.items = new LinkedList<RequestItem>();
        }
        this.items.add(items);
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
