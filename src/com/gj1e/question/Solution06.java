package com.gj1e.question;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author GJ1e
 * @Create 2019/9/11
 * @Time 21:21
 *
 * 剑指Offer
 * 面试题6：从尾到头打印链表
 * “已AC的”
 * 题目：
 *      输入一个链表的头节点，从尾到头反过来打印出每个节点的值
 *
 * 思路1：
 *      遍历的顺序是从头到尾，输出的顺序是从尾到头。也就是说，第一个遍历的节点，最后一个输出；
 *      最后一个遍历的节点，第一个输出。这就是典型的“先进后出”。所以可以选择“栈”来解决这个问题。
 * 思路2：这个题也可以用递归的方式来解，递归的本质就是一个栈结构。
 */
public class Solution06 {
    class ListNode{
        int value;
        ListNode next = null;

        ListNode(int value){
            this.value = value;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (listNode == null)   //异常输入
            return arrayList;

        Stack<Integer> stack = new Stack<Integer>();
        while(listNode!= null)
        {
            stack.push(listNode.value);
            listNode = listNode.next;
        }
        while (!stack.empty())
        {
            arrayList.add(stack.pop().intValue());
        }
        return arrayList;
    }
}
