package cn.belongtech.leetcode.binarytree;

/**
 * 删除二叉搜索树中的节点
 *
 * @author sunliang
 * @version 1.0
 */
public class DeleteBSTNodeSolution {

    /**
     * 区分三种情况：叶子结点，有左子树，有右子树
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (null == root) {
            return null;
        }

        if (root.val > key) {
            // 删除左子树
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            // 删除右子树
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                // 叶子节点，可直接删除
                root = null;
            } else if (null != root.right) {
                // 有右子树，使用下一节点作为值，并删除下一节点
                root.val = this.successor(root);
                root.right = deleteNode(root.right, root.val);
            } else {
                // 有左子树，使用上一节点作为值，并删除上一节点
                root.val = this.predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }

        return root;
    }

    /**
     * 中序遍历的下一个节点
     */
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    /**
     * 中序遍历的上一个节点
     */
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    /**
     * 中序遍历
     */
    public void midTreeTraverseRecur(TreeNode tree){
        if(null == tree) {
            return;
        }

        this.midTreeTraverseRecur(tree.left);
        System.out.println(tree.val);
        this.midTreeTraverseRecur(tree.right);
    }
}