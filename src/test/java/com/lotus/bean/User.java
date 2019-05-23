package com.lotus.bean;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private int age;
    private Date birth;
    private String name;
    private boolean good;
    private long times;
}
