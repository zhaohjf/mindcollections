package alg.zhj.mindcollections.leecode2.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 *
 * Created by zhaohongjie on 2019/4/18.
 */
public class BinaryTreePostOrderTraversal {

    List<Integer> res = new ArrayList<>();

    public List<Integer> postOrderTraversalRecur(TreeNode root) {

        if (root == null) {
            return res;
        }

        postOrderTraversalRecur(root.left);
        postOrderTraversalRecur(root.right);
        res.add(root.val);

        return res;
    }

    public List<Integer> postOrderTraversal1(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode node = s1.pop();
            s2.push(node);
            /**
             * 注意这里左右节点的处理顺序
             *
             */
            if (node.left != null) {
                s1.push(node.left);
            }
            if (node.right != null) {
                s1.push(node.right);
            }
        }

        while (!s2.isEmpty()) {
            res.add(s2.pop().val);
        }

        return res;
    }

    public List<Integer> postOrderTraversal2(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode h = root;
        TreeNode c = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            c = stack.peek();
            if (c.left != null && h != c.left && h != c.right) {
                stack.push(c.left);
            } else if (c.right != null && h != c.right) {
                stack.push(c.right);
            } else {
                res.add(stack.pop().val);
                h = c;
            }
        }

        return res;
    }
}
