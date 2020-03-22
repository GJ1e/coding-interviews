package com.gj1e.question;

import java.util.Arrays;

/**
 * @Author GJ1e
 * @Create 2020/3/22
 * @Time 10:41
 * 面试题61：扑克牌中的顺子
 *
 * 题目：
 *      从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，
 *      而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 思路：
 *      1.对数组排序。2.统计0的个数。3.看排序后数组的最后一位和非0的第一位差值是不是<=4
 */
public class Solution61 {
    public boolean isContinuous(int [] nums) {
        if (nums == null || nums.length <= 0)
            return false;
        Arrays.sort(nums);
        int k = 0;
        while(nums[k] == 0)
            k++;
        for (int i = k+1; i < nums.length; i++) {
            if (nums[i] == nums[i-1])
                return false;
        }
        return (nums[nums.length-1] - nums[k]) <= 4;
    }
}
