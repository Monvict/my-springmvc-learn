package com.lotus.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    private String id;

    private String name;

    private String password;

    private Integer age;

    private String gender;

    private String phonenum;

    private String email;
}