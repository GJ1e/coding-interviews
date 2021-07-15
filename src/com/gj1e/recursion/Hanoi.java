package com.gj1e.recursion;

/**
 * @author FenDa
 * 汉诺塔问题
 * 打印汉诺塔移动的过程
 */
public class Hanoi {
    public void solution(int n) {
        helper(n, "左", "右", "中");
    }

    private void helper(int n, String from, String to, String other) {
        if (n == 1) {
            System.out.println("Move 1 from " + from + " to " + to);
        } else {
            helper(n - 1, from, other, to);
            System.out.println("Move "+n+" from "+from+" to "+to);
            helper(n - 1, other, to, from);
        }
    }

}
