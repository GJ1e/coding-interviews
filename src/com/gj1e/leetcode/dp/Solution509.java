package com.gj1e.leetcode.dp;

/**
 * @author FenDa
 * 509. 斐波那契数
 */
public class Solution509 {
    //暴力递归
    public int fib(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    //记忆化搜索，自顶向下
    public int fib2(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        dp[1] = 1;
        return ways2(n, dp);
    }

    private int ways2(int n, int[] dp) {
        if (dp[n] != -1){
            return dp[n];
        }
        dp[n] = ways2(n - 1, dp) + ways2(n - 2, dp);
        return dp[n];
    }

}
