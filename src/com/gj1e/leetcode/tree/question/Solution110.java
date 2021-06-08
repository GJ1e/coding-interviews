package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

/**
 * @author GJ1e
 * 110. 平衡二叉树
 */
public class Solution110 {
    /**
     * 解法1 自顶向下的递归
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(helper(root.left) - helper(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int high = 0;
        high += Math.max(helper(root.left),helper(root.right)) + 1;
        return high;
    }

    /**
     * 解法2 自底向上的递归
     * @param root
     * @return
     */
    public boolean isBalanced2(TreeNode root) {
        return helper2(root).isBalance;
    }

    private Info helper2(TreeNode root) {
        Info res = new Info();
        if (root == null) {
            res.high = 0;
            res.isBalance = true;
            return res;
        }
        Info leftInfo = helper2(root.left);
        Info rightInfo = helper2(root.right);

        res.high += Math.max(leftInfo.high,rightInfo.high) + 1;
        res.isBalance = false;
        if (leftInfo.isBalance && rightInfo.isBalance && Math.abs(leftInfo.high - rightInfo.high)<=1){
            res.isBalance = true;
        }
        return res;
    }
    private class Info{
        int high;
        boolean isBalance;
    }
}
