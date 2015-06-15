package com.saas.webservices.data;

public class RequestItem {

    private String fieldName;
    private String dataType;
    private String value;

    public RequestItem(String fieldName, String dataType, String value) {
        this.fieldName = fieldName;
        this.dataType = dataType;
        this.value = value;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
