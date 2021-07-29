package com.gj1e.leetcode.dp;

/**
 * @author FenDa
 * 152. 乘积最大子数组
 */
public class Solution152 {
    public int maxProduct(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        int res = nums[0];
        dpMax[0] = dpMin[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(dpMax[i - 1] * nums[i], Math.max(dpMin[i - 1] * nums[i], nums[i]));
            dpMin[i] = Math.min(dpMax[i - 1] * nums[i], Math.min(dpMin[i - 1] * nums[i], nums[i]));
            res = Math.max(res, dpMax[i]);
        }
        return res;
    }

    //对解法1的空间优化
    private int ways2(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        int dpMax = nums[0];
        int dpMin = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int preMax = dpMax;
            dpMax = Math.max(dpMax * nums[i], Math.max(dpMin * nums[i], nums[i]));
            dpMin = Math.min(preMax * nums[i], Math.min(dpMin * nums[i], nums[i]));
            res = Math.max(res, dpMax);
        }
        return res;
    }

    //另一种思维：https://leetcode-cn.com/problems/maximum-product-subarray/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--36/
    //
    private int ways3(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        int sum = 1;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum *= nums[i];
            max = Math.max(sum, max);
            if (sum == 0) {
                sum = 1;
            }
        }
        sum = 1;
        for (int i = nums.length - 1; i >= 0; i++) {
            sum *= nums[i];
            max = Math.max(sum, max);
            if (sum == 0) {
                sum = 1;
            }
        }
        return max;
    }
}
