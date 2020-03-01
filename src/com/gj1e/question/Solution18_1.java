package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2019/12/18
 * @Time 18:34
 *
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 注意重复的结点不保留：并不是将重复结点删除到只剩一个，而是重复结点的全部会被删除。所以
 * 链表1->2->3->3->4->4->5不是1->2->3->4->5
 */
public class Solution18_1 {
    private class ListNode{
        int value;
        ListNode next = null;
    }

    public ListNode deleteDuplication(ListNode pHead){
        if (pHead==null || pHead.next==null)
            return null;

        ListNode pNode = pHead;
        ListNode pPreNode = null;

        while (pNode!=null && pNode.next!=null){
            //当前节点和下一个节点的值相同，进入删除。
            if (pNode.value == pNode.next.value){
                int val = pNode.value;  //记录下当前重复节点的值

                //把与当前节点值相同的节点全部跳过，出循环的第一个节点就是不重复的节点
                while (pNode!=null && (pNode.value==val)){
                    pNode = pNode.next;
                }
                if (pPreNode==null){ //头节点就是重复节点，被删除要重新设置头节点。
                    pHead = pNode;
                }else {
                    pPreNode.next = pNode;
                }

                //不同则向前推进
            }else {
                pPreNode = pNode;
                pNode = pNode.next;
            }
        }
        return pHead;
    }
}
