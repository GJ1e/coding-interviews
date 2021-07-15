package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

import java.util.Stack;

/**
 * @author FenDa
 * 538. 把二叉搜索树转换为累加树
 */
public class Solution538 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode res = new TreeNode();
        res.right = convertBST(root.right);
        res.val = sum += root.val;
        res.left = convertBST(root.left);
        return res;
    }

    public TreeNode convertBST2(TreeNode root) {
        if (root == null) {
            return new TreeNode();
        }
        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;
        TreeNode res = root;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.right;
            } else {
                root = stack.pop();
                root.val = sum+=root.val;
                root = root.left;
            }
        }
        return res;
    }
}
