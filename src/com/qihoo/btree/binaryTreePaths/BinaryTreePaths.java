package com.qihoo.btree.binaryTreePaths;

import com.qihoo.btree.BTreeUtils;
import com.qihoo.btree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = (new BTreeUtils()).generateBTree();
        List<String> res = solution.binaryTreePaths(root);
        System.out.println(res);
    }
}

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        getLeaf(root, "", result);

        return result;
    }

    private void getLeaf(TreeNode node, String path, List<String> result) {
        if (node != null) {
            StringBuilder pathSB = new StringBuilder();
            pathSB.append(path);
            pathSB.append(node.val);
            if (node.left == null && node.right == null) {
                result.add(pathSB.toString());
            } else {
                pathSB.append("->");
                getLeaf(node.left, pathSB.toString(), result);
                getLeaf(node.right, pathSB.toString(), result);
            }
        }
    }
}