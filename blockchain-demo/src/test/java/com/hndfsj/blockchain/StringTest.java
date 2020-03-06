package com.hndfsj.blockchain;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringJoiner;

/**
 * TODO：
 *
 * @author zhangjunchao
 * @date 2020/3/6
 */
public class StringTest {

    /**
     * string字符串拼接，追加：实现效果1,2,3,4
     */
    @Test
    public void stringJoin(){
        ArrayList<String> list = Lists.newArrayList();
        list.add("1");list.add("2");list.add("3");list.add("4");

        // 第一种方法（推荐），java8的stringjoin()实现  1,2,3,4
        String strJoin = String.join(",", list);
        System.out.println(strJoin);

        // 第二种方法（不推荐），StringBuffer拼接字符串方式  1,2,3,4
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s.concat(","));
        }
        System.out.println(sb.substring(0,sb.length()-1));

        // 此方法是第一种方法的底层实现代码
        StringJoiner joiner = new StringJoiner(",");
        for (String s : list) {
            joiner.add(s);
        }
        System.out.println(joiner.toString());

    }


    /**
     * 时间格式化：日期转字符串，字符串转日期
     */
    @Test
    public void dateFormat() throws ParseException {
        // JDK1.5
        Date date = new Date();

        // date日期转string字符串
        String formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        System.out.println(formatDate);

        // string字符串转date日期
        Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(formatDate);
        System.out.println(parse);

        // JDK 1.8
        LocalDateTime ldt = LocalDateTime.now();

        // localDate日期转string字符串
        String localDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(ldt);
        System.out.println(localDate);

        // string字符串转localDate日期
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(localDate, dtf);
        System.out.println(localDateTime);

    }










}
