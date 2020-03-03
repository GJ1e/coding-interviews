package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2020/3/3
 * @Time 12:13
 * 面试题33：二叉搜索树的后序遍历序列
 *
 * 题目：
 *      输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 *      假设输入的数组的任意两个数字都互不相同。
 *
 * 思路：
 *      利用二叉搜索树的特性，不断递归判断，左右子树是否符合标准。左右子树必须同时符合二叉搜索树的特点才行。
 */
public class Solution33 {
    public boolean verifySquenceOfBST(int[] sequence) {
        if (sequence==null || sequence.length<=0)
            return false;
        return isTreeBST(sequence,0,sequence.length-1);
    }

    private boolean isTreeBST(int[] sequence, int start, int end){
        // start比end大说明上层结点没有左子树或者右子树，begin == end说明该本层结点没有子树，无需比较了
        // 这两种情况都应该返回true
        if(start >= end) return true;
        int i = start;
        for (;i < end; i++){
            if (sequence[i]>sequence[end])  //左子树都比root小
                break;
        }
        for (int j = i;j < end; j++){
            if (sequence[j]<sequence[end])  //右子树中还存在比root小的说明不是二叉搜索树
                return false;
        }
        //左右子树必须同时都是二叉搜索树
        return isTreeBST(sequence,start,i-1) && isTreeBST(sequence,i,end-1);

    }
}
