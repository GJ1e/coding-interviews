package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author GJ1e
 * @Date 2021/5/31
 * 94. 二叉树的中序遍历
 */
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> resList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty() || root != null){
            if (root.left != null) {
                stack.push(root.left);
                root = root.left;
            }else {
                root = stack.pop();
                resList.add(root.val);
                root = root.right;
            }
        }
        return resList;
    }
}
