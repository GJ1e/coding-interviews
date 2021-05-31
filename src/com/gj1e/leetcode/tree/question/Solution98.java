package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

/**
 * @Author GJ1e
 * @Date 2021/5/25
 * 98. 验证二叉搜索树
 * 注：最快捷的方法为中序遍历，直接判断结果是否为升序
 */
public class Solution98 {
    class Info{
        boolean isBST;
        Integer max;
        Integer min;
    }
    public boolean isValidBST(TreeNode root) {
        return process(root).isBST;
    }
    private Info process(TreeNode root){
        if (root == null) {
            return null;
        }
        Info leftTree = process(root.left);
        Info rightTree = process(root.right);

        Integer max = root.val;
        Integer min = root.val;
        if (leftTree != null){
            max = Math.max(max, leftTree.max);
            min = Math.min(min, leftTree.min);
        }
        if (rightTree != null) {
            min = Math.min(min, rightTree.min);
            max = Math.max(max, rightTree.max);
        }
        boolean isBST = false;
        if ((leftTree == null?true:leftTree.isBST) && (rightTree == null?true:rightTree.isBST)
                && (leftTree == null?true:leftTree.max < root.val) && (rightTree == null?true:rightTree.min > root.val)) {
            isBST = true;
        }
        Info info = new Info();
        info.isBST = isBST;
        info.max = max;
        info.min = min;
        return info;
    }
}
