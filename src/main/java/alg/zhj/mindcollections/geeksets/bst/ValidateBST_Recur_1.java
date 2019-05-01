package alg.zhj.mindcollections.geeksets.bst;

import alg.zhj.mindcollections.geeksets.TreeNode;

/**
 * Created by zhaohongjie on 2019/5/1.
 */
public class ValidateBST_Recur_1 {

    /**
     * method 1 correct but not efficient
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        /* false if the max of the left is > than us */
        if (root.left != null && maxValue(root.left) >= root.val) {
            return false;
        }

        /* false if the min of the right is <= than us */
        if (root.right != null && minValue(root.right) <= root.val) {
            return false;
        }

        /* false if, recursively, the left or right is not a BST */
        if (!isValidBST(root.left) || !isValidBST(root.right)) {
            return false;
        }

        /* passing all that, it's a BST */
        return true;
    }

    private int maxValue(TreeNode root) {

        if (root == null) {
            throw new NullPointerException("maxValue parameter is not allow null");
        }

        int res = root.val;
        while (root.right != null) {
            root = root.right;
            res = root.val;
        }

        return res;
    }

    private int minValue(TreeNode root) {

        if (root == null) {
            throw new NullPointerException("minValue parameter is not allow null");
        }

        int res = root.val;
        while (root.left != null) {
            root = root.left;
            res = root.val;
        }

        return res;
    }

    public static void main(String[] args) {

        ValidateBST_Recur_1 obj = new ValidateBST_Recur_1();

        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        boolean res = obj.isValidBST(root);
        System.out.print(res);
    }
}
