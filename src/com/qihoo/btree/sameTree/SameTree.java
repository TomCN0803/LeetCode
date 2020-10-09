package com.qihoo.btree.sameTree;

import com.qihoo.btree.TreeNode;
import com.qihoo.btree.buildTree.BuildTree;

public class SameTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] pPre = {1, 2, 4}, pIn = {2, 1, 4};
        int[] qPre = {1, 2, 3}, qIn = {2, 1, 3};
        TreeNode pRoot = (new BuildTree()).buildTree(pPre, pIn);
        TreeNode qRoot = (new BuildTree()).buildTree(qPre, qIn);
        boolean res = solution.isSameTree(pRoot, qRoot);
        System.out.println(res);
    }
}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(q.right, p.right);
    }
}
