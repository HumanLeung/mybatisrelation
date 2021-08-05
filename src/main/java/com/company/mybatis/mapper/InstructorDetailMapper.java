package com.company.mybatis.mapper;

import com.company.mybatis.entity.InstructorDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorDetailMapper {
    public void addInstructorDetail(InstructorDetail instructorDetail);
}
