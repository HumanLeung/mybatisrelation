package com.company.mybatis.controller;

import com.company.mybatis.entity.Course;
import com.company.mybatis.entity.Instructor;
import com.company.mybatis.entity.Student;
import com.company.mybatis.pojo.PageRequest;
import com.company.mybatis.service.StudentService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    public StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/testOne")
    public Instructor oneToOne () {
        return service.findByAssociation(1);
    }

    @PostMapping("/addInstructor")
    public void addInstructor() {
        service.AddInstructor("Nike","John","123@qq.com","www.youtube.com","run");
    }
    @PostMapping("/addCourse")
    public void addCourse() {
        service.addCourse("Java",5);
    }
    @PostMapping("/addStudent")
    public void addStudent() {
        service.addStudent("Human","Leung","1234@Gmail.com");
    }

    @PostMapping("/addCS")
    public void addCourses() {
        service.addCourses(1, 1);
    }

    @GetMapping("/getStudent")
    public Student getStudent() {
       return service.findStudent(1);
    }

    @GetMapping("/getCourse")
    public Course getCourse() {
        return service.findCourse(1);
    }

    @GetMapping("/getAllStus/{page}/{size}")
    public List<?> getAllStus(@PathVariable Integer page, @PathVariable Integer size) {
        System.out.println(service.findAllStudent(page,size));
        return service.findAllStudent(page,size).getContent();
    }

    @DeleteMapping("deleteStu")
        public void deleteStu() {
         service.deleteStu(3);
        }

}
