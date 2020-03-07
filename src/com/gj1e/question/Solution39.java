package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2020/3/7
 * @Time 11:08
 * 面试题39：数组中出现次数超过一半的数字
 *
 * 题目：
 *      数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 *      由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * 思路：
 *      1. 采用阵地攻守的思想：
 *      第一个数字作为第一个士兵，守阵地；count = 1；
 *      遇到相同元素，count++;
 *      遇到不相同元素，即为敌人，同归于尽,count--；当遇到count为0的情况，又以新的i值作为守阵地的士兵，继续下去，到最后还留在阵地上的士兵，有可能是主元素。
 *      再加一次循环，记录这个士兵的个数看是否大于数组一半即可。
 *
 *      2. 将数组排序，然后找出中位数，然后循环看这个数字出现的次数是否大于数组长度的一半即可。
 */
public class Solution39 {
    public int moreThanHalfNum(int [] array) {
        if(array == null || array.length<=0)
            return 0;
        int result = array[0];  //设置士兵
        int count = 1;

        for (int i = 1; i < array.length; i++) {
            if (count == 0){
                result = array[i];
                count = 1;
            }else if (result == array[i]){
                count++;
            }else {
                count--;
            }
        }

        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (result==array[i])
                count++;
        }
        if (count*2<=array.length)
            return 0;
        return result;
    }
}
