package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2019/11/1
 * @Time 16:21
 *
 * 面试题55扩展题：平衡二叉树
 *
 * 题目：
 *      输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，
 *      那么它就是一颗平衡二叉树。
 *
 * 思路：
 *      遍历这棵二叉树的同时得到它左、右子树的深度。如果每个节点的左、右子树的深度相差都不超过1，那么它就是一棵平衡二叉树。
 *
 */
public class Solution55_1 {
    class BinaryTree{
        int value;
        BinaryTree left = null;
        BinaryTree right = null;
    }

    public boolean isBalanced(BinaryTree root){
        if (root == null)
            return true;

        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        int diff = left - right;
        if (diff<=1 || diff>=-1)
            return true;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int treeDepth(BinaryTree root){
        if (root == null)
            return 0;

        int left = treeDepth(root.left);    //递归遍历左子树的长度
        int right = treeDepth(root.right);  //递归遍历右子树的长度

        return (left>right)? (left+1) : (right+1);  //返回左、右子树深度较大的值+1。
    }
}
