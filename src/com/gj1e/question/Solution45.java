package com.gj1e.question;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @Author GJ1e
 * @Create 2020/3/11
 * @Time 11:15
 * 面试题45：把数组排成最小的数
 *
 * 题目：
 *      输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *      例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class Solution45 {

    public String printMinNumber(int [] numbers) {
        if (numbers==null || numbers.length<=0)
            return "";

        String result = "";
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<numbers.length; i++){
            list.add(numbers[i]);
        }

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1+""+o2;
                String s2 = o2+""+o1;
                return s1.compareTo(s2);
            }
        });

        for (int i : list) {
            result+=i;
        }
        return result;
    }
}
