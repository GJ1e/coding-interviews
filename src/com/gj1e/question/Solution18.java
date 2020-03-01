package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2019/9/14
 * @Time 14:32
 *
 * 剑指offer
 * 面试题18:删除链表的节点
 *
 * 问题：
 *      给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间内删除该节点。
 *
 * 思路：删除链表中的某个节点，并不一定是删除本身的节点。
 *      可以把要删除节点的下一个节点的内容复制到需要删除的节点上覆盖原有的内容，然后在把下一个节点删除，
 *      这也就是相当于把需要的节点删除了。
 *
 * 异常情况：
 *      1.删除节点是尾节点
 *      2.链表只有一个节点
 *      3.空链表，或删除节点为空。
 *
 * 注：因收到O(1)时间的限制，以下的解法均基于一个假设：要删除的节点的确在链表中。
 */
public class Solution18 {
    private class ListNode{
        int value;
        ListNode next = null;
    }

    public ListNode deleteListNode(ListNode listNode , ListNode deleteNode){
        if (listNode == null || deleteNode == null)
            return listNode;
        if(deleteNode.next != null)     //删除的节点不是尾节点
        {
            ListNode temp = deleteNode.next;
            deleteNode.value = temp.value;
            deleteNode.next = temp.next;

            return listNode;
        }
        else if (deleteNode == listNode)    //链表只有一个节点，删除的节点为头节点（也是尾节点）
        {
            listNode = null;

            return listNode;
        }
        else        //删除的链表是尾节点
        {
            while(listNode.next != deleteNode)  //要删除的节点是尾节点，所以要寻找删除节点的前一个节点（前驱）
            {
                listNode = listNode.next;
            }
            listNode.next = null;

            return listNode;
        }

    }
}
