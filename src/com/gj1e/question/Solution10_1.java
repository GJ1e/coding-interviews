package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2019/10/15
 * @Time 20:18
 *
 * 剑指offer
 * 面试题10的扩展题：青蛙跳台阶问题
 *
 * 题目：
 *      一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * 思路：
 *      和面试题10的思路差不多，一种递归，一种找规律。
 *      找规律：f(0)=0,f(1)=1,f(2)=2,f(3)=f(1)+f(2),f(4)=f(2)+f(3)···以此类推。
 */
public class Solution10_1 {

    //递归
    public int JumpFloor(int n){
        if (n<=0)
            return 0;
        else if (n==1)
            return 1;
        else if (n==2)
            return 2;

        return JumpFloor(n-1) + JumpFloor(n-2);
    }

    //找规律
    public int JumpFloor01(int n){
        if (n<=0)
            return 0;
        else if (n==1)
            return 1;
        else if (n==2)
            return 2;

        int jumpOne = 1;
        int jumpTwo = 2;
        int jumpN = 0;

        for (int i = 3; i <= n; i++) {
            jumpN = jumpOne + jumpTwo;
            jumpOne = jumpTwo;
            jumpTwo = jumpN;
        }
        return jumpN;
    }
}
