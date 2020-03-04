package com.gj1e.question;

import java.util.ArrayList;

/**
 * @Author GJ1e
 * @Create 2020/3/4
 * @Time 10:49
 * 面试题34：二叉树中和为某一值的路径
 *
 * 题目：
 *      输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 *      路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 * 思路：
 *      递归二叉树前序遍历，从根节点开始开始向下遍历，当访问到某一节点时，把该节点添加到路径上，并累加该节点的值。
 *      如果该节点为叶子节点，并且路径中的节点值的和刚好符合要求，则将其添加到列表中。
 *      否则，回退到父节点，且路径中也应该将该节点移除。
 */
public class Solution34 {
    class BinaryTreeNode{
        int value;
        BinaryTreeNode left = null;
        BinaryTreeNode right = null;
    }

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> findPath(BinaryTreeNode root, int target){
        if (root == null)
            return listAll;
        list.add(root.value);   //添加节点值到列表中
        target -= root.value;
        if (target==0 && root.left==null && root.right==null)   //符合规定，则将路径添加到列表中
            listAll.add(new ArrayList<>(list));

        if (root.left != null)  //递归遍历左子树
            findPath(root.left,target);
        if (root.right != null) //递归遍历右子树
            findPath(root.right,target);

        list.remove(list.size()-1); //不符合要求，则回退到父节点，并将该节点从列表中删除

        return listAll;

    }
}
