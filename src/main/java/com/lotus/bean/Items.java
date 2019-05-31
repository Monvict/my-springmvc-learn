package com.lotus.bean;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Tony
 * 2018-06-26 18:26
 **/
@Data
//@XmlRootElement
public class Items {

    private int id;

    private float price;

    private String detail;

    private String date;

    private String name;
}
