package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

/**
 * @Author GJ1e
 * @Date 2021/6/3
 * 104. 二叉树的最大深度
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {
        int max = 0;
        if (root == null) {
            return 0;
        }
        max = Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        return max;
    }
}
