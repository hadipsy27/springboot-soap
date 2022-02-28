package com.bytecodedevelocity.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.server.MessageDispatcher;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import javax.servlet.ServletRegistration;

@EnableWs
@Configuration
public class WSDLConfiguration {
    // Request Handleer - Servlet -> ServletRegistration Bean -> MessageServlet
    // URL /soap/*

    @Bean
    public ServletRegistrationBean requestDicpacther(ApplicationContext context){
        MessageDispatcherServlet mds = new MessageDispatcherServlet();
        mds.setApplicationContext(context);
        mds.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(mds, "/soap/*");
    }

    @Bean
    public XsdSchema employeeSchema(){
        return new SimpleXsdSchema(new ClassPathResource("employee.xsd"));
    }

    @Bean
    public DefaultWsdl11Definition createWsdl(XsdSchema schema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("Employee");
        wsdl11Definition.setLocationUri("/soap");
        wsdl11Definition.setTargetNamespace("http://bytecodedevelocity.com/hrms");
        wsdl11Definition.setSchema(schema);
        return wsdl11Definition;
    }
}
