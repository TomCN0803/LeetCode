package com.qihoo.btree.uniqueBinarySearchTreesII;

import com.qihoo.btree.TreeNode;
import com.qihoo.btree.traversal.Traversal;

import java.util.LinkedList;
import java.util.List;

public class UniqueBST {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        List<TreeNode> BSTs = solution.generateTrees(70);
        for (TreeNode bst : BSTs) {
            System.out.println("前序遍历结果：" + (new Traversal()).traverse(bst, 0));
        }
    }
}

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }

        return generator(1, n);
    }

    private List<TreeNode> generator(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = generator(start, i - 1);
            List<TreeNode> rightTree = generator(i + 1, end);
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    allTrees.add(node);
                }
            }
        }

        return allTrees;
    }
}
