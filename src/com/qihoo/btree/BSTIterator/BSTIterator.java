package com.qihoo.btree.BSTIterator;

import com.qihoo.btree.BTreeUtils;
import com.qihoo.btree.TreeNode;

import java.util.*;

public class BSTIterator {
    private final Queue<Integer> elements;

    public BSTIterator(TreeNode root) {
        elements = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            elements.offer(root.val);
            root = root.right;
        }
    }

    public int next() {
        if (elements.peek() != null)
            return elements.poll();
        else return -1;
    }

    public boolean hasNext() {
        return !elements.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode root = (new BTreeUtils()).generateBTree(1);
        BSTIterator bstIterator = new BSTIterator(root);
        while (bstIterator.hasNext()) {
            System.out.println(bstIterator.next());
        }
    }
}
