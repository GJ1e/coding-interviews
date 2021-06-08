package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

import java.util.*;

/**
 * @Author GJ1e
 * @Date 2021/6/8
 */
public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                list.add(root.val);
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            resList.add(0,list);
        }
        return resList;
    }
}
