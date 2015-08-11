package com.csb.parser.component.model;

import java.util.List;

public class SaaSPlanInfo {

    private String planCode;

    private List<SaaSPlanItemInfo> saasPlanItemInfoList;

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    public List<SaaSPlanItemInfo> getSaasPlanItemInfoList() {
        return saasPlanItemInfoList;
    }

    public void setSaasPlanItemInfoList(List<SaaSPlanItemInfo> saasPlanItemInfoList) {
        this.saasPlanItemInfoList = saasPlanItemInfoList;
    }

}
