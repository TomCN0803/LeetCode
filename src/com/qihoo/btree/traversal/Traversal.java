package com.qihoo.btree.traversal;


import com.qihoo.btree.BTreeUtils;
import com.qihoo.btree.TreeNode;

import java.util.*;

/**
 * 二叉树的四种遍历方式，递归与非递归都有
 *
 * @author tanghaokun
 */
public class Traversal {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = (new BTreeUtils()).generateBTree();
//        List<Integer> res = solution.postorderTraversal(root, 0);
        List<List<Integer>> res = solution.levelOrder(root);
        System.out.println(res);
    }

    public List<Integer> traverse(TreeNode root, int method) {
        List<Integer> res = new ArrayList<>();
        Solution solution = new Solution();
        final int PREORDER = 0;
        final int INORDER = 1;
        final int POSTORDER = 2;
        switch (method) {
            case PREORDER:
                res = solution.preorderTraversal(root, 1);
                break;
            case INORDER:
                res = solution.inorderTraversal(root, 1);
                break;
            case POSTORDER:
                res = solution.postorderTraversal(root, 1);
                break;
            default:
                break;
        }

        return res;
    }
}

class Solution {
    private static final int RECURSIVE = 1; // 采用递归
    private static final int ITERATIVE = 0; // 不采用递归

    private static void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    private static List<Integer> inorderIterative(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }

        return res;
    }

    private static List<Integer> inorderRecursive(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        inorder(root, res);
        return res;
    }

    private static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    /**
     * 对外的前序遍历二叉树接口
     *
     * @param root 二叉树根结点
     * @param flag 1: 采用递归 0: 采用迭代
     * @return 遍历结果
     */
    public List<Integer> preorderTraversal(TreeNode root, int flag) {
        if (flag != RECURSIVE && flag != ITERATIVE) {
            return null;
        }
        return flag == ITERATIVE ? preorderIterative(root) : preorderRecursive(root);
    }

    private List<Integer> preorderIterative(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return result;
    }

    private List<Integer> preorderRecursive(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        preorder(root, res);
        return res;
    }

    /**
     * 对外的后序遍历二叉树接口
     *
     * @param root 二叉树根结点
     * @param flag 1: 采用递归 0: 采用迭代
     * @return 遍历结果
     */
    public List<Integer> postorderTraversal(TreeNode root, int flag) {
        if (flag != RECURSIVE && flag != ITERATIVE) {
            return null;
        }
        return flag == ITERATIVE ? postorderIterative(root) : postorderRecursive(root);
    }

    private List<Integer> postorderIterative(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode visited = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.peek();
            if (node.right == null || node.right == visited) {
                stack.pop();
                res.add(node.val);
                visited = node;
            } else {
                root = node.right;
            }
        }

        return res;
    }

    private List<Integer> postorderRecursive(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        postorder(root, res);
        return res;
    }

    private void postorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

    /**
     * 对外的中序遍历二叉树接口
     *
     * @param root 二叉树根节点
     * @param flag 1: 采用递归 0: 采用迭代
     * @return 遍历结果
     */
    public List<Integer> inorderTraversal(TreeNode root, int flag) {
        if (flag != ITERATIVE && flag != RECURSIVE) {
            return null;
        }
        return flag == ITERATIVE ? inorderIterative(root) : inorderRecursive(root);
    }

    /**
     * 二叉树层次遍历
     *
     * @param root 二叉树根结点
     * @return 遍历结果
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int queueLen = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < queueLen; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(list);
        }

        return res;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int qLen = queue.size();
            List<Integer> temp = new LinkedList<>();
            for (int i = 0; i < qLen; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                temp.add(node.val);
            }
            result.add(0, temp);
        }

        return result;
    }
}

