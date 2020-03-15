package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2020/3/15
 * @Time 9:36
 * 面试题23：链表中环的入口节点
 *
 * 题目：
 *      给一个链表，若其中包含环，请找出该链表的环的入口结点。
 *
 * 思路：
 *      快慢指针,建议画图，自己走一下。
 */
public class Solution23 {
    //定义链表节点
    private class ListNode{
        int value;
        ListNode next = null;
    }

    public ListNode entryNodeOfLoop(ListNode pHead){
        if (pHead==null || pHead.next==null)
            return null;
        ListNode fast = pHead.next.next;    //快指针
        ListNode slow = pHead.next;     //慢指针

        //确定链表是否有环
        while (fast!=null && slow!=null){
            if (fast == slow)
                break;
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast==null || slow==null)
            return  null;

        //找出环的入口节点
        slow = pHead;
        while (slow != fast){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
