package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

/**
 * @Author GJ1e
 * @Date 2021/6/2
 *
 * 101. 对称二叉树
 */
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        return process(root,root);
    }

    private boolean process(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            return process(p.left, q.right) && process(p.right, q.left);
        } else {
            return false;
        }
    }
}
