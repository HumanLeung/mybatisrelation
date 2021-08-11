package com.company.mybatis.controller;

import com.company.mybatis.entity.Student;
import com.company.mybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;

import org.springframework.cache.CacheManager;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("my")
public class HelloController {
    /*
     在每个controller里面写上@ExceptionHandler可以处理当前controller里面抛出的异常
     集中处理ControllerAdvice
     */

    @Autowired
    private StudentService service;

    @Autowired
    private CacheManager cacheManager;

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
    }
}
