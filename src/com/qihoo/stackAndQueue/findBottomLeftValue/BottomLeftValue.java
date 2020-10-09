package com.qihoo.stackAndQueue.findBottomLeftValue;

import com.qihoo.btree.TreeNode;
import com.qihoo.btree.buildTree.BuildTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BottomLeftValue {
    public static void main(String[] args) {
        TreeNode root = (new BuildTree()).buildTree(new int[]{1, 2, 4, 3, 5, 7, 6},
                new int[]{4, 2, 1, 7, 5, 3, 6});
        Solution solution = new Solution();
        int res = solution.FindBottomLeftValue(root);
        System.out.println(res);
    }
}

class Solution {
    public int FindBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        if (root == null) return -1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.right != null) queue.offer(node.right);
            if (node.left != null) queue.offer(node.left);
            list.add(node.val);
        }

        return list.get(list.size() - 1);
    }
}
