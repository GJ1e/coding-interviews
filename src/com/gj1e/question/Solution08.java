package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2019/10/10
 * @Time 20:30
 *
 * 剑指offer
 * 面试题08：二叉树的下一个节点
 *
 * 题目：
 *      给定一棵二叉树和其中的一个节点，如何找出中序遍历的下一个节点？
 *      树中的节点除了有两个分别指向左、右子节点的指针，还有一个指向父节点的指针。
 *
 * 思路：
 *      二叉树中序遍历序列的顺序：左，根，右。
 *      根据二叉树中序遍历的规则，我们可以将树中的节点分为以下几种情况：
 *      1、节点有右子树，那么它的下一个节点，就是它自己的右子树中的最左子节点。
 *         (也就是从右子节点出发，一直沿着指向左子节点的指针，就能找到它的下一个节点)
 *
 *      2、节点没有右子树，并且还是自己父节点的左子节点，那么它的下一个节点就是自己的父节点。
 *
 *      3、节点没有右子树，并且还是自己父节点的右子节点。对于这样的节点，我们可以沿着它指向父节点的指针一直向上遍历，
 *         直到找到一个是自己父节点的左子节点的节点。如果这样的节点存在，那么这个节点的父节点就是我们要找的下一个节点。
 *
 */
public class Solution08 {
    //定义二叉树结构体
    class BinaryTreeNode{
        int vaule;
        BinaryTreeNode left = null;
        BinaryTreeNode right = null;
        BinaryTreeNode parent = null;

        public BinaryTreeNode(int vaule){
            this.vaule = vaule;
        }
    }

    public BinaryTreeNode getNextNode(BinaryTreeNode pNode){
        if (pNode==null) return null;

        BinaryTreeNode pNext = null;

        if (pNext.right != null){       //节点有右子树
            BinaryTreeNode Right = pNode.right;
            while (Right.left != null)
                Right = Right.left;

            pNext = Right;
        }else if (pNode.parent != null){       //节点没有右子树，且节点的父节点不为空
            BinaryTreeNode current = pNode;
            BinaryTreeNode Parent = pNode.parent;

            while (Parent != null && current == current.right){     //节点的父节点不为空，且为自己父节点的右子节点
                current = Parent;
                Parent = Parent.parent;
            }
            pNext = Parent;         // 节点是自己父节点的左子节点情况，下一个节点就是自己的父节点
        }
        return pNext;
    }
}
