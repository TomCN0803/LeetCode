package com.qihoo.btree.mergeTwoBTrees;

import com.qihoo.btree.TreeNode;
import com.qihoo.btree.buildTree.BuildTree;
import com.qihoo.btree.traversal.Traversal;

import java.util.List;

public class MergeBTrees {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] t1Pre = {1}, t1In = {1};
        int[] t2Pre = {2, 1, 4, 3, 7}, t2In = {1, 4, 2, 3, 7};
        TreeNode t1 = (new BuildTree()).buildTree(t1Pre, t1In);
        TreeNode t2 = (new BuildTree()).buildTree(t2Pre, t2In);
        TreeNode res = solution.mergeTrees(t1, t2);
        List<Integer> resList = (new Traversal()).traverse(res, 0);
        System.out.println(resList);
    }
}

class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);
        return node;
    }
}
