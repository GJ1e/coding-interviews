package com.gj1e.leetcode.hot;

/**
 * @author FenDa
 * 33. 搜索旋转排序数组
 * 二分查找。
 */
public class Solution33 {
    public static int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int low = 0;
        int high = nums.length-1;
        while (low <= high) {
            int mid = (high+low)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,8,0,1,2};
        int[] nums1 = new int[]{3,1};
        int target = 1;
        search(nums, target);
    }
}
