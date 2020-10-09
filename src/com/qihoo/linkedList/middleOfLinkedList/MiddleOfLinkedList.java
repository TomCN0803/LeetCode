package com.qihoo.linkedList.middleOfLinkedList;

import com.qihoo.linkedList.ListNode;

public class MiddleOfLinkedList {
    public static void main(String[] args) {

    }
}

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) fast = fast.next;
        }

        return slow;
    }
}
