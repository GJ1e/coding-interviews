package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author GJ1e
 * 113. 路径总和 II
 */
public class Solution113 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root,targetSum);
        return res;
    }

    private void helper(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        list.offer(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                res.add(new ArrayList<>(list));
            }
        }
        helper(root.left,sum - root.val);
        helper(root.right,sum - root.val);
        list.removeLast();
    }

}
