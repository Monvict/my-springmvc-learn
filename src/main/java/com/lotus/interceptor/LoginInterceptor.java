package com.lotus.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Tony
 * 2018-07-03 14:20
 **/
@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        // 本来就是登陆页面
        String url = request.getRequestURI();
        if (url.indexOf("login") > 0) {
            log.info("Login action, pass!");
            return true;
        }

        // Session中有userName
        HttpSession session = request.getSession();
        if (!StringUtils.isEmpty(session.getAttribute("userName"))) {
            log.info("The user has logined, pass!");
            return true;
        }

        // 转发到登陆页面
        log.info("need to login first!");
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        return false;
    }
}
