package com.qihoo.btree.insertIntoBST;

import com.qihoo.btree.BTreeUtils;
import com.qihoo.btree.TreeNode;
import com.qihoo.btree.traversal.Traversal;

import java.util.List;

public class InsertIntoBST {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = (new BTreeUtils()).generateBTree(1);
        TreeNode res = solution.insertIntoBST(root, 5);
        List<Integer> traverse = (new Traversal()).traverse(res, 1);
        System.out.println(traverse);
    }
}

class Solution {
    public final int LEFT = 0;
    public final int RIGHT = 1;

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        insert(root, null, -1, val);
        return root;
    }

    private void insert(TreeNode node, TreeNode prev, int flag, int val) {
        if (node == null) {
            if (flag == RIGHT) {
                prev.right = new TreeNode(val);
            }
            if (flag == LEFT) {
                prev.left = new TreeNode(val);
            }
            return;
        }
        if (node.val > val) {
            insert(node.left, node, LEFT, val);
        }
        if (node.val < val) {
            insert(node.right, node, RIGHT, val);
        }
    }
}
