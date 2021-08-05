package com.company.mybatis.mapper;

import com.company.mybatis.entity.Course;
import com.company.mybatis.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    public void addStudent(Student student);

    public void addCourses(Student student, Course course);

    public Student findStudent(Integer sid);

    public List<Student> findAllStudent();

    public void deleteStu(Integer sid);

}
