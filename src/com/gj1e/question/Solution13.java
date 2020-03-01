package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2019/10/29
 * @Time 9:41
 *
 * 面试题13：机器人的运动范围
 *
 * 题目：
 *      地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 *      但是不能进入行坐标和列坐标的数位之和大于k的格子。
 *      例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 *      但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * 思路：
 *      这个题和12题一样，也是用回溯法的思路来解。
 *      在这个矩阵中，除边界上的格子之外，其他的格子都有4个相邻的格子。
 *      机器人从坐标(0,0)开始移动，准备进入下一个格子(i,j)之前检查是否满足限制条件能否进入，如果可以进入就+1，
 *      同时用一个布尔矩阵来记录可以进入的格子，然后再来判断它能否进入四个相邻的格子(i,j-1),(i-1,j),(i,j+1),(i+1,j)。
 *
 */
public class Solution13 {

    public int movingCount(int threshold, int rows, int cols){
        if (threshold<0 || rows<=0 || cols<=0)  //异常矩阵检查
            return -1;
        boolean[] visite = new boolean[rows*cols];
        int count = movingCountCore(threshold,rows,cols,0,0,visite); //以(0,0)为起点坐标

        return count;
    }

    /**
     *
     * @param threshold  进入格子的限制值
     * @param rows       矩阵的行
     * @param cols       矩阵的列
     * @param row        起点的行坐标
     * @param col        起点的列坐标
     * @param visit      用来记录已经进入过的格子
     * @return
     */
    public int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visit){
        int count = 0;
        if (row>=0 && row>rows && col>=0 && col>cols && (getDigitSum(row)+getDigitSum(col))<=threshold
            && !visit[row*cols+col]){

            visit[row*cols+col]=true;

            //以当前格子为中心检查四周相邻的格子是否满足
            count = 1+movingCountCore(threshold,rows,cols,row,col-1,visit)
                     +movingCountCore(threshold,rows,cols,row-1,col,visit)
                     +movingCountCore(threshold,rows,cols,row,col+1,visit)
                     +movingCountCore(threshold,rows,cols,row+1,col,visit);
        }
        return count;
    }
    //计算行或列的数字的位数之和
    public int getDigitSum(int digit){
        int sum = 0;
        while (digit>0){
            sum += digit%10;
            digit /= 10;
        }
        return sum;
    }

}
