package com.gj1e.leetcode.tree.question;


/**
 * @Author GJ1e
 * @Date 2021/5/31
 * 96. 不同的二叉搜索树
 */
public class Solution96 {
    public int numTrees(int n) {
       int[] dp = new int[n+1];
       dp[0] = 1;
       dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] += dp[j-1] * dp[n-j];
            }
        }
        return dp[n];
    }
}
