package com.qihoo.btree.deepestLeavesSum;

import com.qihoo.btree.TreeNode;
import com.qihoo.btree.buildTree.BuildTree;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {
    public static void main(String[] args) {
        TreeNode root = (new BuildTree()).buildTree(new int[]{1, 2, 4, 7, 5, 3, 6, 8},
                new int[]{7, 4, 2, 5, 1, 3, 6, 8});
        Solution solution = new Solution();
        int sum = solution.deepestLeavesSumDFS(root);
        System.out.println(sum);
    }
}

class Solution {
    private int maxDepth;
    private int ans;

    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        if (root == null) return sum;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            sum = 0;
            int qLen = queue.size();
            for (int i = 0; i < qLen; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                sum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return sum;
    }

    public int deepestLeavesSumDFS(TreeNode root) {
        maxDepth = -1;
        ans = 0;
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (depth > maxDepth) {
            maxDepth = depth;
            ans = root.val;
        }
        else if (depth == maxDepth) {
            ans += root.val;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
