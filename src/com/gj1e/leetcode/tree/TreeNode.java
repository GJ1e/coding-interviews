package com.gj1e.leetcode.tree;


/**
 * @Author GJ1e
 * @Date 2021/5/22
 *
 * 二叉树结构体定义
 *
 */
public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
