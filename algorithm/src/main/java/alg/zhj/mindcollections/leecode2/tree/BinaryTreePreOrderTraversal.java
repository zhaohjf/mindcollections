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

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(5);
        TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        BinaryTreePreOrderTraversal preOrder = new BinaryTreePreOrderTraversal();
        System.out.println(preOrder.preOrderTraversalRecur(n1));
        BinaryTreeInorderTraversal inOrder = new BinaryTreeInorderTraversal();
        System.out.println(inOrder.inorderTraversal(n1));
    }
}
