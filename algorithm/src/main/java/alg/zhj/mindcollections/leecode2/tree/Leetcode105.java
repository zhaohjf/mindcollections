package alg.zhj.mindcollections.leecode2.tree;

import java.util.Arrays;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。

 注意:
 你可以假设树中没有重复的元素。

 例如，给出

 前序遍历 preorder = [3,9,20,15,7]
 中序遍历 inorder = [9,3,15,20,7]
 * Created by zhaohongjie on 2020/5/22.
 */
public class Leetcode105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || inorder == null) {
            return null;
        }

        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);
        int i = indexOf(inorder, rootValue);

        root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
        root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length),
                Arrays.copyOfRange(inorder, i + 1, inorder.length));

        return root;
    }

    private int indexOf(int[] array, int val) {

        if (array == null || array.length == 0) {
            return -1;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == val) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        Leetcode105 obj = new Leetcode105();
        TreeNode treeNode = obj.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

}
