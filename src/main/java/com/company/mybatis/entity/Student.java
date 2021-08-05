package com.company.mybatis.entity;


import com.company.mybatis.plugin.EncodeStrategy;
import com.company.mybatis.plugin.Encoder;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student {
    private Integer id;

    @Encoder(strategy = EncodeStrategy.TEST)
    private String firstName;
    private String lastName;
    private String email;
    private List<Course> courses;

    public Student(Integer id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
