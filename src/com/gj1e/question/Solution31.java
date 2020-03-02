package com.gj1e.question;

import java.util.Stack;

/**
 * @Author GJ1e
 * @Create 2020/3/2
 * @Time 11:16
 * 面试题31：栈的压入，弹出序列
 *
 * 题目：
 *      输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 *      假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 *      但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 *
 * 思路：
 *      构建一个辅助栈，按入栈顺序压栈，按弹出序列出栈。先将第一个元素入栈，然后判断栈顶元素和出栈序列的第一个元素是否相等。
 *      不等则继续压栈，相等则弹出栈顶元素，出栈一个元素，则将出栈序列的标记向后移动一位。直到不相等。
 *      循环遍历完之后，如果栈不为空，说明弹出序列不是该栈的弹出顺序。
 */
public class Solution31 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0 || pushA.length != popA.length)
            return false;

        Stack<Integer> data = new Stack<>();//辅助栈
        int popIndex = 0; //出栈序列的标记

        for (int i = 0; i < pushA.length; i++) {
            data.push(pushA[i]);
            while (!data.empty() && data.peek()==popA[popIndex]){ //这里的判空还是有必要的，因为有可能会弹出好几次。
                data.pop();
                popIndex++;
            }
        }
        return data.empty();
    }
}
