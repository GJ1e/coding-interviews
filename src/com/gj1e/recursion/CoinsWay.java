package com.gj1e.recursion;

/**
 * @author GJ1e
 * 给定数组arr，arr中所有的值都为正数，且不重复。
 * 每个值都代表一种面值的货币，每种面值的货币可以使用任意张。
 * 在给定一个正数aim，代表要凑的钱数。
 * 求组成aim的方法数。
 */
public class CoinsWay {
    public int solution1(int[] arr, int aim) {
        if (arr == null || arr.length <= 0 || aim <= 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }

    private int process1(int[] arr, int index, int aim) {
        if (index == arr.length) {
            return aim == 0 ? 1 : 0;
        }
        if (aim < 0){
            return 0;
        }
        int ways = 0;
        for (int zhang = 0; zhang * arr[index] <= aim; zhang++) {
            ways += process1(arr, index + 1, aim - (zhang * arr[index]));
        }
        return ways;
    }

    public int solution2(int[] arr, int aim) {
        if (arr == null || arr.length <= 0 || aim <= 0) {
            return 0;
        }
        int[][] dp = new int[arr.length+1][aim+1];
        for (int i = 0; i < dp.length;i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return process2(arr, 0, aim, dp);
    }

    private int process2(int[] arr, int index, int aim, int[][] dp) {
        if (dp[index][aim] != -1) {
            return dp[index][aim];
        }
        if (index == arr.length) {
            dp[index][aim] = aim == 0 ? 1 : 0;
            return dp[index][aim];
        }
        int ways = 0;
        for (int zhang = 0; zhang * arr[index] <= aim; zhang++) {
            ways += process2(arr, index + 1, aim - (zhang * arr[index]), dp);
            dp[index][aim] = ways;
        }
        return dp[index][aim];
    }
}
