package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

/**
 * @author GJ1e
 * 236. 二叉树的最近公共祖先
 */
public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
