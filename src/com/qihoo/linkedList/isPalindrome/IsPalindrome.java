package com.qihoo.linkedList.isPalindrome;

import com.qihoo.linkedList.ListNode;

public class IsPalindrome {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNode.generateLinkedList(new int[]{1, 2, 2, 1});
        boolean res = solution.isPalindrome(head);
        System.out.println(res);
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode cpHead = new ListNode(head.val);
        ListNode original = head, copied = cpHead;
        while (original != null) {
            copied.next = original.next != null ? new ListNode(original.next.val) : null;
            copied = copied.next;
            original = original.next;
        }
        ListNode prev = null, curr = cpHead;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        original = head;
        copied = prev;
        while (original != null && copied != null) {
            if (original.val != copied.val) return false;
            original = original.next;
            copied = copied.next;
        }
        return true;
    }
}
