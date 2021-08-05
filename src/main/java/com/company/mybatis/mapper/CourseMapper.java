package com.company.mybatis.mapper;

import com.company.mybatis.entity.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMapper {
  public void addCourse(Course course, Integer instructor_id);

  public Course findCourse(Integer cid);
}
