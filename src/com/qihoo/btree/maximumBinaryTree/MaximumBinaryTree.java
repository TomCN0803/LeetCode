package com.qihoo.btree.maximumBinaryTree;

import com.qihoo.btree.TreeNode;
import com.qihoo.btree.traversal.Traversal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumBinaryTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inputArr = {3, 2, 1, 6, 0, 5};
        TreeNode root = solution.constructMaximumBinaryTree(inputArr);
        List<Integer> result = (new Traversal()).traverse(root, 0);
        System.out.println(result);
    }
}

class Solution {
    private static Map<Integer, Integer> keyMap;

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        keyMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            keyMap.put(nums[i], i);
        }

        return constructHelper(nums, 0, nums.length - 1);
    }

    private TreeNode constructHelper(int[] nums, int start, int end) {
        if (start > end) return null;
        int[] sorted;
        sorted = nums.clone();
        Arrays.sort(sorted, start, end + 1);
        int maxVal = sorted[end];
        TreeNode root = new TreeNode(maxVal);
        root.left = constructHelper(nums, start, keyMap.get(maxVal) - 1);
        root.right = constructHelper(nums, keyMap.get(maxVal) + 1, end);
        return root;
    }
}
