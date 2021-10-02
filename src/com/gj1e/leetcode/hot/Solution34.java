package com.gj1e.leetcode.hot;


import java.util.ArrayList;
import java.util.List;

/**
 * @author FenDa
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class Solution34 {
    public static int[] searchRange(int[] nums, int target) {
        int size = nums.length;
        int[] res = new int[2];
        List<Integer> list = new ArrayList<>();
        if (size <= 0) {
            return new int[]{-1, -1};
        }
        if (size == 1) {
            return nums[0] == target ? new int[]{0, 0} : new int[]{-1, -1};
        }
        int low = 0;
        int high = size-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                list.add(mid);
            }
        }
        res[0] = list.get(0);
        res[1] = list.get(list.size() - 1);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        searchRange(nums, 8);
    }
}
