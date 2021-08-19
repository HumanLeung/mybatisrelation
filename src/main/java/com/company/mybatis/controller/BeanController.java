package com.company.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.format.WebConversionService;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.ConversionServiceExposingInterceptor;
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@RequestMapping("/ops")
@Service
public class BeanController {

    @Autowired
    HandlerMapping handlerMapping;

    @Autowired
    HandlerAdapter simpleControllerHandlerAdapter;

    @Autowired
    DispatcherServlet dispatcherServlet;

    @Autowired
    ConversionService conversionService;



//    @Autowired
//    HandlerExecutionChain handlerExecutionChain;


//    RequestMappingHandlerMapping

    @ResponseBody
    @GetMapping("test")
    public String test() throws Exception {
        HttpServletRequest request= ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        System.out.println(handlerMapping);
        System.out.println("it works");
        System.out.println(handlerMapping.getHandler(request));
        System.out.println(simpleControllerHandlerAdapter);
        System.out.println(handlerMapping);
        dispatcherServlet.setDetectAllHandlerAdapters(true);
        assert dispatcherServlet.getHandlerMappings() != null;
        System.out.println(dispatcherServlet.getHandlerMappings().get(1).getClass());
        System.out.println(Objects.requireNonNull(dispatcherServlet.getHandlerMappings().get(0).getHandler(request)).getHandler());
//        System.out.println(dispatcherServlet.getWebApplicationContext());
//        System.out.println(dispatcherServlet.getWebApplicationContext());
//        System.out.println(dispatcherServlet.getServletContext());
        return "cool";
    }

    @GetMapping("test2")
    @ResponseBody
    public String test2() throws Exception {
//        ConversionServiceExposingInterceptor
        HttpServletRequest request= ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        System.out.println(Objects.requireNonNull(dispatcherServlet.getHandlerMappings().get(0).getHandler(request)).getInterceptorList());
        System.out.println(Objects.requireNonNull(dispatcherServlet.getHandlerMappings().get(0).getHandler(request)));
//        System.out.println(conversionService.getClass());
//        WebConversionService
        return "haha";
    }

}
