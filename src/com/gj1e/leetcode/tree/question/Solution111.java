package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

/**
 * @author GJ1e
 * 111. 二叉树的最小深度
 */
public class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        if (root.left == null || root.right == null){
            return l+r+1;
        }
        return Math.min(l,r)+1;

    }
}
