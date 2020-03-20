package com.gj1e.question;

import java.util.ArrayList;

/**
 * @Author GJ1e
 * @Create 2020/3/20
 * @Time 11:46
 *
 * 面试题57题变形题：和为s的连续正数序列
 *
 * 题目：
 *      输入一个正数S，打印出所有和为S的连续正数序列（至少含有两个数字）。
 *
 * 思路：
 *      双指针，就是相当于有一个窗口，窗口的左右两边就是两个指针，我们根据窗口内值之和来确定窗口的位置和宽度。
 */
public class Solution57_1 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int small = 1; //窗口左端的指针
        int big = 2;    //窗口右端的指针
        while (big>small){
            //当前窗口中的序列和，因为连续，且等差，直接求和公式
            int curSum = (big+small) * (big-small+1) / 2;
            if (curSum == sum){
                //符合要求，则将当前窗口中的序列记录并保存
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                result.add(list);
                //保存完，移动窗口指针
                big++;
            }else if (curSum < sum)
                //当前窗口序列和比目标值小，就移动窗口大的一端。
                big++;
            else //当前窗口序列和比目标值大，就移动窗口小的一端。
                small++;
        }
        return result;


    }
}
