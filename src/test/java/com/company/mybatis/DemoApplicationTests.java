package com.company.mybatis;

import com.company.two.Two;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Vector;


@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
//        LinkedList


        new OuterClass.InnerClass().does();

     OuterClass outerClass =  new OuterClass();
     outerClass.new NormalClass();

    }

}

class OuterClass {
   static final String cool = "1";
    static class InnerClass{
       String nice = cool;
       void does() {
           System.out.println("sys");
       }
    }
     class NormalClass{
        NormalClass() {

        }
        String e = cool;
    }
}
