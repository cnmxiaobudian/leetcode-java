package cn.belongtech.leetcode.tree;

/**
 * 树的遍历
 *
 * @author sunliang
 * @version 1.0
 */
public class TreeTraverse<T> {

    /**
     * 先序遍历
     */

    public void preTreeTraverseRecur(TreeNode<T> tree){
         if(null == tree) {
             return;
         }

         System.out.println(tree.getData());
         this.preTreeTraverseRecur(tree.getLeft());
         this.preTreeTraverseRecur(tree.getRight());
    }

    public void preTreeTraverse(TreeNode<T> tree){
        if(null == tree) {
            return;
        }










    }

}
