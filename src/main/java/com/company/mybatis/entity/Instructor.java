package com.company.mybatis.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Instructor {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private InstructorDetail instructorDetail;
    private Course course;

    public Instructor(Integer id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
