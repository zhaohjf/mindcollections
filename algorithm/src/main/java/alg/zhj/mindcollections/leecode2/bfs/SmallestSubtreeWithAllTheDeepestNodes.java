package alg.zhj.mindcollections.leecode2.bfs;

import alg.zhj.mindcollections.leecode2.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 * <p>
 * Created by zhaohongjie on 2019/3/8.
 */
public class SmallestSubtreeWithAllTheDeepestNodes {

    private class Pair<T, K> {
        final T key;
        final K value;

        public Pair(T key, K value) {
            this.key = key;
            this.value = value;
        }

        public K getValue() {
            return value;
        }

        public T getKey() {
            return key;
        }
    }

    /**
     * 求路径最长叶节点所属的最小子树
     *
     * @param root
     * @return
     */
    public TreeNode subtreeWithAllDeepest(TreeNode root) {

        return deep(root).getValue();
    }

    public Pair<Integer, TreeNode> deep(TreeNode root) {

        if (root == null) return new Pair(0, null);

        Pair<Integer, TreeNode> l = deep(root.left), r = deep(root.right);

        int d1 = l.getKey(), d2 = r.getKey();
        return new Pair(Math.max(d1, d2) + 1, d1 == d2 ? root : d1 > d2 ? l.getValue() : r.getValue());
    }

    //========================================

    Map<TreeNode, Integer> depth;
    int max_depth;

    public TreeNode subtreeWithAllDeepest_1(TreeNode root) {
        depth = new HashMap();
        depth.put(null, -1);
        dfs(root, null);
        max_depth = -1;
        for (Integer d: depth.values())
            max_depth = Math.max(max_depth, d);

        return answer(root);
    }

    /**
     * 计算每个节点的最大深度
     * @param node
     * @param parent
     */
    public void dfs(TreeNode node, TreeNode parent) {
        if (node != null) {
            depth.put(node, depth.get(parent) + 1);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    /**
     * 寻找最大深度节点的父节点
     * @param node
     * @return
     */
    public TreeNode answer(TreeNode node) {
        if (node == null || depth.get(node) == max_depth)
            return node;
        TreeNode L = answer(node.left),
                R = answer(node.right);
        if (L != null && R != null) return node;
        if (L != null) return L;
        if (R != null) return R;
        return null;
    }
}
