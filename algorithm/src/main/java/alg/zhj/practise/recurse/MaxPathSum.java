package alg.zhj.practise.recurse;

import alg.zhj.util.TreeNode;

public class MaxPathSum {

    /**
     * 实际上，这种方法算出来的是，所有从一个叶节点开始到另一个叶节点结束的路径中，和最大的一个。
     * 而，题目中并没有限制必须是从叶节点开始或结束。
     *
     * @param root
     * @return
     */
    public int maxPathSum_own(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int ans = sum(root);
        ans = Math.max(ans, Math.max(maxPathSum(root.left), maxPathSum(root.right)));
        return ans;
    }

    private int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        //int sum = node.val + preSum;
        if (node.left == null && node.right == null) {
            return node.val;
        }
        return sum(node.left) + sum(node.right) + node.val;
    }

    /**==================================================================================================================*/

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewpath = root.val + leftGain + rightGain;

        maxSum = Math.max(maxSum, priceNewpath);

        return root.val + Math.max(leftGain, rightGain);
    }

    /**==================================================================================================================*/

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-3);
        MaxPathSum obj = new MaxPathSum();
        System.out.println(obj.maxPathSum(root));
    }
}
