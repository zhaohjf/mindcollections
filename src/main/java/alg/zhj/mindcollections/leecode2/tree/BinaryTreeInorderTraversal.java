package alg.zhj.mindcollections.leecode2.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/submissions/
 *
 * Created by zhaohongjie on 2019/4/16.
 */
public class BinaryTreeInorderTraversal {

    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal_recur(TreeNode root) {

        if (root == null) {
            return res;
        }

        inorderTraversal_recur(root.left);
        res.add(root.val);
        inorderTraversal_recur(root.right);

        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }

        return res;
    }
}
