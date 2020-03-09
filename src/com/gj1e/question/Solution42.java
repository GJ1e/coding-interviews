package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2020/3/9
 * @Time 10:49
 * 面试题42：连续子数组的最大和
 *
 * 题目：
 *      输入一个整型数组，数组里有正数也有负数。数组中一个或连续多个整数组成一个子数组。求所有子数组和的最大值。
 *      要求时间复杂度为O(n)
 *
 */
public class Solution42 {

    /**
     * 使用动态规划
     * F（i）：以array[i]为末尾元素的子数组的和的最大值，子数组的元素的相对位置不变
     * F（i）=max（F（i-1）+array[i] ， array[i]）
     * maxSubSum：所有子数组的和的最大值
     * maxSubSum=max（maxSubSum，F（i））
     * @param array
     * @return
     */
    public int findGreatestSumOfSubArray(int[] array) {
        if (array==null || array.length<=0)
            return 0;
        int maxSubSum = array[0];   //记录最大连续子数组的和
        int curMaxSum = array[0];   //记录当前包括array[i]在内的最大连续子数组的和
        for (int i = 1; i < array.length; i++) {
            curMaxSum = Math.max(curMaxSum+array[i], array[i]);
            maxSubSum = Math.max(curMaxSum , maxSubSum);
        }
        return maxSubSum;
    }

    /**
     * 找规律，感觉和动态规划没有特别大的区别。
     * @param array
     * @return
     */
    public int findGreatestSumOfSubArray1(int[] array) {
        if (array==null || array.length<=0)
            return 0;
        int curSum = array[0];  //记录当前连续子数组的和
        int maxSubSum = array[0];   //记录最大连续子数字的和。
        for (int i = 1; i < array.length; i++) {
            if (curSum<=0)
                curSum = array[i];
            else
                curSum += array[i];

            if (curSum > maxSubSum)
                maxSubSum = curSum;
        }
        return maxSubSum;
    }
}
