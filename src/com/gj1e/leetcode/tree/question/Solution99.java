package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

import java.util.Stack;

/**
 * @Author GJ1e
 * @Date 2021/6/1
 *
 * 99. 恢复二叉搜索树
 */
public class Solution99 {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode x = null, y = null, pre = null;
        while (!stack.empty() || root != null){
            if (root != null) {
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                if (pre != null && root.val < pre.val){
                    x = root;
                    if (y == null){
                        y = pre;
                    }else {
                        break;
                    }
                }
                pre = root;
                //中序遍历 操作
                root = root.right;
            }
        }
        //交换
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
}
