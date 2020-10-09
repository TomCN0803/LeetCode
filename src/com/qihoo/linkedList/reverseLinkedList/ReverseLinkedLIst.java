package com.qihoo.linkedList.reverseLinkedList;

import com.qihoo.linkedList.ListNode;

public class ReverseLinkedLIst {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNode.generateLinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.println("反转前：" + ListNode.traverseLinkedList(head));
        ListNode reversed = solution.reverseList(head);
        System.out.println("反转后：" + ListNode.traverseLinkedList(reversed));
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
