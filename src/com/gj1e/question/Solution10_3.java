package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2019/10/27
 * @Time 22:20
 *
 * 题目：
 *      我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 思路：
 *      斐波那契数列的变形题，思路就是递归循环。
 *      2*n的大矩形，和n个2*1的小矩形，其中n*2为大矩阵的大小，有以下几种情形：
 *      n <= 0 大矩形为<= 2*0,直接return 0；
 *      n = 1 大矩形为2*1，只有一种摆放方法，return1；
 *      n = 2 大矩形为2*2，有两种摆放方法，return2；
 *      n = 3 分为两步考虑：有三种摆放方法，所以f(3)=f(1)+f(2)
 *      以此类推，f(n)=f(n-1)+f(n-2)
 */
public class Solution10_3 {
    public int RectCover(int n){
        if (n<=0)
            return 0;
        else if (n==1)
            return 1;
        else if (n==2)
            return 2;
        else
            return RectCover(n-1) + RectCover(n-2);
    }
}
