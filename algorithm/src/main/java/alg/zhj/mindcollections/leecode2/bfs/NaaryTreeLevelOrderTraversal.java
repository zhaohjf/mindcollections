package alg.zhj.mindcollections.leecode2.bfs;

import alg.zhj.mindcollections.leecode2.base.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 *
 * Created by zhaohongjie on 2019/3/7.
 */
public class NaaryTreeLevelOrderTraversal {

    /**
     * bfs
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int levelCount = queue.size();
            for (int i = 0; i < levelCount; i++) {
                Node node = queue.poll();
                temp.add(node.val);
                for (Node n : node.children) {
                    queue.add(n);
                }
            }
            res.add(temp);
        }

        return res;
    }

    //======================

    List<List<Integer>> result = new ArrayList<>();

    /**
     * dfs 深度优先 递归解决问题
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_1(Node root) {

        dfs(root, 0);

        return result;
    }

    private void dfs(Node node, int level) {

        if (node == null) {
            return;
        }

        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(node.val);

        for (Node n : node.children) {
            dfs(n, level + 1);
        }
    }
}
