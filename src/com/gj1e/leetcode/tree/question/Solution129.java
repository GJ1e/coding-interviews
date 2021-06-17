package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;
import org.omg.CORBA.INVALID_TRANSACTION;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author GJ1e
 * 129. 求根节点到叶节点数字之和
 */
public class Solution129 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public int sumNumbers(TreeNode root) {
        helper(root);
        Integer sum = 0;
        for (List<Integer> l : res) {
            StringBuffer sb = new StringBuffer();
            for (int i : l) {
                sb =sb.append(i);
            }
            sum += Integer.parseInt(sb.toString());
        }
        return sum;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        list.offer(root.val);
        if (root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
        }
        helper(root.left);
        helper(root.right);
        list.removeLast();
    }
}
