package com.qihoo.linkedList.convertToBST;

import com.qihoo.btree.TreeNode;
import com.qihoo.btree.traversal.Traversal;
import com.qihoo.linkedList.ListNode;

import java.util.List;

public class ConvertToBST {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNode.generateLinkedList(new int[]{-10, -3, 0, 5, 9});
        TreeNode root = solution.sortedListToBST(head);
        List<Integer> result = (new Traversal()).traverse(root, 1);
        System.out.println(result);
    }
}

class Solution {
    private static ListNode getMedian(ListNode left, ListNode right) {
        ListNode slow = left;
        ListNode fast = left;
        while (fast != right && fast.next != right) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    private static TreeNode genBST(ListNode left, ListNode right) {
        if (left == right) return null;
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = genBST(left, mid);
        root.right = genBST(mid.next, right);

        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        return genBST(head, null);
    }
}
