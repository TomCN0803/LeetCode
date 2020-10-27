package com.qihoo.btree.pathSum;

import com.qihoo.btree.TreeNode;
import com.qihoo.btree.buildTree.BuildTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PathSumII {
    public static void main(String[] args) {
        TreeNode root = (new BuildTree()).buildTree(new int[]{5, 4, 11, 7, 2, 8, 13, 3, 6, 1},
                new int[]{7, 11, 2, 4, 5, 13, 8, 6, 3, 1});
        Solution solution = new Solution();
        int sum = 22;

        List<List<Integer>> ans = solution.pathSum(root, sum);
        System.out.println(ans);

    }
}

class Solution {
    private Stack<Integer> level;
    private List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        level = new Stack<>();
        ans = new LinkedList<>();
        dfs(root, sum);

        return ans;
    }

    private void dfs(TreeNode node, int sum) {
        if (node == null) return;
        sum -= node.val;
        level.add(node.val);
        if (node.left == null && node.right == null && sum == 0) {
            ans.add(new ArrayList<>(level));
        }
        dfs(node.left, sum);
        dfs(node.right, sum);
        level.pop();
    }
}
