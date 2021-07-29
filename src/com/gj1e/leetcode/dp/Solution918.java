package com.gj1e.leetcode.dp;

/**
 * @author FenDa
 */
public class Solution918 {
    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        int dp = nums[0];
        int sum = dp;
        int max = dp;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            dp = Math.max(dp + nums[i], nums[i]);
            max = Math.max(dp, max);
        }
        dp = 0;
        int min = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            dp = Math.min(dp + nums[i], nums[i]);
            min = Math.min(dp, min);
        }
        return Math.max(sum - min, max);
    }

    public static void main(String[] args) {

    }
}
