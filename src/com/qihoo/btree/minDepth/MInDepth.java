package com.qihoo.btree.minDepth;

import com.qihoo.btree.TreeNode;
import com.qihoo.btree.buildTree.BuildTree;


public class MInDepth {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = (new BuildTree()).buildTree(preorder, inorder);
        int res = solution.minDepth(root);
        System.out.println(res);
    }
}

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int minLeft = minDepth(root.left);
        int minRight = minDepth(root.right);
        return root.left == null || root.right == null ? minLeft + minRight + 1 : Math.min(minLeft, minRight) + 1;
    }
}
