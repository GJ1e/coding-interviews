package com.gj1e.question;

import java.util.Stack;

/**
 * @Author GJ1e
 * @Create 2020/3/2
 * @Time 10:30
 * 面试题30：包含min函数的栈
 *
 * 题目：
 *      定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 * 思路：
 *      额外定义一个辅助栈，记录压入数据站的最小值。
 */
public class Solution30 {
    
    Stack<Integer> data = new Stack<>();    //数据栈
    Stack<Integer> minData = new Stack<>(); //辅助栈

    public void push (int node){
        data.push(node);
        if (minData.size()==0 || node<minData.peek()){ //若当前入栈值小于辅助栈中所记录的最小值，则把该元素压入辅助栈
            minData.push(node);
        }else { //否则继续压入辅助栈中记录的最小值
            minData.push(minData.peek());
        }
    }

    public void pop(){
        data.pop();
        minData.pop();
    }

    public int min(){
        return minData.peek();
    }

}
