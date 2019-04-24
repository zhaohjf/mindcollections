package alg.zhj.mindcollections.leecode.binarytree.travel;

import alg.zhj.mindcollections.leecode.binarytree.search.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zhaohongjie on 2019/1/28.
 */
public class BinaryTreeLevelOrderTraversal {

    List<List<Integer>> levelOrder = new ArrayList<>();

    /**
     * 深度优先遍历（1ms）
     *
     * 每次递归都记录层数，根据层数找到二维数组中子数组，将对应层的数据添入到子数组中。
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_DFS(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        this.dfs(root, 0);

        return levelOrder;
    }

    /**
     * 定义一个level变量，来表示当前遍历的是哪层的结点
     *
     * 遍历到根节点为空时退出，递归顺序是从左节点开始，依次把访问到的节点放入对就层的List中
     *
     * @param node
     * @param level
     */
    private void dfs(TreeNode node, int level) {

        if (node == null) {
            return;
        }

        if (levelOrder.size() <= level) {
            levelOrder.add(new ArrayList<>());
        }

        levelOrder.get(level).add(node.val);

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }

    /**
     * 宽度优先遍历（2ms）
     *
     * 使用队列来进行广度优先遍历（广度优先遍历找到的路径一定是最短路径）
     *
     * 根节点入队，遍历时记录当前队列里所有节点的值（按顺序），然后将每个节点的左右子节点再次入队
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_BFS(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level_node = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level_node.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(level_node);
        }


        return result;
    }
}
