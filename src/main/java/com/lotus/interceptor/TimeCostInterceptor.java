package com.lotus.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 计算处理器执行一个方法花费的时间
 * @author Tony
 * 2018-07-03 11:06
 **/
@Component
@Slf4j
public class TimeCostInterceptor extends HandlerInterceptorAdapter {
    NamedThreadLocal<LocalDateTime> startTimeLocal = new NamedThreadLocal<>("Start Time Thread Local");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) {
        LocalDateTime startTime = LocalDateTime.now();
        startTimeLocal.set(startTime);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) {
        LocalDateTime endTime = LocalDateTime.now();
        Duration duration = Duration.between(startTimeLocal.get(), endTime);
        log.info("Total cost {} ms for [{}]", duration.toMillis(), request.getRequestURI());
    }
}
