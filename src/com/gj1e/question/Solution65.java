package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2020/3/23
 * @Time 12:01
 * 面试题65：不用加减乘除做加法
 *
 * 题目：
 *      写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * 思路：
 *      运用位运算符进行计算。
 */
public class Solution65 {
    public int add(int a, int b) {
        int sum = 0;
        int curry = 0;
        while(b != 0){
            sum = a ^ b;
            curry = (a & b) << 1;
            a = sum;
            b = curry;
        }
        return a;
    }
}
