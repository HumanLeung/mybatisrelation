package com.company.mybatis.handler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.AbstractDetectingUrlHandlerMapping;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter;

@Configuration
public class AppConfig {

    @Autowired
    HandlerMapping handlerMapping;

    @Autowired
    HandlerAdapter simpleControllerHandlerAdapter;

    @Autowired
    BeanNameUrlHandlerMapping abstractDetectingUrlHandlerMapping;

    @Autowired
    DispatcherServlet dispatcherServlet;

    @Bean(name="/example")
    public Controller simpleControllerHandler() {
        System.out.println(handlerMapping+"this is mapper");
        System.out.println(simpleControllerHandlerAdapter);
        System.out.println(abstractDetectingUrlHandlerMapping);
        return new MySimpleControllerHandler();
    }

    @Bean("/info")
    public HttpRequestHandler httpRequestHandler () {
        System.out.println(handlerMapping+"this is mapper");
        System.out.println(simpleControllerHandlerAdapter);
        System.out.println(abstractDetectingUrlHandlerMapping);
        System.out.println(dispatcherServlet+"dis");
        return new MyHttpRequestHandler(simpleControllerHandlerAdapter, dispatcherServlet);
    }
}
