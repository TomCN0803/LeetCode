package com.qihoo.btree.rightSideView;

import com.qihoo.btree.TreeNode;
import com.qihoo.btree.buildTree.BuildTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return result;
        else queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                if (i == n - 1) result.add(node.val);
            }
        }

        return result;
    }
}

public class RightSideView {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preorder = {1, 2, 5, 3, 4}, inorder = {2, 5, 1, 0, 4};
        try {
            TreeNode root = (new BuildTree()).buildTree(preorder, inorder);
            List<Integer> res = solution.rightSideView(root);
            System.out.println(res);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause().toString());
        }
    }
}
