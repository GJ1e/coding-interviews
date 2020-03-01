package com.gj1e.question;



/**
 * @Author GJ1e
 * @Create 2019/10/26
 * @Time 14:59
 *
 * 题目：
 *      输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *      例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 思路：现根据先序序列找二叉树的根节点，先序序列的第一个节点就是root节点。
 *      然后找出中序序列中root节点的位置。
 *      根据中序序列的性质，root节点的左边为左子树的节点，右边为右子树的节点。
 *      然后用递归的方式重建二叉树的左子树和右子树。
 */
public class Solution07 {
    class BinaryTreeNode{
        int vaule;
        BinaryTreeNode left = null;
        BinaryTreeNode right = null;

        public BinaryTreeNode(int vaule){
            this.vaule = vaule;
        }
    }

    public BinaryTreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre==null || pre.length<=0 || in==null || in.length<=0)
            return null;
        int preStart = 0;
        int preEnd = pre.length-1;
        int inStart = 0;
        int inEnd = in.length-1;

        return constructCore(pre,in,preStart,preEnd,inStart,inEnd);
    }

    /**
     *
     * @param pre 先序遍历数组
     * @param in  中序遍历数组
     * @param preStart  先序数组的起点
     * @param preEnd    先序数组的末尾
     * @param inStart   中序数组的起点
     * @param inEnd     中序数组的末尾
     * @return
     */
    public BinaryTreeNode constructCore(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd){
        if (preStart>preEnd || inStart>inEnd)
            return null;
        BinaryTreeNode root = new BinaryTreeNode(pre[preStart]);

        for (int i = inStart;i<=inEnd;i++){
            if (in[i] == pre[preStart])
            {
                root.left = constructCore(pre,in,preStart+1,preStart+i-inStart,inStart,i-1);
                root.right = constructCore(pre,in,i-inStart+preStart+1,preEnd,i+1,inEnd);
                break;
            }
        }
        return root;
    }
}
