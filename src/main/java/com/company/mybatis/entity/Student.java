package com.company.mybatis.entity;


import com.company.mybatis.plugin.EncodeStrategy;
import com.company.mybatis.plugin.Encoder;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student {
    private Integer id;

    @Encoder(strategy = EncodeStrategy.TEST)
    @NotEmpty
    @Size(min=2,message = "user name should have at least 2 character")
    private String firstName;
    private String lastName;

    @NotEmpty
    @Email
    private String email;
    private List<Course> courses;

    public Student(Integer id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
