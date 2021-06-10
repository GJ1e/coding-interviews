package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

/**
 * @author GJ1e
 * 114. 二叉树展开为链表
 */
public class Solution114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;

        TreeNode tmp = root;
        while (tmp.right != null) {
            tmp = tmp.right;
        }
        tmp.right = right;
    }
}
