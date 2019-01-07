package com.lotus.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    /***
     * 给当前时间加上N秒
     */
    public static String addSeconds(String pre, long addValue) {
        LocalDateTime localDateTime = LocalDateTime.parse(pre, DEFAULT_FORMATTER);
        return localDateTime.plusSeconds(addValue).format(DEFAULT_FORMATTER);
    }

    /**
     * 给当前时间增加N分钟
     */
    public static String addMinuts(String pre, long minuteValue) {
        return addSeconds(pre, minuteValue * 60);
    }
}
