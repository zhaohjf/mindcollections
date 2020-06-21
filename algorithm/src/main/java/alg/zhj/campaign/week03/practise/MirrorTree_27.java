package alg.zhj.campaign.week03.practise;

import alg.zhj.mindcollections.leecode.binarytree.search.TreeNode;

import java.util.Stack;

/**
 * Created by zhaohongjie on 2020/6/21.
 */
public class MirrorTree_27 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }

    /**
     * 交换左右节点
     *
     * @param root
     * @return
     */
    public TreeNode _mirrorTree(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack() {{
            add(root);
        }};
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }
}
