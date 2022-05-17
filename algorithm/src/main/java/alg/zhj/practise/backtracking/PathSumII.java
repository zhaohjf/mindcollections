package alg.zhj.practise.backtracking;

import alg.zhj.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/path-sum-ii/
 */
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(root, ans, new ArrayList<>(), targetSum);
        return ans;
    }

    private void backtrack(TreeNode root, List<List<Integer>> ans, List<Integer> temp, int targetSum) {
        if (root == null) {
            return;
        }
        // 如果有负数存在，这种剪枝方式是有问题的
        // if (targetSum < root.val) {
        //     return;
        // }
        temp.add(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            ans.add(new ArrayList<>(temp));
            // return;
        }
        backtrack(root.left, ans, temp, targetSum);
        backtrack(root.right, ans, temp, targetSum);
        temp.remove(temp.size() - 1);
    }
}
