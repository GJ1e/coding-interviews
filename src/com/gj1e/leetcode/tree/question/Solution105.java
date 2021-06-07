package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

/**
 * @Author GJ1e
 * @Date 2021/6/7
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private TreeNode build(int[] pre, int preS, int preE, int[] in, int inS, int inE) {
        if (preS > preE){
            return null;
        }
        int index = -1;
        for (int i = inS; i <= inE; i++) {
            if (in[i] == pre[preS]) {
                index = i;
                break;
            }
        }
        int leftSize = index - inS;
        TreeNode root = new TreeNode(pre[preS]);
        root.left = build(pre,preS+1,preS+leftSize,in,inS,index-1);
        root.right = build(pre,preS+leftSize+1,preE,in,index+1,inE);
        return root;
    }
}
