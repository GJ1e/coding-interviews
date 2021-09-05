package com.gj1e.leetcode.hot;

import com.gj1e.leetcode.common.ListNode;


/**
 * @author FenDa
 * 19. 删除链表的倒数第 N 个结点
 * 快慢指针
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = tmp;
        for (int i = 0; i < 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return tmp.next;
    }
}
