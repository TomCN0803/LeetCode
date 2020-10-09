package com.qihoo.linkedList.intersectionOfTwoLinkedList;

import com.qihoo.linkedList.ListNode;

public class IntersectionNode {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode headA = ListNode.generateLinkedList(new int[]{4, 1, 8, 4, 5});
        ListNode headB = ListNode.generateLinkedList(new int[]{5, 0, 1});
        headB.next.next.next = headA.next.next;
        ListNode inter = solution.getIntersectionNode(headA, headB);
        System.out.println(inter.val);
    }
}

class Solution {
    private static int getLinkedListLen(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }

        return count;
    }

    private static ListNode getStartNode(ListNode head, int diff) {
        int i = 0;
        while (i != diff) {
            head = head.next;
            i++;
        }

        return head;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLinkedListLen(headA), lenB = getLinkedListLen(headB);
        ListNode startLong, startShort;
        int lenDiff = Math.abs(lenA - lenB);
        if (lenA > lenB) {
            startLong = getStartNode(headA, lenDiff);
            startShort = headB;
        } else if (lenA < lenB) {
            startLong = getStartNode(headB, lenDiff);
            startShort = headA;
        } else {
            startLong = headA;
            startShort = headB;
        }

        while (startLong != null && startShort != null && !startLong.equals(startShort)) {
            startLong = startLong.next;
            startShort = startShort.next;
        }

        return startLong;
    }
}
