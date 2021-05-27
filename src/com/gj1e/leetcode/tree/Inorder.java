package com.gj1e.leetcode.tree;


import java.util.Stack;

/**
 * @Author GJ1e
 * @Date 2021/5/26
 *
 * 二叉树中序遍历
 */
public class Inorder {
    /**
     * 递归版
     * @param root
     */
    public void middle(TreeNode root) {
        if (root == null) {
            return;
        }
        middle(root.left);
        System.out.println(root.val);
        middle(root.right);
    }

    public void middle2(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                System.out.println(root.val);
                root = root.right;
            }
        }
    }
}
