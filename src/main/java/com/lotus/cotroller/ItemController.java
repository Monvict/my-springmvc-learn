package com.lotus.cotroller;

import com.lotus.bean.Items;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tony
 * 2018-06-26 18:24
 **/
public class ItemController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        System.out.println("step in .ModelAndView handleRequest");

        List<Items> itemsList = new ArrayList<Items>();
        Items items_1 = new Items();
        items_1.setName("联想笔记本");
        items_1.setPrice(6000f);
        items_1.setDetail("ThinkPad T 430");

        Items items_2 = new Items();
        items_2.setName("苹果手机");
        items_2.setPrice(5000f);
        items_2.setDetail("iphone6s");

        itemsList.add(items_1);
        itemsList.add(items_2);

        //返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        //相当于request的setAttribute方法，在jsp页面中就可以通过items取数据了
        modelAndView.addObject("itemsList", itemsList);

        System.out.println(itemsList);
        //指定视图
        modelAndView.setViewName("/WEB-INF/views/itemList.jsp");
        return modelAndView;
    }
}
