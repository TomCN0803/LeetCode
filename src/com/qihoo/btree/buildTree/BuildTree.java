package com.qihoo.btree.buildTree;

import com.qihoo.btree.TreeNode;
import com.qihoo.btree.traversal.Traversal;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {

    private Map<Integer, Integer> indexMap;

    /**
     * 根据前序遍历和中序遍历唯一确定一棵二叉树
     *
     * @param preorder 前序遍历
     * @param inorder  后序遍历
     * @return 二叉树头节点
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildHelper(preorder, 0, n - 1, 0);
    }

    private TreeNode buildHelper(int[] preorder, int preorderLeft, int preorderRight,
                                 int inorderLeft) {
        if (preorderLeft > preorderRight) {
            return null;
        }
        int inorderRoot = indexMap.get(preorder[preorderLeft]);
        int leftTraversalLen = inorderRoot - inorderLeft;
        TreeNode root = new TreeNode(preorder[preorderLeft]);
        root.left = buildHelper(preorder, preorderLeft + 1,
                preorderLeft + leftTraversalLen, inorderLeft);
        root.right = buildHelper(preorder, preorderLeft + leftTraversalLen + 1, preorderRight,
                inorderRoot + 1);

        return root;
    }

    public static void main(String[] args) {
        int[] preorderInput = {3, 9, 20, 15, 7};
        int[] inorderInput = {9, 3, 15, 20, 7};
        TreeNode root = (new BuildTree()).buildTree(preorderInput, inorderInput);
        System.out.println("二叉树生成完毕！");
        System.out.println("前序遍历：" + (new Traversal()).traverse(root, 0));
        System.out.println("中序遍历：" + (new Traversal()).traverse(root, 1));
    }
}


