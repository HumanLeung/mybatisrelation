package com.company.mybatis.controller;

import com.company.mybatis.entity.Student;
import com.company.mybatis.service.StudentService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.cache.Cache;

import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@RestController("haha")
@RequestMapping("my")
public class HelloController implements ApplicationContextAware {
    /*
     在每个controller里面写上@ExceptionHandler可以处理当前controller里面抛出的异常
     集中处理ControllerAdvice
     */

    @Autowired
    private StudentService service;

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    ServletContext context;

    @RequestMapping("/intercept/{num}")
    public Student test(@PathVariable @Valid Integer num) {
      return service.findStudent(num);
    }

    @PostMapping("/stu")
    public void add(@RequestBody @Valid Student student , BindingResult result){
//        if (result.hasErrors()){
//            for (ObjectError error : result.getAllErrors()) {
//                System.out.println(error.getObjectName());
//                System.out.println(error.getDefaultMessage());
//                System.out.println(result.hasErrors());
//            }
//        }
        System.out.println(student);
    }

    @ExceptionHandler(BindException.class)
    public String handleEx(BindException e) {
        List<FieldError> fieldErrors = e.getFieldErrors();
        StringBuilder sb = new StringBuilder();
        for (FieldError fe: fieldErrors) {
            sb.append("attributes").append(fe.getField())
               .append("failed to check ").append(fe.getDefaultMessage());
        }
        return sb.toString();
    }

    @GetMapping("cache")
    public String cache(){
        Cache cache = cacheManager.getCache("usersCache");
        cache.put("key","asdas");
        return "jaja";
    }
    @GetMapping("/delete")
    public void delete(){
        Cache cache = cacheManager.getCache("usersCache");
        cache.evict("key");
        System.out.println(cache.get("key"));
        ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(context);
        System.out.println(ac.getApplicationName().toLowerCase());
        System.out.println(ac.getDisplayName()+"Utils");
        System.out.println(ac.getClass().getName());
        System.out.println(ac.getBean("studentService").toString());
//        AnnotationConfigServletWebServerApplicationContext
//        ContextLoaderListener
//        DispatcherServlet
//        WebApplicationContext
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        XmlWebApplicationContext xmlWebApplicationContext = (XmlWebApplicationContext) applicationContext.getBean("dispatcherServlet");
//        System.out.println(xmlWebApplicationContext.getClass());
        System.out.println(applicationContext.getBean("haha").getClass());
        System.out.println(applicationContext.getDisplayName()+"controller");

    }
}
