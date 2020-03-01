package com.gj1e.question;


/**
 * @Author GJ1e
 * @Create 2019/9/14
 * @Time 15:44
 *
 *
 * 剑指offer
 * 面试题24：反转链表
 *
 * 问题：
 *      定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 思路：
 *      反转链表的过程中，一定要防止链表因为反转而导致断裂，所以一定要先保存，在赋值。
 *      H--->I--->J   以调整I节点为例，调整I.next指针时，除了要知道I节点本身，
 *      还需要知道I的前一个节点H，为了防止在调整过程中导致J节点的丢失，链表断裂，
 *      我们还需要事先保存I的下一个节点J。
 *
 * 异常情况：
 *      1.空链表，或链表只有一个节点
 *      2.反转之后链表出现断裂
 *      3.返回的反转之后的链表的头节点不是原始链表的尾节点
 */
public class Solution24 {
    class ListNode{
        int value;
        ListNode next = null;

        ListNode(int value){
            this.value = value;
            this.next = null;
        }
    }

    public ListNode ReverseList(ListNode head){
        if (head==null || head.next ==null )
            return head;
        ListNode reversHead = null;
        ListNode node = head;
        ListNode preNode = null;
        while (node != null){
            ListNode next = node.next;
            if (next == null){
                reversHead = node;
            }
            node.next = preNode;
            preNode = node;
            node = next;
        }
        return reversHead;
    }
}

