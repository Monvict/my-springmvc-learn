package com.lotus.cotroller;

import com.lotus.bean.Login;
import com.lotus.bean.User;
import com.lotus.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author Tony
 * 2018-07-03 14:02
 **/
@Controller
@Slf4j
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/register")
    public ModelAndView register() {

        // 首页的“注册”链接(GET方法)转移到注册页面
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/register");
        return mv;
    }

    @PostMapping("/register")
    public ModelAndView doRegister(HttpSession session, User user) {

        // 存入数据库
        session.setAttribute("userName", user.getName());
        userMapper.insert(user);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/cities");
        return mv;
    }

    @PostMapping("/login")
    public ModelAndView login(HttpSession session, Login login) {
        log.info("receive loginInfo = {}", login);

        ModelAndView mv = new ModelAndView();
        User user = userMapper.selectByName(login.getName(), login.getPassword());
        if (user == null) {
            log.warn("wrong username or password!");
            mv.setViewName("/login");
            return mv;
        }

        // 将用户放入到session当中
        session.setAttribute("userName", user.getName());
        // 转到“城市列表”页面
        mv.setViewName("redirect:/cities");
        return mv;
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session) {

        log.info("need to clean session info when logout");
        session.invalidate();

        // 转到“城市列表”页面
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/cities");
        return mv;
    }
}
