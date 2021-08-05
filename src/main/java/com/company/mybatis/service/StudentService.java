package com.company.mybatis.service;

import com.company.mybatis.entity.Course;
import com.company.mybatis.entity.Instructor;
import com.company.mybatis.entity.InstructorDetail;
import com.company.mybatis.entity.Student;
import com.company.mybatis.mapper.CourseMapper;
import com.company.mybatis.mapper.InstructorDetailMapper;
import com.company.mybatis.mapper.InstructorMapper;
import com.company.mybatis.mapper.StudentMapper;
import com.company.mybatis.pojo.PageRequest;
import com.company.mybatis.pojo.PageResult;
import com.company.mybatis.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.AutoConfigurationImportSelector;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    private final InstructorMapper instructorMapper;
    private final InstructorDetailMapper instructorDetailMapper;
    private final CourseMapper courseMapper;
    private final StudentMapper studentMapper;

    @Autowired
    public StudentService(InstructorMapper instructorMapper, InstructorDetailMapper instructorDetailMapper,
                          CourseMapper courseMapper, StudentMapper studentMapper) {
        this.instructorMapper = instructorMapper;
        this.instructorDetailMapper = instructorDetailMapper;
        this.courseMapper = courseMapper;
        this.studentMapper = studentMapper;
        System.out.println("studentService is called");
    }

    public Instructor findByAssociation(Integer id) {
        return instructorMapper.findByAssociation(id);
    }

    public void AddInstructor(String firstName, String lastName, String email,
                              String youtubeChannel, String hobby) {
        InstructorDetail instructorDetail = new InstructorDetail(null, youtubeChannel, hobby);
        instructorDetailMapper.addInstructorDetail(instructorDetail);

        Instructor instructor = new Instructor(null, firstName, lastName, email);
        instructorMapper.addInstructor(instructor, instructorDetail.getId());
    }

    public void addCourse(String title, Integer instructor_id) {
        Course course = new Course(null, title);
        courseMapper.addCourse(course, instructor_id);
    }

    public void addStudent(String firstName, String lastName, String email) {
        Student student = new Student(null, firstName, lastName, email);
        studentMapper.addStudent(student);
    }

    public void addCourses(Integer cid, Integer sid) {
        Student student = studentMapper.findStudent(sid);
        Course course = courseMapper.findCourse(cid);
        studentMapper.addCourses(student, course);
    }

    public Student findStudent(Integer sid) {
        return studentMapper.findStudent(sid);
    }

    public Course findCourse(Integer cid) {
        return courseMapper.findCourse(cid);
    }

    @Transactional
    public void deleteStu(Integer sid) {
        studentMapper.addStudent(new Student(null, "john", "lad", "aew"));
        Student student = studentMapper.findStudent(4);
        studentMapper.deleteStu(student.getId());
//        studentMapper
    }

    public PageResult findAllStudent(Integer page, Integer size) {
        PageRequest pageRequest = new PageRequest(page, size);
//        SpringFactoriesLoader
//        AutoConfigurationImportSelector
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    private PageInfo<Student> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Student> StuList = studentMapper.findAllStudent();
        return new PageInfo<>(StuList);
    }
}


