package com.csb.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring {@link ApplicationContext} singleton to hold the context
 *
 * @author 
 * @since 19/11/2012 10:00 AM
 */
@Component
public class SpringApplicationContextHolder implements ApplicationContextAware {

    private static ApplicationContext context;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }


    public static ApplicationContext get() {
        return context;
    }


}
