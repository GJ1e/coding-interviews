package com.gj1e.question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author GJ1e
 * @Create 2020/3/3
 * @Time 9:21
 * 面试题32：从上到下打印二叉树
 *
 * 题目：
 *      从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 思路：
 *      1.创建一个辅助队列，每遍历一个节点，则判断该节点是否有左右子节点，若有则加入队列。然后将队首节点出队列。
 *      2.继续按上述操作遍历队列中的节点，直到队列为空。
 */
public class Solution32 {
    //定义二叉树节点
    class BinaryTreeNode{
        int value;
        BinaryTreeNode left = null;
        BinaryTreeNode right = null;
    }

    public ArrayList<Integer> PrintFromTopToBottom (BinaryTreeNode root){
        if (root == null)
            return null;
        ArrayList<Integer> list = new ArrayList<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            if (queue.peek().left != null)  //若队首节点有左子节点，则将左子节点入队列
                queue.offer(queue.peek().left);
            if (queue.peek().right != null) //若队首节点有有子节点，则将右子节点入队列
                queue.offer(queue.peek().right);
            list.add(queue.poll().value);   //将队首元素出队列。
        }
        return list;
    }
}
