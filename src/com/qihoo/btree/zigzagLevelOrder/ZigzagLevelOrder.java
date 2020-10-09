package com.qihoo.btree.zigzagLevelOrder;

import com.qihoo.btree.TreeNode;
import com.qihoo.btree.buildTree.BuildTree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arrPre = {3, 9, 20, 15, 7}, arrIn = {9, 3, 15, 20, 7};
        TreeNode root = (new BuildTree()).buildTree(arrPre, arrIn);
        List<List<Integer>> result = solution.zigzagLevelOrder(root);
        System.out.println(result);
    }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int flag = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        else queue.offer(root);
        while (!queue.isEmpty()) {
            var n = queue.size();
            List<Integer> temp = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                temp.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            if (flag % 2 != 0) {
                Collections.reverse(temp);
            }
            result.add(temp);
            flag++;
        }

        return result;
    }
}
