package cn.zhj.mindcollections.leecode.binarytree.travel;

import cn.zhj.mindcollections.leecode.binarytree.search.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaohongjie on 2019/1/28.
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    /**
     * 以zigzag顺序来打印树
     *
     * 需要根据层的奇偶性来决定递归遍历的顺序，是先遍历左节点， 还是先遍历右节点
     *
     * 这里的做法有比较tricky，它是在往对应层添加数据时，根据奇偶性来判断是从列表的尾部追加，还是插入到列表的第一个位置
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> zigzagLevelOrder = new ArrayList<>();

        dfs(zigzagLevelOrder, root, 0);

        return zigzagLevelOrder;
    }

    private static void dfs(List<List<Integer>> zigzagLevelOrder, TreeNode node, int level) {

        if (node == null) {
            return;
        }

        if (zigzagLevelOrder.size() <= level) {
            zigzagLevelOrder.add(new ArrayList<>());
        }

        if (level % 2 == 0) {
            zigzagLevelOrder.get(level).add(node.val);
        } else {
            zigzagLevelOrder.get(level).add(0, node.val);
        }

        dfs(zigzagLevelOrder, node.left, level + 1);
        dfs(zigzagLevelOrder, node.right, level + 1);

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

        List<List<Integer>> lists = zigzagLevelOrder(n_3);
        lists.stream().forEach(list -> {
            list.forEach(c -> System.out.print(c + ", "));
            System.out.println();
        });

    }
}
