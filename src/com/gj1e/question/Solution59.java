package com.gj1e.question;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author GJ1e
 * @Create 2020/3/20
 * @Time 16:00
 *
 * 面试题59：队列的最大值
 *
 * 题目：
 *      给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 *      那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 *
 * 思路：
 *      用一个双端队列，队列第一个位置保存当前窗口的最大值，当窗口滑动一次
 *      1.判断当前最大值是否过期
 *      2.新增加的值从队尾开始比较，把所有比他小的值丢掉
 *
 */
public class Solution59 {

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        if (num == null || num.length == 0 || size <= 0 || num.length < size) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        //双端队列，用来记录每个窗口的最大值下标
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!queue.isEmpty() && queue.peekFirst()<=i-size)
                queue.pollFirst();
            while (!queue.isEmpty() && num[i] >= num[queue.peekLast()])
                queue.pollLast();
            queue.addLast(i);

            if (i >= size-1)
                result.add(num[queue.peekFirst()]);
        }
        return result;
    }
}
