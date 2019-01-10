package cn.zhj.mindcollections.leecode.binarysearch;

/**
 * Created by zhaohongjie on 2019/1/9.
 */
public class LowestCommonAncestorOfABinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        return leftNode == null ? rightNode : rightNode == null ? leftNode : root;
    }
}
