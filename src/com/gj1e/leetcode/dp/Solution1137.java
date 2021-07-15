package com.gj1e.leetcode.dp;

/**
 * @author FenDa
 * 1137. 第 N 个泰波那契数
 */
public class Solution1137 {
    //暴力递归
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

    public int tribonacci2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        return ways2(n, dp);
    }

    //记忆搜索，自顶向下
    private int ways2(int n, int[] dp) {
        if (n == 0) {
            return 0;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = ways2(n-1,dp) + ways2(n-2,dp) + ways2(n-3,dp);
        return dp[n];
    }
}
