package com.lotus.cotroller;

import com.lotus.bean.Items;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tony
 * 2018-06-27 11:04
 **/
public class ItemControllerHttp implements HttpRequestHandler {

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("step in void handleRequest");

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

        request.setAttribute("itemsList",itemsList);
        request.getRequestDispatcher("/WEB-INF/views/itemList.jsp").forward(request, response);
    }
}
