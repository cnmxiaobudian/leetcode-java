package cn.belongtech.leetcode.tree;

/**
 * 树节点
 *
 * @author sunliang
 * @version 1.0
 */
public class TreeNode<T> {

    /**
     * 节点数据
     */
    public T data;

    /**
     * 左节点
     */
    public TreeNode<T> left;

    /**
     * 右节点
     */
    public TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public TreeNode() {
    }
}