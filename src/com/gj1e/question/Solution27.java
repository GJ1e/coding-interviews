package com.gj1e.question;


/**
 * @Author GJ1e
 * @Create 2020/2/29
 * @Time 12:06
 * 面试题27：二叉树的镜像
 *
 * 题目：
 *      操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Solution27 {
    //二叉树定义
    class BinaryTreeNode{
        int value;
        BinaryTreeNode left = null;
        BinaryTreeNode right = null;

        public BinaryTreeNode(int value){
            this.value = value;
        }
    }

    public void Mirror(BinaryTreeNode root) {
        if (root == null) return;
        if (root.left==null && root.right==null) return;

        //树的左右子节点交换
        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //递归遍历二叉树
        if (root.left != null)
            Mirror(root.left);
        if (root.right != null)
            Mirror(root.right);

    }
}
