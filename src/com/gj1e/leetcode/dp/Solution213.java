package com.gj1e.leetcode.dp;

/**
 * @author FenDa
 * 213. 打家劫舍 II
 */
public class Solution213 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int a = process(nums, 0, nums.length - 2);
        int b = process(nums, 1, nums.length - 1);
        return Math.max(a, b);
    }

    private int process(int[] nums, int start, int end) {
        int[] dp = new int[end+1];
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start+1], nums[start]);
        for (int i = start+2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end];
    }
}
