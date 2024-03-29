package com.gj1e.leetcode.list;

import com.gj1e.leetcode.common.ListNode;

/**
 * @author FenDa
 * 141. 环形链表
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode p1 = head, p2 = head;
        while (p1 != null && p1.next != null) {
            p1 = p1.next.next;
            p2 = p2.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }
}
