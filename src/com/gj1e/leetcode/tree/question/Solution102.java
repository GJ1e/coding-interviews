package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;
import com.sun.media.sound.DLSInfo;

import java.util.*;

/**
 * @Author GJ1e
 * @Date 2021/6/2
 *
 * 102. 二叉树的层序遍历
 */
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return resList;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                root = queue.poll();
                list.add(root.val);
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            resList.add(list);
        }
        return resList;
    }
}
