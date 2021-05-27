package com.gj1e.leetcode.tree;

import java.util.Stack;

/**
 * @Author GJ1e
 * @Date 2021/5/26
 *
 * 二叉树先序遍历
 */
public class Preorder {
    /**
     * 递归版
     * @param root
     */
    public void pre(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        pre(root.left);
        pre(root.right);
    }

    /**
     * 非递归版
     * @param root
     */
    public void pre2(TreeNode root){
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            root = stack.pop();
            System.out.println(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }

}
