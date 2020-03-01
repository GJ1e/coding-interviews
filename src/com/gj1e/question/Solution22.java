package com.gj1e.question;


/**
 * @Author GJ1e
 * @Create 2019/9/14
 * @Time 15:18
 *
 * 剑指offer
 * 面试题22：链表中倒数第K个节点。
 *
 * 问题：
 *      输入一个链表，输出该链表中倒数第K个节点。
 *
 * 思路：（快慢指针）
 *      假设整个链表有N个节点，那么倒数第K个节点就是从头节点开始的第N-K+1个节点。
 *      定义两个指针，第一个指针从链表头节点开始遍历向前走K-1步，第二个指针保持不动。
 *      从第K步开始，第二个指针也开始从链表头节点开始遍历。
 *      由于2个指针的距离保持在K-1,当第一个指针到达链表的尾节点时，第二个指针正好指向倒数第K个节点。
 *
 * 异常情况：
 *      1.空链表
 *      2.k-1超过了链表的长度。
 *      3.k=0
 */
public class Solution22 {
    class ListNode{
        int value;
        ListNode next = null;
    }

    public ListNode findListFromTailToK(ListNode listNode , int k) {

        if (listNode==null || k==0)     //异常情况处理
            return listNode;

        ListNode fastPoint = listNode;
        ListNode slowPoint = null;

        for (int i=0;i<k-1;i++)
        {
            if (fastPoint.next != null)     //检查K-1是否超过链表长度。
            {
                fastPoint = fastPoint.next;
            }
            else {
                return listNode;
            }
        }

        slowPoint = listNode;

        while (fastPoint.next != null)
        {
            fastPoint = fastPoint.next;
            slowPoint = slowPoint.next;
        }

        return slowPoint;

    }
}
