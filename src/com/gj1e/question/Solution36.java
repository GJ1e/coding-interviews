package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2020/3/5
 * @Time 11:00
 * 面试题36：二叉搜索树与双向链表
 *
 * 题目：
 *      输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 思路：
 *      二叉搜索树，如果用中序遍历，那么遍历的结果正好就是从小到大排列。
 */
public class Solution36 {
    class BinaryTreeNode{
        int value;
        BinaryTreeNode left = null;
        BinaryTreeNode right = null;
    }

    public BinaryTreeNode Convert (BinaryTreeNode root){
        if (root == null)
            return null;
        if (root.left==null && root.right==null)
            return root;
        //1.递归遍历左子树，将左子树构造成双链表，并返回头节点
        BinaryTreeNode left = Convert(root.left);
        BinaryTreeNode index = left;

        //2.定位到左子树双链表的最后一个节点
        while(index!=null && index.right!=null){
            index = index.right;
        }
        //3.将root节点添加在左子树双链表的最后
        if (left != null){
            index.right = root;
            root.left = index;
        }
        //4.递归遍历右子树，将右子树构造成双链表，并返回头节点
        BinaryTreeNode right = Convert(root.right);
        //5.将右子树双链表添加在root节点后面
        if (right != null){
            right.left = root;
            root.right = right;
        }

        //6.返回双链表的头节点
        return left!=null?left:root;
    }
}
