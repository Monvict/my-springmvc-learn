package com.lotus;

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

        StringBuffer sb =  new StringBuffer(sql);
        sb.append("(");
        for(int i = 0; i<list.size(); i++){
            sb.append("?,");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        System.out.println(sb.toString());
    }
}
