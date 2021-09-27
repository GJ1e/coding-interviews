package com.gj1e.leetcode.hot;

import java.util.Stack;

/**
 * @author FenDa
 * 20. 有效的括号
 */
public class Solution20 {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char ele : s.toCharArray()) {
            if (ele == '(') stack.push(')');
            else if (ele == '{') stack.push('}');
            else if (ele == '[') stack.push(']');
            else if (stack.isEmpty() || ele != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
