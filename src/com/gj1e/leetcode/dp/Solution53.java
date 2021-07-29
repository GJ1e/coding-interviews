package com.gj1e.leetcode.dp;


/**
 * @author FenDa
 * 53. 最大子序和
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private int ways2(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        int sum = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Solution53 a = new Solution53();
        System.out.println(a.ways2(nums));
        System.out.println(a.maxSubArray(nums));
    }
}
