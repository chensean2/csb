package com.csb.mall.web;

import com.csb.mall.auth.service.AuthenticatedUser;

public class UserContextHolder {

    private static final ThreadLocal<Long> userLocal = new ThreadLocal<Long>();

    private static final ThreadLocal<AuthenticatedUser> principalLocal = new ThreadLocal<AuthenticatedUser>();


    public static Long getLoginUserId() {
        return userLocal.get() != null ? userLocal.get() : 0;
    }


    public static String getLoginUserIdAsString() {
        return getLoginUserId().toString();
    }


    /**
     * For static set only. User setLoginUser in web environment
     *
     * @param userId
     */
    public static void setLoginUserId(Long userId) {
        userLocal.set(userId);
    }


    public static AuthenticatedUser getLoginUser() {
        return principalLocal.get();
    }


    public static void setLoginUser(AuthenticatedUser user) {
        principalLocal.set(user);
        userLocal.set(user != null ? user.getUser().getId() : null);
    }


    public static void clearLoginUser() {
        userLocal.set(null);
        principalLocal.set(null);
    }


}
