package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

import java.util.*;

/**
 * @Author GJ1e
 * @Date 2021/6/2
 *
 * 103. 二叉树的锯齿形层序遍历
 */
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            Deque<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (flag){
                    list.offerLast(root.val);
                }else {
                    list.offerFirst(root.val);
                }
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            resList.add(new LinkedList<>(list));
            flag = !flag;
        }
        return resList;
    }

}
