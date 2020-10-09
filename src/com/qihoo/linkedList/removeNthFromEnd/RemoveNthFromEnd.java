package com.qihoo.linkedList.removeNthFromEnd;

import com.qihoo.linkedList.ListNode;

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {1, 2};
        int n = 2;
        ListNode head = ListNode.generateLinkedList(input);
        ListNode removed = solution.removeNthFromEnd(head, n);
        String result = ListNode.traverseLinkedList(removed);
        System.out.println(result);
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode front = dummy, back = dummy;
        int i = 0;
        while (front != null) {
            if (i < n + 1) {
                front = front.next;
                i++;
                continue;
            }
            back = back.next;
            front = front.next;
            i++;
        }
        back.next = back.next.next;

        return dummy.next;
    }
}
