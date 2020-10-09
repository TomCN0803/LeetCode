package com.qihoo.linkedList.numComponents;

import com.qihoo.linkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

public class NumComponents {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNode.generateLinkedList(new int[]{0, 1, 2, 3});
        int[] G = {0, 1, 3};
        int ans = solution.numComponents(head, G);
        System.out.println(ans);
    }
}

class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> Gset = new HashSet<>();
        int ans = 0;
        for (int num : G) {
            Gset.add(num);
        }

        ListNode curr = head;
        while (curr != null) {
            if (Gset.contains(curr.val) && (curr.next == null || !Gset.contains(curr.next.val))) {
                ans++;
            }
            curr = curr.next;
        }

        return ans;
    }
}
