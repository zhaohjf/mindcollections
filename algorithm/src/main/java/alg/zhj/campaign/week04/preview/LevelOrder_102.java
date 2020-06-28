package alg.zhj.campaign.week04.preview;

import alg.zhj.mindcollections.leecode.binarytree.search.TreeNode;
import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zhaohongjie on 2020/6/28.
 */
public class LevelOrder_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int count = queue.size();
            while (count > 0) {
                TreeNode node = queue.poll();
                count--;
                tmp.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(tmp);
        }
        return ans;
    }

    public List<List<Integer>> _levelOrder(TreeNode root) {
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
