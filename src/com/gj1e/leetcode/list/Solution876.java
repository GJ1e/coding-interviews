package com.gj1e.leetcode.list;

import com.gj1e.leetcode.common.ListNode;

/**
 * @author FenDa
 * 876. 链表的中间结点
 */
public class Solution876 {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
