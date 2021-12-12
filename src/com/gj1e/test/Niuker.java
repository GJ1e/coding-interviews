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
        list.add("123abccd");
        list.add("abcdc123");
        list.add("1234abc");
        list.add("ab1234cd");
        List<String> strings = solution(list);
        strings.forEach(System.out::println);
    }
}



