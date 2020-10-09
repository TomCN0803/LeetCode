package com.qihoo.linkedList.myLinkedList;

import com.qihoo.linkedList.ListNode;

public class MyLinkedList {
    private final ListNode dummy;

    private ListNode tail;

    private int size;

    /**
     * Initialize data structure here.
     */
    public MyLinkedList() {
        this.dummy = new ListNode(Integer.MIN_VALUE);
        this.tail = this.dummy;
        this.size = 0;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);
        list.deleteAtIndex(1);

    }

    public int size() {
        return this.size;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        ListNode node = this.dummy.next;
        int counter = 0;
        while (node != null) {
            if (counter == index) return node.val;
            node = node.next;
            counter++;
        }

        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        this.dummy.next = new ListNode(val, this.dummy.next);
        if (this.size == 0) this.tail = this.dummy.next;
        this.size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        this.tail.next = new ListNode(val);
        this.tail = this.tail.next;
        this.size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > this.size) return;
        if (index == 0) this.addAtHead(val);
        ListNode currNode = this.dummy;
        ListNode node = new ListNode(val);
        int counter = 0;
        while (currNode != null) {
            if (counter == index) {
                node.next = currNode.next;
                currNode.next = node;
                this.size++;
                return;
            }
            currNode = currNode.next;
            counter++;
        }
    }

    public void deleteAtIndex(int index) {
        ListNode prev = this.dummy;
        ListNode node = this.dummy.next;
        int counter = 0;
        while (node != null) {
            if (counter == index) {
                prev.next = node.next;
                this.size--;
                return;
            }
            prev = prev.next;
            node = node.next;
            counter++;
        }
    }
}
