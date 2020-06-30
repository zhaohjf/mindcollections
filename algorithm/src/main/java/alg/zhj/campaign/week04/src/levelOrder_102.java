package alg.zhj.campaign.week04.src;

import alg.zhj.mindcollections.leecode.binarytree.search.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaohongjie on 2020/6/30.
 */
public class levelOrder_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        dfs(root, ans, 0);
        return ans;
    }

    private void dfs(TreeNode root, List<List<Integer>> ans, int level) {
        if (root == null) {
            return;
        }
        if (ans.size() <= level) {
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(root.val);
        dfs(root.left, ans, level + 1);
        dfs(root.right, ans, level + 1);
    }
}
