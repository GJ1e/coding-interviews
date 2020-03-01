package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2019/10/29
 * @Time 19:01
 *
 * 面试题54：二叉搜索树的第K大个节点
 *
 * 题目：
 *      给定一刻二叉搜索树，请找出其中第K大的节点。例如：{5,3,7,2,4,6,8}中按节点数值大小顺序，第三大的节点的值是4。
 *
 * 思路：
 *      按照中序遍历的顺序遍历一棵二叉搜索树，则遍历序列的数字就是递增排序的。这样我们就可以很容易的找到二叉搜索树中的
 *      第K大的节点。
 */
public class Solution54 {
    class BinaryTree{
        int value;
        BinaryTree left = null;
        BinaryTree right = null;
    }

    public BinaryTree findKNode(BinaryTree root, int k){
        return null;
    }
}
