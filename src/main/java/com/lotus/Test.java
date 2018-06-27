package com.lotus;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Tony
 * 2018-06-27 10:28
 **/
public class Test {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();

        list.add(0, "A");
        list.add(0, "B");
        list.add(0, "C");

        System.out.println(list);
    }
}
