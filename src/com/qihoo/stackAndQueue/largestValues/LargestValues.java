package com.qihoo.stackAndQueue.largestValues;

import com.qihoo.btree.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValues {
    public static void main(String[] args) {

    }
}


class Solution {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int qLen = queue.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < qLen; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            Collections.sort(level);
            result.add(level.get(level.size() - 1));
        }

        return result;
    }
}
