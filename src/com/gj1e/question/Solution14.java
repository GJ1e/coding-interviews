package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2019/11/1
 * @Time 23:27
 *
 * 面试题14：剪绳子
 *
 * 题目：
 *      给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m≥1）。
 *      每段的绳子的长度记为`k[0]、k[1]、……、k[m]。k[0]*k[1]*…*k[m]`可能的最大乘积是多少？
 *      例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到最大的乘积18。
 *
 * 思路：
 *      尽可能多地减去长度为3的绳子段,当绳子最后剩下的长度为4的时候，不能再剪去长度为3的绳子段。
 *      此时更好的方法是把绳子剪成长度为2的两段，因为`2*2 > 3*1`。
 */
public class Solution14 {
    public int maxProductAfterCutting(int length){
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;

        int timesOf3 = length / 3;  // 尽可能多地减去长度为3的绳子段

        // 当绳子最后剩下的长度为4的时候，不能再剪去长度为3的绳子段。
        // 此时更好的方法是把绳子剪成长度为2的两段，因为2*2 > 3*1。
        if (length - timesOf3*3 == 1)
            timesOf3 -= 1;

        int timesOf2 = (length - timesOf3 * 3) / 2;

        return (int) (Math.pow(3, timesOf3)) * (int) (Math.pow(2, timesOf2));


    }
}
