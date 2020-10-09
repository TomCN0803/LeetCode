package com.qihoo.linkedList.removeZeroSumSublists;

import com.qihoo.linkedList.ListNode;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumSublists {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        Map<Integer, ListNode> prefixSumMap = new HashMap<>();
        ListNode p = dummy;
        int prefixSum = 0;
        while (p != null) {
            prefixSum += p.val;
            if (prefixSumMap.containsKey(prefixSum)) {
                p = prefixSumMap.get(prefixSum).next;
                int val = prefixSum + p.val;
                while (val != prefixSum) {
                    prefixSumMap.remove(val);
                    p = p.next;
                    val += p.val;
                }
                prefixSumMap.get(prefixSum).next = p.next;
            } else {
                prefixSumMap.put(prefixSum, p);
            }
            p = p.next;
        }
        return dummy.next;
    }
}
