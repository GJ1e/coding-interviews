package com.gj1e.question;


/**
 * @Author GJ1e
 * @Create 2020/2/26
 * @Time 14:58
 * 题目：调整数组顺序使奇数位于偶数前
 *
 * 描述：
 *      输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 *      所有的偶数位于数组的后半部分。
 */
public class Solution21 {
    public void reOrderArray(int[] array){
        if(array==null || array.length==0)
            return;
        int start = 0;
        int end = array.length-1;

        while (start<end){
            //从左向右寻找偶数
            while (start<end && !isEven(array[start]))
                start++;
            //从右向左寻找奇数
            while (start<end && isEven(array[end]))
                end--;
            if (start<end){
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
    }

    //判断一个数字是否为奇数
    private boolean isEven(int num){
        if (num%2==0){
            return true;
        }
        return false;
    }
}
