package alg.zhj.mindcollections.geeksets.bst;

import alg.zhj.mindcollections.geeksets.TreeNode;

/**
 * Created by zhaohongjie on 2019/5/1.
 */
public class ValidateBST_Recur_2 {

    public boolean isValidBST(TreeNode root) {

        return isValid(root,null,null);

    }

    /**
     * 通过收紧一个取值范围，来减少节点的遍历次数，详见 ValidateBST_Efficient.java
     *
     * @param root
     * @param min
     * @param max
     * @return
     */
    private boolean isValid(TreeNode root, Integer min, Integer max) {

        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min) {
            return false;
        }

        if (max != null && root.val >= max) {
            return false;
        }

        return isValid(root.left, min, root.val) &&
                isValid(root.right, root.val, max);
    }

}
