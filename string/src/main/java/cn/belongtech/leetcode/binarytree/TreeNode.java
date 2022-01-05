package cn.belongtech.leetcode.binarytree;

/**
 * int二叉树
 *
 * @author sunliang
 * @version 1.0
 */
public class TreeNode {
    int val;

    TreeNode left;

    TreeNode right;

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
}