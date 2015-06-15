package com.saas.webservices.data;

import java.util.LinkedList;
import java.util.List;

public class ResponseObject {

    private List<ResponseResult> responseResults;

    public ResponseObject() {
    }

    public List<ResponseResult> getResponseResults() {
        return responseResults;
    }

    public void setResponseResults(List<ResponseResult> responseResults) {
        this.responseResults = responseResults;
    }

    public void addResponseResults(ResponseResult responseResults) {
        if (this.responseResults == null) {
            this.responseResults = new LinkedList<ResponseResult>();
        }
        this.responseResults.add(responseResults);
    }

    public void clearResponseResults() {
        this.responseResults = new LinkedList<ResponseResult>();
    }
}
