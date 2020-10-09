package com.qihoo.linkedList.linkedListCycle;

import com.qihoo.linkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {1, 2};
        int pos = -1;
        ListNode head = ListNode.generateCycleLinkedList(input, pos);
        ListNode cycleNode = solution.detectCycleSet(head);
        if (cycleNode != null) {
            System.out.println(cycleNode.val);
        } else System.out.println("NULL");
    }
}

class Solution {
    public ListNode detectCycleFloyd(ListNode head) {
        ListNode slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) {
                ListNode headPtr = head, meetPtr = slow;
                while (headPtr != meetPtr) {
                    headPtr = headPtr.next;
                    meetPtr = meetPtr.next;
                }
                return headPtr;
            }
        }
        return null;
    }

    public ListNode detectCycleSet(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if (nodeSet.contains(node)) {
                return node;
            }
            nodeSet.add(node);
            node = node.next;
        }

        return null;
    }
}
