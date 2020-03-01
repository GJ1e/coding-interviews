package com.gj1e.question;

import java.util.ArrayList;

/**
 * @Author GJ1e
 * @Create 2020/3/1
 * @Time 11:32
 * 面试题29：顺时针打印矩阵
 *
 * 题目：
 *      输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 *      1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Solution29 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return list;
        //定义四个边界，上下左右
        int up = 0;
        int down = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        //循环打印四边
        while(true){
            //从左到右打印
            for (int cols = left; cols <= right; cols++){
                list.add(matrix[up][cols]);
            }
            //删除打印过的行
            up++;
            if (up>down) break;

            //从上到下打印
            for (int rows = up; rows <= down; rows++){
                list.add(matrix[rows][right]);
            }
            right--;
            if (left>right) break;

            //从右到左打印
            for (int cols = right; cols >= left; cols--){
                list.add(matrix[down][cols]);
            }
            down--;
            if (up>down) break;

            //从下到上打印
            for (int rows = down; rows >= up; rows--){
                list.add(matrix[rows][left]);
            }
            left++;
            if (left>right) break;
        }
        return list;
    }
}
