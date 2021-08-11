package com.company.mybatis.controller;

import com.company.mybatis.entity.Student;
import com.company.mybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;

import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("my")
public class HelloController {

    @Autowired
    private StudentService service;

    @Autowired
    private CacheManager cacheManager;

    @RequestMapping("/intercept/{num}")
    public Student test(@PathVariable @Valid Integer num) {
      return service.findStudent(num);
    }
    @PostMapping("/stu")
    public void add(@RequestBody @Valid Student student){
        System.out.println(student);
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
