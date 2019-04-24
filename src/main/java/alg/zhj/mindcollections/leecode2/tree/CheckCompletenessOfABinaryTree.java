package alg.zhj.mindcollections.leecode2.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/
 *
 * Created by zhaohongjie on 2019/4/21.
 */
public class CheckCompletenessOfABinaryTree {

    public boolean isCompleteTree(TreeNode root) {

        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        boolean leaf = false;
        TreeNode l = null;
        TreeNode r = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            l = root.left;
            r = root.right;

            if (leaf && (l != null || r != null)) {
                return false;
            }

            if (l == null && r != null) {
                return false;
            }

            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            } else {
                leaf = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
    }

}
