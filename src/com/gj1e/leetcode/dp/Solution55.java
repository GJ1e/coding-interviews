package com.gj1e.leetcode.dp;

/**
 * @author FenDa
 * 55. 跳跃游戏
 */
public class Solution55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int range = nums[0];
        for (int i = 0; i <= range; i++) {
            range = Math.max(range, i + nums[i]);
            if (range >= nums.length) {
                return true;
            }
        }
        return false;
    }
}
