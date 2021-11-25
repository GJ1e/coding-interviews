package com.gj1e.leetcode.hot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author FenDa
 * 46. 全排列
 */
public class Solution46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>(nums.length);
        boolean[] used = new boolean[nums.length];
        for (int i : nums) {
            list.add(i);
        }
//        process(list, 0, res);
//        dfs(nums,0,list,res,used);
        dfs2(0,list,res);
        return res;
    }

    private void process(List<Integer> nums, int idx, List<List<Integer>> res) {
        if (idx == nums.size()) {
            res.add(new ArrayList<>(nums));
            return;
        }
        for (int i = idx; i < nums.size(); i++) {
            Collections.swap(nums, idx, i);
            process(nums, idx + 1, res);
            Collections.swap(nums, idx, i);
        }
    }

    private static void dfs(int[] nums, int idx, List<Integer> path, List<List<Integer>> res,boolean[] used) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, idx + 1, path, res, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    private static void dfs2(int idx, List<Integer> nums, List<List<Integer>> res) {
        if (idx == nums.size()) {
            res.add(new ArrayList<>(nums));
            return;
        }
        boolean[] used = new boolean[nums.size()];
        for (int i = idx; i < nums.size(); i++) {
            if (!used[i]) {
                Collections.swap(nums,i,idx);
                dfs2(idx+1,nums,res);
                Collections.swap(nums, i, idx);
            }
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        permute.forEach(System.out::println);
    }
}
