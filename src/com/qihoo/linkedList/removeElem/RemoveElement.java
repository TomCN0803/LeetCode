package com.qihoo.linkedList.removeElem;

import com.qihoo.linkedList.ListNode;

public class RemoveElement {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] testList = {1, 2, 6, 3, 4, 5, 6};
        int testVal = 6;
        ListNode head = ListNode.generateLinkedList(testList);
        ListNode res = solution.removeElements(head, testVal);
        String resStr = ListNode.traverseLinkedList(res);
        System.out.println(resStr);
    }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }

        return dummy.next;
    }
}
