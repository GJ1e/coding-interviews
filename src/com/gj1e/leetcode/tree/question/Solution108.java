package com.gj1e.leetcode.tree.question;

import com.gj1e.leetcode.tree.TreeNode;

/**
 * @author GJ1e
 *
 * 108. 将有序数组转换为二叉搜索树
 */
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums,0,nums.length-1);
    }

    private TreeNode build(int[] nums, int start, int end) {
        //base case
        if (start > end) {
            return null;
        }
        int index = (start + end)/2;

        TreeNode root = new TreeNode(nums[index]);
        root.left = build(nums,start,index-1);
        root.right = build(nums,index+1,end);
        return root;
    }
}
