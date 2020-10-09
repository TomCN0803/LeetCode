package com.qihoo.linkedList.splitListToParts;

import com.qihoo.linkedList.ListNode;

public class SplitListToParts {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 5;
        ListNode head = ListNode.generateLinkedList(new int[]{1, 2, 3});
        ListNode[] ans = solution.splitListToParts(head, k);
        for (ListNode a : ans) {
            System.out.println(ListNode.traverseLinkedList(a));
        }
    }
}

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        int width = len / k;
        int rem = len % k;
        curr = head;
        for (int i = 0; i < k; i++) {
            ListNode dummy = new ListNode(Integer.MIN_VALUE), writer = dummy;
            for (int j = 0; j < width + (i >= rem ? 0 : 1); j++) {
                writer.next = new ListNode(curr.val);
                writer = writer.next;
                curr = curr.next;
            }
            result[i] = dummy.next;
        }

        return result;
    }
}
