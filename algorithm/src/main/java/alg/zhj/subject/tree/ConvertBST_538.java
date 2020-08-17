package alg.zhj.subject.tree;

import alg.zhj.util.TreeNode;

import java.util.Stack;

/**
 * Created by zhaohongjie on 2020/8/16.
 */
public class ConvertBST_538 {

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode ans = root;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
    }

    public TreeNode _convertBST(TreeNode root) {
        if (root != null) {
            _convertBST(root.right);
            sum += root.val;
            root.val = sum;
            _convertBST(root.left);
        }
        return root;
    }

    public TreeNode __convertBST(TreeNode root) {

        int sum = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (!stack.isEmpty() || node != null) {
            /* push all nodes up to (and including) this subtree's maximum on
             * the stack. */
            while (node != null) {
                stack.add(node);
                node = node.right;
            }

            node = stack.pop();
            sum += node.val;
            node.val = sum;

            /* all nodes with values between the current and its parent lie in
             * the left subtree. */
            node = node.left;
        }

        return root;
    }
}
