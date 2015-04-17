package com.saas.webservices.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IsvCommon {
    public static String getDateString(Date datetime, String dateformat) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat(dateformat);
        return dateFormat.format(datetime);
    }

    public static void main(String[] args) {
        String dateformat = "yyyy/MM/dd HH:mm:ss";

        try {
            System.out.println("Date Time : " + getDateString(new Date(), dateformat));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
