package com.qihoo.btree;

public class BTreeUtils {
    private final int NORMAL = 0;
    private final int BINSEARCHTREE = 1;

    public TreeNode generateBTree() {
        TreeNode n5 = (new TreeNode(3));
        TreeNode n4 = (new TreeNode(5));
        TreeNode n3 = (new TreeNode(2));
        TreeNode n2 = (new TreeNode(2));
        TreeNode n1 = (new TreeNode(1));
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.right = n5;

        return n1;
    }

    public TreeNode generateBTree(int type) {
        if (type == BINSEARCHTREE) {
            TreeNode n5 = (new TreeNode(7));
            TreeNode n4 = (new TreeNode(3));
            TreeNode n3 = (new TreeNode(15));
            TreeNode n2 = (new TreeNode(9));
            TreeNode n1 = (new TreeNode(20));
            n5.left = n4;
            n5.right = n3;
            n3.left = n2;
            n3.right = n1;

            return n5;
        }

        return generateBTree();
    }
}
