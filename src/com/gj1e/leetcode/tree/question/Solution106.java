package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

/**
 * @Author GJ1e
 * @Date 2021/6/8
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    private TreeNode helper(int[] in, int inS, int inE, int[] post, int postS, int postE) {
        //base case
        if (inS > inE) {
            return null;
        }
        int index = -1;
        for (int i = inS; i <= inE; i++) {
            if (in[i] == post[postE]) {
                index = i;
                break;
            }
        }
        int leftSize = index - inS;
        TreeNode root = new TreeNode(post[postE]);
        root.left = helper(in,inS,index-1,post,postS,postS+leftSize-1);
        root.right = helper(in,index+1,inE,post,postS+leftSize,postE-1);
        return root;
    }
}
