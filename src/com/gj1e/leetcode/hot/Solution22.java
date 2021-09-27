package com.gj1e.leetcode.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FenDa
 * 22. 括号生成
 */
public class Solution22 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n == 0)
            return res;
        process("", n, n);
        return res;
    }

    private void process(String s, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            process(s+"(",left-1,right);
        }
        if (right > 0) {
            process(s+")",left,right-1);
        }
    }
}
