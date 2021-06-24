package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GJ1e
 * 337. 打家劫舍 III
 */
public class Solution337 {
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0],res[1]);
    }

    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] l = helper(root.left);
        int[] r = helper(root.right);

        int[] dp = new int[2];
        dp[0] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        dp[1] = root.val + l[0] + r[0];
        return dp;
    }

}
