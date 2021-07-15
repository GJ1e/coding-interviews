package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author FenDa
 * 623. 在二叉树中增加一行
 */
public class Solution623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) {
            return new TreeNode();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int curD = 1;
        TreeNode res = root;
        queue.offer(root);
        if (depth-1 == 0){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (curD == depth-1) {
                    if (root.left != null) {
                        TreeNode tmp = root.left;
                        TreeNode node = new TreeNode(val);
                        root.left = node;
                        node.left = tmp;
                    }else {
                        TreeNode node = new TreeNode(val);
                        root.left = node;
                    }
                    if (root.right != null) {
                        TreeNode tmp = root.right;
                        TreeNode node = new TreeNode(val);
                        root.right = node;
                        node.right = tmp;
                    }else {
                        TreeNode node = new TreeNode(val);
                        root.right = node;
                    }
                }
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            curD++;
        }
        return res;
    }
}
