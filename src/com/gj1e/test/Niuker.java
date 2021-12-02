package com.gj1e.test;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author FenDa
 */
public class Niuker {
    public static List<String> solution(List<String> list) {
        List<String> res = new ArrayList<>();
        if (list.size() <= 0) {
            return res;
        }
        List<String> numString = new ArrayList<>();
        for (int j = 0; j < list.size(); j++) {
            String ele = list.get(j);
            StringBuilder numKey = new StringBuilder();
            for (int i = 0; i < ele.length(); i++) {
                if (ele.charAt(i) >= '0' && ele.charAt(i) <= '9') {
                    numKey.append(ele.charAt(i));
                }
            }
            if (!numString.contains(numKey.toString())) {
                res.add(list.get(j));
                numString.add(numKey.toString());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("asdhfj123");
        list.add("123sdfs");
        list.add("asda1234htfh");
        list.add("1234fsasd");
        List<String> strings = solution(list);
        strings.forEach(System.out::println);

        Date date = new Date();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        cl.add(Calendar.HOUR,24);
        date = cl.getTime();
        boolean before = date.before(new Date());
        System.out.println(before);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
    }
}



