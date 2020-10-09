package com.qihoo.linkedList;

/**
 * 单链表节点的定义
 *
 * @author tanghaokun
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 根据数组生成单链表
     *
     * @param elements 数组
     * @return 单链表头节点
     */
    public static ListNode generateLinkedList(int[] elements) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode prev = dummy;
        for (int elem : elements) {
            ListNode node = new ListNode(elem);
            prev.next = node;
            prev = node;
        }

        return dummy.next;
    }

    /**
     * 根据数组生成环形单链表
     *
     * @param elements 数组
     * @param pos      环形节点的索引
     * @return 环形单链表头节点
     */
    public static ListNode generateCycleLinkedList(int[] elements, int pos) {
        final ListNode head = ListNode.generateLinkedList(elements);
        if (pos < 0) return head;
        ListNode tail = head, node = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        int counter = 0;
        while (node != null) {
            if (counter == pos) {
                tail.next = node;
                break;
            }
            counter++;
            node = node.next;
        }

        return head;
    }

    /**
     * 遍历单链表
     *
     * @param head 单链表头节点
     * @return 遍历结果
     */
    public static String traverseLinkedList(ListNode head) {
        StringBuilder result = new StringBuilder();
        while (head != null) {
            result.append(head.val).append(" -> ");
            head = head.next;
        }
        result.append("null");

        return result.toString();
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5};
        ListNode head = generateCycleLinkedList(test, 1);
//        String result = traverseLinkedList(head);
        System.out.println(head);
    }
}
