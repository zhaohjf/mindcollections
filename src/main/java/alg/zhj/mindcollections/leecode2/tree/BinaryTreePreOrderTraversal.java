package alg.zhj.mindcollections.leecode2.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 * Created by zhaohongjie on 2019/4/18.
 */
public class BinaryTreePreOrderTraversal {

    List<Integer> res = new ArrayList<>();

    public List<Integer> preOrderTraversalRecur(TreeNode root) {

        if (root == null) {
            return res;
        }

        res.add(root.val);
        preOrderTraversalRecur(root.left);
        preOrderTraversalRecur(root.right);

        return res;
    }

    public List<Integer> preOrderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return res;
    }
}
