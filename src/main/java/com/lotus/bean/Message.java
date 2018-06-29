package com.lotus.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Message {
    private String id;

    private String user;

    private String time;

    private String msg;
}