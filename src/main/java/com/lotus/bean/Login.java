package com.lotus.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

/**
 * @author Tony
 * 2018-07-03 15:12
 **/
@Data
@ToString
public class Login {
    @JsonIgnore
    private String name;

    private String password;
}
