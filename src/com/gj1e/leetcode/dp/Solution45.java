package com.gj1e.leetcode.dp;

/**
 * @author FenDa
 */
public class Solution45 {
    public int jump(int[] nums) {
        int second = 0;
        int max = 0;
        int cur = 0;
        if (nums.length == 1) {
            return second;
        }
        max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) {
                second++;
                break;
            }
            if (i == cur) {
                cur = max;
                second++;
            }
        }
        return second;
    }
}
