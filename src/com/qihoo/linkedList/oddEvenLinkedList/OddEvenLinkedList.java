package com.qihoo.linkedList.oddEvenLinkedList;

import com.qihoo.linkedList.ListNode;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNode.generateLinkedList(new int[]{2, 1, 3, 5, 6, 4, 7});
        ListNode sorted = solution.oddEvenList(head);
        String result = ListNode.traverseLinkedList(sorted);
        System.out.println(result);
    }
}

class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode prev = dummy, oddsDummy = new ListNode(Integer.MIN_VALUE), oddNode = oddsDummy;
        int counter = 1;
        while (head != null) {
            if (counter % 2 != 0) {
                oddNode.next = head;
                prev.next = head.next;
                oddNode = oddNode.next;
                head = head.next;
                oddNode.next = null;
            } else {
                prev = prev.next;
                head = head.next;
            }
            counter++;
        }
        oddNode.next = dummy.next;
        return oddsDummy.next;
    }
}
