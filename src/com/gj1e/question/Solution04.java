package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2019/9/11
 * @Time 18:58
 *
 * 剑指offer
 * 面试题4：二维数组中的查找
 * 已AC
 * 题目：
 *      在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 思路：
 *      就是比较矩阵的右上角的数与target的大小，
 *      如果target比这个矩阵右上角的数大，由于矩阵的右上角元素A是A所在行的最大的值，
 *      所以target肯定不在A所在的行了，所以这时候就应该就在除去第一行的剩下的行中去找这个target;
 *      如果target比矩阵右上角的数A小，那么由于A所在的列中A是最小的，那么target就在除去最右边的列的其它的列；
 *      如果相等，返回true;
 */
public class Solution04 {

    public boolean arrayFind(int target , int[][] array){
        //检查异常输入
        if(array==null || array.length<0 || array[0].length<0)
            return false;

        int rows = 0;   //行
        int cols = array[0].length-1;   //列

        while(rows<=array.length-1 && cols>=0){
            if(target>array[rows][cols]) //target大于矩阵左上角的数，说明target大于这一行上的所有数
                rows++;                  //进入下一行继续比较
            else if(target<array[rows][cols]) //target小于矩阵左上角的数，说明target小于这一列上的所有数
                cols--;                       //进入下一列继续比较
            else         //找到target
                return true;
        }
        return false;
    }
}

//        if(array.length==0 || array[0].length==0)   //检查异常输入
//            return false;
//
//        int row = array.length-1;   //数组行
//        int cols = array[0].length-1;  //数组列
//
//        int i = 0;
//        int j = cols;
//
//        while (i<=row || j>=0){
//
//            if(array[i][j] < target)    //
//            {
//                i++;
//            }
//            else if (array[i][j] > target)
//            {
//                j--;
//            }
//            else
//            {
//                return true;
//            }
//        }
//        return false;
//
//    }


