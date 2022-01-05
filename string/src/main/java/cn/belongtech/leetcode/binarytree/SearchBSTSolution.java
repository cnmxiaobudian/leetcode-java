package cn.belongtech.leetcode.binarytree;

/**
 * 二叉搜索树中的搜索
 *
 * @author sunliang
 * @version 1.0
 */
public class SearchBSTSolution {
    /**
     * 递归
     *
     * BST：二叉搜索树，核心是 左子树的值 <= 右子树的值 && 右子树的值 > 左子树的值
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (null == root) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        return this.searchBST(root.val < val ? root.right : root.left, val);
    }

    /**
     * O(1)
     */
    public TreeNode searchBSTBy2(TreeNode root, int val) {
        while (null != root) {
            if (root.val == val) {
                return root;
            }
            root = root.val > val ? root.left : root.right;
        }
        return null;
    }
}