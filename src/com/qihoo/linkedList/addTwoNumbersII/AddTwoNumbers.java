package com.qihoo.linkedList.addTwoNumbersII;

import com.qihoo.linkedList.ListNode;

import java.util.Stack;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = ListNode.generateLinkedList(new int[]{5});
        ListNode l2 = ListNode.generateLinkedList(new int[]{5});
        ListNode sum = solution.addTwoNumbers(l1, l2);
        String res = ListNode.traverseLinkedList(sum);
        System.out.println(res);
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resDummy = new ListNode(Integer.MIN_VALUE);
        ListNode n1 = l1, n2 = l2;
        Stack<ListNode> s1 = new Stack<>(), s2 = new Stack<>();
        while (n1 != null) {
            s1.push(n1);
            n1 = n1.next;
        }
        while (n2 != null) {
            s2.push(n2);
            n2 = n2.next;
        }

        byte carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            ListNode t1 = s1.isEmpty() ? null : s1.pop();
            ListNode t2 = s2.isEmpty() ? null : s2.pop();
            int v1 = t1 != null ? t1.val : 0;
            int v2 = t2 != null ? t2.val : 0;
            int sum = v1 + v2 + carry;
            carry = (byte) (sum >= 10 ? 1 : 0);
            sum %= 10;
            ListNode sumNode = new ListNode(sum);
            sumNode.next = resDummy.next;
            resDummy.next = sumNode;
        }

        return resDummy.next;
    }
}
