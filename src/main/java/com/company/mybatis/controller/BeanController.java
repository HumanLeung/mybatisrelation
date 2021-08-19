package com.company.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@RequestMapping("/ops")
@Service
public class BeanController {

    @Autowired
    HandlerMapping handlerMapping;

    @Autowired
    HandlerAdapter simpleControllerHandlerAdapter;


//    RequestMappingHandlerMapping

    @ResponseBody
    @GetMapping("test")
    public String test() {
        System.out.println(handlerMapping);
        System.out.println("it works");
        System.out.println(simpleControllerHandlerAdapter);
        return "cool";
    }

}
