package com.gj1e.leetcode.hot;

/**
 * @author FenDa
 * 5. 最长回文子串
 */
public class Solution05 {
    /**
     * 解法一：暴力枚举 时间复杂度O(n3)
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 0) {
            return s;
        }
        String res = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j <= len; j++) {
                String tmp = s.substring(i, j);
                if (tmp.length() > max && isPalindrome(tmp)) {
                    max = tmp.length();
                    res = tmp;
                }
            }
        }
        return res;
    }

    private static boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i <= len/2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 动态规划 时间复杂度O(n2)
     * @param s
     * @return
     */
    public static String ways2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int len = s.length();
        char[] chars = s.toCharArray();
        int begin = 0;
        int maxLen = 1;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }


                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, maxLen + begin);
    }
}
