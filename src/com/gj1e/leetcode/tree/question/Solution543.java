package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

/**
 * @author GJ1e
 * 543. 二叉树的直径
 */
public class Solution543 {
    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root).maxHigh-1;
    }

    private Info helper(TreeNode root) {
        if (root == null) {
            return new Info(0,0);
        }

        Info l = helper(root.left);
        Info r = helper(root.right);

        int cur = Math.max(l.curHigh, r.curHigh) + 1;
        int max = Math.max(Math.max(l.maxHigh, r.maxHigh), (l.curHigh+r.curHigh+1));
        return new Info(max,cur);
    }

    private class Info {
        int maxHigh;
        int curHigh;

        public Info (int maxHigh, int curHigh) {
            this.maxHigh = maxHigh;
            this.curHigh = curHigh;
        }
    }
}
