package com.gj1e.question;

import java.util.*;

/**
 * @Author GJ1e
 * @Create 2020/3/8
 * @Time 9:35
 * 面试题40：最小的K个数
 *
 * 题目：
 *      输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4
 *
 * 思路：
 *      法一：排序，然后找出所要求的K个数。
 *      法二：用一个最大堆来做容器，容器满了之后，只需要进行比较，然后替换就好。最大堆的堆顶就是容器中里的最大值。
 *
 */
public class Solution40 {
    //方法一：
    public ArrayList<Integer> getLeastNumbers(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input==null || input.length<=0 || k>input.length)
            return list;
        Arrays.sort(input); //升序排序
        for (int i = 0; i < k; i++) {
            list.add(input[i]); //找出要求的K个数
        }
        return list;
    }

    //方法二：
    public ArrayList<Integer> getTopKNumbers(int[] input, int k){
            ArrayList<Integer> list = new ArrayList<>();
            if (input==null || input.length<=0 || k>input.length)
                return list;
            Queue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
                //让这个堆变成降序排列
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            //循环比较
            for (int i = 0; i < input.length; i++) {
                if (maxHeap.size() != k){
                    maxHeap.offer(input[i]);
                }else if (maxHeap.peek() > input[i]){
                        maxHeap.poll();
                        maxHeap.offer(input[i]);
                }
            }
            for (int i : maxHeap) {
                list.add(i);
            }
            return list;
    }
}
