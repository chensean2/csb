package com.csb.core.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Formula;

import com.csb.core.common.BaseEntity;

@Entity
@Table(name = "csb_user")
public class User extends BaseEntity<Long> {

    @Column(name = "name")
    private String name;
    
    @Column(name = "login_id")
    private String loginId;
    
    @Column(name = "password")
    private String password;

    @Column(length = 50)
    protected String firstName;

    @Column(length = 50)
    protected String lastName;

    @Column(length = 255)
    protected String email;

    @Column(length = 50)
    protected String mobileNumber;

    @Column(length = 50)
    protected String accountStatus;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date emailVerifiedDate;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastLoginDate;

    protected String lastLoginIp;

    @Column(length = 255, unique = true)
    protected String username;

    protected transient String checkCode;

    @Formula("password")
    protected String currentPassword;

    protected transient String passwordConfirm;

    protected Integer passwordReset = 0;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date passwordModifiedDate;

    @ManyToMany
    @JoinTable(name = "aa_user_roles", joinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "role_id", nullable = false, updatable = false) })
    protected Set<Role> roles;

    public User() {
    }

    public User(String firstName, String lastName, String username, String email, String password,String accountStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username=username;
        this.password=password;
        this.accountStatus = accountStatus;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Date getEmailVerifiedDate() {
        return emailVerifiedDate;
    }

    public void setEmailVerifiedDate(Date emailVerifiedDate) {
        this.emailVerifiedDate = emailVerifiedDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Set<Role> getRoles() {
        if (roles == null) {
            roles = new HashSet<Role>();
        }
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Role addRole(Role role) {
        if (!getRoles().contains(role)) {
            getRoles().add(role);
        }
        return role;
    }

    public Role removeRole(Role role) {
        getRoles().remove(role);
        return role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Integer getPasswordReset() {
        return passwordReset;
    }

    public void setPasswordReset(Integer passwordReset) {
        this.passwordReset = passwordReset;
    }

    public Date getPasswordModifiedDate() {
        return passwordModifiedDate;
    }

    public void setPasswordModifiedDate(Date passwordModifiedDate) {
        this.passwordModifiedDate = passwordModifiedDate;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}