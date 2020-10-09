package com.qihoo.btree.searchBST;

import com.qihoo.btree.BTreeUtils;
import com.qihoo.btree.TreeNode;

public class SearchBST {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = (new BTreeUtils()).generateBTree(1);
        int target = 3;
        TreeNode res = solution.searchBST(root, target);
        System.out.println(res.val);
    }
}

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        TreeNode resNode;
        if (root.val > val) {
            resNode = searchBST(root.left, val);
        } else if (root.val < val) {
            resNode = searchBST(root.right, val);
        } else {
            return root;
        }

        return resNode;
    }
}