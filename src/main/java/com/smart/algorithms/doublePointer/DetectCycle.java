package com.smart.algorithms.doublePointer;

import java.util.HashSet;

/**
 * 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet();
        while (head != null) {
            boolean add = set.add(head);
            if (!add) return head;
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
