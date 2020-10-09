package com.qihoo.btree.sumOfLeftLeaves;

import com.qihoo.btree.TreeNode;
import com.qihoo.btree.buildTree.BuildTree;

public class SumOfLeftLeaves {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = (new BuildTree()).buildTree(new int[]{3, 9, 20, 15, 7},
                new int[]{9, 3, 15, 20, 7});
        int res = solution.sumOfLeftLeaves(root);
        System.out.println(res);
    }
}

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root != null && root.left == null && root.right == null)
            return 0;
        return helper(root, 1);
    }

    private int helper(TreeNode node, int left) {
        if (node == null) return 0;
        if (node.left == null && node.right == null && left == 1)
            return node.val;
        int leftTree = helper(node.left, 1);
        int rightTree = helper(node.right, 0);

        return leftTree + rightTree;
    }
}
