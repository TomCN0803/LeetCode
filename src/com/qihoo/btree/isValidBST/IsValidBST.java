package com.qihoo.btree.isValidBST;

import com.qihoo.btree.BTreeUtils;
import com.qihoo.btree.TreeNode;

public class IsValidBST {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = (new BTreeUtils()).generateBTree(1);
        boolean res = solution.isValidBST(root);
        System.out.println(res);
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode node, long lower, long upper) {
        if (node == null) return true;
        if (node.val < lower || node.val > upper) return false;
        return helper(node.left, lower, node.val) && helper(node.right, node.val, upper);
    }
}
