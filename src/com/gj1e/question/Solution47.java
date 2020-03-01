package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2019/10/17
 * @Time 21:10
 *
 * 面试题47：礼物的最大价值
 *
 * 题目：
 *      在一个M*N的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值(价值大于0)。你可以从棋盘的左上角开始拿格子里的礼物，
 *      并每次向右或这向下移动一个，直到到达棋盘的右下角。给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？
 *
 * 思路：
 *      首先定义一个函数f(i,j)表示到达坐标为(i,j)的格子时能拿到的礼物总和的最大值。
 *      根据要求，到达坐标为(i,j)的格子只能通过格子(i-1,j)或者格子(i,j-1)。
 *      所以f(i,j)=MAX(f(i-1,j),f(i,j-1))+gift(i,j)
 */
public class Solution47 {
    /**
     *
     * @param values 棋盘及其上面的礼物
     * @return 返回拿到的礼物的总价值
     */
    public int getMaxValue(int[][] values){
        if (values==null || values.length<=0 || values[0].length<=0)
            throw new RuntimeException("数组输入异常");

        int cols = values[0].length;        //辅助数组的长度等于棋盘的列
        int[] maxValues = new int[cols];    //构建一个一维辅助数组

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < cols; j++) {

                int up = 0;
                int left = 0;

                if (i>0)
                    up = maxValues[j];
                if (j>0)
                    left = maxValues[j-1];

                maxValues[j] = Math.max(up,left) + values[i][j];
            }
        }
        return maxValues[cols-1];
    }

//    public static void main(String[] args) {
//        int[][] values = {{1}};
//        Sloution47 test = new Sloution47();
//        int a = test.getMaxValue(values);
//        System.out.println(a);
//    }
}
