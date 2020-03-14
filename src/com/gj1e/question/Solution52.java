package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2020/3/14
 * @Time 12:02
 * 面试题52：两个链表的第一个公共节点
 *
 * 题目：
 *      输入两个链表，找出他们的第一个公共节点。
 *
 * 思路：
 *      记录两个链表的长度，然后让长的链表先走，走到和短链表一样长的位置上，然后在同时遍历两个链表，找出公共节点。
 */
public class Solution52 {
    private class ListNode{
        int value;
        ListNode next = null;
    }
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1==null || pHead2==null)
            return null;
        //记录两个链表的长度
        int p1Length = listCount(pHead1);
        int p2Length = listCount(pHead2);
        int dif = p1Length - p2Length; //记录两个链表长度的差值。

        ListNode longList = pHead1;
        ListNode shortList = pHead2;
        if (p1Length < p2Length){
            longList = pHead2;
            shortList = pHead1;
            dif = p2Length - p1Length;
        }
        //在长链表上先走几步，让两个链表对齐
        for (int i = 0; i < dif; i++) {
            longList = longList.next;
        }
        //同时遍历两个链表，找出公共节点
        while (longList!=null && shortList!=null){
            if (longList == shortList)
                return longList;
            else {
                longList = longList.next;
                shortList = shortList.next;
            }
        }
        //没找到
        return null;
    }

    /**
     * 计算链表长度
     * @param pHead
     * @return
     */
    private int listCount(ListNode pHead){
        int count = 0;
        while (pHead == null){
            count++;
            pHead = pHead.next;
        }
        return count;
    }
}
