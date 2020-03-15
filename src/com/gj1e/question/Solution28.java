package com.gj1e.question;


/**
 * @Author GJ1e
 * @Create 2020/3/15
 * @Time 11:19
 * 面试题28：对称的二叉树
 *
 * 题目：
 *      请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * 思路：
 *      递归比较左右子树是否相等，以及比较左子树的左子树和右子树的右子树是否相等。
 *      非递归也可以，采用栈或者队列，然后存取各级子树的根节点进行比较。
 */
public class Solution28 {
    private class BinaryTreeNode{
        int value;
        BinaryTreeNode left = null;
        BinaryTreeNode right = null;
    }

    public boolean isSymmetrical(BinaryTreeNode pRoot){
        if (pRoot == null)
            return true;
        return isSymmetricalCore(pRoot,pRoot);
    }

    private boolean isSymmetricalCore(BinaryTreeNode left, BinaryTreeNode right){
        if (left==null && right==null) return true; //左右节点同时为空，说明遍历结束。
        if (left==null || right==null) return false;//左右节点不相等，返回false
        if (left.value != right.value) return false;//左右节点的值不想的，返回false

        return isSymmetricalCore(left.left, right.right) && isSymmetricalCore(left.right, right.left);
    }
}
