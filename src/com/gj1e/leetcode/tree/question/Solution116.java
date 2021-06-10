package com.gj1e.leetcode.tree.question;

/**
 * @author GJ1e
 */
public class Solution116 {
    public Node connect(Node root) {
        helper(root,root);
        return root;
    }

    private void helper(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return;
        }
        node1.next = node2;
        helper(node1.left,node1.right);
        helper(node2.left,node2.right);
        helper(node1.right,node2.left);
    }

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
