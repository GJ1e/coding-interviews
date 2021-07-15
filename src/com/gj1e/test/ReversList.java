package com.gj1e.test;

import sun.jvmstat.perfdata.monitor.AliasFileParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author FenDa
 */
public class ReversList {
    public static List<Integer> solution(List<Integer> list, int k) {
        if (list == null || k <0 ) {
            return list;
        }
        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int nums = list.size() / k;
        int index = 0;
        for (int i = 0; i < nums; i++) {
            for (int j = 0; j < k; j++) {
                stack.push(list.get(index));
                index++;
            }
            while (!stack.isEmpty()) {
                res.add(stack.pop());
            }
        }
        for (int i = index; i < list.size(); i++) {
            res.add(list.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            list.add(i);
        }
        System.out.println("反转前：");
        for (int i :
                list) {
            System.out.print(i+"，");
        }
        System.out.println();
        List<Integer> res = solution(list, 3);
        System.out.println("反转后：");
        for (int i :
                res) {
            System.out.print(i+"，");
        }
    }
}
