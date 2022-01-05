package cn.belongtech.leetcode.binarytree;

/**
 * 二叉树的最近公共祖先
 *
 * @author sunliang
 * @version 1.0
 */
public class LowestCommonAncestorSolution {

    private TreeNode result;

    /**
     * 递归方案
     *
     * 左子树、右子树，当前节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.result;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root) {
            return false;
        }

        boolean lson = this.dfs(root.left, p, q);
        boolean rson = this.dfs(root.right, p, q);

        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            this.result = root;
        }

        return lson || rson || (root.val == p.val || root.val == q.val);
    }
}