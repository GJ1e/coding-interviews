package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2019/10/15
 * @Time 20:05
 *
 * 剑指offer
 * 面试题10:斐波那契数列
 *
 * 题目：
 *      大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 *
 * 思路：
 *      第一种递归。
 *      第二种找规律，f(0)=0,f(1)=1,f(2)=f(1)+f(0),f(3)=f(2)+f(1)···以此类推
 */
public class Solution10 {
    //递归
    public int fibonacci01(int n){
        if (n<=0)
            return 0;
        else if (n == 1)
            return 1;

        return fibonacci01(n-1) + fibonacci01(n-2);
    }

    //找规律
    public int fibonacci02(int n){
        if (n<=0)
            return 0;
        else if (n == 1)
            return 1;

        int fibOne = 1;
        int fibTwo = 0;
        int fibN = 0;

        for (int i = 2; i <= n; i++) {
            fibN = fibOne + fibTwo;
            fibTwo = fibOne;
            fibOne = fibN;
        }
        return fibN;
    }
}
