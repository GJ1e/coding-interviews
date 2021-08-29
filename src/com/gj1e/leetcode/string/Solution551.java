package com.gj1e.leetcode.string;

/**
 * @author FenDa
 * 551. 学生出勤记录 I
 */
public class Solution551 {
    public boolean checkRecord(String s) {
        if (s == null || s.equals("")) {
            return false;
        }
        int a = 0; //缺勤必须少于2次
        int l = 0; //迟到 不能连续3次
        for (char ele : s.toCharArray()) {
            if (ele == 'A') {
                a++;
            }
            if (ele == 'L') {
                l++;
            } else {
                l = 0;
            }
            if (a >= 2 || l >= 3) {
                return false;
            }
        }
        return true;
    }
}
