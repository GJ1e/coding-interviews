package com.gj1e.leetcode.dp;

/**
 * @author FenDa
 * 70. 爬楼梯
 */
public class Solution70 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        return way1(n, dp);
    }

    private int way1(int n, int[] dp) {
        if (n == 0) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = way1(n - 1, dp) + way1(n - 2, dp);
        return dp[n];
    }
}
