package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2019/9/14
 * @Time 16:31
 *
 *
 * 剑指offer
 * 面试题25：合并两个排序链表
 *
 * 问题：
 *      输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 思路：
 *      比较两个链表的头节点，谁的值小，谁就是合并之后的链表的头节点，然后接着比较两个链表中剩下的头节点的值，
 *      谁小，谁就是合并之后链表的下一个节点，并将这个节点，和刚才的节点连接，以此类推。
 *
 * 异常情况：
 *      1.链表1为空，或者链表2为空
 */
public class Solution25 {
    class ListNode{
        int value;
        ListNode next = null;
    }

    public ListNode mergeList(ListNode listNode1,ListNode listNode2){
        if (listNode1 == null)
            return listNode2;
        else if (listNode2 == null)
            return listNode1;

        ListNode mergeList = new ListNode();

        if (listNode1.value < listNode2.value)
        {
            mergeList = listNode1;
            mergeList.next = mergeList(listNode1.next,listNode2);
        }
        else
        {
            mergeList = listNode2;
            mergeList.next = mergeList(listNode2.next,listNode1);
        }

        return mergeList;
    }
}
