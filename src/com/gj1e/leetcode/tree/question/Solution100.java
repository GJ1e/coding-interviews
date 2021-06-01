package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

/**
 * @Author GJ1e
 * @Date 2021/6/2
 * 100. 相同的树
 */
public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val == q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }else {
            return false;
        }
    }
}
