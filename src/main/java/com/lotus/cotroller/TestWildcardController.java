package com.lotus.cotroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试通配符标识请求路径，当有多个路径满足时取值问题
 */
@RestController
@RequestMapping("/wildcard")
public class TestWildcardController {

    @RequestMapping("/test/**")
    public String test1() {
        return "TestWildcardController ----> /test/**";
    }

    @RequestMapping("/test/*")
    public String test2() {
        return "TestWildcardController ----> /test/*";
    }

    @RequestMapping("test*")
    public String test3() {
        return "TestWildcardController ----> /test*";
    }

    @RequestMapping("/test?")
    public String test4() {
        return "TestWildcardController ----> /test?";
    }
}
