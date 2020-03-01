package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2019/11/1
 * @Time 16:05
 *
 * 面试题55：二叉树的深度
 *
 * 题目：
 *      输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点一次经过的节点(含根，叶节点)形成树的一条路径，
 *      最长路径的长度为树的深度。
 *
 * 思路：
 *      如果一棵树只有一个节点，那么它的深度为1。
 *      如果根节点只有左子树，那么它的深度就应该是左子树的深度+1。
 *      如果根节点只有右子树，那么它的深度就应该是右子树的深度+1。
 *      如果既有右子树，又有左子树，那么它的深度就应该是其左、右子树深度较大的值在+1。
 */
public class Solution55 {
    class BinaryTree{
        int value;
        BinaryTree left = null;
        BinaryTree right = null;
    }

    public int treeDepth(BinaryTree root){
        if (root == null)
            return 0;

        int left = treeDepth(root.left);    //递归遍历左子树的长度
        int right = treeDepth(root.right);  //递归遍历右子树的长度

        return (left>right)? (left+1) : (right+1);  //返回左、右子树深度较大的值+1。
    }
}
