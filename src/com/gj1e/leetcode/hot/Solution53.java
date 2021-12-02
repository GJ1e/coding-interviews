package com.gj1e.leetcode.hot;

/**
 * @author FenDa
 * 53. 最大子序和
 */
public class Solution53 {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);
    }
}
