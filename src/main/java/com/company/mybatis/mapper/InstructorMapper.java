package com.company.mybatis.mapper;


import com.company.mybatis.entity.Instructor;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorMapper {
   Instructor findByAssociation(Integer id);

   public void addInstructor (Instructor instructor, Integer instructor_detail_id);

}
