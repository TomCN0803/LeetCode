package com.qihoo.linkedList.removeDuplicatesII;

import com.qihoo.linkedList.ListNode;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNode.generateLinkedList(new int[]{1, 1, 2, 2, 3, 3});
        ListNode deleted = solution.deleteDuplicates(head);
        String result = ListNode.traverseLinkedList(deleted);
        System.out.println(result);
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        boolean flag = false;
        ListNode prev = dummy;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                flag = true;
                head = head.next;
                continue;
            }
            if (flag) {
                flag = false;
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }

        return dummy.next;
    }
}
