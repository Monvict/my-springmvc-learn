package com.lotus;

import com.lotus.utils.DateUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Tony
 * 2018-06-27 10:28
 **/
public class Test {
    public static void main(String[] args) {
//        List<String> list = new LinkedList<>();
//
//        list.add(0, "A");
//        list.add(0, "B");
//        list.add(0, "C");
//        System.out.println("Nice to meet you");
//        System.out.println(list);

        String sql = "select * from cs_user where id in ";
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("ff");
        list.add("gg");
        list.add("hh");
        list.add("dd");

        list.add("mmmm");
        list.add("kkkkkkk");
        list.add("ppppppp");

        list.add("qqqqqqqqqqqqqqqqqqqq");
        list.add("llllllllllllll");
        list.add("mmmmmmmmmmmmmm");




        StringBuffer sb =  new StringBuffer(sql);
        sb.append("(");
        for(int i = 0; i<list.size(); i++){
            sb.append("?,");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        System.out.println(sb.toString());

        System.out.println(DateUtils.addSeconds("20181223123456", 1000));
        System.out.println(DateUtils.addHours("20181223123456", 1));

        System.out.println(DateUtils.addSeconds("20181223123456", 1000));
        System.out.println(DateUtils.addHours("20181223123456", 1));
        System.out.println(DateUtils.addMinuts("20181223123456", 1));
    }
}
