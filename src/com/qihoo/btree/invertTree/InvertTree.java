package com.qihoo.btree.invertTree;

import com.qihoo.btree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return root;
    }

    public TreeNode invertTreeRec(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTreeRec(root.left);
        root.left = invertTreeRec(root.right);
        root.right = left;

        return root;
    }
}
