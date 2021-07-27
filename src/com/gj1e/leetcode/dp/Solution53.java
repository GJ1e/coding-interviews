package com.gj1e.leetcode.dp;

import sun.reflect.generics.tree.ClassSignature;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FenDa
 * 53. 最大子序和
 */
public class Solution53 {
    int max = Integer.MIN_VALUE;
    List<String> res = new ArrayList<>();
    public int maxSubArray(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        process(nums,0,"");
        return max;
    }

    private void process(int[] nums, int index, String path) {
        if (index == nums.length) {
            res.add(path);
            return;
        }
        process(nums, index + 1, path);
        process(nums, index + 1, path + ","+ String.valueOf(nums[index]));
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,3};
        Solution53 s = new Solution53();
        s.maxSubArray(nums);
        s.res.stream().forEach(System.out::println);
        System.out.println(s.max);
    }
}
