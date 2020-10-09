package com.qihoo.btree.lowestCommonAncestor;

import com.qihoo.btree.TreeNode;

public class LowestCommonAncestor {
    public static void main(String[] args) {

    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while (true) {
            if (curr.val < p.val && curr.val < q.val) {
                curr = curr.right;
            } else if (curr.val > p.val && curr.val > q.val) {
                curr = curr.left;
            } else {
                return curr;
            }
        }
    }
}
