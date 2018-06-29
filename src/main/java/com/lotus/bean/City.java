package com.lotus.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class City {
    private String id;

    private String provinceId;

    private String cityName;

    private String description;
}