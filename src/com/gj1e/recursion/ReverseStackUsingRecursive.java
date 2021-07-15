package com.gj1e.recursion;

import java.util.Stack;

/**
 * @author FenDa
 * 给你一个栈，请你逆序这个栈。
 * 不能申请额外的数据结构，
 * 只能使用递归函数。
 */
public class ReverseStackUsingRecursive {
    public void solution(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = f(stack);
        solution(stack);
        stack.push(i);
    }

    private int f(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int tmp = f(stack);
            stack.push(result);
            return tmp;
        }
    }
}
