package com.gj1e.leetcode.dp;

/**
 * @author FenDa
 * 740. 删除并获得点数
 */
public class Solution740 {
    public int deleteAndEarn(int[] nums) {
        int[] trans = new int[10001];
        for (int i = 0; i < nums.length; i++) {
            trans[nums[i]] += nums[i];
        }
        return nums[1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 3, 3, 4};
        Solution740 s = new Solution740();
        s.deleteAndEarn(nums);
    }
}
