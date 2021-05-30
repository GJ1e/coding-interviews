package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

/**
 * @Author GJ1e
 * @Date 2021/5/25
 * 98. 验证二叉搜索树
 *
 */
public class Solution98 {
    Integer last = -Integer.MAX_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isValidBST(root.left)){
            if (last < root.val){
                last = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }

}
