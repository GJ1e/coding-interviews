package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2019/9/17
 * @Time 20:54
 *
 *
 * 剑指offer
 * 面试题26：树的子结构
 *
 * 问题：
 *      输入两棵二叉树A和B，判断B是不是A的子结构。
 *
 * 思路：（递归思想）
 *      首先，在A树中找到与B树根节点相同值的节点，然后判断A树中以此节点为根节点的子树是不是包含
 *      和B树一样的结构。
 *
 *
 */
public class Solution26 {
    //二叉树的定义
    class BinaryTreeNode{
        int value;
        BinaryTreeNode left = null;
        BinaryTreeNode right = null;

        public BinaryTreeNode(int value){
            this.value = value;
        }
    }
    //递归遍历，对比树A和树B根节点相同的节点
    public boolean hasSubTree(BinaryTreeNode tree1,BinaryTreeNode tree2){
        boolean flag = false;
        if (tree1 != null && tree2 != null) {
            if (tree1.value == tree2.value) {   //递归思想，如果根节点相同则递归调用DoesTree1HaveTree2()
                flag = doesTree1HaveTree2(tree1, tree2);
            }
            //如果根节点不相同，则判断tree1的左子树和tree2是否相同
            if (!flag) {
                 flag = hasSubTree(tree1.left, tree2);
            }
            //再判断右子树和tree2是否相同
            if (!flag) {
                 flag = hasSubTree(tree1.right, tree2);
            }
        }
        return flag;

    }

    private boolean doesTree1HaveTree2(BinaryTreeNode tree1,BinaryTreeNode tree2){
        if(tree1 == null && tree2 != null) return false;      //Tree1为空，Tree2不为空，不匹配。

        if (tree2 == null) return true;     //Tree2为空，说明遍历完了，即匹配成功

        if(tree1.value != tree2.value) return false;    //两棵树的节点不同，不匹配。

        return doesTree1HaveTree2(tree1.left,tree2.left) && doesTree1HaveTree2(tree1.right,tree2.right);
    }
}
