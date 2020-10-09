package com.qihoo.btree.isSymmetric;

import com.qihoo.btree.BTreeUtils;
import com.qihoo.btree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {
    public static void main(String[] args) {
        BTreeUtils bTreeUtils = new BTreeUtils();
        TreeNode root = bTreeUtils.generateBTree();
        Solution solution = new Solution();
        Boolean res = solution.isSymmetric(root);
        System.out.println(res);
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode u = queue.poll();
            TreeNode v = queue.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || ((u.val != v.val))) {
                return false;
            }
            queue.offer(u.left);
            queue.offer(v.right);
            queue.offer(u.right);
            queue.offer(v.left);
        }

        return true;
    }
}

