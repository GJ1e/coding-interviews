package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

/**
 * @author FenDa
 */
public class TreeUtils {

    public static TreeNode arrayToTree(Integer[] array) {
        return arrayToTree(array, 0);
    }
    /**
     * 根据数组生成二叉树
     * @param array
     * @param index
     * @return
     */
    public static TreeNode arrayToTree(Integer[] array, int index) {
        TreeNode root = null;
        if (index < array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            root = new TreeNode(value);
            root.left = arrayToTree(array, 2 * index + 1);
            root.right = arrayToTree(array, 2 * index + 2);
            return root;
        }
        return null;
    }

}
