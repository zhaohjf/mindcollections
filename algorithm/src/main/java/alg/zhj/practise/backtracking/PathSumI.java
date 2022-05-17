package alg.zhj.practise.backtracking;

import alg.zhj.util.TreeNode;

/**
 * https://leetcode.cn/problems/path-sum/
 */
public class PathSumI {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }

    /**
     * 非递归版本
     */
}
