package alg.zhj.mindcollections.leecode2.tree;

import java.util.Arrays;

/**
 * Created by zhaohongjie on 2020/5/22.
 */
public class Leetcode_106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder == null || postorder == null) {
            return null;
        }

        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);
        int i = indexOf(inorder, rootValue);

        root.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
        root.right = buildTree(Arrays.copyOfRange(inorder, i + 1, inorder.length),
                Arrays.copyOfRange(postorder, i, postorder.length - 1));

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
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        Leetcode_106 obj = new Leetcode_106();
        TreeNode treeNode = obj.buildTree(inorder, postorder);
        System.out.println(treeNode);
    }
}
