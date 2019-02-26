package cn.zhj.mindcollections.leecode.binarytree.search;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * Created by zhaohongjie on 2019/1/9.
 */
public class LowestCommonAncestorOfABinaryTree {

    /**
     * 查找最近公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        // 递归退出条件中有为Null的情况
        return leftNode == null ? rightNode : rightNode == null ? leftNode : root;
    }
}
