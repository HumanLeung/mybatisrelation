package com.company.mybatis.entity;


import com.company.mybatis.plugin.EncodeStrategy;
import com.company.mybatis.plugin.Encoder;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/*
@Null 被注释的元素必须为null
@NotNull 被注释的元素必须不为Null
@NotEmpty
@AssertTrue 被注释的元素必须为true
@AssertFalse 被注释的元素必须为false
@Min(value) 被注释的元素是一个数字， >=
@Max(value) 被注释的元素必须是一个数字， <=
@DecimalMin(value) >=
@DecimalMax(value) <=
@Size(max, min)
@Digits(integer, fraction)
@Past be被注释的元素必须是一个过去的日期
@PastOrPresent 时间
@NegativeOrZero <= 0
@Future 被注释的元素必须是一个将来的日期
@Pattern(value) 被注释的元素必须符合指定的正则表达式
@Email
@Length
@Range
@URL
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student {
    private Integer id;

    @Encoder(strategy = EncodeStrategy.TEST)
    @NotEmpty
//    @NotNull(groups = {Student.class})
    @Size(min=2,message = "user name should have at least {min} character")
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
