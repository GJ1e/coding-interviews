package com.gj1e.leetcode.list;

import com.gj1e.leetcode.common.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author FenDa
 * 23. 合并K个升序链表
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode ans = head;
        if (lists == null || lists.length <= 0) {
            return ans.next;
        }
        Queue<ListNode> minHeap = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        for (ListNode ele : lists) {
            if (ele != null) {
                minHeap.offer(ele);
            }
        }
        while (!minHeap.isEmpty()) {
            ListNode tmp = minHeap.poll();
            head.next = tmp;
            if (tmp.next != null) {
                minHeap.offer(tmp.next);
            }
            head = head.next;
        }
        return ans.next;
    }
}
