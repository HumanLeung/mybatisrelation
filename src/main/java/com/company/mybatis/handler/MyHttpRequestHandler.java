package com.company.mybatis.handler;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerExecutionChain;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class MyHttpRequestHandler implements HttpRequestHandler {
    HandlerAdapter handlerAdapter;
    DispatcherServlet dispatcherServlet;

    MyHttpRequestHandler(HandlerAdapter handlerAdapter, DispatcherServlet dispatcherServlet) {
        this.handlerAdapter = handlerAdapter;
        this.dispatcherServlet = dispatcherServlet;
    }
    @SneakyThrows
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpServletRequest reques1= ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        PrintWriter writer = response.getWriter();
        System.out.println(handlerAdapter);
        System.out.println(request.getHttpServletMapping().getMappingMatch() + "this is match");
        System.out.println(dispatcherServlet);
        writer.write("response from MyHttpRequestHandler, uri: "+request.getRequestURI());
    }
}
