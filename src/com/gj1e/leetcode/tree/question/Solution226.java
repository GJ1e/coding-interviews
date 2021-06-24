package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

/**
 * @author GJ1e
 * 226. 翻转二叉树
 */
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
