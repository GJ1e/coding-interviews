package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

/**
 * @author GJ1e
 */
public class Solution124 {
    Integer res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0,maxPathSum(root.left));
        int right = Math.max(0,maxPathSum(root.right));

        res = Math.max(res,(root.val+left+right));
        return Math.max(left,right)+root.val;
    }
}
