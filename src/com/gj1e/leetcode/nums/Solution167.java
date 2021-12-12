package com.gj1e.leetcode.nums;

/**
 * @author FenDa
 * 167. 两数之和 II - 输入有序数组
 */
public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            } else {
                return new int[]{l + 1, r + 1};
            }
        }
        return new int[]{};
    }
}
