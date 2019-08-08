package alg.zhj.mindcollections.leecode.binarytree.depth;

import alg.zhj.mindcollections.leecode.binarytree.search.TreeNode;

/**
 * Created by zhaohongjie on 2019/1/28.
 */
public class DepthOfBinaryTree {

    public int maxDepth(TreeNode root) {

        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            return 1 + minDepth(root.right);
        }

        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    /**
     * 递归逻辑更加清晰、合理
     *
     * @param root
     * @return
     */
    public int minDepth_2(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftDepth = minDepth_2(root.left);
        int rightDepth = minDepth_2(root.right);

        return (leftDepth == 0 || rightDepth == 0)
                ? leftDepth + rightDepth + 1
                : Math.min(leftDepth, rightDepth) + 1;
    }
}
