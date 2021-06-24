package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

/**
 * @author GJ1e
 * 235. 二叉搜索树的最近公共祖先
 */
public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}
