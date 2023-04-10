package com.meiken;

/**
 * @Author glf
 * @Date 2023/4/8
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    /**
     *                1
     *             /    \
     *           2       3
     *          / \     / \
     *         4   5   6  7
     *            / \
     *           8   9
     *
     *  pre : 1 2 4 5 8 9 3 6 7
     *  in  : 4 2 8 5 9 1 6 3 7
     *  post: 4 8 9 5 2 6 7 3 1
     * @return
     */
    public static TreeNode getSampleTree(){
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);


        return root;
    }
}
