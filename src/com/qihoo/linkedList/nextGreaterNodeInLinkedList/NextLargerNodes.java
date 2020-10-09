package com.qihoo.linkedList.nextGreaterNodeInLinkedList;

import com.qihoo.linkedList.ListNode;

import java.util.*;

public class NextLargerNodes {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNode.generateLinkedList(new int[]{2, 7, 4, 3, 5});
        int[] result = solution.nextLargerNodes(head);
        System.out.println(Arrays.toString(result));
    }
}

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        Map<ListNode, Integer> indexMap = new HashMap<>();
        LinkedList<Integer> res = new LinkedList<>();
        int index = 0;
        while (head != null) {
            res.add(0);
            while (!stack.isEmpty() && head.val > stack.peek().val) {
                res.set(indexMap.get(stack.pop()), head.val);
            }
            indexMap.put(head, index++);
            stack.push(head);
            head = head.next;
        }

        Iterator<Integer> iterator = res.iterator();
        int[] result = new int[index];
        index = 0;
        while (iterator.hasNext()) {
            result[index] = iterator.next();
            index++;
        }

        return result;
    }
}
