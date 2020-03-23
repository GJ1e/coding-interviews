package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2020/3/23
 * @Time 11:25
 * 面试题64：求1+2+...+n
 *
 * 题目：
 *      求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 思路：
 *      利用短路规则，进行递归循环
 */
public class Solution64 {
    public int sumNums(int n) {
        boolean b = (n > 0) && (n += sumNums(n-1)) > 0;//第一种短路规则写法
      //boolean b = n == 0 || (n += sumNums(n-1)) > 0; //第二种短路规则写法
        return n;
    }


}
