package alg.zhj.mindcollections.practise;

import alg.zhj.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zhaohongjie on 2020/4/18.
 */
public class Test {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ans.add(tmp);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode n_3 = new TreeNode(3);
        TreeNode n_9 = new TreeNode(9);
        TreeNode n_20 = new TreeNode(20);
        TreeNode n_15 = new TreeNode(15);
        TreeNode n_7 = new TreeNode(7);

        n_3.left = n_9;
        n_3.right = n_20;

        n_20.left = n_15;
        n_20.right = n_7;

        List<List<Integer>> lists = levelOrder(n_3);
        System.out.print(lists);
    }
}
