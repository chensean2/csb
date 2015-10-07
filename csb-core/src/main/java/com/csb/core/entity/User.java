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

    @Column(name = "account_status",length = 50)
    private String accountStatus;
    
    @Column(name = "email",length = 255)
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "email_verified_date")
    private Date emailVerifiedDate;
    
    @Column(name = "first_name",length = 50)
    private String firstName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_login_date")
    private Date lastLoginDate;

    @Column(name = "last_login_ip")
    private String lastLoginIp;
    
    @Column(name = "last_name",length = 50)
    private String lastName;

    @Column(name = "login_id")
    private String loginId;
    
    @Column(name = "mobile_number",length = 50)
    private String mobileNumber;

    @Column(name = "name")
    private String name;
    
    @Column(name = "password")
    private String password;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "password_modified_date")
    private Date passwordModifiedDate;
    
    @Column(name = "password_reset")
    private Integer passwordReset = 0;
    
    @Column(name = "user_name",length = 255, unique = true)
    private String userName;

    @Column(name = "user_type")
    private String userType;

    @ManyToMany
    @JoinTable(name = "aa_user_roles", joinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "role_id", nullable = false, updatable = false) })
    private Set<Role> roles;

}