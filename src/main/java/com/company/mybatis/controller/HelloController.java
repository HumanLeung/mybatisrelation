package com.company.mybatis.controller;

import com.company.mybatis.entity.Student;
import com.company.mybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("my")
public class HelloController {

    @Autowired
    private StudentService service;

    @RequestMapping("/intercept")
    public Student test() {
      return service.findStudent(1);
    }
}
