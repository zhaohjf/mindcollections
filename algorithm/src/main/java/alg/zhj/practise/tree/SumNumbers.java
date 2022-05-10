package alg.zhj.practise.tree;

import alg.zhj.util.TreeNode;

/**
 * https://leetcode.cn/problems/3Etpl5/
 */
public class SumNumbers {

    int ans = 0;
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0, 0);
//        return ans;
    }

    // wrong
    private int dfs(TreeNode root, int sum, int level) {
        if (root == null) {
            ans += sum;
            return sum;
        }
        sum = (int) (sum * Math.pow(10, level)) + root.val;
        return dfs(root.left, sum, level + 1) + dfs(root.right, sum, level + 1);
    }

    /**=======================================================================================================================*/
    public int sumNumbers_2(TreeNode root) {
        return dfs2(root, 0);
    }

    // 对比上面写错的，递归退出条件要想清楚了，首先子问题要构造明确了，别先着急写代码
    private int dfs2(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }
        int sum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs2(root.left, sum) + dfs2(root.right, sum);
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        SumNumbers obj = new SumNumbers();
        System.out.println(obj.sumNumbers_2(root));
    }
}
