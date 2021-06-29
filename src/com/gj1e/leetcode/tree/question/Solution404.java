package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

/**
 * @author GJ1e
 * 404. 左叶子之和
 */
public class Solution404 {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        return process(root,false);
    }

    private int process(TreeNode root, boolean flag) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null && flag) {
            sum += root.val;
        }
        process(root.left, true);
        process(root.right,false);
        return sum;
    }
}
