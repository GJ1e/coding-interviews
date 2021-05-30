package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author GJ1e
 * @Date 2021/5/31
 * 95. 不同的二叉搜索树 II
 */
public class Solution95 {
    public List<TreeNode> generateTrees(int n) {
        return helper(1,n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> resList = new ArrayList<>();
        if (start > end) {
            resList.add(null);
            return resList;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = helper(start,i-1);
            List<TreeNode> rightTree = helper(i+1,end);

            for (TreeNode l : leftTree) {
                for (TreeNode r: rightTree) {
                    TreeNode res = new TreeNode(i);
                    res.left = l;
                    res.right = r;
                    resList.add(res);
                }
            }
        }
        return resList;
    }
}
