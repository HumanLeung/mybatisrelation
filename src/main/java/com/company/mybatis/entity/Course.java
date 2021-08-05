package com.company.mybatis.entity;


import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {
    private Integer id;
    private String title;
    private Instructor instructor;
    private List<Student> students;

    public Course(Integer id, String title) {
        this.id = id;
        this.title = title;
    }
}
