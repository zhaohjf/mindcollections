package alg.zhj.mindcollections.geeksets.bst;

import alg.zhj.mindcollections.geeksets.TreeNode;
import edu.princeton.cs.algs4.In;

/**
 * ValidateBST_Recur_1
 *
 * method above runs slowly since it traverses over some parts of the tree many times.
 * a better solution looks at each node only once. The tricky is to write a utility helper
 * function isBSTUtil(struct node* node, int min, int max) that traverses down the tree
 * keeping track of the narrowing min and max allowed values as it goes, looking at each
 * node only once. The initial values for min and max should be INT_MIN and INT_MAX — they narrow from there.
 *
 * Created by zhaohongjie on 2019/5/1.
 */
public class ValidateBST_Efficient {

    public boolean isValidBST(TreeNode root) {

        return isBSTUtil_boundary(root, null, null);
    }

    /**
     * 以下算法有边界值问题 [-2147483648,-2147483648] 结点值 = Integer.MIN_VALUE or Integer.MAX_VALUE
     *
     * @param root
     * @param min
     * @param max
     * @return
     */
    private boolean isBSTUtil(TreeNode root, int min, int max) {

        if (root == null) {
            return true;
        }

        if (root.val > max || root.val < min) {
            return false;
        }

        return isBSTUtil(root.left, min, root.val - 1) &&
                isBSTUtil(root.right, root.val + 1, max);
    }

    private boolean isBSTUtil_boundary(TreeNode root, Integer min, Integer max) {

        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min) {
            return false;
        }

        if (max != null && root.val >= max) {
            return false;
        }

        return isBSTUtil_boundary(root.left, min, root.val)
                && isBSTUtil_boundary(root.right, root.val, max);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(-2147483648);
        TreeNode left = new TreeNode(-2147483648);
        root.left = left;

        ValidateBST_Efficient obj = new ValidateBST_Efficient();
        System.out.println(obj.isValidBST(root));
    }
}
