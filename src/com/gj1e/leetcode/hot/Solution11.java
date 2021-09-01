package com.gj1e.leetcode.hot;

/**
 * @author FenDa
 * 11. 盛最多水的容器
 */
public class Solution11 {
    public int maxArea(int[] height) {
        int head = 0;
        int last = height.length-1;
        int max = -1;
        while (head < last) {
            max = Math.max(max,Math.min(height[head], height[last]) * (last - head));
            if (height[head] < height[last]) {
                head++;
            } else {
                last--;
            }
        }
        return max;
    }
}
