package com.csb.core.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "csb_user")
public class CsbUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_dt")
    private Date createdDt;

    @Column(name = "last_updated_by")
    private String lastUpdatedBy;

    @Column(name = "last_updated_dt")
    private Date lastUpdatedDt;

    private Integer version;

    @Column(name = "accountStatus")
    private String accountstatus;

    private String email;

    @Column(name = "emailVerifiedDate")
    private Date emailverifieddate;

    @Column(name = "firstName")
    private String firstname;

    @Column(name = "lastLoginDate")
    private Date lastlogindate;

    @Column(name = "lastLoginIp")
    private String lastloginip;

    @Column(name = "lastName")
    private String lastname;

    @Column(name = "login_id")
    private String loginId;

    @Column(name = "mobileNumber")
    private String mobilenumber;

    private String name;

    private String password;

    @Column(name = "passwordModifiedDate")
    private Date passwordmodifieddate;

    @Column(name = "passwordReset")
    private Integer passwordreset;

    private String username;

    /**
     * @return id
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
     * @return created_by
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
     * @return created_dt
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
     * @return last_updated_by
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
     * @return last_updated_dt
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
     * @return version
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
     * @return accountStatus
     */
    public String getAccountstatus() {
        return accountstatus;
    }

    /**
     * @param accountstatus
     */
    public void setAccountstatus(String accountstatus) {
        this.accountstatus = accountstatus;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return emailVerifiedDate
     */
    public Date getEmailverifieddate() {
        return emailverifieddate;
    }

    /**
     * @param emailverifieddate
     */
    public void setEmailverifieddate(Date emailverifieddate) {
        this.emailverifieddate = emailverifieddate;
    }

    /**
     * @return firstName
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return lastLoginDate
     */
    public Date getLastlogindate() {
        return lastlogindate;
    }

    /**
     * @param lastlogindate
     */
    public void setLastlogindate(Date lastlogindate) {
        this.lastlogindate = lastlogindate;
    }

    /**
     * @return lastLoginIp
     */
    public String getLastloginip() {
        return lastloginip;
    }

    /**
     * @param lastloginip
     */
    public void setLastloginip(String lastloginip) {
        this.lastloginip = lastloginip;
    }

    /**
     * @return lastName
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return login_id
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * @param loginId
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * @return mobileNumber
     */
    public String getMobilenumber() {
        return mobilenumber;
    }

    /**
     * @param mobilenumber
     */
    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return passwordModifiedDate
     */
    public Date getPasswordmodifieddate() {
        return passwordmodifieddate;
    }

    /**
     * @param passwordmodifieddate
     */
    public void setPasswordmodifieddate(Date passwordmodifieddate) {
        this.passwordmodifieddate = passwordmodifieddate;
    }

    /**
     * @return passwordReset
     */
    public Integer getPasswordreset() {
        return passwordreset;
    }

    /**
     * @param passwordreset
     */
    public void setPasswordreset(Integer passwordreset) {
        this.passwordreset = passwordreset;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }
}