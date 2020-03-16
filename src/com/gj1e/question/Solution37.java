package com.gj1e.question;


/**
 * @Author GJ1e
 * @Create 2020/3/16
 * @Time 11:45
 * 面试题37：序列化二叉树
 *
 * 题目：
 *      请实现两个函数，分别用来序列化和反序列化二叉树
 *
 */
public class Solution37 {
    //二叉树节点定义
    private class BinaryTreeNode{
        int value;
        BinaryTreeNode left = null;
        BinaryTreeNode right = null;

        public BinaryTreeNode(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    private int index = -1; //反序列化时计数器

    //序列化二叉树
    public String serialize(BinaryTreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.value+",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    //反序列化
    public BinaryTreeNode deserialize(String str) {
        index++;
        String[] strings = str.split(",");

        BinaryTreeNode treeNode = null;
        if (!strings[index].equals("#")){
            treeNode = new BinaryTreeNode(Integer.valueOf(strings[index]));
            treeNode.left = deserialize(str);
            treeNode.right = deserialize(str);
        }
        return treeNode;
    }
}
