package com.gj1e.leetcode.tree;

import apple.laf.JRSUIUtils;

import java.util.Stack;

/**
 * @Author GJ1e
 * @Date 2021/5/27
 * 二叉树后续遍历
 */
public class Postorder {
    /**
     * 递归版
     * @param root
     */
    public void post(TreeNode root) {
        if (root == null) {
            return;
        }
        post(root.left);
        post(root.right);
        System.out.println(root.val);
    }

    /**
     * 非递归双栈版
     * @param root
     */
    public void post2(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.empty()) {
            root = stack1.pop();
            stack2.push(root);
            if (root.left != null) {
                stack1.push(root.left);
            }
            if (root.right != null) {
                stack1.push(root.right);
            }
        }
        while (!stack2.empty()){
            System.out.println(stack2.pop().val);
        }
    }

    /**
     * 非递归单栈版
     * @param root
     */
    public void post3(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = null;
        stack.push(root);
        while (!stack.empty()) {
            tmp = stack.peek();
            if (tmp != null && root != tmp.left && root != tmp.right) {
                stack.push(tmp.left);
            } else if (root != tmp.left && root != tmp.right) {
                stack.push(tmp.right);
            } else {
                System.out.println(stack.pop().val);
                root = tmp;
            }
        }
    }
}
