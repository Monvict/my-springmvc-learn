package com.lotus;

import com.lotus.bean.User;
import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.propertyeditors.CustomDateEditor;


import java.text.SimpleDateFormat;
import java.util.Date;

public class BeanWraperTest {

    @Test
    public void testWraper() {
        User user = new User();
        BeanWrapper userWrapper = new BeanWrapperImpl(user);
        userWrapper.setPropertyValue("good", "on");

        System.out.println(user);
    }

    @Test
    public void testWrapper2() {
        User user = new User();
        BeanWrapper bw = new BeanWrapperImpl(user);
        bw.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), false));
        bw.setPropertyValue("birth", "1990-06-12");

        System.out.println(user);
    }
}
