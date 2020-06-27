package alg.zhj.campaign.week03.src;

import alg.zhj.mindcollections.leecode.binarytree.search.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by zhaohongjie on 2020/6/26.
 */
public class BuildTree_105 {

    /**
     *
     *
     */
    private int in = 0;
    private int pre = 0;

    public TreeNode _nb_buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (pre >= preorder.length) return null;
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        TreeNode node = new TreeNode(preorder[pre++]);
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, stop);
        return node;
    }

    /**
     * 前序遍历 preorder = [4, 2, 1, 3, 6, 5, 7]
       中序遍历 inorder = [1, 2, 3, 4, 5, 6, 7]
       返回如下的二叉树：
            4
          /  \
         2    6
        / \  / \
       1  3  5  7
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] preorder = {4, 2, 1, 3, 6, 5, 7};
        int[] inorder = {1, 2, 3, 4, 5, 6, 7};
        BuildTree_105 obj = new BuildTree_105();
        TreeNode root = obj._nb_buildTree(preorder, inorder);
        System.out.println(root);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int index = indexOf(inorder, preorder[0]);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length),
                Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return root;
    }
    private int indexOf(int[] arr, int value) {
        if (arr == null) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode _buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
