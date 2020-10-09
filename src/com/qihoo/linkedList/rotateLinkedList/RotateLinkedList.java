package com.qihoo.linkedList.rotateLinkedList;

import com.qihoo.linkedList.ListNode;

public class RotateLinkedList {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNode.generateLinkedList(new int[]{1});
        int k = 1;
        ListNode rotated = solution.rotateRight(head, k);
        String result = ListNode.traverseLinkedList(rotated);
        System.out.println(result);
    }
}

class Solution {
    private static int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }

        return size;
    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode front = dummy, back = dummy;
        int times;
        try {
            times = k % getSize(head);
        } catch (ArithmeticException e) {
            return null;
        }
        if (times == 0) return head;

        int i = 0;
        while (front.next != null) {
            if (i < times) {
                front = front.next;
                i++;
                continue;
            }
            front = front.next;
            back = back.next;
            i++;
        }
        ListNode temp = back.next;
        back.next = null;
        front.next = dummy.next;
        dummy.next = temp;

        return dummy.next;
    }
}
