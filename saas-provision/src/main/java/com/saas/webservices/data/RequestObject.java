package com.saas.webservices.data;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class RequestObject {

    private String userId;
    private String password;
    private String application;
    private String environment;
    private String version;
    private Date dateTime;
    private String requestNo;
    private List<RequestEntity> requestEntities;

    public RequestObject(String userId, String password, String application, String environment, String version,
            Date dateTime, String requestNo) {
        this.userId = userId;
        this.password = password;
        this.application = application;
        this.environment = environment;
        this.version = version;
        this.dateTime = dateTime;
        this.requestNo = requestNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }

    public List<RequestEntity> getRequestEntities() {
        return requestEntities;
    }

    public void setRequestEntities(List<RequestEntity> requestEntities) {
        this.requestEntities = requestEntities;
    }

    public void addRequestEntities(RequestEntity requestEntity) {
        if (this.requestEntities == null) {
            this.requestEntities = new LinkedList<RequestEntity>();
        }
        this.requestEntities.add(requestEntity);
    }

    public void clearRequestEntities() {
        this.requestEntities = new LinkedList<RequestEntity>();
    }
}
