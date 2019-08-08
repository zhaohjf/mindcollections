package alg.zhj.mindcollections.leecode.binarytree.search;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * Created by zhaohongjie on 2019/1/9.
 */
public class LowestCommonAncestorOfABinarySearchTree {

    /**
     * 相比于普通二叉树来说，二叉搜索树的有序性，可以提供更多的信息
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        return root;
    }

    public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return root;
    }
}
