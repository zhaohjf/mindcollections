package alg.zhj.mindcollections.geeksets.bst;

import alg.zhj.mindcollections.geeksets.TreeNode;

/**
 * We can avoid the use of Auxiliary Array. While doing In-Order traversal, we can keep track of previously visited node.
 * If the value of the currently visited node is less than the previous value, then tree is not BST. Thanks to ygos for
 * this space optimization.
 *
 * Created by zhaohongjie on 2019/5/1.
 */
public class ValidateBST_In_Order {

    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {

        // traverse the tree in inorder fashion and
        // keep a track of previous node
        if (root != null) {

            if (!isValidBST(root.left)) {
                return false;
            }

            if (prev != null && root.val <= prev.val) {
                return false;
            }

            prev = root;

            return isValidBST(root.right);
        }

        return true;
    }


}
