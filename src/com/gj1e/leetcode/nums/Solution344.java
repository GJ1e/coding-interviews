package com.gj1e.leetcode.nums;

/**
 * @author FenDa
 * 344. 反转字符串
 */
public class Solution344 {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }
}
