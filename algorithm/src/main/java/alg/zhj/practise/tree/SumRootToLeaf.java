package alg.zhj.practise.tree;

import alg.zhj.util.TreeNode;

public class SumRootToLeaf {

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }
        int sum = ((preSum << 1) + root.val);
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }

    /**=======================================================================================================================*/

    int ans = 0;
    public int sumRootToLeaf2(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs2(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            ans += ((sum << 1) + root.val);
            return;
        }
        sum = (sum << 1) + root.val;
        dfs2(root.left, sum);
        dfs2(root.right, sum);
    }
}
