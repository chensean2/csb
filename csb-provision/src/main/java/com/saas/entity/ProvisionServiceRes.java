package com.saas.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.csb.common.entity.BaseEntity;

/**
 * The persistent class for the tbl_ss_provision_service_res database table.
 * 
 */
@Entity
@Table(name = "tbl_ss_provision_service_res")
public class ProvisionServiceRes extends BaseEntity<Long> {
    private static final long serialVersionUID = 1L;

    @OneToOne
    @JoinColumn(name = "ISV_SERVICE_ID")
    private ProvisionIsvService provisionIsvService;

    @OneToMany(mappedBy = "provisionServiceRes")
    private List<ProvisionServiceResDetail> provisionServiceResDetailList;

    @Column(name = "PROVISION_RES_CODE")
    private String provisionResCode;

    @Lob
    @Column(name = "PROVISION_RES_MESSAGE")
    private String provisionResMessage;

    @Column(name = "ROLLBACK_RES_CODE")
    private String rollbackResCode;

    @Lob
    @Column(name = "ROLLBACK_RES_MESSAGE")
    private String rollbackResMessage;

    @Lob
    @Column(name = "SERVICE_RES_MESSAGE")
    private String serviceResMessage;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SERVICE_RES_RECEIVE_TIME")
    private Date serviceResReceiveTime;

    @Column(name = "SERVICE_RES_TYPE")
    private String serviceResType;

    public ProvisionServiceRes() {
    }

    public String getProvisionResCode() {
        return provisionResCode;
    }

    public void setProvisionResCode(String provisionResCode) {
        this.provisionResCode = provisionResCode;
    }

    public String getRollbackResCode() {
        return rollbackResCode;
    }

    public void setRollbackResCode(String rollbackResCode) {
        this.rollbackResCode = rollbackResCode;
    }

    public Date getServiceResReceiveTime() {
        return serviceResReceiveTime;
    }

    public void setServiceResReceiveTime(Date serviceResReceiveTime) {
        this.serviceResReceiveTime = serviceResReceiveTime;
    }

    public String getServiceResType() {
        return serviceResType;
    }

    public void setServiceResType(String serviceResType) {
        this.serviceResType = serviceResType;
    }

    public ProvisionIsvService getProvisionIsvService() {
        return provisionIsvService;
    }

    public void setProvisionIsvService(ProvisionIsvService provisionIsvService) {
        this.provisionIsvService = provisionIsvService;
    }

    public List<ProvisionServiceResDetail> getProvisionServiceResDetailList() {
        return provisionServiceResDetailList;
    }

    public void setProvisionServiceResDetailList(List<ProvisionServiceResDetail> provisionServiceResDetailList) {
        this.provisionServiceResDetailList = provisionServiceResDetailList;
    }

    public String getProvisionResMessage() {
        return provisionResMessage;
    }

    public void setProvisionResMessage(String provisionResMessage) {
        this.provisionResMessage = provisionResMessage;
    }

    public String getRollbackResMessage() {
        return rollbackResMessage;
    }

    public void setRollbackResMessage(String rollbackResMessage) {
        this.rollbackResMessage = rollbackResMessage;
    }

    public String getServiceResMessage() {
        return serviceResMessage;
    }

    public void setServiceResMessage(String serviceResMessage) {
        this.serviceResMessage = serviceResMessage;
    }

}