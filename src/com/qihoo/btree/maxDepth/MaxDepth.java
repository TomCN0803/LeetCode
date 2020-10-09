package com.qihoo.btree.maxDepth;

import com.qihoo.btree.BTreeUtils;
import com.qihoo.btree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxDepth {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = (new BTreeUtils()).generateBTree();
        int result = solution.maxDepthRecursive(root);
        System.out.println(result);
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        } else {
            return 0;
        }
        while (!queue.isEmpty()) {
            int l = queue.size();
            List<Integer> temp = new LinkedList<>();
            for (int i = 0; i < l; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                temp.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(temp);
        }

        return res.size();
    }

    public int maxDepthRecursive(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepthRecursive(root.left), maxDepthRecursive(root.right)) + 1;
    }
}
