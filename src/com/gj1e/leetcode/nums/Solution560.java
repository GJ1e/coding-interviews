package com.gj1e.leetcode.nums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FenDa
 */
public class Solution560 {
    int i = 0;
    public static int subarraySum(int[] nums, int k) {
        List<List<Integer>> res = new ArrayList<>();
        process(nums, k, new ArrayList<>(), res);
        return res.size();
    }

    private static void process(int[] nums, int target, List<Integer> tmp, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i : nums) {
            tmp.add(i);
            process(nums, target-i, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1};
        int a = subarraySum(nums, 2);
        System.out.println(a);
    }
}
