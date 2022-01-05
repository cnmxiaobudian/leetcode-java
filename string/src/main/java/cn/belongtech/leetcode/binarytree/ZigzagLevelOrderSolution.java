package cn.belongtech.leetcode.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的锯齿形层序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * @author sunliang
 * @version 1.0
 */
public class ZigzagLevelOrderSolution {
    /**
     * 层序遍历变种：左右左
     *
     * 双端队列：Deque
     *
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (null == root) {
            return ret;
        }

        boolean isLeft = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Deque<Integer> tmp = new LinkedList<>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (isLeft) {
                    // 加入链表尾部
                    tmp.offerLast(node.val);
                } else {
                    // 加入链表头部
                    tmp.offerFirst(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(new ArrayList<>(tmp));
            isLeft = !isLeft;
        }
        return ret;
    }

    /**
     * 二叉树层序遍历（给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点））
     *
     * 广度优先搜索
     *
     * 队列：queue
     * 弹出 -> 压左子树 -> 压右子树
     *
     *
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                level.add(node.val);
            }
            ret.add(level);
        }

        return ret;
    }

    // 广度优先搜索
    public List<Integer> wide(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (null == root) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // 先往队列中压入左节点，再压右节点，这样出队列就是先左节点后右节点了
            if (null != node.left) {
                queue.offer(node.left);
            }
            if (null != node.right) {
                queue.offer(node.right);
            }
            ret.add(node.val);
        }
        return ret;
    }

    /**
     * 深度优先搜索
     *
     * 栈：stack
     * 弹出值 -> 压右子树 -> 压左子树
     *
     * https://blog.csdn.net/lb812913059/article/details/83313360
     */
    public List<Integer> deep(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (null == root) {
            return ret;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // 先往栈中压入右节点，再压左节点，这样出栈就是先左节点后右节点了
            if (null != node.right) {
                stack.push(node.right);
            }
            if (null != node.left) {
                stack.push(node.left);
            }
            ret.add(node.val);
        }
        return ret;
    }
}
