package alg.zhj.campaign.week06.practise;

import alg.zhj.mindcollections.leecode.binarytree.search.TreeNode;

/**
 * Created by zhaohongjie on 2020/7/9.
 */
public class IncreasingBST_recurse_897 {

    TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inorder(root);
        return ans.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        inorder(node.right);
    }

    public TreeNode _increasingBST(TreeNode root) {
        return increasingBST(root, null);
    }

    public TreeNode increasingBST(TreeNode root, TreeNode tail) {
        if (root == null) return tail;
        // 找到root的最左节点
        TreeNode res = increasingBST(root.left, root);
        root.left = null;
        // 找到root右节点的最左节点，作为root的右节点（中序遍历）
        root.right = increasingBST(root.right, tail);
        return res;
    }
}
