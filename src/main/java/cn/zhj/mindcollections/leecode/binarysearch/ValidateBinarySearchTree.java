package cn.zhj.mindcollections.leecode.binarysearch;

/**
 * Created by zhaohongjie on 2019/1/8.
 */
public class ValidateBinarySearchTree {

    TreeNode prev;

    public boolean isValidBST(TreeNode root) {

        return helper(root);

    }

    /**
     * 利用一个额外的存储空间来记录当前的根节点。
     * 利用递归进行遍历——节点为空为递归出口；从左子树开始遍历，如果一个节点的左孩子大于等于这个节点，那么代表这不一个有效的二叉树；
     * 如果没有找到这样的节点，直到为空，那么返回true。
     *
     * @param root
     * @return
     */
    private boolean helper(TreeNode root) {

        if (root == null) {
            return true;
        }

        if (!helper(root.left)) {
            return false;
        }

        if (prev != null && prev.val >= root.val) {
            return false;
        }

        prev = root;

        return helper(root.right);

    }

    private boolean isValid(TreeNode root, Integer min, Integer max) {

        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min) {
            return false;
        }

        if (max != null && root.val >= max) {
            return false;
        }

        return isValid(root.left, min, root.val) &&
                isValid(root.right, root.val, max);
    }
}
