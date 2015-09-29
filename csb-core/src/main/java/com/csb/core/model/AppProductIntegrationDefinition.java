package com.csb.core.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "csb_app_product_integration_definition")
public class AppProductIntegrationDefinition {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DT")
    private Date createdDt;

    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @Column(name = "LAST_UPDATED_DT")
    private Date lastUpdatedDt;

    @Column(name = "VERSION")
    private Integer version;

    @Column(name = "assignment_url")
    private String assignmentUrl;

    @Column(name = "oauth_consumer_key")
    private String oauthConsumerKey;

    @Column(name = "oauth_consumer_secret")
    private String oauthConsumerSecret;

    @Column(name = "sso_url")
    private String ssoUrl;

    @Column(name = "subscription_cancel_url")
    private String subscriptionCancelUrl;

    @Column(name = "subscription_create_url")
    private String subscriptionCreateUrl;

    @Column(name = "subscription_notify_url")
    private String subscriptionNotifyUrl;

    @Column(name = "subscription_update_url")
    private String subscriptionUpdateUrl;

    @Column(name = "subscription_validate_url")
    private String subscriptionValidateUrl;

    @Column(name = "un_assignment_url")
    private String unAssignmentUrl;

    /**
     * @return ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return CREATED_BY
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return CREATED_DT
     */
    public Date getCreatedDt() {
        return createdDt;
    }

    /**
     * @param createdDt
     */
    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    /**
     * @return LAST_UPDATED_BY
     */
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    /**
     * @param lastUpdatedBy
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * @return LAST_UPDATED_DT
     */
    public Date getLastUpdatedDt() {
        return lastUpdatedDt;
    }

    /**
     * @param lastUpdatedDt
     */
    public void setLastUpdatedDt(Date lastUpdatedDt) {
        this.lastUpdatedDt = lastUpdatedDt;
    }

    /**
     * @return VERSION
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * @return assignment_url
     */
    public String getAssignmentUrl() {
        return assignmentUrl;
    }

    /**
     * @param assignmentUrl
     */
    public void setAssignmentUrl(String assignmentUrl) {
        this.assignmentUrl = assignmentUrl;
    }

    /**
     * @return oauth_consumer_key
     */
    public String getOauthConsumerKey() {
        return oauthConsumerKey;
    }

    /**
     * @param oauthConsumerKey
     */
    public void setOauthConsumerKey(String oauthConsumerKey) {
        this.oauthConsumerKey = oauthConsumerKey;
    }

    /**
     * @return oauth_consumer_secret
     */
    public String getOauthConsumerSecret() {
        return oauthConsumerSecret;
    }

    /**
     * @param oauthConsumerSecret
     */
    public void setOauthConsumerSecret(String oauthConsumerSecret) {
        this.oauthConsumerSecret = oauthConsumerSecret;
    }

    /**
     * @return sso_url
     */
    public String getSsoUrl() {
        return ssoUrl;
    }

    /**
     * @param ssoUrl
     */
    public void setSsoUrl(String ssoUrl) {
        this.ssoUrl = ssoUrl;
    }

    /**
     * @return subscription_cancel_url
     */
    public String getSubscriptionCancelUrl() {
        return subscriptionCancelUrl;
    }

    /**
     * @param subscriptionCancelUrl
     */
    public void setSubscriptionCancelUrl(String subscriptionCancelUrl) {
        this.subscriptionCancelUrl = subscriptionCancelUrl;
    }

    /**
     * @return subscription_create_url
     */
    public String getSubscriptionCreateUrl() {
        return subscriptionCreateUrl;
    }

    /**
     * @param subscriptionCreateUrl
     */
    public void setSubscriptionCreateUrl(String subscriptionCreateUrl) {
        this.subscriptionCreateUrl = subscriptionCreateUrl;
    }

    /**
     * @return subscription_notify_url
     */
    public String getSubscriptionNotifyUrl() {
        return subscriptionNotifyUrl;
    }

    /**
     * @param subscriptionNotifyUrl
     */
    public void setSubscriptionNotifyUrl(String subscriptionNotifyUrl) {
        this.subscriptionNotifyUrl = subscriptionNotifyUrl;
    }

    /**
     * @return subscription_update_url
     */
    public String getSubscriptionUpdateUrl() {
        return subscriptionUpdateUrl;
    }

    /**
     * @param subscriptionUpdateUrl
     */
    public void setSubscriptionUpdateUrl(String subscriptionUpdateUrl) {
        this.subscriptionUpdateUrl = subscriptionUpdateUrl;
    }

    /**
     * @return subscription_validate_url
     */
    public String getSubscriptionValidateUrl() {
        return subscriptionValidateUrl;
    }

    /**
     * @param subscriptionValidateUrl
     */
    public void setSubscriptionValidateUrl(String subscriptionValidateUrl) {
        this.subscriptionValidateUrl = subscriptionValidateUrl;
    }

    /**
     * @return un_assignment_url
     */
    public String getUnAssignmentUrl() {
        return unAssignmentUrl;
    }

    /**
     * @param unAssignmentUrl
     */
    public void setUnAssignmentUrl(String unAssignmentUrl) {
        this.unAssignmentUrl = unAssignmentUrl;
    }
}