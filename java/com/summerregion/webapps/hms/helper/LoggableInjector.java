/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.helper;

import java.io.Serializable;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author LENOVO
 */
@Singleton
@Named(value="loggableInjector")
public class LoggableInjector implements Serializable {
    
    @Produces
    @ILoggable
    public static Logger createLogger(InjectionPoint ip) {
       return LoggerFactory.getLogger(ip.getMember().getDeclaringClass().getName());
    }
}
