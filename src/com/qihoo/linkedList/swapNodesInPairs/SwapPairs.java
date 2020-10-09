package com.qihoo.linkedList.swapNodesInPairs;

import com.qihoo.linkedList.ListNode;

public class SwapPairs {
    public static void main(String[] args) {
        ListNode head = ListNode.generateLinkedList(new int[]{1, 2, 3, 4, 5});
        Solution solution = new Solution();
        ListNode swapped = solution.swapPairs(head);
        String res = ListNode.traverseLinkedList(swapped);
        System.out.println(res);
    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode nextPair = swapPairs(head.next.next);
        ListNode node = head.next;
        node.next = head;
        head.next = nextPair;

        return node;
    }
}
