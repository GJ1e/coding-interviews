package com.gj1e.question;

import java.util.Stack;

/**
 * @Author GJ1e
 * @Create 2019/10/15
 * @Time 18:39
 *
 * 剑指offer
 * 面试题09：用两个栈实现队列
 *
 * 题目：
 *      用两个栈实现一个队列。完成队列的Push和Pop操作。队列中的元素为int类型。
 *
 * 思路：
 *      栈的特点是先进后厨，队列的特点是先进先出。
 *      队列：入队顺序：1，2，3，4；出队顺序：1，2，3，4
 *      栈：Push顺序：1，2，3，4；Pop顺序：4，3，2，1
 *
 *      首先插入元素1，随便把它插入哪个栈，比如我们就把它插入stack1，此时stack1中的元素有{1}，stack2为空。
 *      在压入2个元素2，3还是插入stack1，此时stack1中的元素有{1，2，3}其中元素3位于栈顶。
 *      这时如果删除一个元素，按照队列先进先出的规则，应该删除元素1。但是元素1并不位于栈顶，因此不能直接删除，
 *      但是，如果我们把stack1中的元素依次弹出并压入stack2中，则stack2中元素的顺序正好和stack1中的顺序相反，
 *      stack2中元素的顺序为{3，2，1}.这是元素1就位于栈顶了，就可以直接弹出了，且stack2中所有元素的弹出顺序
 *      都和队列出队的顺序一样。
 *      因此可以总结出，当stack2不位空时，stack2中的栈顶元素就是最先入队列的元素，直接弹出即可。
 *      当stack2位空时，我们可就把stack1中的元素逐个弹出并压入stack2中。如果接下来在插入一个元素4，
 *      则还是把它压入stack1。
 */
public class Solution09 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //队列的Push操作。
    public void Push(int elemen){
        stack1.push(elemen);
    }

    //队列的Pop操作
    public int Pop(){
        if (stack1.empty() && stack2.empty())
            throw new RuntimeException("请添加元素");
        if (stack2.empty()){    //stack2为空就把stack1中的元素弹出并压入stack2中。
            while (!stack1.empty())
            stack2.push(stack1.pop());
        }
        return stack2.pop();    //弹出stack2中的栈顶元素。
    }
}
