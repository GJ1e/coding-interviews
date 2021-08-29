package com.gj1e.leetcode.hot;


/**
 * @author FenDa
 * 2. 两数相加
 */
public class Solution02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int curry = 0;
        while (l1 != null || l2 != null) {
            int node1 = l1 == null ? 0 : l1.val;
            int node2 = l2 == null ? 0 : l2.val;

            int sum = node1 + node2 + curry;
            curry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (curry != 0) {
                cur.next = new ListNode(curry);
            }
        }
        return pre.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

