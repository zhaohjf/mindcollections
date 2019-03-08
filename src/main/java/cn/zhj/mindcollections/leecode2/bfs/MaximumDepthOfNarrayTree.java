package cn.zhj.mindcollections.leecode2.bfs;

import cn.zhj.mindcollections.leecode2.base.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhaohongjie on 2019/3/7.
 */
public class MaximumDepthOfNarrayTree {

    /**
     * bfs
     *
     * @param root
     * @return
     */
    public int maxDepth(Node root) {

        if (root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();
                for (Node n : temp.children) {
                    queue.add(n);
                }
            }
            depth += 1;
        }

        return depth;
    }

    /**
     * dfs
     *
     * @param root
     * @return
     */
    public int maxDepth_1(Node root) {

        return dfs(root);
    }

    private int dfs(Node root) {

        if (root == null) {
            return 0;
        }

        int max = 0;
        for (Node node : root.children) {
            max = Math.max(max, dfs(node));
        }

        return max + 1;
    }
}
