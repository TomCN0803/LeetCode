package com.qihoo.btree.hasPathSum;

import com.qihoo.btree.BTreeUtils;
import com.qihoo.btree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class HasPathSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = (new BTreeUtils()).generateBTree();
        boolean res = solution.hasPathSum(root, 6, 0);
        System.out.println(res);
    }
}

class Solution {
    private static final int RECURSIVE = 1;
    private static final int ITERATIVE = 0;

    public boolean hasPathSum(TreeNode root, int num, int type) {
        if (type != RECURSIVE && type != ITERATIVE) {
            return false;
        }
        return type == ITERATIVE ? hasPathSumIter(root, num) : hasPathSumRec(root, num);
    }

    private boolean hasPathSumIter(TreeNode root, int num) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valQueue = new LinkedList<>();
        if (root != null) {
            nodeQueue.offer(root);
            valQueue.offer(root.val);
        } else {
            return false;
        }
        while (!nodeQueue.isEmpty() && !valQueue.isEmpty()) {
            int tempVal = valQueue.poll();
            TreeNode tempNode = nodeQueue.poll();
            assert tempNode != null;
            if (tempNode.left == null && tempNode.right == null) {
                if (tempVal == num) {
                    return true;
                }
                continue;
            }
            if (tempNode.left != null) {
                nodeQueue.offer(tempNode.left);
                valQueue.offer(tempNode.left.val + tempVal);
            }
            if (tempNode.right != null) {
                nodeQueue.offer(tempNode.right);
                valQueue.offer(tempNode.right.val + tempVal);
            }
        }

        return false;
    }

    private boolean hasPathSumRec(TreeNode root, int num) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == num;
        }
        return hasPathSumRec(root.left, num - root.val) || hasPathSumRec(root.right, num - root.val);
    }
}
