package com.lotus.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/view")
public class TestViewController {

    @RequestMapping("test-jsp")
    public ModelAndView test1() {
        return new ModelAndView("jsp:index");
    }

    @RequestMapping("test-fm")
    public ModelAndView test2() {
        return new ModelAndView("freemarker:index");
    }
}
