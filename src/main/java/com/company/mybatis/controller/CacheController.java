package com.company.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
//@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private CacheManager cacheManager;

    @GetMapping("/test")
    public String cache() {
        Cache cache =  cacheManager.getCache("usersCache");
        assert cache != null;
        System.out.println(Objects.requireNonNull(cache.get("key")).get());
        return (String) Objects.requireNonNull(cache.get("key")).get();
    }
}
