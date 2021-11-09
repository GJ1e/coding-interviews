package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author GJ1e
 * @Date 2021/5/31
 * 94. 二叉树的中序遍历
 */
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> resList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null){
            if (root != null) {
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                resList.add(root.val);
                root = root.right;
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, null, 7};
        TreeNode tree = TreeUtils.arrayToTree(array);
        Solution94 test = new Solution94();
        List<Integer> list = test.inorderTraversal(tree);
        System.out.print("中序遍历：");
        list.forEach(ele -> {
            System.out.print("  " + ele);
        });
    }
}
