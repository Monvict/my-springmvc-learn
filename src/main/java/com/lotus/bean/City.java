package com.lotus.bean;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Size;

@Data
@ToString
public class City {
    private String id;

    private String provinceId;

    @Size(min = 1, max = 5, message = "{city.name.len.msg}")
    private String cityName;

    private String description;
}