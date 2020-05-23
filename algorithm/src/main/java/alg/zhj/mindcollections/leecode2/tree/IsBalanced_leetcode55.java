package alg.zhj.mindcollections.leecode2.tree;

/**
 * 递归求左右子树高度，相差大于1即非平衡二叉树
 *
 * Created by zhaohongjie on 2020/5/22.
 */
public class IsBalanced_leetcode55 {

    public boolean isBalanced(TreeNode root) {
        return recurse(root) != -1;
    }

    private int recurse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recurse(root.left);
        if (left == -1) {
            return -1;
        }
        int right = recurse(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
