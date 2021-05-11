package com.smart.algorithms;

/**
 * 反转链表
 */
public class ReverseList {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /*
    三指针法：
    以 1 -> 2 -> 3 -> 4 为例
    指针 pre 指向 null
    指针 curr 指向 1
    指针 next 指向 2
    反转就是：curr 的 next 指向 pre，next 的 next 指向 curr
     */
    public ListNode doReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ans = null;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                ans = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return ans;
    }
    //1 -> 2 -> 3 -> 4
    //cur next
}