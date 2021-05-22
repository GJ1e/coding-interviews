package com.gj1e.leetcode.tree.hard;


import com.gj1e.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author GJ1e
 * @Date 2021/5/22
 *
 * 297. 二叉树的序列化与反序列化
 */
public class Solution297 {
    String res = "";
    public String serialize(TreeNode root) {
        if (root == null) {
            return res += "null,";
        }
        res += root.val+",";
        serialize(root.left);
        serialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = new ArrayList<>(Arrays.asList(data.split(",")));
        return resDeserialize(list);
    }

    private TreeNode resDeserialize(List<String> list){
        if (list.get(0).equals("null")){
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = resDeserialize(list);
        root.right = resDeserialize(list);
        return root;
    }
}
