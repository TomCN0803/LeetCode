package com.qihoo.linkedList.reorderList;

import com.qihoo.linkedList.ListNode;

public class ReorderList {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNode.generateLinkedList(new int[]{1, 2, 3, 4});
        ListNode reordered = solution.reorderList(head);
        String res = ListNode.traverseLinkedList(reordered);
        System.out.println(res);
    }
}

class Solution {
    public ListNode reorderList(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) fast = fast.next;
        }
        fast = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (fast != null) {
            ListNode temp = fast.next;
            fast.next = prev;
            prev = fast;
            fast = temp;
        }
        slow = head;
        while (prev != null) {
            ListNode temp = prev.next;
            prev.next = slow.next;
            slow.next = prev;
            slow = prev.next;
            prev = temp;
        }

        return head;
    }
}
