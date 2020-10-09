package com.qihoo.btree.deleteNode;

import com.qihoo.btree.TreeNode;

public class DeleteNode {
    public static void main(String[] args) {

    }
}

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else {
                if (root.right != null) {
                    root.val = successor(root.right);
                    root.right = deleteNode(root.right, root.val);
                } else {
                    root.val = predecessor(root.left);
                    root.left = deleteNode(root.left, root.val);
                }
            }
        }

        return root;
    }

    private int successor(TreeNode node) {
        if (node.left == null) {
            return node.val;
        }
        return successor(node.left);
    }

    private int predecessor(TreeNode node) {
        if (node.right == null) return node.val;
        return successor(node.right);
    }
}
