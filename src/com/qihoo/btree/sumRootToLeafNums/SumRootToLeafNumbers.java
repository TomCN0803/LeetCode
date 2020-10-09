package com.qihoo.btree.sumRootToLeafNums;

import com.qihoo.btree.BTreeUtils;
import com.qihoo.btree.TreeNode;

public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = (new BTreeUtils()).generateBTree();
        int sum = solution.sumNumbers(root);
        System.out.println(sum);
    }
}

class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode node, int tempSum) {
        if (node == null) return 0;
        int temp = node.val;
        temp += 10 * tempSum;
        if (node.left == null && node.right == null) {
            return temp;
        } else {
            return helper(node.left, temp) + helper(node.right, temp);
        }
    }
}
