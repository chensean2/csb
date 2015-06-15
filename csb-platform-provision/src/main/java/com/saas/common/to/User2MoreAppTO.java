package com.saas.common.to;

public class User2MoreAppTO  extends SCBaseTO {

    private static final long serialVersionUID = 376082255714563306L;
    private String userMoreAppId;
    private String userId;
    private String moreAppIndicator;
    public String getUserMoreAppId() {
        return userMoreAppId;
    }
    public void setUserMoreAppId(String userMoreAppId) {
        this.userMoreAppId = userMoreAppId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getMoreAppIndicator() {
        return moreAppIndicator;
    }
    public void setMoreAppIndicator(String moreAppIndicator) {
        this.moreAppIndicator = moreAppIndicator;
    }
}
