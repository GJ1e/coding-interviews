package com.gj1e.recursion;

/**
 * @author GJ1e
 * 假设有排成一行的N个位置，记为1～N，N一定大于等于2。
 * 开始时机器人在其中的M位置上(M一定是1～N中的一个)
 * 机器人如果来到1位置，下一步只能向右走来到2位置，
 * 机器人如果来到N位置，下一步只能向左走来到N-1位置。
 * 机器人如果来到中间位置，下一步既可以向左走也可向右走。
 * 规定机器人必须走K步，最终能来到P位置(P也是1～N中的一个)的方法有多少种。
 * 给定四个参数N,M,K,P,返回方法数。
 */
public class RobotWalk {
    public int solution1(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M > N || M < 1 || P < 1 || P > N) {
            return 0;
        }
        return walk1(N, M, K, P);
    }

    public int solution2(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M > N || M < 1 || P < 1 || P > N) {
            return 0;
        }
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < K + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return walk2(N, M, K, P, dp);
    }

    /**
     * 暴力递归
     * @param N 位置为1～N，固定参数。
     * @param cur 当前所在的位置，可变参数。
     * @param rest 剩余多少步，可变参数。
     * @param P 目标位置，固定参数。
     * @return
     */
    private int walk1(int N, int cur, int rest, int P) {
        if (rest == 0) {
            return cur == P ? 1 : 0;
        }
        if (cur == 1) {
            return walk1(N, cur + 1, rest - 1, P);
        }
        if (cur == N) {
            return walk1(N, cur - 1, rest - 1, P);
        }
        return walk1(N, cur + 1, rest - 1, P) + walk1(N, cur - 1, rest - 1, P);
    }

    /**
     * 动态规划
     * @param N 位置为1～N，固定参数。
     * @param cur 当前所在的位置，可变参数。
     * @param rest 剩余多少步，可变参数。
     * @param P 目标位置，固定参数。
     * @param dp
     * @return
     */
    private int walk2(int N, int cur, int rest, int P, int[][] dp) {
        if (dp[cur][rest] != -1) {
            return dp[cur][rest];
        }
        if (rest == 0) {
            dp[cur][rest] = cur == P ? 1 : 0;
            return dp[cur][rest];
        }
        if (cur == 1) {
            dp[cur][rest] = walk2(N, cur + 1, rest - 1, P, dp);
            return dp[cur][rest];
        }
        if (cur == N) {
            dp[cur][rest] = walk2(N, cur - 1, rest - 1, P, dp);
            return dp[cur][rest];
        }
        dp[cur][rest] = walk2(N, cur + 1, rest - 1, P, dp) + walk2(N, cur - 1, rest - 1, P, dp);
        return dp[cur][rest];
    }
}