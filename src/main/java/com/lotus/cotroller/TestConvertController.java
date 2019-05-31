package com.lotus.cotroller;

import com.lotus.bean.Items;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestConvertController {

    /***
     * 1. 在Items上加上@XmlRootElement注解
     * 2. 用curl进行请求，当请求头为Accept: application/xml时， 返回xml格式的数据
     * 3. 用curl进行请求，当请求头为Accept: application/json时， 返回json格式的数据
     * @return
     */
    @RequestMapping("/get-json-xml")
    public Items test1() {
        Items items = new Items();
        items.setDate("2019-05-27");
        items.setName("苹果笔记本");
        items.setDetail("还是买不起啊");
        return items;
    }
}
