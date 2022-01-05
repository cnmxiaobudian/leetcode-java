package cn.belongtech.leetcode.binarytree;

/**
 * 完全二叉树的节点个数
 *
 * @author sunliang
 * @version 1.0
 */
public class CountNodesSolution {

    int count = 0;

    /**
     * O(n)
     */
    public int countNodes(TreeNode root) {
        if (null != root) {
            count += 1;
            this.countNodes(root.left);
            this.countNodes(root.right);
        }
        return this.count;
    }

    /**
     * O(1)
     *
     * https://leetcode-cn.com/problems/count-complete-tree-nodes/solution/wan-quan-er-cha-shu-de-jie-dian-ge-shu-by-leetco-2/
     *
     * 二分查找 + 位运算
     */
    public int countNodesBy2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exists(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }
}