package com.gj1e.leetcode.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FenDa
 */
public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        dfs(candidates, target, 0, combination, res);
        return res;
    }

    private void dfs(int[] candidates, int target, int idx, List<Integer> combination, List<List<Integer>> res) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(combination));
            return;
        }
        dfs(candidates, target, idx + 1, combination, res);
        if (target - candidates[idx] >= 0) {
            combination.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], idx, combination, res);
            combination.remove(combination.size() - 1);
        }
    }
}
