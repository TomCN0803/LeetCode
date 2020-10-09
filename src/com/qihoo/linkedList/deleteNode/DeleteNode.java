package com.qihoo.linkedList.deleteNode;

import com.qihoo.linkedList.ListNode;

public class DeleteNode {
    public static void main(String[] args) {

    }
}

class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
