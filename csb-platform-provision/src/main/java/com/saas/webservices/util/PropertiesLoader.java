package com.saas.webservices.util;

import java.io.InputStream;
import java.util.Properties;

import com.saas.webservices.config.IsvConstants;

public class PropertiesLoader {

    public Properties loadProps(String filename) throws Exception {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(filename + IsvConstants.PROPERTIES_POST);
        Properties configProp = new Properties();
        configProp.load(in);
        return configProp;
    }

    public static void main(String[] args) {
        try {
            PropertiesLoader sample = new PropertiesLoader();
            Properties configProp = sample.loadProps("saas-webservices-config");
            System.out.println(configProp.getProperty("service.request.xmlns"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

}
