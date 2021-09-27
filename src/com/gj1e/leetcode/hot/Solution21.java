package com.gj1e.leetcode.hot;

import com.gj1e.leetcode.common.ListNode;

/**
 * @author FenDa
 * 21. 合并两个有序链表
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(-1);
        ListNode ans = head;

        while (true) {
            if (l1 == null) {
                head.next = l2;
                return ans.next;
            }
            if (l2 == null) {
                head.next = l1;
                return ans.next;
            }
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
    }
}
