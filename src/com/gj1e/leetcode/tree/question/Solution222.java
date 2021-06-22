package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

/**
 * @author GJ1e
 * 222. 完全二叉树的节点个数
 */
public class Solution222 {
    public int countNodes(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        res += countNodes(root.left) + countNodes(root.right) +1;
        return res;
    }
}
