package alg.zhj.campaign.week04.practise;

import alg.zhj.mindcollections.leecode.binarytree.search.TreeNode;

/**
 * Created by zhaohongjie on 2020/6/29.
 */
public class KthLargest_54 {

    int k = 0, ans = -1;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        if (--k == 0) {
            ans = root.val;
        }
        dfs(root.left);
    }
}
