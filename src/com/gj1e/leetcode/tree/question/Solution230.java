package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author GJ1e
 * 230. 二叉搜索树中第K小的元素
 */
public class Solution230 {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty() || root != null){
            if (root != null) {
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list.get(k);
    }

    public int kthSmallest2(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            if (root != null) {
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                if (--k == 0) {
                    break;
                }
                root = root.right;
            }
        }
        return root.val;
    }
}
