package com.company.mybatis.handler;

import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.HandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyHttpRequestHandler implements HttpRequestHandler {
    HandlerAdapter handlerAdapter;
    MyHttpRequestHandler(HandlerAdapter handlerAdapter) {
        this.handlerAdapter = handlerAdapter;
    }
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        System.out.println(handlerAdapter);
        writer.write("response from MyHttpRequestHandler, uri: "+request.getRequestURI());
    }
}
