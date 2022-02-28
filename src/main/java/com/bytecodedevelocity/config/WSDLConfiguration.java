package com.bytecodedevelocity.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.server.MessageDispatcher;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

import javax.servlet.ServletRegistration;

@EnableWs
@Configuration
public class WSDLConfiguration {
    // Request Handleer - Servlet -> ServletRegistration Bean -> MessageServlet
    // URL /soap/*

    public ServletRegistrationBean requestDicpacther(ApplicationContext context){
        MessageDispatcherServlet mds = new MessageDispatcherServlet();
        mds.setApplicationContext(context);
        mds.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(mds, "/soap/*");
    }
}
